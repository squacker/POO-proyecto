/*
Clase: IGUProductos
Autor: Fernando Cordero 
*/

package globoFeliz.vista;


import globoFeliz.modelo.*;

import java.io.IOException;
import java.util.Scanner;

public class IGUVentas {

    private Scanner lector = new Scanner (System.in);

    public int menuInventario() {

        limpiarConsola ();

        int opcion;

        System.out.println("\n\nGestionar Ventas\n\n" +
                "1. Registrar\n" +
                "2. Eliminar\n" +
                "3. Buscar\n" +
                "4. Listar\n" +
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

    public String leerIdProducto () {

        String idProducto;

        System.out.printf("\nIngresa el id del producto: ");

        idProducto = lector.nextLine();
    

		return idProducto;
    }
    
    public String leerIdVenta () {

        String idVenta;

        System.out.printf("\nIngresa el id: ");

        idVenta = lector.nextLine();
        

		return idVenta;
    }

    // public ListaProductos leerProductosVendidos () {

    //     String [] listaId = new String[10]; 

    //     String idProducto;

    //     int repetidor = 1;
    //     int contador = 0;

    //     while (repetidor == 1 && repetidor < 10) {
            
    //         System.out.printf ("Ingresa el id del producto: ");

    //         idProducto = leerIdProducto();

    //         listaId [contador] = idProducto;

    //         System.out.printf ("Agregar otro producto (1)  Calcular Monto (0): ");

    //         repetidor = lector.nextInt();

    //         limpiarBuffer();

    //     }

    //     ListaProductos productosVendidos = new ListaProductos(listaId);

    //     return productosVendidos;
    // }

    public void mensaje (String mensaje) {

        System.out.printf("\n" + mensaje + "\n\n - Presiona cualquier tecla para continuar: ");

        lector.nextLine();

    }

    public void limpiarBuffer () {

        lector.nextLine();

    }

    public void escribirVentas (ArrayListVenta ventas) {

        limpiarConsola();
   
        Venta ventaEscrita;

        for (int i = 0; i < ventas.getTamaño(); i ++){
            
            ventaEscrita = ventas.getVenta(i);

            System.out.println(ventaEscrita.imprimirDatos());
        }

        System.out.println("\nPresiona cualquier tecla para salir...");

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
