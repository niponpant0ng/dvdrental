package example.dvdrental.repository;

import example.dvdrental.AppConfig;
import example.dvdrental.model.Film;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;

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
}
