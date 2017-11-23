package be.penance.finalfantasy.xv.comrades.domain;

import be.penance.finalfantasy.xv.comrades.enums.EquipItemType;
import be.penance.finalfantasy.xv.comrades.enums.ItemType;
import be.penance.finalfantasy.xv.comrades.enums.Rarity;

import javax.persistence.*;

@Entity
public class EquipmentItem extends Item {

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 1)
    private EquipItemType eType;

    @Column(name = "current_level", length = 5)
    private Integer current_level;

    @Column(name = "max_level", length = 5)
    private Integer max_level;

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

    @Column(name = "has_hp_upgr", length = 5)
    private Boolean hasHpUpgr;

    @Column(name = "has_mp_upgr", length = 5)
    private Boolean hasMpUpgr;

    @Column(name = "has_vit_upgr", length = 5)
    private Boolean hasVitUpgr;

    @Column(name = "has_str_upgr", length = 5)
    private Boolean hasStrUpgr;

    @Column(name = "has_mag_upgr", length = 5)
    private Boolean hasMagUpgr;

    @Column(name = "has_spr_upgr", length = 5)
    private Boolean hasSprUpgr;

    @Column(name = "has_fire_upgr", length = 5)
    private Boolean hasFireUpgr;

    @Column(name = "has_ice_upgr", length = 5)
    private Boolean hasIceUpgr;

    @Column(name = "has_thunder_upgr", length = 5)
    private Boolean hasThunderUpgr;

    @Column(name = "has_dark_upgr", length = 5)
    private Boolean hasDarkUpgr;

    @Column(name = "has_shot_upgr", length = 5)
    private Boolean hasShotUpgr;

    @Column(name = "exp", length = 10)
    private Integer experience;

    @ManyToOne
    @JoinColumn(name = "skill_1_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "equipitem_skill_1_fk"))
    private Skill skill1;

    @ManyToOne
    @JoinColumn(name = "skill_2_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "equipitem_skill_2_fk"))
    private Skill skill2;

    public EquipmentItem(ItemType type, String name, String description, EquipItemType eType, Integer current_level,
                         Integer max_level, Integer attack, Integer hp, Integer mp, Integer vitality, Integer strength,
                         Integer magic, Integer spirit, Integer fireResist, Integer iceResist, Integer thunderResist,
                         Integer darkResist, Integer shotResist, Boolean hasHpUpgr, Boolean hasMpUpgr,
                         Boolean hasVitUpgr, Boolean hasStrUpgr, Boolean hasMagUpgr, Boolean hasSprUpgr,
                         Boolean hasFireUpgr, Boolean hasIceUpgr, Boolean hasThunderUpgr, Boolean hasDarkUpgr,
                         Boolean hasShotUpgr, Integer experience, Skill skill1, Skill skill2) {
        super(type, name, description);
        this.eType = eType;
        this.current_level = current_level;
        this.max_level = max_level;
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
        this.hasHpUpgr = hasHpUpgr;
        this.hasMpUpgr = hasMpUpgr;
        this.hasVitUpgr = hasVitUpgr;
        this.hasStrUpgr = hasStrUpgr;
        this.hasMagUpgr = hasMagUpgr;
        this.hasSprUpgr = hasSprUpgr;
        this.hasFireUpgr = hasFireUpgr;
        this.hasIceUpgr = hasIceUpgr;
        this.hasThunderUpgr = hasThunderUpgr;
        this.hasDarkUpgr = hasDarkUpgr;
        this.hasShotUpgr = hasShotUpgr;
        this.experience = experience;
        this.skill1 = skill1;
        this.skill2 = skill2;
    }

    public EquipmentItem(ItemType type, String name, String description, Rarity rarity, EquipItemType eType,
                         Integer current_level, Integer max_level, Integer attack, Integer hp, Integer mp,
                         Integer vitality, Integer strength, Integer magic, Integer spirit, Integer fireResist,
                         Integer iceResist, Integer thunderResist, Integer darkResist, Integer shotResist,
                         Boolean hasHpUpgr, Boolean hasMpUpgr, Boolean hasVitUpgr, Boolean hasStrUpgr,
                         Boolean hasMagUpgr, Boolean hasSprUpgr, Boolean hasFireUpgr, Boolean hasIceUpgr,
                         Boolean hasThunderUpgr, Boolean hasDarkUpgr, Boolean hasShotUpgr, Integer experience,
                         Skill skill1, Skill skill2) {
        super(type, name, description, rarity);
        this.eType = eType;
        this.current_level = current_level;
        this.max_level = max_level;
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
        this.hasHpUpgr = hasHpUpgr;
        this.hasMpUpgr = hasMpUpgr;
        this.hasVitUpgr = hasVitUpgr;
        this.hasStrUpgr = hasStrUpgr;
        this.hasMagUpgr = hasMagUpgr;
        this.hasSprUpgr = hasSprUpgr;
        this.hasFireUpgr = hasFireUpgr;
        this.hasIceUpgr = hasIceUpgr;
        this.hasThunderUpgr = hasThunderUpgr;
        this.hasDarkUpgr = hasDarkUpgr;
        this.hasShotUpgr = hasShotUpgr;
        this.experience = experience;
        this.skill1 = skill1;
        this.skill2 = skill2;
    }

    public EquipmentItem(ItemType type, String name, String description, Rarity rarity, Boolean isFavorite,
                         EquipItemType eType, Integer current_level, Integer max_level, Integer attack, Integer hp,
                         Integer mp, Integer vitality, Integer strength, Integer magic, Integer spirit,
                         Integer fireResist, Integer iceResist, Integer thunderResist, Integer darkResist,
                         Integer shotResist, Boolean hasHpUpgr, Boolean hasMpUpgr, Boolean hasVitUpgr,
                         Boolean hasStrUpgr, Boolean hasMagUpgr, Boolean hasSprUpgr, Boolean hasFireUpgr,
                         Boolean hasIceUpgr, Boolean hasThunderUpgr, Boolean hasDarkUpgr, Boolean hasShotUpgr,
                         Integer experience, Skill skill1, Skill skill2) {
        super(type, name, description, rarity, isFavorite);
        this.eType = eType;
        this.current_level = current_level;
        this.max_level = max_level;
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
        this.hasHpUpgr = hasHpUpgr;
        this.hasMpUpgr = hasMpUpgr;
        this.hasVitUpgr = hasVitUpgr;
        this.hasStrUpgr = hasStrUpgr;
        this.hasMagUpgr = hasMagUpgr;
        this.hasSprUpgr = hasSprUpgr;
        this.hasFireUpgr = hasFireUpgr;
        this.hasIceUpgr = hasIceUpgr;
        this.hasThunderUpgr = hasThunderUpgr;
        this.hasDarkUpgr = hasDarkUpgr;
        this.hasShotUpgr = hasShotUpgr;
        this.experience = experience;
        this.skill1 = skill1;
        this.skill2 = skill2;
    }

    public EquipItemType getEType() {
        return eType;
    }

    public void setEType(EquipItemType eType) {
        this.eType = eType;
    }

    public Integer getCurrent_level() {
        return current_level;
    }

    public void setCurrent_level(Integer current_level) {
        this.current_level = current_level;
    }

    public Integer getMax_level() {
        return max_level;
    }

    public void setMax_level(Integer max_level) {
        this.max_level = max_level;
    }

    public Integer getAttack() {
        return this.attack;
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

    public Boolean getHasHpUpgr() {
        return hasHpUpgr;
    }

    public void setHasHpUpgr(Boolean hasHpUpgr) {
        this.hasHpUpgr = hasHpUpgr;
    }

    public Boolean getHasMpUpgr() {
        return hasMpUpgr;
    }

    public void setHasMpUpgr(Boolean hasMpUpgr) {
        this.hasMpUpgr = hasMpUpgr;
    }

    public Boolean getHasVitUpgr() {
        return hasVitUpgr;
    }

    public void setHasVitUpgr(Boolean hasVitUpgr) {
        this.hasVitUpgr = hasVitUpgr;
    }

    public Boolean getHasStrUpgr() {
        return hasStrUpgr;
    }

    public void setHasStrUpgr(Boolean hasStrUpgr) {
        this.hasStrUpgr = hasStrUpgr;
    }

    public Boolean getHasMagUpgr() {
        return hasMagUpgr;
    }

    public void setHasMagUpgr(Boolean hasMagUpgr) {
        this.hasMagUpgr = hasMagUpgr;
    }

    public Boolean getHasSprUpgr() {
        return hasSprUpgr;
    }

    public void setHasSprUpgr(Boolean hasSprUpgr) {
        this.hasSprUpgr = hasSprUpgr;
    }

    public Boolean getHasFireUpgr() {
        return hasFireUpgr;
    }

    public void setHasFireUpgr(Boolean hasFireUpgr) {
        this.hasFireUpgr = hasFireUpgr;
    }

    public Boolean getHasIceUpgr() {
        return hasIceUpgr;
    }

    public void setHasIceUpgr(Boolean hasIceUpgr) {
        this.hasIceUpgr = hasIceUpgr;
    }

    public Boolean getHasThunderUpgr() {
        return hasThunderUpgr;
    }

    public void setHasThunderUpgr(Boolean hasThunderUpgr) {
        this.hasThunderUpgr = hasThunderUpgr;
    }

    public Boolean getHasDarkUpgr() {
        return hasDarkUpgr;
    }

    public void setHasDarkUpgr(Boolean hasDarkUpgr) {
        this.hasDarkUpgr = hasDarkUpgr;
    }

    public Boolean getHasShotUpgr() {
        return hasShotUpgr;
    }

    public void setHasShotUpgr(Boolean hasShotUpgr) {
        this.hasShotUpgr = hasShotUpgr;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Skill getSkill1() {
        return skill1;
    }

    public void setSkill1(Skill skill1) {
        this.skill1 = skill1;
    }

    public Skill getSkill2() {
        return skill2;
    }

    public void setSkill2(Skill skill2) {
        this.skill2 = skill2;
    }
}
