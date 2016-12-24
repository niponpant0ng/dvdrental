package example.dvdrental.repository;

import example.dvdrental.AppConfig;
import example.dvdrental.model.Rental;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nipon on 12/24/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class RentalRepositoryTest {
    @Autowired
    private RentalRepository rentalRepository;

    @Test
    @Transactional
    public void testCreateRentalNewFilm() {
        Rental rental = rentalRepository.rentalNewFilm("new film");

//        assertThat(rental.getRentalId(), is(notNullValue()));
//        assertThat(rental.getInventory().getInventoryId(), is(notNullValue()));
//        assertThat(rental.getInventory().getFilm().getFilmId(), is(notNullValue()));
    }
}
