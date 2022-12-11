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

    public void bookedCar(Car car){
        carRepo.findAll();
        Car currentCar = carRepo.findById(car.getId()).get();
        currentCar.setStatus("booked");
        currentCar.setCustomerName(car.getCustomerName());
        currentCar.setCustomerPhone(car.getCustomerPhone());
        carRepo.save(currentCar);
    }

    public void cancelBook(UUID id){
        carRepo.findAll();
        Car currentCar = carRepo.findById(id).get();
        currentCar.setStatus("sale");
        currentCar.setCustomerName(null);
        currentCar.setCustomerPhone(null);
        carRepo.save(currentCar);
    }

    public void updateSoldStatus(UUID id){
        carRepo.findAll();
        Car currentCar = carRepo.findById(id).get();
        currentCar.setStatus("sold");
        carRepo.save(currentCar);
    }

    public void edit(Car car){
        carRepo.findAll();
        Car currentCar = carRepo.findById(car.getId()).get();
        currentCar.setImg(car.getImg());
        currentCar.setCarType(car.getCarType());
        currentCar.setTier(car.getTier());
        currentCar.setIssueDate(car.getIssueDate());
        currentCar.setDistance(car.getDistance());
        currentCar.setGearSystem(car.getGearSystem());
        currentCar.setRegistrationYear(car.getRegistrationYear());
        currentCar.setCapacity(car.getCapacity());
        currentCar.setColor(car.getColor());
        currentCar.setPrice(car.getPrice());
        currentCar.setCustomerName(car.getCustomerName());
        currentCar.setCustomerPhone(car.getCustomerPhone());
        carRepo.save(currentCar);
    }
}
