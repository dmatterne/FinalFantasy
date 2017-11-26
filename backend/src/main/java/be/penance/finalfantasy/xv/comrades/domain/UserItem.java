package be.penance.finalfantasy.xv.comrades.domain;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "USER_ITEM", schema = "public", uniqueConstraints = @UniqueConstraint(name = "user_item_pk", columnNames = {"USER_ID" , "ITEM_ID"}))
@Immutable
public class UserItem {

    @Embeddable
    public static class Id implements Serializable {
        @Column(name = "USER_ID")
        protected Long userId;
        @Column(name = "ITEM_ID")
        protected Long itemId;

        public Id() {
        }
        public Id(Long userId, Long itemId) {
            this.userId = userId;
            this.itemId = itemId;
        }

        public boolean equals(Object o) {
            if (o != null && o instanceof Id) {
                Id that = (Id) o;
                return this.userId.equals(that.userId)
                        && this.itemId.equals(that.itemId);
            }
            return false;
        }
        public int hashCode() {
            return userId.hashCode() + itemId.hashCode();
        }

    }

    @EmbeddedId
    protected Id id = new Id();

    @Column
    @NotNull
    protected Integer quantity;

    @ManyToOne
    @JoinColumn(
            name = "USER_ID",insertable = false, updatable = false)
    protected User user;

    @ManyToOne
    @JoinColumn(
            name = "ITEM_ID",insertable = false, updatable = false)
    protected Item item;

    public UserItem(
            Integer quantity,
            User user,
            Item item) {
        this.quantity = quantity;
        this.user = user;
        this.item = item;
        this.id.userId = user.getId();
        this.id.itemId = item.getId();
        user.getUserItems().add(this);
    }
}