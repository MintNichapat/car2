package car2.service;

import car2.model.master.Car;
import car2.model.security.User;
import car2.repo.CarRepo;
import car2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getAll(){
        return userRepo.findAll();
    }

    public User create(User user) {
        User record = userRepo.save(user);
        return record;
    }

    public User getByUsername(String username){
        return userRepo.findByUsername(username);
    }
}
