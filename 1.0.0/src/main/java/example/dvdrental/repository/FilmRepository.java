package example.dvdrental.repository;

import example.dvdrental.model.Film;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by nipon on 12/21/16.
 */
@Repository
public class FilmRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Film> getFilms() {
        Query query = entityManager.createQuery("FROM Film");
        return query.getResultList();
    }

    public List<Film> getFilmsUsingFetchJoin() {
        Query query = entityManager.createQuery("FROM Film film JOIN FETCH film.language");
        return query.getResultList();
    }
}
