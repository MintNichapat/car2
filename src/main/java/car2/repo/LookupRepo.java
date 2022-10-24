package car2.repo;

import car2.model.master.Lookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LookupRepo extends JpaRepository<Lookup, UUID> {
}
