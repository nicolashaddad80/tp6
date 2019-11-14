package fr.cnam.tp6.sol1;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckingAccountTest {
    private final static double e = 0.0001;
    private CheckingAccount acc1;
    private Person p0;
    String nom="HADDAD";
    String prenom="Nicolas";
    Gender genre=Gender.MALE;

    @Before
    public void setUp() throws Exception {
        this.p0 = new Person(nom,prenom,genre);
        this.acc1= new CheckingAccount(this.p0);
        this.acc1.credit(60);
        this.acc1.debit(20);
        this.acc1.credit(100);
        this.acc1.debit(50);
    }


    @Test
    public void testInitialisation() {
        assertNotNull(this.p0);
        assertNotNull(this.acc1);
        assertNotNull(this.acc1);
        assertEquals(this.p0, this.acc1.getOwner());
        assertEquals(this.p0, this.acc1.getOwner());
        assertEquals(90, this.acc1.getAmount(),e);
    }

    @Test
    public void getAccountStatement() {
        assertEquals("[\n1, 60.0\n2, -20.0\n3, 100.0\n4, -50.0\n]", this.acc1.getAccountStatement());
    }

    @Test
    public void getCreditStatement() {
        assertEquals("[\n1, 60.0\n2, 100.0\n]", this.acc1.getCreditStatement());
    }

    @Test
    public void getDebitStatement() {
        assertEquals("[\n1, -20.0\n2, -50.0\n]", this.acc1.getDebitStatement());
    }
}