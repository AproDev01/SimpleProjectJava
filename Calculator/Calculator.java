import java.util.Scanner;

public class Calculator {

    public static void calcul() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Donne le premier nombre: ");
        int nombre1 = sc.nextInt();

        System.out.print("Donne le deuxième nombre: ");
        int nombre2 = sc.nextInt();

        System.out.print("Choisis une opération (+, -, *, /): ");
        String op = sc.next();

        int result = 0;
        switch (op) {
            case "+":
                result = nombre1 + nombre2;
                break;
            case "-":
                result = nombre1 - nombre2;
                break;
            case "*":
                result = nombre1 * nombre2;
                break;
            case "/":
                if (nombre2 != 0)
                    result = nombre1 / nombre2;
                else {
                    System.out.println("Erreur : division par zéro !");
                    sc.close();
                    return;
                }
                break;
            default:
                System.out.println("Opération non reconnue !");
                sc.close();
                return;
        }

        System.out.println("Résultat : " + result);
        sc.close();
    }

    public static void main(String[] args) {
        calcul();
    }
}
