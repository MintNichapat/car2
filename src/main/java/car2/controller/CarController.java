package car2.controller;

import car2.model.master.Car;
import car2.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public String getCars(Model model) {
        model.addAttribute("cars", carService.getAll());
        return "car";
    }


    @ResponseBody
    public void getCar(Model model, @RequestParam UUID id) {
        System.out.println(id);
//        model.addAttribute("car", carService.getCarById(id));
    }
    @GetMapping("/add")
    public String getAddPage() {
        return "car-add";
    }

    @PostMapping("/add")
    public String addCar(@ModelAttribute Car car, Model model) {
        car.setStatus("sale");
        carService.create(car);
        return "redirect:/car";
    }

    @PostMapping("/update/sold")
    public void updateSoldStatus(@ModelAttribute Car car, Model model){
//        System.out.println(car);
    }
}
