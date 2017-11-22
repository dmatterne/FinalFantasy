package be.penance.finalfantasy.xv.comrades.domain;

import be.penance.finalfantasy.xv.comrades.enums.Rarity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "MATERIAL", schema = "public", uniqueConstraints = @UniqueConstraint(name = "mater_pk", columnNames = {"id"}))
public class Material implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MATER")
    @SequenceGenerator(name = "SEQ_MATER", sequenceName = "mater_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "desc", length = 4000)
    private String description;

    @Column(name = "hp", length = 5)
    private Integer hp;

    @Column(name = "mp", length = 5)
    private Integer mp;

    @Column(name = "vit", length = 5)
    private Integer vitality;

    @Column(name = "str", length = 5)
    private Integer strength;

    @Column(name = "mag", length = 5)
    private Integer magic;

    @Column(name = "spr", length = 5)
    private Integer spirit;

    @Column(name = "fire_res", length = 5)
    private Integer fireResist;

    @Column(name = "ice_res", length = 5)
    private Integer iceResist;

    @Column(name = "thunder_res", length = 5)
    private Integer thunderResist;

    @Column(name = "dark_res", length = 5)
    private Integer darkResist;

    @Column(name = "shot_res", length = 5)
    private Integer shotResist;

    @Column(name = "exp", length = 10)
    private Integer experience;

    @ManyToOne
    @JoinColumn(name = "skill", referencedColumnName = "id", foreignKey = @ForeignKey(name = "material_skill_fk"))
    private Skill skill;

    @ManyToMany(mappedBy = "materials")
    private List<Quest> quests;

    @Column(name = "quantity", length = 5)
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "rarity", length = 1)
    private Rarity rarity;

    @Column(name = "is_favorite", length = 1)
    private Boolean isFavorite;

    @Column(name = "is_deleted", length = 1)
    private Boolean isDeleted;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createddate")
    private Date createdDate;

    public Material(String name, String description, Integer hp, Integer mp, Integer vitality, Integer strength,
                    Integer magic, Integer spirit, Integer fireResist, Integer iceResist, Integer thunderResist,
                    Integer darkResist, Integer shotResist, Integer experience) {
        this.name = name;
        this.description = description;
        this.hp = hp;
        this.mp = mp;
        this.vitality = vitality;
        this.strength = strength;
        this.magic = magic;
        this.spirit = spirit;
        this.fireResist = fireResist;
        this.iceResist = iceResist;
        this.thunderResist = thunderResist;
        this.darkResist = darkResist;
        this.shotResist = shotResist;
        this.experience = experience;
        this.isDeleted = false;
        this.isFavorite = false;
        this.createdDate = new Date();
    }

    public Material(String name, String description, Integer hp, Integer mp, Integer vitality, Integer strength,
                    Integer magic, Integer spirit, Integer fireResist, Integer iceResist, Integer thunderResist,
                    Integer darkResist, Integer shotResist, Integer experience, Skill skill) {
        this.name = name;
        this.description = description;
        this.hp = hp;
        this.mp = mp;
        this.vitality = vitality;
        this.strength = strength;
        this.magic = magic;
        this.spirit = spirit;
        this.fireResist = fireResist;
        this.iceResist = iceResist;
        this.thunderResist = thunderResist;
        this.darkResist = darkResist;
        this.shotResist = shotResist;
        this.experience = experience;
        this.isDeleted = false;
        this.isFavorite = false;
        this.createdDate = new Date();
        this.skill = skill;
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

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getMp() {
        return mp;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
    }

    public Integer getVitality() {
        return vitality;
    }

    public void setVitality(Integer vitality) {
        this.vitality = vitality;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getMagic() {
        return magic;
    }

    public void setMagic(Integer magic) {
        this.magic = magic;
    }

    public Integer getSpirit() {
        return spirit;
    }

    public void setSpirit(Integer spirit) {
        this.spirit = spirit;
    }

    public Integer getFireResist() {
        return fireResist;
    }

    public void setFireResist(Integer fireResist) {
        this.fireResist = fireResist;
    }

    public Integer getIceResist() {
        return iceResist;
    }

    public void setIceResist(Integer iceResist) {
        this.iceResist = iceResist;
    }

    public Integer getThunderResist() {
        return thunderResist;
    }

    public void setThunderResist(Integer thunderResist) {
        this.thunderResist = thunderResist;
    }

    public Integer getDarkResist() {
        return darkResist;
    }

    public void setDarkResist(Integer darkResist) {
        this.darkResist = darkResist;
    }

    public Integer getShotResist() {
        return shotResist;
    }

    public void setShotResist(Integer shotResist) {
        this.shotResist = shotResist;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
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