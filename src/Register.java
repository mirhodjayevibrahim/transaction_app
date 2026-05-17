public class Register {
    private User user;
    private boolean logged = false;


    public User register(String email, String password) {
        if (!password.matches("\\d{4}")) {
            System.out.println("PIN must be exactly 4 digits.");
            return null;
        }
        if (User.emailExists(email)) {
            System.out.println("Email already exists, please choose another email.");
            return null;
        }
        user = new User(email, password);
        logged = true;
        System.out.println("Registration successful.");
        return user;
    }

    public boolean isLogged() {
        return logged;
    }

    public User getUser() {
        return user;
    }
}