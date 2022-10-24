package car2.controller;

import car2.model.master.Car;
import car2.model.master.Sale;
import car2.service.CarService;
import car2.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public List<Sale> getAll(){
        return saleService.getAll();
    }

    @PostMapping
    public Sale create(@RequestBody Sale sale) {
        return saleService.create(sale);
    }
}
