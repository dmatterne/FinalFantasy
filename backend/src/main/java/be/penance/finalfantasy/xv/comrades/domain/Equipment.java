package be.penance.finalfantasy.xv.comrades.domain;

import be.penance.finalfantasy.xv.comrades.enums.EquipType;
import be.penance.finalfantasy.xv.comrades.enums.QuestType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EQUIPMENT", schema = "public", uniqueConstraints = @UniqueConstraint(name = "equip_pk", columnNames = {"id"}))
public class Equipment implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EQUIP")
    @SequenceGenerator(name = "SEQ_EQUIP", sequenceName = "equip_id_seq",  allocationSize = 1)
    private Long id;

    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "level", length = 5)
    private Integer level;

    @Column(name = "att", length = 5)
    private Integer attack;

    @Column(name = "hp", length = 5)
    private Integer hp;

    @Column(name = "mp", length = 5)
    private Integer mp;

    @Column(name = "vit", length = 5)
    private Integer vit;

    @Column(name = "str", length = 5)
    private Integer str;

    @Column(name = "mag", length = 5)
    private Integer mag;

    @Column(name = "spr", length = 5)
    private Integer spr;

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
    @Column(name = "skill_1", length = 5)
    private Skill skill1;

    @ManyToOne
    @Column(name = "skill_2", length = 5)
    private Skill skill2;
}
