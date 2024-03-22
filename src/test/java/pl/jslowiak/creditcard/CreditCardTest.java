package pl.jslowiak.creditcard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class CreditCardTest {

    @Test
    void itAllowsToAssignCreditLimit() {
        //Arrange
        CreditCard card = thereIsExampleCreditCard();
        //Act
        card.assignCreditLimit(BigDecimal.valueOf(1000));
        //Assert
        assert BigDecimal.valueOf(1000)
                .equals(card.getBalance());
    }

    @Test
    void itAllowsToAssignCreditLimit2() {
        //Arrange
        CreditCard card = thereIsExampleCreditCard();
        //Act
        card.assignCreditLimit(BigDecimal.valueOf(2000));
        //Assert
        assertEquals(BigDecimal.valueOf(2000),
                card.getBalance(),
                "Card balance does not match expected value");
    }

    @Test
    void itDenyToChangeAlreadyAssignedCredit() {
        CreditCard card = thereIsExampleCreditCard();
        card.assignCreditLimit(BigDecimal.valueOf(1000));

        try {
            card.assignCreditLimit(BigDecimal.valueOf(2000));
            fail("Exception should be thrown");
        } catch (CreditCantBeModifiedException e) {
            assertTrue(true);
        }
    }

    @Test
    void itDenyToChangeAlreadyAssignedCreditV2() {
        CreditCard card = thereIsExampleCreditCard();
        card.assignCreditLimit(BigDecimal.valueOf(1000));

        assertThrows(
                CreditCantBeModifiedException.class,
                () -> card.assignCreditLimit(BigDecimal.valueOf(2000)));
    }

    @Test
    void itAllowsToPayBills() {
        CreditCard card = thereIsExampleCreditCard();
        card.assignCreditLimit(BigDecimal.valueOf(1000));

        card.withdraw(BigDecimal.valueOf(550));

        assertEquals(
                BigDecimal.valueOf(450),
                card.getBalance());
    }

    @Test
    void denyWithdrawBeyondCurrentBalance() {
        CreditCard card = thereIsExampleCreditCard();
        card.assignCreditLimit(BigDecimal.valueOf(1000));

        card.withdraw(BigDecimal.valueOf(900));

        assertThrows(
                NotEnoughFoundsException.class,
                () -> card.withdraw(BigDecimal.valueOf(200)));
    }

    private static CreditCard thereIsExampleCreditCard() {
        CreditCard card = new CreditCard("1234-56789");
        return card;
    }
}
