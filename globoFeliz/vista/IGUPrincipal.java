/*
Clase: IGUPrincipal
Autor: Fernando Cordero 
*/

package globoFeliz.vista;
import java.io.IOException;
import java.util.Scanner;


public class IGUPrincipal {


    private Scanner lector = new Scanner (System.in);


    public int menuPrincipal() {

        limpiarConsola ();

        int opcion;
        
        System.out.println("\n\nSISTEMA DE GESTION DE GLOBO FELIZ\n\n" +
                "1. Productos\n" +
                "2. Ventas\n" +
                "3. Abastecimientos\n" +
                "4. Proveedores\n" +
                "0. Salir\n");

        do {

            try {
        
                System.out.printf("\n¿Qué deseas hacer?: ");
            
                opcion = Integer.parseInt(lector.nextLine());
            
                if (opcion < 0 || opcion > 5) {
            
                    throw new IllegalArgumentException("El valor debe estar entre 0 y 5.");
                }
        
            } catch (NumberFormatException excepcion) {
        
                System.out.println("Error: Ingresa un valor numérico.");
        
                opcion = -1;
        
            } catch (IllegalArgumentException excepcion) {
        
                System.out.println(excepcion.getMessage());
        
                opcion = -1;
            }
        
        } while (opcion < 0 || opcion > 5);
                
        return opcion;
    }

    public void limpiarConsola () {

        try {

            String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Comando para limpiar consola en Unix/Linux/Mac
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
