package car2.controller;

import car2.model.security.User;
import car2.repo.UserRepo;
import car2.service.CarService;
import car2.service.UserService;
import car2.serviceImp.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserDetailsServiceImp userDetailsService;

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String getHomePage(Model model, Authentication auth) {
        if(auth != null){
            model.addAttribute("currentUser", userService.getByUsername(auth.getName()));
            return "home";
        }
        return "home";
    }

    @GetMapping("/car/get/{carType}")
    public String getCarType(Model model, @PathVariable String carType, Authentication auth){
        System.out.println("Car Type: " + carType);
        model.addAttribute("currentUser", userService.getByUsername(auth.getName()));
        model.addAttribute("filter", carType);
        model.addAttribute("cars", carService.getCarByType(carType));
        return "car";
    }
}
