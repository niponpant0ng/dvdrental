package example.dvdrental.repository;

import example.dvdrental.AppConfig;
import example.dvdrental.domain.LanguageDomain;
import example.dvdrental.model.Language;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by nipon on 12/21/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class LanguagesTest {
    @Autowired
    private LanguageRepository languageRepository;

    @Test
    public void testGetFilms() {
        List<LanguageDomain> languages = languageRepository.getLanguages();

        assertThat(languages.size(), is(not(0)));
    }

    @Test
    public void testGetFilmsUsingFetchJoin() {
        List<LanguageDomain> languages = languageRepository.getLanguagesUsingFetchJoin();

        assertThat(languages.size(), is(not(0)));
    }
}
