//Create a simple API that have one endpoint (insert user) that receives information about a users and retrieves a generated id and the count of users inserted

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@RestController
public class UserApiApplication {

    private Map<Integer, User> users = new HashMap<>();
    private AtomicInteger count = new AtomicInteger(0);

    @PostMapping("/users")
    public User insertUser(@RequestBody User user) {
        int id = count.incrementAndGet();
        user.setId(id);
        users.put(id, user);
        return user;
    }

    public static void main(String[] args) {
        SpringApplication.run(UserApiApplication.class, args);
    }

    public static class User {
        private int id;
        private String name;
        private String email;

        // getters and setters

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}