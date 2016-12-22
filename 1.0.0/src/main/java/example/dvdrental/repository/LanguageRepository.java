package example.dvdrental.repository;

import example.dvdrental.domain.FilmDomain;
import example.dvdrental.domain.LanguageDomain;
import example.dvdrental.model.Language;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nipon on 12/21/16.
 */
@Repository
public class LanguageRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<LanguageDomain> getLanguages() {
        Query query = entityManager.createQuery("FROM Language");

        return fetchToDomain(query.getResultList());
    }

    @Transactional
    public List<LanguageDomain> getLanguagesUsingFetchJoin() {
        Query query = entityManager.createQuery("FROM Language language LEFT JOIN FETCH language.films");

        return fetchToDomain(query.getResultList());
    }

    @Transactional
    public List<LanguageDomain> getLanguagesUsingFetchJoinByFilmId(Long filmId) {
        Query query = entityManager.createQuery("FROM Language language LEFT JOIN FETCH language.films film WHERE film.filmId = :filmId");
        query.setParameter("filmId", filmId);

        return fetchToDomain(query.getResultList());
    }

    private List<LanguageDomain> fetchToDomain(List<Language> languages) {
        return languages.stream()
                .map(language -> {
                    LanguageDomain languageDomain = new LanguageDomain();
                    BeanUtils.copyProperties(language, languageDomain);

                    languageDomain.setFilmDomains(
                            language.getFilms().stream()
                                    .map(film -> {
                                        FilmDomain filmDomain = new FilmDomain();
                                        BeanUtils.copyProperties(film, filmDomain);

                                        return filmDomain;
                                    })
                                    .collect(Collectors.toList())
                    );

                    return languageDomain;
                })
                .collect(Collectors.toList());
    }
}
