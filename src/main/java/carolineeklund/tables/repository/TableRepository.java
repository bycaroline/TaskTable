package carolineeklund.tables.repository;

import carolineeklund.tables.model.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<RestaurantTable, Long>{
}
