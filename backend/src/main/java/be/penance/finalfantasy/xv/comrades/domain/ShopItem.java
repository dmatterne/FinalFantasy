package be.penance.finalfantasy.xv.comrades.domain;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "SHOP_ITEM", schema = "public", uniqueConstraints = @UniqueConstraint(name = "shop_item_pk", columnNames = {"SHOP_ID" , "ITEM_ID"}))
@Immutable
public class ShopItem {

    @Embeddable
    public static class Id implements Serializable {
        @Column(name = "SHOP_ID")
        protected Long shopId;
        @Column(name = "ITEM_ID")
        protected Long itemId;

        public Id() {
        }
        public Id(Long categoryId, Long itemId) {
            this.shopId = categoryId;
            this.itemId = itemId;
        }

        public boolean equals(Object o) {
            if (o != null && o instanceof Id) {
                Id that = (Id) o;
                return this.shopId.equals(that.shopId)
                        && this.itemId.equals(that.itemId);
            }
            return false;
        }
        public int hashCode() {
            return shopId.hashCode() + itemId.hashCode();
        }

    }

    @EmbeddedId
    protected Id id = new Id();

    @Column(updatable = false)
    @NotNull
    protected Integer price;

    @ManyToOne
    @JoinColumn(
            name = "SHOP_ID",insertable = false, updatable = false)
    protected Shop shop;

    @ManyToOne
    @JoinColumn(
            name = "ITEM_ID",insertable = false, updatable = false)
    protected Item item;

    public ShopItem(
            Integer price,
            Shop shop,
            Item item) {
        this.price = price;
        this.shop = shop;
        this.item = item;
        this.id.shopId = shop.getId();
        this.id.itemId = item.getId();
        shop.getShopItems().add(this);
    }
}
