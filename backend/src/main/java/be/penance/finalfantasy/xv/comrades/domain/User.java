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

  @OneToMany(mappedBy = "user")
  private Set<UserItem> userItems;

  @OneToMany(mappedBy = "user")
  private Set<UserLocation> userLocations;

  @OneToMany(mappedBy = "user")
  private Set<UserQuest> userQuests;

  @OneToMany(mappedBy = "user")
  private Set<UserShop> userShops;

  public User(String name, String description) {
    this.name = name;
    this.description = description;
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

  public Set<Character> getCharacters() {
    return characters;
  }

  public void setCharacters(Set<Character> characters) {
    this.characters = characters;
  }

  public Set<UserItem> getUserItems() {
    return userItems;
  }

  public void setUserItems(Set<UserItem> userItems) {
    this.userItems = userItems;
  }

  public Set<UserLocation> getUserLocations() {
    return userLocations;
  }

  public void setUserLocations(Set<UserLocation> userLocations) {
    this.userLocations = userLocations;
  }

  public Set<UserQuest> getUserQuests() {
    return userQuests;
  }

  public void setUserQuests(Set<UserQuest> userQuests) {
    this.userQuests = userQuests;
  }

  public Set<UserShop> getUserShops() {
    return userShops;
  }

  public void setUserShops(Set<UserShop> userShops) {
    this.userShops = userShops;
  }


}
