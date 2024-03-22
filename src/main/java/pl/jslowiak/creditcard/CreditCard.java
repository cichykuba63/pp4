package pl.jslowiak.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal credit;
    private BigDecimal balance;
    public CreditCard(String cardNumber)
    {

    }

    public void assignCreditLimit(BigDecimal creditLimit)
    {
        if (this.credit != null) {
            throw new CreditCantBeModifiedException();
        }
        this.credit = creditLimit;
        this.balance = creditLimit;
    }

    public BigDecimal getBalance()
    {
        return credit;
    }

    public void withdraw(BigDecimal money) {
        if (!canAfford(money)) {
            throw new NotEnoughFoundsException();
        }
        this.balance = this.balance.subtract(money);
    }

    private boolean canAfford(BigDecimal money) {
        return this.balance.subtract(money)
                .compareTo(BigDecimal.ZERO) < 0;
    }
}