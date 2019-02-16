package jdbc;

public class UserBalance {

    Long userId;

    Double balance;

    //Getter and Setter

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String toString() {
        return "{ userId: " + this.getUserId() + " , balance: " + this.getBalance() + " }";
    }
}