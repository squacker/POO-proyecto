/*
Clase: ControladorCentral
*/

package globoFeliz.controlador;

import globoFeliz.vista.*;
import globoFeliz.modelo.*;

class ControladorCentral {


// ATRIBUTOS

    private static IGUPrincipal interfaz = new IGUPrincipal ();

    private static GestionInventario controladorInventario = new GestionInventario();

    private static GestionProveedores controladorProveedores = new GestionProveedores();

    private static GestionAbastecimiento controladorAbastecimientos = new GestionAbastecimiento();

    private static GestionVentas controladorVentas = new GestionVentas();

    private ArrayListProveedor proveedores = new ArrayListProveedor();

    private ArrayListProductos inventario = new ArrayListProductos();


    public ControladorCentral () {

        generarRelacionesEntreClases();
    }

// FUNCION MAIN 

    public static void main(String[] args) {

        int opcion;

        do {

            opcion = interfaz.menuPrincipal();

            // SWITCH MENU

            switch (opcion) {

                case 1: // GESTIONAR PRODUCTOS

                    controladorInventario.ejecutarControlador();
                    break;

                case 2: // GESTIONAR VENTAS

                    controladorVentas.ejecutarControlador();
                    break;

                case 3: // GESTIONAR ABASTECIMIENTO

                    controladorAbastecimientos.ejecutarControlador();
                    break;

                case 4: // GESTIONAR PROVEEDORES

                    controladorProveedores.ejecutarControlador();
                    break;

                case 0: // SALIR

                    break;

            }

        } while(opcion != 0);



    }

     
    public void generarRelacionesEntreClases () {

        proveedores.setProductosAsignados();
        inventario.setProveedorAsignado();

    }
}