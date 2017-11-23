package be.penance.finalfantasy.xv.comrades.domain;

import be.penance.finalfantasy.xv.comrades.enums.QuestType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "QUEST", schema = "public", uniqueConstraints = @UniqueConstraint(name = "quest_pk",
        columnNames = {"id"}))
public class Quest implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_QUEST")
    @SequenceGenerator(name = "SEQ_QUEST", sequenceName = "quest_id_seq", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 1)
    private QuestType type;

    @Column(name = "name", length = 255, unique = true)
    private String name;

    @Column(name = "desc", length = 4000)
    private String description;


    @Column(name = "level", length = 5)
    private Integer level;

    @ManyToOne
    @JoinColumn(name = "location", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "quest_location_fk"))
    private Location location;

    @Column(name = "kwh_power", length = 5)
    private Integer kwhPower;

    @Column(name = "bounty", length = 10)
    private Integer bounty;

    @ManyToMany
    @JoinTable(name = "QUEST_ITEM",
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID", referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "quest_item_item_fk")),
            joinColumns = @JoinColumn(name = "QUEST_ID", referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "quest_item_quest_fk")))
    private Set<Item> items;

    public Quest(QuestType type, String name, String description, Integer level, Location location, Integer kwhPower,
                 Integer bounty) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.level = level;
        this.location = location;
        this.kwhPower = kwhPower;
        this.bounty = bounty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuestType getType() {
        return type;
    }

    public void setType(QuestType type) {
        this.type = type;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getKwhPower() {
        return kwhPower;
    }

    public void setKwhPower(Integer kwhPower) {
        this.kwhPower = kwhPower;
    }

    public Integer getBounty() {
        return bounty;
    }

    public void setBounty(Integer bounty) {
        this.bounty = bounty;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
