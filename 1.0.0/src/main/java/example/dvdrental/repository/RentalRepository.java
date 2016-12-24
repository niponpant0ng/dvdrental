package example.dvdrental.repository;

import example.dvdrental.model.Film;
import example.dvdrental.model.Inventory;
import example.dvdrental.model.Language;
import example.dvdrental.model.Rental;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by nipon on 12/24/16.
 */
@Repository
public class RentalRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Rental rentalNewFilm(String title) {
        Timestamp lastUpdate = new Timestamp(new Date().getTime());

        Language language = new Language();
        language.setName("en");
        language.setLastUpdate(lastUpdate);

        Film film = new Film();
        film.setTitle(title);
        film.setLanguage(language);

        Inventory inventory = new Inventory();
        inventory.setLastUpdated(lastUpdate);
        inventory.setFilm(film);
        inventory.setStoreId(1L);

        Rental rental = new Rental();
        rental.setInventory(inventory);
        rental.setRentalDate(lastUpdate);
        rental.setCustomerId(1L);
        rental.setStaffId(1L);

        entityManager.persist(rental);
        entityManager.flush();

        return rental;
    }
}
