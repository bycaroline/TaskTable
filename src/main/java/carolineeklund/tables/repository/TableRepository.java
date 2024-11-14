package carolineeklund.tables.repository;

import carolineeklund.tables.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table, Long>{
}
