package car2.controller;

import car2.model.security.User;
import car2.repo.UserRepo;
import car2.service.UserService;
import car2.serviceImp.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private UserDetailsServiceImp userDetailsService;
    private UserService userService;

    @RequestMapping("/")
    public String getHomePage(Model model, Authentication auth) {
        return "home";
    }
}
