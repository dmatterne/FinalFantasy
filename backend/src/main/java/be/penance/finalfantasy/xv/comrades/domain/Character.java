package be.penance.finalfantasy.xv.comrades.domain;

import be.penance.finalfantasy.xv.comrades.enums.ItemType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CHARACTER", schema = "public", uniqueConstraints = @UniqueConstraint(name = "char_pk", columnNames = {"id"}))
public class Character implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CHAR")
    @SequenceGenerator(name = "SEQ_CHAR", sequenceName = "char_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "desc", length = 4000)
    private String description;

    @Column(name = "current_level", length = 5)
    private Integer current_level;

    @Column(name = "base_attack", length = 5)
    private Integer attack;

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

    @ManyToOne
    @JoinColumns(
            foreignKey = @ForeignKey(name = "char_weapon_1_fk"),
            value = {
                    @JoinColumn(name = "weapon_1_userid", referencedColumnName = "user_id"),
                    @JoinColumn(name = "weapon_1_itemid", referencedColumnName = "item_id")
            }
    )
    private UserItem weapon1;

    @ManyToOne
    @JoinColumns(
            foreignKey = @ForeignKey(name = "char_weapon_2_fk"),
            value = {
                    @JoinColumn(name = "weapon_2_userid", referencedColumnName = "user_id"),
                    @JoinColumn(name = "weapon_2_itemid", referencedColumnName = "item_id")
            }
    )
    private UserItem weapon2;

    @ManyToOne
    @JoinColumns(
            foreignKey = @ForeignKey(name = "char_weapon_3_fk"),
            value = {
                    @JoinColumn(name = "weapon_3_userid", referencedColumnName = "user_id"),
                    @JoinColumn(name = "weapon_3_itemid", referencedColumnName = "item_id")
            }
    )
    private UserItem weapon3;

    @ManyToOne
    @JoinColumns(
            foreignKey = @ForeignKey(name = "char_weapon_4_fk"),
            value = {
                    @JoinColumn(name = "weapon_4_userid", referencedColumnName = "user_id"),
                    @JoinColumn(name = "weapon_4_itemid", referencedColumnName = "item_id")
            }
    )
    private UserItem weapon4;

    @ManyToOne
    @JoinColumns(
            foreignKey = @ForeignKey(name = "char_sigil_fk"),
            value = {
                    @JoinColumn(name = "sigil_userid", referencedColumnName = "user_id"),
                    @JoinColumn(name = "sigil_itemid", referencedColumnName = "item_id")
            }
    )
    private UserItem sigil;

    @Column(name = "is_favorite", length = 1)
    private Boolean isFavorite;

    @Column(name = "is_deleted", length = 1)
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "char_user_fk"))
    private User user;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createddate")
    private Date createdDate;

    public Character(String name, String description, Integer current_level, Integer attack, Integer hp, Integer mp,
                     Integer vitality, Integer strength, Integer magic, Integer spirit, Integer fireResist,
                     Integer iceResist, Integer thunderResist, Integer darkResist, Integer shotResist,
                     UserItem weapon1) {
        this.name = name;
        this.description = description;
        this.current_level = current_level;
        this.attack = attack;
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
        this.weapon1 = weapon1;
        this.isDeleted = false;
        this.isFavorite = false;
        this.createdDate = new Date();
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

    public Integer getCurrent_level() {
        return current_level;
    }

    public void setCurrent_level(Integer current_level) {
        this.current_level = current_level;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
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

    public UserItem getWeapon1() {
        return weapon1;
    }

    public void setWeapon1(UserItem weapon1) {
        this.weapon1 = weapon1;
    }

    public UserItem getWeapon2() {
        return weapon2;
    }

    public void setWeapon2(UserItem weapon2) {
        this.weapon2 = weapon2;
    }

    public UserItem getWeapon3() {
        return weapon3;
    }

    public void setWeapon3(UserItem weapon3) {
        this.weapon3 = weapon3;
    }

    public UserItem getWeapon4() {
        return weapon4;
    }

    public void setWeapon4(UserItem weapon4) {
        this.weapon4 = weapon4;
    }

    public UserItem getSigil() {
        return sigil;
    }

    public void setSigil(UserItem sigil) {
        this.sigil = sigil;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
