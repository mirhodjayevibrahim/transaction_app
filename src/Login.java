public class Login {
    public User user;
    public boolean log = false;

    public User login(String email, String password) {
        if (User.users.containsKey(email) && User.users.get(email).equals(password)) {
            System.out.println("Login successful");
            log = true;
            return User.usersList.stream().filter(u -> u.email.equals(email)).findFirst().orElse(null);
        } else if (User.users.containsKey(email)) {
            System.out.println("Incorrect password, please try again");
            return null;
        } else {
            System.out.println("Email does not exist, please register first");
            return null;
        }
    }
}
