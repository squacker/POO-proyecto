/**
 *  Modelo: ControladorCentral
 *  Autor:  Fernando Cordero
 * 
 *  Versión: 1.0 
 * 
 */

package globoFeliz.controlador;

import globoFeliz.vista.*;

class ControladorCentral {

    public enum FUNCIONES {
        PRODUCTOS,
        VENTAS,
        ABASTECIMIENTO,
        CLIENTES,
        PROVEEDORES,
        SALIR
    }


// ATRIBUTOS

    private static IGUPrincipal interfaz = new IGUPrincipal ();

    private static GestionInventario controladorInventario = new GestionInventario();

    private static GestionProveedores controladorProveedores = new GestionProveedores();




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

                    break;

                case 3: // GESTIONAR ABASTECIMIENTO

                    break;


                case 4: // GESTIONAR CLIENTES

                    break;


                case 5: // GESTIONAR PROVEEDORES

                    controladorProveedores.ejecutarControlador();
                    break;

                case 6: // SALIR

                    break;

            }

        } while(opcion != 0);



    }

     
}