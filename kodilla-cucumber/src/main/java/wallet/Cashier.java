package wallet;

public class Cashier {
    private final CashSlot cashSlot;

    public Cashier(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    public void withdraw(Wallet wallet, int amount) {
        if (wallet.getWalletMassage().equals("You can't deposit negative values")) {
            cashSlot.dispense(0);
        } else {
            wallet.debit(amount);
            cashSlot.dispense(wallet.getCashToDispense());
        }
    }
}
