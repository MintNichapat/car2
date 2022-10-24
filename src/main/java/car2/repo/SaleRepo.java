package car2.repo;

import car2.model.master.Car;
import car2.model.master.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SaleRepo extends JpaRepository<Sale, UUID> {

}
