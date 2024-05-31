/*
Clase: GestionAbastecimiento
Autor: Fernando Cordero 
*/

package globoFeliz.controlador;

import globoFeliz.modelo.*;
import globoFeliz.vista.*;

public class GestionAbastecimiento {

// ATRIBUTOS

    Abastecimiento abastecimiento;

    private ArrayListAbastecimientos abastecimientos = new ArrayListAbastecimientos(abastecimiento);

    private IGUAbastecimiento interfaz = new IGUAbastecimiento();


    public void ejecutarControlador() {

        // VARIABLES AUXILIARES

        String id;
        int opcion;
        Abastecimiento abastecimientoNuevo;

        // CONTROLADOR DE MENU PRINCIPAL

        do {

            opcion = interfaz.menuAbastecimiento();

            // SWITCH MENU

            switch (opcion) {

                case 1: // AGREGAR (CREATE)

                    abastecimientoNuevo = interfaz.leerDatosAbastecimiento();
                    abastecimientos.agregarAbastecimiento(abastecimientoNuevo);

                    break;

                case 4: // ELIMINAR (DELETE)

                    id = interfaz.leerIdAbastecimiento();

                    if (abastecimientos.buscarAbastecimiento(id) == -1) {

                        interfaz.mensaje("El id que ingresaste no existe");

                    } else {

                        abastecimientos.eliminarAbastecimiento(id);

                    }

                    break;

                case 5: // BUSCAR (READ)

                    id = interfaz.leerIdAbastecimiento();

                    int posicion = abastecimientos.buscarAbastecimiento(id);

                    if (posicion == -1) {

                        interfaz.mensaje("El id que ingresaste no existe");

                    } else {

                        Abastecimiento abastecimientoEscrito = abastecimientos.getAbastecimiento(posicion);

                        interfaz.mensaje(abastecimientoEscrito.imprimirDatos());
                    }

                    break;

                case 6: // LISTAR (READ)

                    interfaz.escribirAbastecimientos(abastecimientos);

                    break;

                case 0: // SALIR

                    break;

                default:

                    break;

            }

        } while (opcion != 0);

    }

}
