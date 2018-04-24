package edu.learn.repos;

import edu.learn.entities.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User,Long> {
    Mono<User> findByEmail(String email);
}
