package edu.learn.restcontrollers;

import edu.learn.entities.User;
import edu.learn.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.security.Principal;

@RestController
@RequestMapping(path = "/api/users")
public class UserRest {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/list")
    public Flux<User> getAllUsers(@AuthenticationPrincipal Principal user){
        System.out.println(user.getName());
        return this.userRepository.findAll();
    }
}
