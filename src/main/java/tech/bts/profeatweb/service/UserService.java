package tech.bts.profeatweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.bts.profeatweb.data.Meal;
import tech.bts.profeatweb.data.User;
import tech.bts.profeatweb.repository.MealRepository;
import tech.bts.profeatweb.repository.UserRepository;

import javax.jws.soap.SOAPBinding;
import java.util.Collection;

@Service
public class UserService {

    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        //User user = new User();
        userRepo.create(user);
        return user;
    }
    public Collection<User> getAllUsers() {
        return userRepo.getAll();
    }

    public User getUserById(String id) {
        return userRepo.getById(id);
    }
    public void updateUser(User user) {
        userRepo.update(user);
    }

    public boolean login(User user) {
        return userRepo.login(user);
    }
}
