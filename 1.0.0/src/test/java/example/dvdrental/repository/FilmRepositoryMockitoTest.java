package example.dvdrental.repository;

import example.dvdrental.AppConfig;
import example.dvdrental.domain.LanguageDomain;
import example.dvdrental.model.Film;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.powermock.api.mockito.PowerMockito.doReturn;

/**
 * Created by nipon on 12/22/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class FilmRepositoryMockitoTest {
    @InjectMocks
    private FilmRepository filmRepository;

    @Mock
    private LanguageRepository languageRepository;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Before
    public void before() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        MockitoAnnotations.initMocks(this);

        filmRepository.setEntityManager(entityManager);
    }

    @Test
    public void testGetFilms() {
        List<Film> films = filmRepository.getFilms();

        assertThat(films.size(), is(not(0)));
        films.forEach(film -> assertThat(film.getLanguage(), is(notNullValue())));
    }

    @Test
    public void testGetFilmsUsingFetchJoinByFilmId() {
        LanguageDomain languageDomain = new LanguageDomain();
        languageDomain.setLanguageId(1L);
        doReturn(Collections.singletonList(languageDomain)).when(languageRepository).getLanguages();

        List<Film> films = filmRepository.getFilmByLanguage();

        assertThat(films.size(), is(not(0)));
        films.forEach(film -> assertThat(film.getLanguage(), is(notNullValue())));
    }
}
