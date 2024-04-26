import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootApplication
@RestController
public class RestInAPI {

    private Map<Integer, User> users = new HashMap<>();
    private int userCount = 0;

    public static void main(String[] args) {
        SpringApplication.run(RestInAPI.class, args);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        return users.get(id);
    }

    @PostMapping("/users")
    public User insertUser(@RequestBody User user) {
        userCount++;
        user.setId(userCount);
        users.put(user.getId(), user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public void removeUser(@PathVariable int id) {
        users.remove(id);
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