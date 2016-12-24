package example.dvdrental.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.Set;

import static org.hibernate.annotations.CascadeType.SAVE_UPDATE;
import static org.hibernate.annotations.CascadeType.PERSIST;

/**
 * Created by nipon on 12/24/16.
 */
@Entity
public class Inventory {
    @Id
    @SequenceGenerator(name = "inventory", sequenceName="inventory_inventory_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "inventory")
    @Column(name = "inventory_id")
    private Long inventoryId;

    @Column(name = "lastUpdated")
    private Timestamp lastUpdated;

    @ManyToOne
    @JoinColumn(name = "film_id")
    @Cascade({SAVE_UPDATE, PERSIST})
    private Film film;

    @OneToMany(mappedBy = "inventory")
    private Set<Rental> rentals;

    @Column(name = "store_id")
    private Long storeId;

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Set<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(Set<Rental> rentals) {
        this.rentals = rentals;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
