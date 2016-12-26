package example.dvdrental.repository;

import example.dvdrental.domain.FilmDomain;
import example.dvdrental.domain.LanguageDomain;
import example.dvdrental.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by nipon on 12/21/16.
 */
@Repository
public class FilmRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private LanguageRepository languageRepository;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Film> getFilms() {
        Query query = entityManager.createQuery("FROM Film");
        return query.getResultList();
    }

    public List<Film> getFilmsUsingFetchJoin() {
        Query query = entityManager.createQuery("FROM Film film JOIN FETCH film.language");
        return query.getResultList();
    }

    public List<Film> getFilmByLanguage() {
        List<LanguageDomain> languages = languageRepository.getLanguages();

        Query query = entityManager.createQuery("FROM Film film JOIN FETCH film.language language WHERE language.languageId IN :ids");
        query.setParameter("ids", languages.stream().map(LanguageDomain::getLanguageId).collect(Collectors.toList()));

        return query.getResultList();
    }

    public Film create(Film filmData) {
        entityManager.persist(filmData);
        entityManager.flush();

        return filmData;
    }

    public List<FilmDomain> findFilmByCustomerRentalId(Long customerId) {
        Query query = entityManager.createQuery("FROM Film film JOIN FETCH film.inventories inv JOIN FETCH inv.rentals rental WHERE rental.customerId = :id");
        query.setParameter("id", customerId);
        List<Film> films = query.getResultList();

        List<FilmDomain> filmDomains = new ArrayList<>();
        films.forEach(film -> {
            FilmDomain filmDomain = new FilmDomain();
            filmDomain.setFilmId(film.getFilmId());
            filmDomain.setDescription(film.getDescription());
            filmDomain.setTitle(film.getTitle());

            filmDomains.add(filmDomain);
        });

        return filmDomains;
    }
}
