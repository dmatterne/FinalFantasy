package be.penance.finalfantasy.xv.comrades.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CHARACTER", schema = "public", uniqueConstraints = @UniqueConstraint(name = "character_pk", columnNames = {"id"}))
public class Character implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CHAR")
    @SequenceGenerator(name = "SEQ_CHAR", sequenceName = "char_id_seq",  allocationSize = 1)
    private Long id;

    @Column(name = "name", length = 255, unique = true)
    private String name;

    @Column(name = "desc", length = 4000)
    private String description;
}
