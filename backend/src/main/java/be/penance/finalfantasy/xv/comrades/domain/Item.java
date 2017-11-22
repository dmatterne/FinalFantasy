package be.penance.finalfantasy.xv.comrades.domain;

import be.penance.finalfantasy.xv.comrades.enums.EquipType;
import be.penance.finalfantasy.xv.comrades.enums.ItemType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ITEM", schema = "public", uniqueConstraints = @UniqueConstraint(name = "item_pk", columnNames = {"id"}))
public class Item implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ITEM")
    @SequenceGenerator(name = "SEQ_ITEM", sequenceName = "item_id_seq",  allocationSize = 1)
    private Long id;

    @Column(name = "name", length = 255, unique = true)
    private String name;

    @Column(name = "desc", length = 4000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "equip_type", length = 1)
    private EquipType equipType;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 1)
    private ItemType type;

    @Column(name = "max_level", length = 5)
    private Integer max_level;

    @Column(name = "base_attack", length = 5)
    private Integer baseAttack;

    @Column(name = "base_hp", length = 5)
    private Integer baseHp;

    @Column(name = "base_mp", length = 5)
    private Integer baseMp;

    @Column(name = "base_vit", length = 5)
    private Integer baseVit;

    @Column(name = "base_str", length = 5)
    private Integer baseStr;

    @Column(name = "base_mag", length = 5)
    private Integer baseMag;

    @Column(name = "base_spr", length = 5)
    private Integer baseSpr;

    @Column(name = "base_fire_res", length = 5)
    private Integer baseFireResist;

    @Column(name = "base_ice_res", length = 5)
    private Integer baseIceResist;

    @Column(name = "base_thunder_res", length = 5)
    private Integer baseThunderResist;

    @Column(name = "base_dark_res", length = 5)
    private Integer baseDarkResist;

    @Column(name = "base_shot_res", length = 5)
    private Integer baseShotResist;

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

    @ManyToOne
    @JoinColumn(name = "default_skill_1", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "item_skill_1_fk"))
    private Skill defaultSkill1;

    @ManyToOne
    @JoinColumn(name = "default_skill_2", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "item_skill_2_fk"))
    private Skill defaultSkill2;

    public Item(String name, String description, ItemType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public Item(String name, String description, EquipType equipType, ItemType type, Integer max_level,
                Integer baseAttack, Integer baseHp, Integer baseMp, Integer baseVit, Integer baseStr, Integer baseMag,
                Integer baseSpr, Integer baseFireResist, Integer baseIceResist, Integer baseThunderResist,
                Integer baseDarkResist, Integer baseShotResist, Boolean hasHpUpgr, Boolean hasMpUpgr,
                Boolean hasVitUpgr, Boolean hasStrUpgr, Boolean hasMagUpgr, Boolean hasSprUpgr, Boolean hasFireUpgr,
                Boolean hasIceUpgr, Boolean hasThunderUpgr, Boolean hasDarkUpgr, Boolean hasShotUpgr) {
        this.name = name;
        this.description = description;
        this.equipType = equipType;
        this.type = type;
        this.max_level = max_level;
        this.baseAttack = baseAttack;
        this.baseHp = baseHp;
        this.baseMp = baseMp;
        this.baseVit = baseVit;
        this.baseStr = baseStr;
        this.baseMag = baseMag;
        this.baseSpr = baseSpr;
        this.baseFireResist = baseFireResist;
        this.baseIceResist = baseIceResist;
        this.baseThunderResist = baseThunderResist;
        this.baseDarkResist = baseDarkResist;
        this.baseShotResist = baseShotResist;
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
    }

    public Item(String name, String description, EquipType equipType, ItemType type, Integer max_level,
                Integer baseAttack, Integer baseHp, Integer baseMp, Integer baseVit, Integer baseStr, Integer baseMag,
                Integer baseSpr, Integer baseFireResist, Integer baseIceResist, Integer baseThunderResist,
                Integer baseDarkResist, Integer baseShotResist, Boolean hasHpUpgr, Boolean hasMpUpgr,
                Boolean hasVitUpgr, Boolean hasStrUpgr, Boolean hasMagUpgr, Boolean hasSprUpgr, Boolean hasFireUpgr,
                Boolean hasIceUpgr, Boolean hasThunderUpgr, Boolean hasDarkUpgr, Boolean hasShotUpgr,
                Skill defaultSkill1) {
        this.name = name;
        this.description = description;
        this.equipType = equipType;
        this.type = type;
        this.max_level = max_level;
        this.baseAttack = baseAttack;
        this.baseHp = baseHp;
        this.baseMp = baseMp;
        this.baseVit = baseVit;
        this.baseStr = baseStr;
        this.baseMag = baseMag;
        this.baseSpr = baseSpr;
        this.baseFireResist = baseFireResist;
        this.baseIceResist = baseIceResist;
        this.baseThunderResist = baseThunderResist;
        this.baseDarkResist = baseDarkResist;
        this.baseShotResist = baseShotResist;
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
        this.defaultSkill1 = defaultSkill1;
    }

    public Item(String name, String description, EquipType equipType, ItemType type, Integer max_level,
                Integer baseAttack, Integer baseHp, Integer baseMp, Integer baseVit, Integer baseStr, Integer baseMag,
                Integer baseSpr, Integer baseFireResist, Integer baseIceResist, Integer baseThunderResist,
                Integer baseDarkResist, Integer baseShotResist, Boolean hasHpUpgr, Boolean hasMpUpgr,
                Boolean hasVitUpgr, Boolean hasStrUpgr, Boolean hasMagUpgr, Boolean hasSprUpgr, Boolean hasFireUpgr,
                Boolean hasIceUpgr, Boolean hasThunderUpgr, Boolean hasDarkUpgr, Boolean hasShotUpgr,
                Skill defaultSkill1, Skill defaultSkill2) {
        this.name = name;
        this.description = description;
        this.equipType = equipType;
        this.type = type;
        this.max_level = max_level;
        this.baseAttack = baseAttack;
        this.baseHp = baseHp;
        this.baseMp = baseMp;
        this.baseVit = baseVit;
        this.baseStr = baseStr;
        this.baseMag = baseMag;
        this.baseSpr = baseSpr;
        this.baseFireResist = baseFireResist;
        this.baseIceResist = baseIceResist;
        this.baseThunderResist = baseThunderResist;
        this.baseDarkResist = baseDarkResist;
        this.baseShotResist = baseShotResist;
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
        this.defaultSkill1 = defaultSkill1;
        this.defaultSkill2 = defaultSkill2;
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

    public EquipType getEquipType() {
        return equipType;
    }

    public void setEquipType(EquipType equipType) {
        this.equipType = equipType;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public Integer getMax_level() {
        return max_level;
    }

    public void setMax_level(Integer max_level) {
        this.max_level = max_level;
    }

    public Integer getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(Integer baseAttack) {
        this.baseAttack = baseAttack;
    }

    public Integer getBaseHp() {
        return baseHp;
    }

    public void setBaseHp(Integer baseHp) {
        this.baseHp = baseHp;
    }

    public Integer getBaseMp() {
        return baseMp;
    }

    public void setBaseMp(Integer baseMp) {
        this.baseMp = baseMp;
    }

    public Integer getBaseVit() {
        return baseVit;
    }

    public void setBaseVit(Integer baseVit) {
        this.baseVit = baseVit;
    }

    public Integer getBaseStr() {
        return baseStr;
    }

    public void setBaseStr(Integer baseStr) {
        this.baseStr = baseStr;
    }

    public Integer getBaseMag() {
        return baseMag;
    }

    public void setBaseMag(Integer baseMag) {
        this.baseMag = baseMag;
    }

    public Integer getBaseSpr() {
        return baseSpr;
    }

    public void setBaseSpr(Integer baseSpr) {
        this.baseSpr = baseSpr;
    }

    public Integer getBaseFireResist() {
        return baseFireResist;
    }

    public void setBaseFireResist(Integer baseFireResist) {
        this.baseFireResist = baseFireResist;
    }

    public Integer getBaseIceResist() {
        return baseIceResist;
    }

    public void setBaseIceResist(Integer baseIceResist) {
        this.baseIceResist = baseIceResist;
    }

    public Integer getBaseThunderResist() {
        return baseThunderResist;
    }

    public void setBaseThunderResist(Integer baseThunderResist) {
        this.baseThunderResist = baseThunderResist;
    }

    public Integer getBaseDarkResist() {
        return baseDarkResist;
    }

    public void setBaseDarkResist(Integer baseDarkResist) {
        this.baseDarkResist = baseDarkResist;
    }

    public Integer getBaseShotResist() {
        return baseShotResist;
    }

    public void setBaseShotResist(Integer baseShotResist) {
        this.baseShotResist = baseShotResist;
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

    public Skill getDefaultSkill1() {
        return defaultSkill1;
    }

    public void setDefaultSkill1(Skill defaultSkill1) {
        this.defaultSkill1 = defaultSkill1;
    }

    public Skill getDefaultSkill2() {
        return defaultSkill2;
    }

    public void setDefaultSkill2(Skill defaultSkill2) {
        this.defaultSkill2 = defaultSkill2;
    }
}
