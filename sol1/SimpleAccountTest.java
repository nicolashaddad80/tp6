package fr.cnam.tp6.sol1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SimpleAccountTest {

    private final static double e = 0.0001;
    private int globalAccountNum=10001;
    private SimpleAccount  acc1;
    private Person p0;
    String nom="HADDAD";
    String prenom="Nicolas";
    Gender genre=Gender.MALE;

    @Before
    public void setUp() {
        this.p0 = new Person(nom,prenom,genre);
        this.acc1= new SimpleAccount(this.p0);
    }

    @Test
    public void testInitialisation() {
        assertNotNull(this.p0);
        assertNotNull(this.acc1);
        assertEquals(this.p0, this.acc1.getOwner());
        assertEquals(0, this.acc1.getAmount(),e);
    }

    @Test
    public void testCredit(){
        this.acc1.credit(60);
        assertEquals(60, this.acc1.getAmount(),e);
    }

    @Test
    public void testDebit(){
        this.acc1.debit(25);
        assertEquals(-25, this.acc1.getAmount(),e);
    }
/*
    @Test
    public void getNewAccountNumber(){
        assertEquals(10001, SimpleAccount.getNewAccountNumber());
        assertEquals(10002, SimpleAccount.getNewAccountNumber());
        assertEquals(10003, SimpleAccount.getNewAccountNumber());
    }
*/
    @Test
    public void testToString(){
        assertEquals("[(HADDAD, Nicolas, MALE), 0.0]",this.acc1.toString());
    }
}
