/*
Clase: IGUProveedor
Autor: Alonso Martinez Juan Carlos
*/

package globoFeliz.vista;

import globoFeliz.modelo.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class IGUProveedor {
    
    private Scanner lector = new Scanner (System.in);

    public int menuProveedor() {

        limpiarConsola ();

        int opcion;

        System.out.println("\n\nGestionar Proveedores\n\n" +
                "1. Agregar\n" +
                "2. Reemplazar\n" +
                "3. Modificar\n" +
                "4. Borrar\n" +
                "5. Buscar\n" +
                "6. Mostrar Listado de Proveedores\n" +
                "0. Salir\n");

        do { 

            try {

                System.out.printf("\n¿Qué deseas hacer?: ");

                opcion = Integer.parseInt(lector.nextLine());

                if (opcion < 0 || opcion > 6) {

                    throw new IllegalArgumentException("El valor debe estar entre 0 y 6.");
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

    public Proveedor leerDatosProveedor () {

        Proveedor nuevoProveedor = new Proveedor();

        System.out.println("\nIngrese los siguientes datos del proveedor: ");

        nuevoProveedor.setNombreProveedor(this.leerNombreProveedorNuevo());

        nuevoProveedor.setTelefonoproveedor(this.leerTelefonoNuevo());
        
        nuevoProveedor.setCorreoProveedor(this.leerCorreoProveedorNuevo());

        nuevoProveedor.setDireccionFiscal(this.leerDirecionFiscalNuevo());

        nuevoProveedor.setRfcProveedor(this.leerRfcProveedorNuevo());

        return nuevoProveedor;
    }

    public String leerIdProveedor () {

        String idProveedor;

        System.out.printf("\nIngresa el id: ");

        idProveedor = lector.nextLine();
        

		return idProveedor;
    }

    public void mensaje (String mensaje) {

        System.out.println("\n" + mensaje + " - Presiona cualquier tecla para continuar");

        lector.nextLine();
    }

    public int leerOpcionModificar() {

        int opcionModificar = 0;
        
        boolean opcionValida = false;

        do {

            try {

                System.out.printf("\n1. Nombre   \n2. Telefono   \n3. Correo Electronico   \n4. Dirección Fiscal   \n5.RFC    0. Cancelar\n\n¿Qué dato deseas modificar?: ");

                opcionModificar = lector.nextInt();

                if (opcionModificar < 0 || opcionModificar > 5) {

                    throw new IllegalArgumentException("La opción debe estar entre 0 y 5.");

                }

                opcionValida = true;

            } catch (InputMismatchException exepcion) {

                System.out.println("Error: Debes ingresar un valor numérico entero.");

                this.limpiarBuffer();

            } catch (IllegalArgumentException exepcion) {

                System.out.println("Error: " + exepcion.getMessage());

            }

        } while (!opcionValida);

        return opcionModificar;
    }

    public String leerNombreProveedorNuevo () {

        String nombre = " ";
        boolean datoValido = false;

        do {

            System.out.print("\nNombre: ");

            try {

                nombre = lector.nextLine();

                if (nombre.length() > 20) {

                    throw new IllegalArgumentException("El nombre debe tener menos de 20 caracteres.");
                
                }

                datoValido = true; 
            
            } catch (IllegalArgumentException exepcion) {
                
                System.out.println("Error: " + exepcion.getMessage());
            
            }

        } while (!datoValido);


        return nombre;
    }

    public String leerTelefonoNuevo () {

        String telefonoNuevo = " ";
        boolean datoValido = false;

        do {

            System.out.print("\nTelefono: ");

            try {

                telefonoNuevo = lector.nextLine();

                if (telefonoNuevo.length() > 10) {

                    throw new IllegalArgumentException("El telefono debe tener menos de 11 caracteres.");
                
                }

                datoValido = true; 
            
            } catch (IllegalArgumentException exepcion) {
                
                System.out.println("Error: " + exepcion.getMessage());
            
            }

        } while (!datoValido);

        return telefonoNuevo;
    }
    
    public String leerCorreoProveedorNuevo () {

        String correoNuevo = " ";
        boolean datoValido = false;

        do {

            System.out.print("\nCorreo Electronico: ");

            try {

                correoNuevo = lector.nextLine();

                if (correoNuevo.length() > 65) {

                    throw new IllegalArgumentException("El correo debe tener menos de 65 caracteres.");
                
                }

                datoValido = true; 
            
            } catch (IllegalArgumentException exepcion) {
                
                System.out.println("Error: " + exepcion.getMessage());
            
            }

        } while (!datoValido);

        return correoNuevo;
    }
    
    public String leerDirecionFiscalNuevo () {

        String direccionFiscNueva = " ";
        boolean datoValido = false;

        do {

            System.out.print("\nDirección Fiscal: ");

            try {

                direccionFiscNueva = lector.nextLine();

                if (direccionFiscNueva.length() > 121) {

                    throw new IllegalArgumentException("El correo debe tener menos de 121 caracteres.");
                
                }

                datoValido = true; 
            
            } catch (IllegalArgumentException exepcion) {
                
                System.out.println("Error: " + exepcion.getMessage());
            
            }

        } while (!datoValido);

        return direccionFiscNueva;
    }
    
    public String leerRfcProveedorNuevo () {

        String rfcNuevo = " ";
        boolean datoValido = false;

        do {

            System.out.print("\nRFC: ");

            try {

                rfcNuevo = lector.nextLine();

                if (rfcNuevo.length() > 14) {

                    throw new IllegalArgumentException("El correo debe tener menos de 14 caracteres.");
                
                }

                datoValido = true; 
            
            } catch (IllegalArgumentException exepcion) {
                
                System.out.println("Error: " + exepcion.getMessage());
            
            }

        } while (!datoValido);

        return rfcNuevo;
    }

    public void limpiarBuffer () {

        lector.nextLine();
    }

    public void escribirProveedores (ArrayListProveedor proveedores) {

		Proveedor proveedorEscrito;

		for (int i = 0; i < proveedores.getTamaño(); i ++){
		
			proveedorEscrito = proveedores.getProveedor(i);

			System.out.println(proveedorEscrito.imprimirDatos());
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

    