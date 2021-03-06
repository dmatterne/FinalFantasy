package be.penance.finalfantasy.xv.comrades.domain;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "USER_QUEST", schema = "public", uniqueConstraints = @UniqueConstraint(name = "user_quest_pk", columnNames = {"USER_ID" , "QUEST_ID"}))
@Immutable
public class UserQuest {

    @Embeddable
    public static class Id implements Serializable {
        @Column(name = "USER_ID")
        protected Long userId;
        @Column(name = "QUEST_ID")
        protected Long questId;

        public Id() {
        }
        public Id(Long userId, Long questId) {
            this.userId = userId;
            this.questId = questId;
        }

        public boolean equals(Object o) {
            if (o != null && o instanceof Id) {
                Id that = (Id) o;
                return this.userId.equals(that.userId)
                        && this.questId.equals(that.questId);
            }
            return false;
        }
        public int hashCode() {
            return userId.hashCode() + questId.hashCode();
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
            name = "QUEST_ID",insertable = false, updatable = false)
    protected Quest quest;

    public UserQuest(
            Boolean isUnlocked,
            User user,
            Quest quest) {
        this.isUnlocked = isUnlocked;
        this.user = user;
        this.quest = quest;
        this.id.userId = user.getId();
        this.id.questId = quest.getId();
        user.getUserQuests().add(this);
    }
}