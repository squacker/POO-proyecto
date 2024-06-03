/*
Clase: IGUProductos
*/

package globoFeliz.vista;

import globoFeliz.modelo.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class IGUProductos {

    
    // ATRIBUTOS

    private ArrayListProveedor proveedores = new ArrayListProveedor();
    
    private Scanner lector = new Scanner (System.in);

 // METODOS

    // ENTRADA

    public int menuInventario() {

        limpiarConsola ();

        int opcion;

        System.out.println("\n\nGestionar Inventario\n\n" +
                "1. Agregar\n" +
                "2. Reemplazar\n" +
                "3. Modificar\n" +
                "4. Borrar\n" +
                "5. Buscar\n" +
                "6. Mostrar inventario\n" +
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

    public Producto leerDatosProducto () {

        Producto nuevoProducto = new Producto();

        System.out.println("\nIngrese los siguientes datos del producto: ");

        nuevoProducto.setNombreProducto(this.leerNombreNuevo());

        nuevoProducto.setDescripcionProducto(this.leerDescripcionNuevo());
        
        nuevoProducto.setPrecioProducto(this.leerPrecioNuevo());

        nuevoProducto.setExistenciasProducto(this.leerExistenciasNuevo());

        nuevoProducto.setIdProveedorAsignado(this.leerIdProveedorAsignado());

        return nuevoProducto;
    }

    public String leerIdProducto () {

        String idProducto;

        System.out.printf("\nIngresa el id: ");

        idProducto = lector.nextLine();
        

		return idProducto;
    }
    
    public int leerOpcionModificar() {

        int opcionModificar = 0;
        
        boolean opcionValida = false;

        do {

            try {

                System.out.printf("\n1. Nombre   2. Descripcion   3. Precio   4. Existencias   5. Proveedor   0. Cancelar\n\n¿Qué dato deseas modificar?: ");

                opcionModificar = lector.nextInt();

                this.limpiarBuffer();

                if (opcionModificar < 0 || opcionModificar > 5) {

                    throw new IllegalArgumentException("La opción debe estar entre 0 y 5.");

                }

                opcionValida = true;

            } catch (InputMismatchException exepcion) {

                System.out.println("Error: Debes ingresar un valor numérico entero.");

                

            } catch (IllegalArgumentException exepcion) {

                System.out.println("Error: " + exepcion.getMessage());

            }

        } while (!opcionValida);

        return opcionModificar;
    }

    public String leerNombreNuevo () {

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

    public String leerDescripcionNuevo () {

        String descripcionNuevo = " ";
        boolean datoValido = false;

        do {

            System.out.print("\nDescripcion: ");

            try {

                descripcionNuevo = lector.nextLine();

                if (descripcionNuevo.length() > 50) {

                    throw new IllegalArgumentException("La descripcion debe tener menos de 50 caracteres.");
                
                }

                datoValido = true; 
            
            } catch (IllegalArgumentException exepcion) {
                
                System.out.println("Error: " + exepcion.getMessage());
            
            }

        } while (!datoValido);

        return descripcionNuevo;
    }

    public float leerPrecioNuevo () {
        
        float precioNuevo = 0.0f;
        boolean datoValido = false;

        do {

            System.out.print("\nPrecio: ");

            try {

                precioNuevo = lector.nextFloat();

                if (precioNuevo < 1) {

                    throw new IllegalArgumentException("El precio debe ser mayor a 0.");

                }

                datoValido = true;
            
            } catch (InputMismatchException exepcion) {
                
                System.out.println("Error: Debes ingresar un valor numérico.");
                
                this.limpiarBuffer();
            
            } catch (IllegalArgumentException exepcion) {
                
                System.out.println("Error: " + exepcion.getMessage());
            
            }
        
        } while (!datoValido);

        return precioNuevo;
    }

    public int leerExistenciasNuevo () {
        
        int existenciasNuevo = 0;
        boolean datoValido = false;

        do {

            System.out.print("\nExistencias: ");

            try {

                existenciasNuevo = lector.nextInt();

                if (existenciasNuevo < 5 || existenciasNuevo > 50) {

                    throw new IllegalArgumentException("Las existencias deben estar entre 5 y 50.");
                
                }
                                
                datoValido = true;
            
            } catch (InputMismatchException exepcion) {
                
                System.out.println("Error: Debes ingresar un valor numérico entero.");
                
                this.limpiarBuffer();
            
            } catch (IllegalArgumentException exepcion) {
                
                System.out.println("Error: " + exepcion.getMessage());
            
            }

        } while (!datoValido);

        return existenciasNuevo;
    }

    public String leerIdProveedorAsignado () {

        String idProveedor;
        boolean encontrado = false;

        limpiarBuffer();
        
        do {

            

            System.out.printf("\nIngresa el id del proveedor: ");

            idProveedor = lector.nextLine();

            if (proveedores.buscarProveedor(idProveedor) != -1) {

                encontrado = true;

                
            } else {

                System.out.printf("\nEl id ingresado no existe, vuelve a intentar\n");

            }

        } while (!encontrado);

        
		return idProveedor;

    }

    // SALIDA

    public void mensaje (String mensaje) {

        System.out.printf("\n" + mensaje + "\n\n - Presiona cualquier tecla para continuar: ");

        lector.nextLine();

    }

    public void escribirInventario (ArrayListProductos inventario) {

        limpiarConsola();
   
        Producto productoEscrito;

        for (int i = 0; i < inventario.getInventario().size(); i ++){
            
            productoEscrito = inventario.getProducto(i);

            System.out.println(productoEscrito.imprimirDatos());
        }

        System.out.println("\nPresiona cualquier tecla para salir...");

        lector.nextLine();

	}


    // AUXILIAR

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
    
    public void limpiarBuffer () {

        lector.nextLine();

}

}

    