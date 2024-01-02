package wallet;

public class Wallet {
    private int balance = 0;
    private String massage;
    private int cashToDispense = 0;

    public Wallet() {
    }

    public void debit(int money) {
        if (money > 0 && money <= this.balance) {
            this.massage = "Withdraw Successful";
            this.balance -= money;
            this.cashToDispense = money;
        } else if (money > this.balance) {
            this.massage = "Not enough money";
        } else if (money == 0) {
            this.massage = "You can't withdraw zero amount";
        } else {
            this.massage = "You can't withdraw negative amount";
        }
    }

    public void deposit(int money) {
        if (money >= 0) {
            this.balance += money;
        } else {
            this.massage = "You can't deposit negative values";
        }
    }

    public int getBalance() {
        return balance;
    }

    public String getWalletMassage() {
        return massage;
    }

    public int getCashToDispense() {
        return cashToDispense;
    }
}
