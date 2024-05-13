package globoFeliz.vista;

import globoFeliz.modelo.*;
import java.util.Scanner;

public class IGUProductos {
    
    private Scanner lector = new Scanner (System.in);

    public int menuInventario () {

        int opcion;

        System.out.println ("\n\nGestionar Inventario\n\n" +
                            "1. Agregar\n" +
                            "2. Reemplazar\n" +
                            "3. Modificar\n" +
                            "4. Borrar\n" +
                            "5. Buscar\n" +
                            "6. Mostrar inventario\n" +
                            "0. Salir\n" 
                            );
        
        System.out.printf("\n¿Que deseas hacer?: ");
        opcion = lector.nextInt();
        this.limpiarBuffer();

        return opcion;

    }

    public Producto leerDatosProducto () {

        Producto nuevoProducto = new Producto();

        System.out.println("\nIngrese los siguientes datos del producto: ");

        System.out.print ("\nNombre: ");
		nuevoProducto.setNombreProducto(lector.nextLine());

        System.out.print ("Descripcion: ");
		nuevoProducto.setDescripcionProducto(lector.nextLine());

        System.out.print ("Precio: ");
		nuevoProducto.setPrecioProducto(lector.nextFloat());

        System.out.print ("Existencias: ");
		nuevoProducto.setExistenciasProducto(lector.nextInt());

        this.limpiarBuffer();

        return nuevoProducto;
    }

    public String leerIdProducto () {

        String idProducto;

        System.out.printf("\nIngresa el id: ");

        idProducto = lector.nextLine();
        

		return idProducto;
    }

    public void mensaje (String mensaje) {

        System.out.println("\n" + mensaje);
    }

    public int leerOpcionModificar () {

        int opcionModificar;
        
        System.out.printf("\n1. Nombre   2. Descripcion   3. Precio   4. Existencias\n\n¿Que dato deseas modificar?: ");
        opcionModificar = lector.nextInt();
        this.limpiarBuffer();

        return opcionModificar;
    }

    public String leerNombreNuevo () {

        String nombreNuevo;

        System.out.printf("\nIngresa el nuevo nombre del producto: ");
        nombreNuevo = lector.nextLine();

        return nombreNuevo;
    }

    public String leerDescripcionNuevo () {

        String descripcionNuevo;

        System.out.printf("\nIngresa la nueva descripcion del producto: ");
        descripcionNuevo = lector.nextLine();

        return descripcionNuevo;
    }

    public float leerPrecioNuevo () {
        
        float precioNuevo;

        System.out.printf("\nIngresa el nuevo precio del producto: ");
        precioNuevo = lector.nextFloat();

        return precioNuevo;
    }

    public int leerExistenciasNuevo () {
        
        int existenciasNuevo;

        System.out.printf("\nIngresa las unidades en existencia del producto: ");
        existenciasNuevo = lector.nextInt();
        this.limpiarBuffer();

        return existenciasNuevo;
    }

    public void limpiarBuffer () {

        lector.nextLine();
    }

}

    