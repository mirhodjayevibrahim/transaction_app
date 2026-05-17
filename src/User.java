import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String email;
    private String password;
    private long balance = 0;
    private List<String> transactions = new ArrayList<>();

    private static final List<User> usersList = new ArrayList<>();
    private static final Map<String, String> users = new HashMap<>();

    User(String email, String password) {
        this.email = email;
        this.password = password;
        users.put(email, password);
        usersList.add(this);
    }


    public String getEmail() {
        return email;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }


    public void addTransaction(String entry) {
        if (transactions.size() >= 10) {
            transactions.remove(0);
        }
        transactions.add(entry);
    }

    public List<String> getTransactions() {
        return new ArrayList<>(transactions); // defensive copy
    }


    public static boolean emailExists(String email) {
        return users.containsKey(email);
    }

    public static boolean credentialsMatch(String email, String password) {
        return users.containsKey(email) && users.get(email).equals(password);
    }

    public static User findByEmail(String email) {
        return usersList.stream()
                .filter(u -> u.email.equals(email))
                .findFirst()
                .orElse(null);
    }
}