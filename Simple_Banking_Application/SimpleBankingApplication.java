import java.util.Scanner;

public class SimpleBankingApplication {
    
        private String Nom;
        long NembreAccount;
        private String AccountType;
        private long SoldeAccount;
        long SoldeDeposer;
        long SoldeRetirer;

        Scanner sc=new Scanner(System.in);
    
     //method to open new account           (methode de creation de neuveau account) 
    public void DetailAccount(){
        

        System.out.println("Entrer le Nom:");
        Nom= sc.nextLine();

        System.out.println("Entrer le numero de compte:");
        NembreAccount= sc.nextLong();
        sc.nextLine();

        System.out.println("Entrer le type de compte:");
        AccountType= sc.nextLine();
        
        System.out.println("Entrer le solde de votre compte:");
        SoldeAccount= sc.nextLong();

    }
    //method to display account details    (affichage du votre compte)
    public void Affichage(){
        System.out.println("*****************detail de votre compte********************");
        System.out.println("le Nom est:"+ Nom);
        System.out.println("le numero de compte:"+NembreAccount);
        System.out.println(" le type de compte:"+AccountType);
        System.out.println(" le solde de votre compte est:"+SoldeAccount);
    }

    //method to deposit money              (mettre une solde dans votre compte)
     public void PoserUneSolde(){
        System.out.println("donner le solde que tu vas deposer:");
        long SoldeDeposer=sc.nextLong();

        sc.nextLine();
         
        SoldeDeposer = SoldeAccount + SoldeDeposer;
        System.out.println("danc votre solde de votre account sera:"+ SoldeDeposer);


     }
    //method to withdraw money    (méthode pour retirer de l'argent)
    public void RetirerSolde(){
        System.out.println("donner le solde que tu vas Retirer:");
        long SoldeRetirer=sc.nextInt();
       if(SoldeAccount > SoldeRetirer){
        
        SoldeAccount=SoldeAccount - SoldeRetirer;
        
        System.out.println("Solde après retrait:"+SoldeAccount);
       }
       else{
      System.out.println("Votre solde est inférieur à " + SoldeAccount + " le retrait a échoué");
       }
    }
     //method to search an account number    (méthode pour rechercher un numéro de compte)
     public boolean search(Long NembreAccountUser) {  
        if (NembreAccount == NembreAccountUser) {  
            Affichage();  
            return (true);  
        }  
        else{
            System.out.println("le numero de compte n existe pas");
        return (false);
        }  
    }  
     public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n;

        System.out.print("Combien de compte souhaitez-vous saisir ?");
        n = sc.nextInt();  
        SimpleBankingApplication LeCompteNumero[] = new SimpleBankingApplication[n];
      

        for (int i = 0; i < LeCompteNumero.length; i++) {  
            
            System.out.println("\n*********le compte numero "+ (i+1)+"*************\n");
            LeCompteNumero[i] = new SimpleBankingApplication() ;  
            LeCompteNumero[i].DetailAccount();  
        } 

        System.out.println("\n ***************welcome to banking Application***********\n");
        System.out.println("\n 1-afficher tous les détails du compte"+
                           "\n 2-recherche par numéro de compte "+
                           "\n 3- ajeuter un montant dans le compte"+
                           "\n 4-retirer un montant dans le compte"+
                           "\n 5-Exit");

        int numero=sc.nextInt();

        switch (numero) {
            case 1:
            {
                 for (int i = 0; i < LeCompteNumero.length; i++) {  
            
                System.out.println("\n*********le compte numero "+ (i+1)+"*************\n"); 
                   LeCompteNumero[i].Affichage();  
                
                }
                break;
                
            }
            case 2:
            {
                
                
               // boolean found = false;  
                for (int i = 0; i < LeCompteNumero.length; i++) {
                 System.out.println("\n*********le compte numero "+ (i+1)+"*************\n");

                 System.out.print("donner le numero de comptre:");
                 Long NembreAccountUser=sc.nextLong();

                 LeCompteNumero[i].search(NembreAccountUser);  

                 /*if (found) {  
                    break;  
                }  
                  
                if (!found) {  
                   System.out.println("La recherche a échoué ! Le compte n'existe pas.. !!");  
                }  */
                }
                break;
            }
            case 3:
            {
                 for (int i = 0; i < LeCompteNumero.length; i++) {  
            
                System.out.println("\n*********le compte numero "+ (i+1)+"*************\n");
               // LeCompteNumero[i] = new SimpleBankingApplication() ;  
                LeCompteNumero[i].PoserUneSolde();  
                } 
                break;
            }
            case 4:
            {
                 for (int i = 0; i < LeCompteNumero.length; i++) {  
            
                System.out.println("\n*********le compte numero "+ (i+1)+"*************\n");
               // LeCompteNumero[i] = new SimpleBankingApplication() ;  
                LeCompteNumero[i].RetirerSolde();  
                } 
                break;
            }
                
               
            case 5:{
                System.out.println("A bientot");
                break;
            }

            default:
            System.out.println("donner le nembre entre 1 et 5");
                break;
        }
        sc.close();


    }
    
    
}
