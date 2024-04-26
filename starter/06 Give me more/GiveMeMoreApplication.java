//Create a simple API that have two endpoints (get user, get users) that retrieves information about a collection of users and a specific user
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GiveMeMoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(GiveMeMoreApplication.class, args);
    }

    @RestController
    public class UserController {

        private List<User> users;

        public UserController() {
            // Initialize the list of users
            users = new ArrayList<>();
            users.add(new User(1, "John Doe"));
            users.add(new User(2, "Jane Smith"));
            users.add(new User(3, "Bob Johnson"));
        }

        @GetMapping("/users")
        public List<User> getUsers() {
            return users;
        }

        @GetMapping("/users/{id}")
        public User getUser(@PathVariable int id) {
            // Find the user with the given id
            for (User user : users) {
                if (user.getId() == id) {
                    return user;
                }
            }
            return null; // User not found
        }
    }

    public class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}