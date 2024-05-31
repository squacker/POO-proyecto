/*
Clase: IGUProductos
Autor: Fernando Cordero 
*/

package globoFeliz.vista;

import globoFeliz.modelo.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class IGUAbastecimiento {

    ArrayListProductos inventario = new ArrayListProductos();

    private Scanner lector = new Scanner (System.in);


    public int menuAbastecimiento() {

        limpiarConsola ();

        int opcion;

        System.out.println("\n\nGestionar Abastecimientos\n\n" +
                "1. Agregar\n" +
                "2. Borrar\n" +
                "3. Buscar\n" +
                "4. Mostrar Historial\n" +
                "0. Salir\n");

        do {

            try {

                System.out.printf("\n¿Qué deseas hacer?: ");

                opcion = Integer.parseInt(lector.nextLine());

                if (opcion < 0 || opcion > 4) {

                    throw new IllegalArgumentException("El valor debe estar entre 0 y 4.");
                }

            } catch (NumberFormatException excepcion) {

                System.out.println("Error: Ingresa un valor numérico.");

                opcion = -1;

            } catch (IllegalArgumentException excepcion) {

                System.out.println(excepcion.getMessage());

                opcion = -1;
            }

        } while (opcion < 0 || opcion > 6);

        return opcion;
    }
    
    public Abastecimiento leerDatosAbastecimiento () {

        Abastecimiento nuevoAbastecimiento = new Abastecimiento();

        nuevoAbastecimiento.setIdProducto(this.leerIdProducto());

        nuevoAbastecimiento.setUnidades(this.leerUnidades());

        this.limpiarBuffer();

        return nuevoAbastecimiento;
    }

    public String leerIdProducto () {

        String idProducto;

        do {

            System.out.printf("\nIngresa el id del producto: ");

            idProducto = lector.nextLine();

            if (inventario.buscarProducto(idProducto) == -1) {
                
                System.out.println("\nNo se encontro el producto");
            }

        } while (inventario.buscarProducto(idProducto) == -1);

		return idProducto;
    }

    public String leerIdAbastecimiento () {

        String idProducto;

        System.out.printf("Ingrese el id del abastecimiento: ");

        idProducto = lector.nextLine();

        return idProducto;

    }

    public int leerUnidades() {

        int unidades;

        System.out.printf("Ingrese las unidades abastecidas: ");

        unidades = lector.nextInt();

        return unidades;
        
    }

    public void mensaje (String mensaje) {

        System.out.printf("\n" + mensaje + "\n\n - Presiona cualquier tecla para continuar: ");

        lector.nextLine();

    }

    public void escribirAbastecimientos (ArrayListAbastecimientos abastecimientos) {

        limpiarConsola();
   
        Abastecimiento abastecimientoEscrito;

        for (int i = 0; i < abastecimientos.getAbastecimientos().size(); i ++){
            
            abastecimientoEscrito = abastecimientos.getAbastecimiento(i);

            System.out.println(abastecimientoEscrito.imprimirDatos());

        }

        System.out.println("\nPresiona cualquier tecla para salir...");

        lector.nextLine();

	}

    public void limpiarBuffer () {

        lector.nextLine();

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
