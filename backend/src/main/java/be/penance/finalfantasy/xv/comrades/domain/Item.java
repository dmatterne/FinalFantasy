package be.penance.finalfantasy.xv.comrades.domain;

import be.penance.finalfantasy.xv.comrades.enums.ItemType;
import be.penance.finalfantasy.xv.comrades.enums.Rarity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ITEM", schema = "public", uniqueConstraints = @UniqueConstraint(name = "item_pk", columnNames = {"id"}))
public class Item {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ITEM")
    @SequenceGenerator(name = "SEQ_ITEM", sequenceName = "item_id_seq", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 1)
    private ItemType type;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "desc", length = 4000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "rarity", length = 1)
    private Rarity rarity;

    @Column(name = "is_favorite", length = 1)
    private Boolean isFavorite;

    @Column(name = "is_deleted", length = 1)
    private Boolean isDeleted;

    @ManyToMany(mappedBy = "items")
    private Set<Quest> quests;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createddate")
    private Date createdDate;

    @OneToMany(mappedBy = "item")
    protected Set<ShopItem> shopItems;

    @OneToMany(mappedBy = "item")
    protected Set<UserItem> userItems;

    public Item() {
    }

    public Item(ItemType type, String name, String description) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.rarity = Rarity.NORMAL;
        this.isFavorite = false;
        this.createdDate = new Date();
    }

    public Item(ItemType type, String name, String description, Rarity rarity) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.rarity = rarity;
        this.isFavorite = false;
        this.createdDate = new Date();
    }

    public Item(ItemType type, String name, String description, Rarity rarity, Boolean isFavorite) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.rarity = rarity;
        this.isFavorite = isFavorite;
        this.createdDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
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

    public Set<Quest> getQuests() {
        return quests;
    }

    public void setQuests(Set<Quest> quests) {
        this.quests = quests;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Set<ShopItem> getShopItems() {
        return shopItems;
    }

    public void setShopItems(Set<ShopItem> shopItems) {
        this.shopItems = shopItems;
    }

    public Set<UserItem> getUserItems() {
        return userItems;
    }

    public void setUserItems(Set<UserItem> userItems) {
        this.userItems = userItems;
    }
}
