package fr.cnam.tp6.sol1;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
public class MainTest {

    public static void main(String Args[] ){
        Person p0;
        String nom="HADDAD";
        String prenom="Nicolas";
        Gender genre=Gender.MALE;
        SimpleAccount asc0,asc1,asc2;
        CheckingAccount acc0,acc1,acc2;

        p0=new Person(nom,prenom,genre);

        asc0=new SimpleAccount(p0);
        assertEquals(10001,asc0.getAccountNum());

        asc1=new SimpleAccount(p0);
        assertEquals(10002,asc1.getAccountNum());

        asc2=new SimpleAccount(p0);
        assertEquals(10003,asc2.getAccountNum());

        acc0=new CheckingAccount(p0);
        assertEquals(10004,acc0.getAccountNum());

        acc1=new CheckingAccount(p0);
        assertEquals(10005,acc1.getAccountNum());

        acc2=new CheckingAccount(p0);
        assertEquals(10006,acc2.getAccountNum());
    }
}
