package car2.service;

import car2.model.master.Car;
import car2.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarService {

    @Autowired
    private CarRepo carRepo;

    public List<Car> getAll() {
        return carRepo.findAll();
    }

    public Car getCarById(UUID id){return  carRepo.getById(id);}

    public Car create(Car car) {
        Car record = carRepo.save(car);
        return record;
    }

}
