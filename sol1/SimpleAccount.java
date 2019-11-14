package fr.cnam.tp6.sol1;

/**
*___________________________________________________________<br>
 *                        NFP121:TP6 <br>
 *Nicolas HADDAD        <br>
 *nicolas.haddad80@gmail.com  <br>
 * _____________________________________________________________<br>
 *La classe SimpleAccount Modelise un Compte Bancaire Simple <br>
 *La modelisation d'un Compte Simple  est represente par la Personne qui le detient et son Solde courant  dans deux attribus <br>
 *____________________________________________________________________________________<br>
*/

public class SimpleAccount {

  /**
   * Compteur pour generer a chaque fois un nouveau numero de compte, on commence le premier compte a 10001
   */
  private static int genAccountNum=10001;

  /**
   * Methode pour obtenir un nouveau numlero de compte a chaque fois qu'elle est invoquee
   * @return : un nouveau numero de compte
   */
  protected static int getNewAccountNumber(){
    return genAccountNum++;
  }
  /** 
   *  Le Propritaire de  Compte Simple
   */
  protected Person owner;

  /** 
   *   Le solde de notre Compte Simple
   */
  protected double solde;


  /**
   * Le numero du Compte Simple
   */
  protected final int numAccount;
  /** 
   *  Constructeur de notre Compte Simple (solde initial mis  a zero)
   *  @param a_Owner : La Personne propritaire de notre Compte Simple
   */
  public  SimpleAccount(Person a_Owner) {
    this.owner=a_Owner;
    this.solde=0;
    this.numAccount=SimpleAccount.getNewAccountNumber();
  }

  /**
   *  Methode qui permet d'obtenir le numero de notre Compte Simple
   *  @return : le numero de notre Compte Simple
   */
  public int getAccountNum() {
    return this.numAccount;
  }

  /** 
   *  Methode qui permet de crediter notre Compte Simple d'une somme donnee
   *  @param a_Amount : la somme a crediter sur notre Compte Simple
   */
  public void credit(double a_Amount) {
    this.solde+=a_Amount;
  }

  /** 
   *  Methode qui permet de debiter une somme donnee de notre Compte Simple
   *  @param a_Amount : la somme a debiter de notre Compte Simple
   */
  public void debit(double a_Amount) {
    this.solde-=a_Amount;
  }

  /** 
   *  Methode qui permet d'afficher notre Compte Simple sur la cosol
   *  @return : La chaine de caracteres representant notre Compte Simple
   */
  public String toString() {
  return "["+this.owner.toString()+", "+this.solde+"]";
  }

  /**
   *  Methode qui permet d'obtenir le solde de notre Compte Simple
   *  @return : Le solde de notre Compte Simple
   */
  public double getAmount(){
    return this.solde;
  }

  /**
   *  Methode qui permet d'obtenir le stitulaire de notre Compte Simple
   *  @return : Le titulaire de notre Compte Simple
   */
  public Person getOwner(){
    return this.owner;
  }

}