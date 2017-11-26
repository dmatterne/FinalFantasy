package be.penance.finalfantasy.xv.comrades.domain;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "USER_LOCATION", schema = "public", uniqueConstraints = @UniqueConstraint(name = "user_loc_pk", columnNames = {"USER_ID" , "LOC_ID"}))
@Immutable
public class UserLocation {

    @Embeddable
    public static class Id implements Serializable {
        @Column(name = "USER_ID")
        protected Long userId;
        @Column(name = "LOC_ID")
        protected Long locationId;

        public Id() {
        }
        public Id(Long userId, Long locationId) {
            this.userId = userId;
            this.locationId = locationId;
        }

        public boolean equals(Object o) {
            if (o != null && o instanceof Id) {
                Id that = (Id) o;
                return this.userId.equals(that.userId)
                        && this.locationId.equals(that.locationId);
            }
            return false;
        }
        public int hashCode() {
            return userId.hashCode() + locationId.hashCode();
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
            name = "LOC_ID",insertable = false, updatable = false)
    protected Location location;

    public UserLocation(
            Boolean isUnlocked,
            User user,
            Location location) {
        this.isUnlocked = isUnlocked;
        this.user = user;
        this.location = location;
        this.id.userId = user.getId();
        this.id.locationId = location.getId();
        user.getUserLocations().add(this);
    }
}