import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    String email;
    String password;
    long balance = 0;
    List<String> transactions = new ArrayList<>();
    public static List<User> usersList = new ArrayList<>();
    public static Map<String, String> users = new HashMap<>();
    public static Map<User, Long> balances = new HashMap<>();

    User(String email, String password){
        this.email = email;
        this.password = password;
        users.put(email, password);
        usersList.add(this);
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }


}
