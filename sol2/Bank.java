package fr.cnam.tp6.sol2;

/**
 *  ____________________________________________________________________________________________<br  
 *                           NFP121:TP6 <br>                          
 *   Nicolas HADDAD        <br>                              
 *   nicolas.haddad80@gmail.com  <br>
 *  ____________________________________________________________________________________________<br                              
 *  La classe Bank Modelise une Banque  <br>
 *  La modelisation d'une Banque est represente par sa liste de Comptes detenus dans un attribu sous forme de tableau de comptes<br>
 *  ____________________________________________________________________________________________<br>
 */
public class Bank {

  /**
   * Compteur pour generer a chaque fois un nouveau numero de compte, on commence le premier compte a 10001
   */
  private static int genAccountNum=10001;

  /**
   * Methode pour obtenir un nouveau numlero de compte a chaque fois qu'elle est invoquee
   * @return : un nouveau numero de compte
   */
  public static int getNewAccountNumber(){
    return genAccountNum++;
  }

  /**
   * Constante representant le montant des frais bancaires
   */
    private static final double BANKFEESAMOUNT=2;

  /** 
   *  Liste des Comptes de la Banque
   */
  private SimpleAccount [] accountList;

  /**
   *  Constructeur de notre Banque
   */
  public Bank() {
    this.accountList=new SimpleAccount[0];
  }

  /**
   *  Methode qui permet d'obtenir le nombre total de comptes detenus par notre Banque
   *  @return : Le nombre total de comptes detenus par notre Banque
   */
   public int getNbAccounts(){
    return this.accountList.length;
  }
  /**
   *  Methode pour ouvrir un Compte Simple au sein de la Banque
   *  @param a_Owner : La Personne titulaire du Compte Simple
   */
  public void openSimpleAccount(Person a_Owner) {
    SimpleAccount [] l_AccountList = new SimpleAccount[this.getNbAccounts()+1];
    System.arraycopy(this.accountList,0,l_AccountList,0,this.getNbAccounts());
    l_AccountList[this.getNbAccounts()]=new SimpleAccount(a_Owner);
    this.accountList=l_AccountList;
  }

  /**
   *  Methode pour ouvrir un Compte Courant au sein de la Banque
   *  @param a_Owner : La Personne titulaire du Compte Courant
   */
  public void openCheckingAccount(Person a_Owner) {
    SimpleAccount [] l_AccountList = new SimpleAccount[this.getNbAccounts()+1];
    System.arraycopy(this.accountList,0,l_AccountList,0,this.getNbAccounts());
    l_AccountList[this.getNbAccounts()]=new CheckingAccount(a_Owner);
    this.accountList=l_AccountList;
  }

  /**
   *  Methode pour obtenir  le cumul des soldes disponibles sur chacun des comptes de notre Banque
   *  @return :  Le cumul des soldes disponibles sur chacun des comptes
   */
  public double getTotalAmounts() {
    double l_Sum=0;
    for (SimpleAccount acc:this.accountList){
      l_Sum+=acc.getAmount();
    }
  return l_Sum;
  }

  /**
   *  Methode pour obtenir  le nombre de comptes debiteurs dans notre Banque
   *  @return :  Le nombre de comptes debiteurs dans Notre Banque
   */
  public int getNbDebitors() {
    int l_Nb=0;
    for (SimpleAccount acc:this.accountList){
      if(acc.getAmount()<0){
        l_Nb++;
      }
    }
    return l_Nb;
  }

  /**
   *  Methode pour obtenir  la somme de tous les débits des comptes de notre Banque
   *  @return :  La somme de tous les débits
   */
  public double getTotalDebitorsAmounts() {
    double l_Sum=0;
    for (SimpleAccount acc:this.accountList){
      if(acc.getAmount()<0){
        l_Sum+=acc.getAmount();
      }
    }
    return l_Sum;
  }

  /**
   *  Methode pour appliquer les frais bancaire a tous les comptes detenus par la banque
   */
  public void applyBankFees() {
    for (SimpleAccount acc:this.accountList){
      acc.debit(this.BANKFEESAMOUNT);
    }
  }

  /**
   *  Methode pour obtenir les releves de tous les comptes courants detenus par notre Banque
   *  @return :  La somme de tous les débits
   */
  public String getAllCheckingAccountStatements() {
    StringBuilder l_str=new StringBuilder("Bank Accounts List:\n");
    for (SimpleAccount acc:this.accountList) {
      if(acc instanceof CheckingAccount){
        l_str.append(((CheckingAccount)acc).getAccountStatement()+"\n");
      }
    }
    return l_str.toString();
  }

  /**
   *  Methode pour obtenir le compte detenu a uneposition donnee (la premiere position est 1)
   *  @return : Le compte a la position donne
   */
  public SimpleAccount getAccount(int a_Position) {
    assert(this.getNbAccounts()!=0 & a_Position>0 & a_Position <= this.getNbAccounts()) : "No Account yet at this position";
    return this.accountList[a_Position-1];
  }
}