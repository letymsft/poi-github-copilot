import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class GetOuttaHereApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetOuttaHereApplication.class, args);
    }
}

@RestController
@RequestMapping("/api/users")
class UserController {

    private List<User> userList;

    public UserController() {
        userList = new ArrayList<>();
        // Add some dummy users for testing
        userList.add(new User(1, "John"));
        userList.add(new User(2, "Jane"));
        userList.add(new User(3, "Alice"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeUser(@PathVariable int id) {
        User userToRemove = null;
        for (User user : userList) {
            if (user.getId() == id) {
                userToRemove = user;
                break;
            }
        }

        if (userToRemove != null) {
            userList.remove(userToRemove);
            return new ResponseEntity<>("User removed successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}

class User {
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