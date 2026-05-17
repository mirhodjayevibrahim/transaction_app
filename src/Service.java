public class Service {
    private User user;

    Service(User user) {
        this.user = user;
    }

    public void deposit(long amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }
        user.setBalance(user.getBalance() + amount);
        user.addTransaction("Deposit: " + amount);
        System.out.println("Deposit successful. New balance: " + user.getBalance());
    }


    public void withdraw(long amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }
        if (user.getBalance() < amount) {
            System.out.println("Insufficient balance. Current balance: " + user.getBalance());
            return;
        }
        user.setBalance(user.getBalance() - amount);
        user.addTransaction("Withdraw: " + amount);
        System.out.println("Withdrawal successful. New balance: " + user.getBalance());
    }


    public void checkBalance() {
        System.out.println("Current balance: " + user.getBalance());
    }

    public void transfer(String recipientEmail, long amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }
        if (user.getEmail().equals(recipientEmail)) {
            System.out.println("You cannot transfer to yourself.");
            return;
        }
        User recipient = User.findByEmail(recipientEmail);
        if (recipient == null) {
            System.out.println("User not found.");
            return;
        }
        if (user.getBalance() < amount) {
            System.out.println("Insufficient balance. Current balance: " + user.getBalance());
            return;
        }
        user.setBalance(user.getBalance() - amount);
        recipient.setBalance(recipient.getBalance() + amount);
        user.addTransaction("Transfer to " + recipient.getEmail() + ": " + amount);
        recipient.addTransaction("Transfer from " + user.getEmail() + ": " + amount);
        System.out.println("Transfer successful. New balance: " + user.getBalance());
    }


    public void history() {
        System.out.println("Transaction history: " + user.getTransactions());
    }
}