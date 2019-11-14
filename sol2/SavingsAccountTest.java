package fr.cnam.tp6.sol2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SavingsAccountTest {
    private final static double e = 0.01;
    private SavingsAccount acc1;
    private Person p0;
    String nom="HADDAD";
    String prenom="Nicolas";
    Gender genre=Gender.MALE;

    @Before
    public void setUp() throws Exception {
        this.p0 = new Person(nom,prenom,genre);
        this.acc1= new SavingsAccount(this.p0);
    }

    @Test
    public void credit() {
        this.acc1.credit(22000);
        assertEquals(22000,this.acc1.getAmount(),e);
    }

    @Test
    public void debit() {
        this.acc1.credit(2000);
        this.acc1.debit(1500);
        assertEquals(500,this.acc1.getAmount(),e);
    }

    @Test
    public void creditExeedsMaxAmount() {
        this.acc1.credit(22950);
        this.acc1.credit(0.01);
        assertEquals(22950,this.acc1.getAmount(),e);
    }

    @Test
    public void debitExeedsAmount() {
        this.acc1.credit(1000);
        this.acc1.debit(1000.01);
        assertEquals(1000,this.acc1.getAmount(),e);
    }

    @Test
    public void applyInterest1() {
        this.acc1.credit(1000);
        this.acc1.applyInterest();
        assertEquals(1010,this.acc1.getAmount(),e);
    }

    @Test
    public void applyInterest2() {
        this.acc1.credit(22950);
        this.acc1.applyInterest();
        assertEquals(23179.5,this.acc1.getAmount(),e);
    }

}