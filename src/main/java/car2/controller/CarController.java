package car2.controller;

import car2.model.master.Car;
import car2.service.CarService;
import car2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String getCars(Model model, Authentication auth) {
        model.addAttribute("cars", carService.getAll());
        model.addAttribute("currentUser", userService.getByUsername(auth.getName()));
        return "car";
    }

    @ResponseBody
    public void getCar(Model model, @RequestParam UUID id) {
    }
    @GetMapping("/add")
    public String getAddPage(Model model, Authentication auth) {
        model.addAttribute("currentUser", userService.getByUsername(auth.getName()));
        return "car-add";
    }

    @PostMapping("/add")
    public String addCar(@ModelAttribute Car car, Model model) {
        car.setStatus("sale");
        carService.create(car);
        return "redirect:/car";
    }

    @PostMapping("/edit")
    public String editCar(@ModelAttribute Car car, Model model) {
        carService.edit(car);
        return "redirect:/car";
    }

    @GetMapping("/update/sold/{id}")
    public String updateSoldStatus(Model model, @PathVariable UUID id){
        /*เรียกใช้ service ที่ส่ง id ไปแก้ไขสถานะ*/
        carService.updateSoldStatus(id);
        return "redirect:/car";
    }

    @GetMapping("/{id}")
    public String getCarDetail(Model model, Authentication auth,  @PathVariable UUID id){
        model.addAttribute("car", carService.getCarById(id));
        model.addAttribute("currentUser", userService.getByUsername(auth.getName()));
        return "car-detail";
    }

    @GetMapping("/search/{tier}")
    public String searchFromTier(Model model, @PathVariable String tier) {
        model.addAttribute("carList", carService.searchFromTier(tier));
        model.addAttribute("tier", tier);

        return "redirect:/car";
    }

    @PostMapping("/booked")
    public String bookedCar(Model model, Authentication auth, @ModelAttribute Car car){
        model.addAttribute("currentUser", userService.getByUsername(auth.getName()));
        carService.bookedCar(car);
        return "redirect:/car";
    }

    @GetMapping("/cancel/{id}")
    public String cancelBookCar(Model model, Authentication auth, @PathVariable UUID id){
        model.addAttribute("currentUser", userService.getByUsername(auth.getName()));
        carService.cancelBook(id);
        return "redirect:/car";
    }

    @GetMapping("/buy/{id}")
    public String bookedCar(Model model, Authentication auth, @PathVariable UUID id){
        model.addAttribute("currentUser", userService.getByUsername(auth.getName()));
        carService.updateSoldStatus(id);
        return "redirect:/car";
    }
}
