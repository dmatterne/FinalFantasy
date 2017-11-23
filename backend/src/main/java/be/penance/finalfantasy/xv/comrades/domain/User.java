package be.penance.finalfantasy.xv.comrades.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "USER", schema = "public", uniqueConstraints = @UniqueConstraint(name = "user_pk", columnNames = {"id"}))
public class User implements Serializable {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USR")
  @SequenceGenerator(name = "SEQ_USR", sequenceName = "usr_id_seq", allocationSize = 1)
  private Long id;

  @Column(name = "name", length = 255, unique = true)
  private String name;

  @Column(name = "desc", length = 4000)
  private String description;

  @OneToMany(mappedBy = "user")
  private Set<Character> characters;

  @ManyToMany
  @JoinTable(name = "UNLOCKED_",
    inverseJoinColumns = @JoinColumn(name = "ITEM_ID", referencedColumnName = "id",
      foreignKey = @ForeignKey(name = "quest_item_item_fk")),
    joinColumns = @JoinColumn(name = "QUEST_ID", referencedColumnName = "id",
      foreignKey = @ForeignKey(name = "quest_item_quest_fk")))
  private Set<Item> items;

}
