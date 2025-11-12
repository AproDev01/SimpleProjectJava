import java.util.Scanner;

public class SimpleBankingApplication {
    private String nom;
    private long numeroCompte;
    private String typeCompte;
    private long solde;

    private static final Scanner sc = new Scanner(System.in);

    // création d’un nouveau compte
    public void creerCompte() {
        System.out.print("Entrer le nom du titulaire : ");
        nom = sc.nextLine();

        System.out.print("Entrer le numéro de compte : ");
        
        numeroCompte = sc.nextLong();
        sc.nextLine(); // vider le buffer

        System.out.print("Entrer le type de compte : ");
        typeCompte = sc.nextLine();

        System.out.print("Entrer le solde initial : ");
        solde = sc.nextLong();
        sc.nextLine();

        System.out.println("Compte créé avec succès !");
    }

    // affichage des détails du compte
    public void afficherDetails() {
        System.out.println("\n------ Détails du compte ------");
        System.out.println("Titulaire       : " + nom);
        System.out.println("Numéro de compte: " + numeroCompte);
        System.out.println("Type de compte  : " + typeCompte);
        System.out.println("Solde actuel    : " + solde + " DH");
        System.out.println("--------------------------------");
    }

    // dépôt d’argent
    public void deposer() {
        System.out.print("Entrer le montant à déposer : ");
        long montant = sc.nextLong();
        sc.nextLine();

        if (montant > 0) {
            solde += montant;
            System.out.println("✅ Dépôt effectué. Nouveau solde : " + solde + " DH");
        } else {
            System.out.println("⚠️ Montant invalide !");
        }
    }

    //  retrait d’argent
    public void retirer() {
        System.out.print("Entrer le montant à retirer : ");
        long montant = sc.nextLong();
        sc.nextLine();

        if (montant <= 0) {
            System.out.println("⚠️ Montant invalide !");
        } else if (montant > solde) {
            System.out.println("❌ Fonds insuffisants !");
        } else {
            solde -= montant;
            System.out.println("✅ Retrait effectué. Nouveau solde : " + solde + " DH");
        }
    }

    // rechercher un compte par numéro
    public boolean rechercherCompte(long numeroRecherche) {
        if (numeroCompte == numeroRecherche) {
            afficherDetails();
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.print("Combien de comptes souhaitez-vous créer ? ");
        int n = sc.nextInt();
        sc.nextLine();

        SimpleBankingApplication[] comptes = new SimpleBankingApplication[n];

        // Création des comptes
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Création du compte n°" + (i + 1) + " ---");
            comptes[i] = new SimpleBankingApplication();
            comptes[i].creerCompte();
        }

        // Menu principal (boucle)
        int choix;
        do {
            System.out.println("\n===== Menu Banque =====");
            System.out.println("1️⃣  Afficher tous les comptes");
            System.out.println("2️⃣  Rechercher un compte");
            System.out.println("3️⃣  Déposer de l’argent");
            System.out.println("4️⃣  Retirer de l’argent");
            System.out.println("5️⃣  Quitter");
            System.out.print("👉 Votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    for (SimpleBankingApplication compte : comptes) {
                        compte.afficherDetails();
                    }
                    break;

                case 2:
                    System.out.print("Entrer le numéro de compte à rechercher : ");
                    long numeroRecherche = sc.nextLong();
                    sc.nextLine();
                    boolean trouve = false;
                    for (SimpleBankingApplication compte : comptes) {
                        if (compte.rechercherCompte(numeroRecherche)) {
                            trouve = true;
                            break;
                        }
                    }
                    if (!trouve) {
                        System.out.println("❌ Aucun compte trouvé avec ce numéro.");
                    }
                    break;

                case 3:
                    System.out.print("Entrer le numéro de compte : ");
                    long numeroDepot = sc.nextLong();
                    sc.nextLine();
                    boolean trouveDepot = false;
                    for (SimpleBankingApplication compte : comptes) {
                        if (compte.rechercherCompte(numeroDepot)) {
                            compte.deposer();
                            trouveDepot = true;
                            break;
                        }
                    }
                    if (!trouveDepot) {
                        System.out.println("❌ Compte introuvable !");
                    }
                    break;

                case 4:
                    System.out.print("Entrer le numéro de compte : ");
                    long numeroRetrait = sc.nextLong();
                    sc.nextLine();
                    boolean trouveRetrait = false;
                    for (SimpleBankingApplication compte : comptes) {
                        if (compte.rechercherCompte(numeroRetrait)) {
                            compte.retirer();
                            trouveRetrait = true;
                            break;
                        }
                    }
                    if (!trouveRetrait) {
                        System.out.println("❌ Compte introuvable !");
                    }
                    break;

                case 5:
                    System.out.println("👋 Merci d’avoir utilisé notre application bancaire !");
                    break;

                default:
                    System.out.println("⚠️ Choix invalide, veuillez réessayer.");
            }

        } while (choix != 5);

        sc.close();
    }

}
