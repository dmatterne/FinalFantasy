package be.penance.finalfantasy.xv.comrades.domain;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "USER_SHOP", schema = "public", uniqueConstraints = @UniqueConstraint(name = "user_shop_pk", columnNames = {"USER_ID" , "SHOP_ID"}))
@Immutable
public class UserShop {

    @Embeddable
    public static class Id implements Serializable {
        @Column(name = "USER_ID")
        protected Long userId;
        @Column(name = "SHOP_ID")
        protected Long shopId;

        public Id() {
        }

        public Id(Long userId, Long shopId) {
            this.userId = userId;
            this.shopId = shopId;
        }

        public boolean equals(Object o) {
            if (o != null && o instanceof Id) {
                Id that = (Id) o;
                return this.userId.equals(that.userId)
                        && this.shopId.equals(that.shopId);
            }
            return false;
        }
        public int hashCode() {
            return userId.hashCode() + shopId.hashCode();
        }

    }

    @EmbeddedId
    protected Id id = new Id();

    @Column
    @NotNull
    protected Boolean isUnlocked;

    @ManyToOne
    @JoinColumn(
            name = "USER_ID",insertable = false, updatable = false)
    protected User user;

    @ManyToOne
    @JoinColumn(
            name = "SHOP_ID",insertable = false, updatable = false)
    protected Shop shop;

    public UserShop(
            Boolean isUnlocked,
            User user,
            Shop shop) {
        this.isUnlocked = isUnlocked;
        this.user = user;
        this.shop = shop;
        this.id.userId = user.getId();
        this.id.shopId = shop.getId();
        user.getUserShops().add(this);
    }
}