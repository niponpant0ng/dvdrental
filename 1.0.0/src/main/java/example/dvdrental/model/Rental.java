package example.dvdrental.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Timestamp;

/**
 * Created by nipon on 12/24/16.
 */
@Entity
public class Rental {
    @Id
    @SequenceGenerator(name = "rental", sequenceName="rental_rental_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "rental")
    @Column(name = "rental_id")
    private Long rentalId;

    @Column(name = "rental_date")
    private Timestamp rentalDate;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.PERSIST})
    private Inventory inventory;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "staff_id")
    private Long staffId;

    public Long getRentalId() {
        return rentalId;
    }

    public void setRentalId(Long rentalId) {
        this.rentalId = rentalId;
    }

    public Timestamp getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Timestamp rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }
}
