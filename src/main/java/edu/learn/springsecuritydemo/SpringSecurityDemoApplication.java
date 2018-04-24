package edu.learn.springsecuritydemo;

import edu.learn.entities.User;
import edu.learn.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.learn.config","edu.learn.restcontrollers","edu.learn.controllers"})
@EnableReactiveMongoRepositories(basePackages = {"edu.learn.repos"})
public class SpringSecurityDemoApplication {

    @Bean
    CommandLineRunner addUsers(UserRepository users){
        return args -> {
            // sha256 w/ salt encoded "password"
            String passsword = "73ac8218b92f7494366bf3a03c0c2ee2095d0c03a29cb34c95da327c7aa17173248af74d46ba2d4c";

            User rob = new User(1L, "rob@abbasi.com", passsword, "Rob", "Winch");
            User joe = new User(100L, "a@abbasi.com", passsword, "Joe", "Grandja");
            User vedran = new User(200L, "n@abbasi.com", passsword, "Vedran", "Pavić");

            users.save(rob).block();
            users.save(joe).block();
            users.save(vedran).block();

            users.findAll()
                    .doOnNext(user -> user.setPassword("{sha256}" + user.getPassword()))
                    .flatMap(users::save)
                    .collectList()
                    .block();
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoApplication.class, args);
    }
}
