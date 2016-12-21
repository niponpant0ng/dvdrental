package example.dvdrental.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by nipon on 12/21/16.
 */
@Entity
public class Language {
    @Id
    @SequenceGenerator(name = "language", sequenceName="language_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "language")
    @Column(name = "language_id")
    private Long languageId;

    private String name;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @OneToMany(mappedBy = "language")
    private List<Film> films;

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
