public class Login {
    private User user;
    private boolean logged = false;


    public User login(String email, String password) {
        if (!User.emailExists(email)) {
            System.out.println("Email does not exist, please register first.");
            return null;
        }
        if (!User.credentialsMatch(email, password)) {
            System.out.println("Incorrect PIN, please try again.");
            return null;
        }
        user = User.findByEmail(email);
        logged = true;
        System.out.println("Login successful.");
        return user;
    }

    public boolean isLogged() {
        return logged;
    }

    public User getUser() {
        return user;
    }
}