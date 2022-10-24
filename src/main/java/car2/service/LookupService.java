package car2.service;

import car2.model.master.Car;
import car2.model.master.Lookup;
import car2.repo.CarRepo;
import car2.repo.LookupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LookupService {

    @Autowired
    private LookupRepo lookupRepo;

    public List<Lookup> getAll(){
        return lookupRepo.findAll();
    }

    public Lookup create(Lookup lookup) {
        Lookup record = lookupRepo.save(lookup);
        return record;
    }
}
