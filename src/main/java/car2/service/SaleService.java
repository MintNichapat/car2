package car2.service;

import car2.model.master.Car;
import car2.model.master.Sale;
import car2.repo.CarRepo;
import car2.repo.SaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepo saleRepo;

    public List<Sale> getAll(){
        return saleRepo.findAll();
    }

    public Sale create(Sale sale) {
        Sale record = saleRepo.save(sale);
        return record;
    }
}
