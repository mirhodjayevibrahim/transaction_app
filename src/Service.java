import java.util.List;
import java.util.Map;

public class Service {
    User user;
    Service(User user){
        this.user = user;
    }

    public void deposit(long amount){
        user.balance += amount;
        user.transactions.add("Deposit: " + amount);
        User.balances.put(user, user.getBalance());
        System.out.println("Deposit successful, your new balance is: " + user.getBalance());
    }

    public void withdraw(long amount){
        if (user.getBalance() < amount) {
            System.out.println("Insufficient balance, your current balance is: " + user.getBalance());
        } else {
            user.balance -= amount;
            user.transactions.add("Withdraw: " + amount);
            User.balances.put(user, user.getBalance());
            System.out.println("Withdraw successful, your new balance is: " + user.getBalance());
        }
    }

    public void checkbalance(){
        System.out.println("Your current balance is: " + user.getBalance());
    }

    public void transfer(User user1, long amount){
        if (user.getBalance() < amount) {
            System.out.println("Insufficient balance, your current balance is: " + user.getBalance());
        }
        else if(user == user1){
            System.out.println("you can not transer to your self");
        }
        else {
            user.balance -= amount;
            user1.balance += amount;
            user.transactions.add("Transfer to " + user1.email + ": " + amount);
            user1.transactions.add("Transfer from " + user.email + ": " + amount);
            User.balances.put(user, user.getBalance());
            User.balances.put(user1, user1.getBalance());
            System.out.println("Transfer successful, your new balance is: " + user.getBalance());
        }
    }

    public void histroy(){
        System.out.println("Your transactions history: " + user.transactions.toString());
    }
}
