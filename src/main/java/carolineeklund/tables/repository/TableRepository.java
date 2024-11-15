package carolineeklund.tables.repository;

import carolineeklund.tables.model.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TableRepository extends JpaRepository<RestaurantTable, Long>{
    @Query("SELECT t FROM RestaurantTable t WHERE t.number_of_seats = :numberOfSeats")
    List<RestaurantTable> findByNumber_of_seats(@Param("numberOfSeats") int numberOfSeats);
}
