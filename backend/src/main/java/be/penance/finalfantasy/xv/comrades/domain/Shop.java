package be.penance.finalfantasy.xv.comrades.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "SHOP", schema = "public", uniqueConstraints = @UniqueConstraint(name = "shop_pk", columnNames = {"id"}))
public class Shop implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SHOP")
    @SequenceGenerator(name = "SEQ_SHOP", sequenceName = "shop_id_seq",  allocationSize = 1)
    private Long id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "desc", length = 4000)
    private String description;

    @Column(name = "is_deleted", length = 1)
    private Boolean isDeleted;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createddate")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "location", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "shop_location_fk"))
    private Location location;

    @OneToMany(mappedBy = "shop")
    protected Set<ShopItem> shopItems;

    public Shop(String name, String description, Boolean isDeleted, Date createdDate, Location location) {
        this.name = name;
        this.description = description;
        this.isDeleted = isDeleted;
        this.createdDate = createdDate;
        this.location = location;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<ShopItem> getShopItems() {
        return shopItems;
    }

    public void setShopItems(Set<ShopItem> shopItems) {
        this.shopItems = shopItems;
    }
}
