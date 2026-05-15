import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Register {
    public User user;
    public boolean log = false;
    public User register(String email, String password) throws IOException {
        if (User.users.containsKey(email)) {
            System.out.println("Email already exists, please choose another email");
            return null;
        }
        else {
            User user = new User(email, password);
            System.out.println("Register successful");
            log = true;
            return user;
        }


    }


}
