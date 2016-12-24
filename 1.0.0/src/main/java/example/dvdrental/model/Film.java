package example.dvdrental.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Set;

/**
 * Created by nipon on 12/21/16.
 */
@Entity
public class Film {
    @Id
    @SequenceGenerator(name = "film", sequenceName="film_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "film")
    @Column(name = "film_id")
    private Long filmId;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "language_id") // don't want config relation from language side
    @Cascade(value = CascadeType.ALL)
    private Language language;

    @OneToMany(mappedBy = "film")
    @Cascade(value = CascadeType.SAVE_UPDATE)
    private Set<Inventory> inventories;

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Set<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(Set<Inventory> inventories) {
        this.inventories = inventories;
    }
}
