package carolineeklund.tables.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private int number_of_seats;

    private boolean reserved;

}
