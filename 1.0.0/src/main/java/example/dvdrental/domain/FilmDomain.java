package example.dvdrental.domain;

/**
 * Created by nipon on 12/22/16.
 */
public class FilmDomain {
    private Long filmId;
    private String title;
    private String description;
    private LanguageDomain languageDomain;

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

    public LanguageDomain getLanguageDomain() {
        return languageDomain;
    }

    public void setLanguageDomain(LanguageDomain languageDomain) {
        this.languageDomain = languageDomain;
    }
}
