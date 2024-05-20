/*
Clase: IGUProductos
Autor: Fernando Cordero 
*/

package globoFeliz.vista;


import globoFeliz.modelo.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IGUVentas {

    ArrayListProductos inventario = new ArrayListProductos();

    private Scanner lector = new Scanner (System.in);

    public int menuVentas() {

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

        do {

            System.out.printf("\nIngresa el id del producto: ");

            idProducto = lector.nextLine();

            if (inventario.buscarProducto(idProducto) == -1) {
                
                System.out.println("\nNo se encontro el producto");
            }

        } while (inventario.buscarProducto(idProducto) == -1);

		return idProducto;
    }
    
    public String leerIdVenta () {

        String idVenta;

        System.out.printf("\nIngresa el id: ");

        idVenta = lector.nextLine();
        

		return idVenta;
    }

    public ArrayList <String> leerIdProductosVendidos () {


        ArrayList <String> idProductos = new ArrayList <String> ();

        int repetidor = 1;

        while (repetidor == 1) {

            String idProducto;
            
            idProducto = leerIdProducto();

            idProductos.add(idProducto);

            boolean opcionValida = false;

            do {

                try {

                    System.out.printf("\nAgregar otro producto (1)  Calcular Monto (0): ");

                    repetidor = lector.nextInt();

                    if (repetidor < 0 || repetidor > 1) {

                        throw new IllegalArgumentException("La opción debe ser 0 o 1.");

                    }

                    opcionValida = true;

                } catch (InputMismatchException e) {

                    System.out.println("\nError: Debes ingresar un valor numérico entero.");

                    limpiarBuffer();

                } catch (IllegalArgumentException e) {

                    System.out.println("\nError: " + e.getMessage());

                }

            } while (!opcionValida);
                
            limpiarBuffer();

        }

        return idProductos;
    }

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

        for (int i = 0; i < ventas.getVentas().size(); i ++){
            
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
