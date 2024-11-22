import java.util.Stack;
import java.util.Scanner;

public class Metodos {

    public static Stack<Integer> generarNumerosAleatorios(int cantidad) {
        Stack<Integer> pila = new Stack<>();

        for (int i = 0; i < cantidad; i++) {
            int numero = (int) (Math.random() * 100); 
            pila.push(numero);
        }

        System.out.println("Pila generada con números aleatorios: " + pila);
        return pila;
    }

    public static Stack<Integer> calcularFibonacci(Stack<Integer> pila, int cantidad) {
        Stack<Integer> pilaFibonacci = new Stack<>();

        if (pila.size() < 2) {
            System.out.println("No hay suficientes elementos en la pila para calcular la serie de Fibonacci.");
            return pilaFibonacci;
        }

        int a = pila.pop();
        int b = pila.pop();
        pilaFibonacci.push(a);
        pilaFibonacci.push(b);

        for (int i = 2; i < cantidad; i++) {
            int siguiente = a + b;
            pilaFibonacci.push(siguiente);
            a = b;
            b = siguiente;
        }

        return pilaFibonacci;
    }

    public static Stack<Integer> ordenarPila(Stack<Integer> pilaFibonacci) {
        Stack<Integer> pilaOrdenada = new Stack<>();

        while (!pilaFibonacci.isEmpty()) {
            int elemento = pilaFibonacci.pop();

            while (!pilaOrdenada.isEmpty() && pilaOrdenada.peek() > elemento) {
                pilaFibonacci.push(pilaOrdenada.pop());
            }

            pilaOrdenada.push(elemento);
        }

        return pilaOrdenada;
    }

    public static Stack<Integer> eliminarNumero(Stack<Integer> pilaFibonacci) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el número que desea eliminar de la pila: ");
        int elemento = sc.nextInt();
    
        Stack<Integer> pilaTemp = new Stack<>();
        boolean encontrado = false;
    
        while (!pilaFibonacci.isEmpty()) {
            int numero = pilaFibonacci.pop();
    
            
            if (numero == elemento && !encontrado) {
                encontrado = true; 
                System.out.println("El elemento " + elemento + " ha sido eliminado.");
            } else {
                pilaTemp.push(numero); 
            }
        }
    
        
        while (!pilaTemp.isEmpty()) {
            pilaFibonacci.push(pilaTemp.pop());
        }
    
        
        if (!encontrado) {
            System.out.println("El elemento " + elemento + " no se encuentra en la pila.");
        }
    
        return pilaFibonacci;}}
    