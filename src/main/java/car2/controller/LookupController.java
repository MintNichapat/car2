package car2.controller;

import car2.model.master.Car;
import car2.model.master.Lookup;
import car2.service.CarService;
import car2.service.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lookup")
public class LookupController {
    @Autowired
    private LookupService lookupService;

    @GetMapping
    public List<Lookup> getAll(){
        return lookupService.getAll();
    }

    @PostMapping
    public Lookup create(@RequestBody Lookup lookup) {
        return lookupService.create(lookup);
    }

}
