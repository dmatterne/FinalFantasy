package be.penance.finalfantasy.xv.comrades.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "LOCATION", schema = "public", uniqueConstraints = @UniqueConstraint(name = "location_pk", columnNames = {"id"}))
public class Location implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LOC")
    @SequenceGenerator(name = "SEQ_LOC", sequenceName = "loc_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", length = 255, unique = true)
    private String name;

    @Column(name = "desc", length = 4000)
    private String description;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "location")
    private Set<Shop> shops;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "location")
    private Set<Quest> quests;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createddate")
    private Date createdDate;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
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

    public Set<Shop> getShops() {
        return shops;
    }

    public void setShops(Set<Shop> shops) {
        this.shops = shops;
    }

    public Set<Quest> getQuests() {
        return quests;
    }

    public void setQuests(Set<Quest> quests) {
        this.quests = quests;
    }

}
