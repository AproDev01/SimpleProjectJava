import java.util.Scanner;
public class Calculator {
    public static void calcul(){

        Scanner sc= new Scanner(System.in);
        System.out.println("dommer le premier nembre:");
        int nembre1=sc.nextInt();

        
        System.out.println("dommer le deuxieme nembre:");
        int nembre2=sc.nextInt();

        System.out.println("quel est  l operation que vous peuver calculer('+' ,'-','x','%','/') ");
        String operation=sc.next();

        int result=operation(nembre1,nembre2,operation);
        System.out.println("le resultat est :"+result);
        sc.close();
    }
        public static int operation(int nembre1,int nembre2,String operation){
            int result =0;
       
            if (operation.equals("+")) {
                result = nembre1 + nembre2;
            }
            
            else if (operation.equals("-")) {
                result = nembre1 - nembre2;
            }
            else if (operation.equals("x")) {
                result = nembre1 * nembre2;
            }
            else if (operation.equals("%")) {
                result = nembre1  % nembre2;
            }
            else if (operation.equals("/")) {
                result = nembre1 / nembre2;
            }
            else {
                System.out.println("Invalid operation");
            }
            return result;
        }
    
     
         public static void main(String[] args){
            calcul();

        }
        
    
}
