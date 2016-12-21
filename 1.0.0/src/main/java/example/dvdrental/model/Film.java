package example.dvdrental.model;

import javax.persistence.*;

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
    @JoinColumn(name = "language_id")
    private Language language;

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
}
