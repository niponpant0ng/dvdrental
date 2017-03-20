package example.dvdrental.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by nipon on 3/20/17.
 */
@Entity
public class Actor {
    @Id
    @SequenceGenerator(name = "actor", sequenceName="actor_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "actor")
    @Column(name = "actor_id")
    private Long actorId;

    private String name;

    @ManyToMany
    @JoinTable(
        name = "actor_film",
        joinColumns = @JoinColumn(name = "actor_id"),
        inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private Set<Film> films;

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
