package edu.learn.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Document(collection = "users")
@Data
public class User {
    @Id
    private Long id;

    @Indexed
    @NotEmpty(message = "This field is required")
    private String email;

    @NotEmpty(message = "This field is required")
    private String password;

    @NotEmpty(message = "This field is required")
    private String firstName;

    @NotEmpty(message = "This field is required")
    private String lastName;

    public User(){}

    public User(User user) {
        this(user.getId(), user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName());
    }

    public User(Long id, String email, String password, String firstName,
                String lastName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
