package car2.controller;

import car2.model.master.Car;
import car2.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
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

    @GetMapping("/update/sold/{id}")
    public String updateSoldStatus(Model model, @PathVariable UUID id){
        /*เรียกใช้ service ที่ส่ง id ไปแก้ไขสถานะ*/
        carService.updateSoldStatus(id);
        System.out.println("worked! id = "+ id);
        return "redirect:/car";
    }
}
