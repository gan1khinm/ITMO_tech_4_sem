package is.technologies.Controllers;

import is.technologies.Entities.BrandEntity;
import is.technologies.Entities.EngineEntity;
import is.technologies.Entities.User;
import is.technologies.Interfaces.SpringData.UserRepositoryDAO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserRepositoryDAO userRepository;

    public UserController(UserRepositoryDAO userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/get/{id}", produces = "application/json")
    @ResponseBody
    Optional<User> getById(@PathVariable("id") Long id){
        return userRepository.findById(id);
    }

    @GetMapping("/get")
    public List<User> findAll(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return users;
    }

    @PutMapping("/update")
    public String update(@RequestBody User user){
        userRepository.save(user);
        return "updated";
    }

    @PostMapping("/create")
    public String create(@RequestBody User user){
        userRepository.save(user);
        return "created";
    }

    @DeleteMapping(path = { "/delete/{id}" })
    public String deleteById(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return "deleted";
    }
}