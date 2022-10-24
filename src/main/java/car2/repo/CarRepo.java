package car2.repo;

import car2.model.master.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarRepo extends JpaRepository<Car, UUID> {

}
