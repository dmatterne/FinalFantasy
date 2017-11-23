package be.penance.finalfantasy.xv.comrades.domain;

import be.penance.finalfantasy.xv.comrades.enums.Rarity;
import be.penance.finalfantasy.xv.comrades.enums.SkillType;
import be.penance.finalfantasy.xv.comrades.enums.Useability;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "SKILL", schema = "public", uniqueConstraints = @UniqueConstraint(name = "skill_pk",
        columnNames = {"id"}))
public class Skill implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SKILL")
    @SequenceGenerator(name = "SEQ_SKILL", sequenceName = "skill_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", length = 255, unique = true)
    private String name;

    @Column(name = "desc", length = 4000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 1)
    private SkillType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "rarity", length = 1)
    private Rarity rarity;

    @Enumerated(EnumType.STRING)
    @Column(name = "useability", length = 1)
    private Useability useability;

    @OneToMany
    @JoinTable(name = "SKILL_MATERIAL_MAP",
            joinColumns = @JoinColumn(name = "SKILL_ID", referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "skill_mater_map_skill_fk")),
            inverseJoinColumns = @JoinColumn(name = "MATERIAL_ID", referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "skill_mater_map_mater_fk"))
    )
    private Set<EquipmentItem> equipmentItems;

    @Column(name = "is_favorite", length = 1)
    private Boolean isFavorite;

    @Column(name = "is_deleted", length = 1)
    private Boolean isDeleted;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createddate")
    private Date createdDate;

    public Skill(String name, String description) {
        this.name = name;
        this.description = description;
        this.isDeleted = false;
        this.isFavorite = false;
        this.createdDate = new Date();
    }

    public Skill(String name, String description, Rarity rarity) {
        this.name = name;
        this.description = description;
        this.isDeleted = false;
        this.isFavorite = false;
        this.createdDate = new Date();
        this.rarity = rarity;
    }

    public Skill(String name, String description, Rarity rarity, Useability useability) {
        this.name = name;
        this.description = description;
        this.isDeleted = false;
        this.isFavorite = false;
        this.createdDate = new Date();
        this.rarity = rarity;
        this.useability = useability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public Useability getUseability() {
        return useability;
    }

    public void setUseability(Useability useability) {
        this.useability = useability;
    }

    public Set<EquipmentItem> getMaterials() {
        return equipmentItems;
    }

    public void setMaterials(Set<EquipmentItem> equipmentItems) {
        this.equipmentItems = equipmentItems;
    }

    public Boolean getFavorite() {
        return isFavorite;
    }

    public void setFavorite(Boolean favorite) {
        isFavorite = favorite;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}





