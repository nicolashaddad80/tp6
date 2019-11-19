package fr.cnam.tp6.sol2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SavingsAccountTest extends CheckingAccountTest {

    @Override
    @Before
    public void setUp() {
        this.acc1= new SavingsAccount(this.p0);
    }

    @Test(expected = java.lang.AssertionError.class)
    public void creditExeedsMaxAmount() {
        this.acc1.credit(22950);
        this.acc1.credit(0.01);
        assertEquals(22950,this.acc1.getAmount(),e);
    }

    @Test(expected = java.lang.AssertionError.class)
    public void debitExeedsAmount() {
        this.acc1.credit(1000);
        this.acc1.debit(1000.01);
        assertEquals(1000,this.acc1.getAmount(),e);
    }

    @Test
    public void applyInterest1() {
        this.acc1.credit(1000);
        ((SavingsAccount)this.acc1).applyInterest();
        assertEquals(1010,this.acc1.getAmount(),e);
    }

    @Test
    public void applyInterest2() {
        this.acc1.credit(22950);
        ((SavingsAccount)this.acc1).applyInterest();
        assertEquals(23179.5,this.acc1.getAmount(),e);
    }

}