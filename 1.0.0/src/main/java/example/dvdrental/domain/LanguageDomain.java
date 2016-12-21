package example.dvdrental.domain;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by nipon on 12/22/16.
 */
public class LanguageDomain {
    private Long languageId;
    private String name;
    private Timestamp lastUpdate;
    private List<FilmDomain> filmDomains;

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

    public List<FilmDomain> getFilmDomains() {
        return filmDomains;
    }

    public void setFilmDomains(List<FilmDomain> filmDomains) {
        this.filmDomains = filmDomains;
    }
}
