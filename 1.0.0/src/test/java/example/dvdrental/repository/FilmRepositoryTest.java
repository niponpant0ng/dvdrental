package example.dvdrental.repository;

import example.dvdrental.AppConfig;
import example.dvdrental.domain.FilmDomain;
import example.dvdrental.model.Actor;
import example.dvdrental.model.Film;
import example.dvdrental.model.Language;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * Created by nipon on 12/21/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class FilmRepositoryTest {
    @Autowired
    private FilmRepository filmRepository;

    @Test
    public void testGetFilms() {
        List<Film> films = filmRepository.getFilms();

        assertThat(films.size(), is(not(0)));
        films.forEach(film -> assertThat(film.getLanguage(), is(notNullValue())));
    }

    @Test
    public void testGetFilmsUsingFetchJoin() {
        List<Film> films = filmRepository.getFilmsUsingFetchJoin();

        assertThat(films.size(), is(not(0)));
        films.forEach(film -> assertThat(film.getLanguage(), is(notNullValue())));
    }

    @Test
    public void testGetFilmByLanguage() {
        List<Film> films = filmRepository.getFilmByLanguage();

        assertThat(films.size(), is(not(0)));
        films.forEach(film -> assertThat(film.getLanguage(), is(notNullValue())));
    }

    @Test
    @Transactional
    public void testCreateFilmWithLanguage() {
        Language language = new Language();
        language.setName("test");
        language.setLastUpdate(new Timestamp(new Date().getTime()));

        Film filmData = new Film();
        filmData.setTitle("hey test");
        filmData.setLanguage(language);

        Film film = filmRepository.create(filmData);

        assertThat(film.getFilmId(), is(notNullValue()));
        assertThat(film.getLanguage(), is(notNullValue()));
        assertThat(film.getLanguage().getLanguageId(), is(notNullValue()));
    }

    @Test
    @Transactional
    public void testFindFilmByRentalId() {
        List<FilmDomain> films = filmRepository.findFilmByCustomerRentalId(251L);

        assertThat(films.size(), is(not(0)));
        films.forEach(film -> assertThat(film.getLanguageDomain(), is(nullValue())));
    }

    @Test
    @Transactional
    public void testCreateWithActor() {
        Actor actor = new Actor();
        actor.setActorId(1L);
        actor.setName("john");

        Film film = filmRepository.getFilm(1L);
        film.setActors(Collections.singletonList(actor));

        filmRepository.create(film);
    }
}
