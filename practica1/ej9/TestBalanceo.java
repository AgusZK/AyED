package practica1.ej9;
import java.util.Scanner;
import java.util.Stack;

public class TestBalanceo {

    public static boolean balanced (String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < s.length() ; i++){
            Character c = s.charAt(i);
            // SI VIENE UNO DE APERTURA LO PUSHEO
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            }
            
            // SI VIENE UNO DE CIERRE, PREGUNTO SI ESTA VACIA PARA RETORNAR FALSE DE UNA
            else if ( c == '}' || c == ')' || c == ']'){
                if (stack.isEmpty()){
                    return false;
                }
            // SI NO ESTA VACIA, AGARRO EL ULTIMO DE CIERRE Y LE BUSCO MATCH CON EL DEL TOPE
                char top = stack.pop();
                if ((c == '}' && top != '{') || (c == ')' && top != '(') && ( c == ']' && top !='[' )){
                    return false;
                }
            }
        }
       return stack.isEmpty();
    }
      
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("INGRESE CADENA PARA VERIFICAR BALANCEO");
        String cadena = scan.next();
        
        if (balanced(cadena)){
            System.out.println("La cadena: " + cadena + " esta balanceada");
        }
        else
            System.out.println("La cadena no esta balanceada");
    }
    
}
