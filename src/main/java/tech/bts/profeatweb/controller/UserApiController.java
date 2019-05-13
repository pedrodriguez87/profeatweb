package tech.bts.profeatweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.bts.profeatweb.data.Meal;
import tech.bts.profeatweb.data.User;
import tech.bts.profeatweb.service.MealService;
import tech.bts.profeatweb.service.UserService;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(path = "/api/users")
public class UserApiController {

    private UserService userService;

    @Autowired
    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = POST)
    public String createUser(@RequestBody User user) {
        userService.createUser(user);
        return user.getId();
    }

    @RequestMapping(method = GET)
    public Collection<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = GET, path = "/{userId}")
    public User getUserById(@PathVariable String id) throws Exception {
        User user = userService.getUserById(id);

        if (user != null) {
            return user;
        } else {
            throw new Exception();
        }
    }

    @RequestMapping(method = POST, path = "/{userId}")
    public String updateMeal(@PathVariable String id) {
        User user = userService.getUserById(id);
        userService.updateUser(user);
        return user.getId();
    }
}
