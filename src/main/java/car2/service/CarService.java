package car2.service;

import car2.model.master.Car;
import car2.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public void updateSoldStatus(UUID id){
        carRepo.findAll();
        Car currentCar = carRepo.findById(id).get();
        currentCar.setStatus("sold");
        carRepo.save(currentCar);
    }

    public List<Car> searchFromTier(String tier){
        List<Car> carList = carRepo.findAll();
        List<Car> filterCar = new ArrayList<>();
        if(tier != null){
            for (Car car: carList) {
                if(car.getCarType().contains(tier)){
                    filterCar.add(car);
                }
            }
            return filterCar;
        }
        return carRepo.findAll();
    }

    public List<Car> getCarByType(String carType){
        System.out.println(carType);
        List<Car> carList = carRepo.findAll();
        List<Car> filterCar = new ArrayList<>();
        if(carType != null){
            for (Car car: carList) {
                if(car.getCarType().equals(carType)){
                    filterCar.add(car);
                }
            }
            return filterCar;
        }
        return carRepo.findAll();
    }
}
