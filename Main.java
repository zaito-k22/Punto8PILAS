import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opt = 0;
        boolean bandera = true;
        Metodos m = new Metodos();
        Stack<Integer> pilaNumeros = null;
        Stack<Integer> pilaFibonacci = null;

        System.out.println("Programa de Números Aleatorios y Serie de Fibonacci");

        while (bandera) {
            System.out.println("Opciones: 1) Generar pila de números aleatorios, 2) Calcular serie Fibonacci, 3) Ordenar pila, 4) Eliminar elemento, 5) Mostrar pila, 6) Salir");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    System.out.print("Ingrese la cantidad de números aleatorios a generar: ");
                    int cantidad = sc.nextInt();
                    pilaNumeros = m.generarNumerosAleatorios(cantidad);
                    break;

                case 2:
                    if (pilaNumeros != null) {
                        pilaFibonacci = m.calcularFibonacci(pilaNumeros, pilaNumeros.size());
                        System.out.println("Pila de Fibonacci creada: " + pilaFibonacci);
                    } else {
                        System.out.println("Primero debe generar la pila de números aleatorios.");
                    }
                    break;

                case 3:
                    if (pilaFibonacci != null) {
                        Stack<Integer> pilaOrdenada = m.ordenarPila(pilaFibonacci);
                        System.out.println("Pila de Fibonacci ordenada: " + pilaOrdenada);
                    } else {
                        System.out.println("Primero debe calcular la serie Fibonacci.");
                    }
                    break;

                case 4:
                    if (pilaFibonacci != null) {
                        pilaFibonacci = m.eliminarNumero(pilaFibonacci);
                        System.out.println("Pila de Fibonacci después de eliminar un elemento: " + pilaFibonacci);
                    } else {
                        System.out.println("Primero debe calcular la serie Fibonacci.");
                    }
                    break;

                case 5:
                    if (pilaFibonacci != null) {
                        System.out.println("Pila de Fibonacci: " + pilaFibonacci);
                    } else {
                        System.out.println("Primero debe calcular la serie Fibonacci.");
                    }
                    break;

                case 6:
                    System.out.println("Hasta luego :D");
                    bandera = false;
                    break;

                default:
                    System.out.println("La opción no es válida");
                    break;
            }
        }
        
    }
}