package be.penance.finalfantasy.xv.comrades.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SHOP", schema = "public", uniqueConstraints = @UniqueConstraint(name = "shop_pk", columnNames = {"id"}))
public class Shop implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MATER")
    @SequenceGenerator(name = "SEQ_MATER", sequenceName = "mater_id_seq",  allocationSize = 1)
    private Long id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "is_deleted", length = 1)
    private Boolean isDeleted;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createddate")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "location", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "shop_location_fk"))
    private Location location;





}
