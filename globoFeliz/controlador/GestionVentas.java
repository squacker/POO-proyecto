/*
Clase: ControladorVentas
*/

package globoFeliz.controlador;

import globoFeliz.modelo.*;
import globoFeliz.vista.*;

public class GestionVentas {
    

    
// ATRIBUTOS


	private ArrayListVenta ventas = new ArrayListVenta("db"); // MODELO

	private IGUVentas interfaz = new IGUVentas(); // VISTA


// METODO PRINCIPAL CLASE VENTA

	public void ejecutarControlador () {


		// VARIABLES AUXILIARES

		String id;
		int opcion;
		Venta ventaNueva;

		// CONTROLADOR DE MENU PRINCIPAL

		do {

			opcion = interfaz.menuVentas();

			// SWITCH MENU

			switch (opcion) {


					

				case 1: // AGREGAR (CREATE)

					ventaNueva = new Venta (" ", interfaz.leerIdProductosVendidos(), " ", " ", 0.0f);

					ventas.agregarVenta(ventaNueva);

					interfaz.mensaje("Total: " + ventaNueva.getMontoTotalVenta());
					
					break;

				case 2: // ELIMINAR (DELETE)

					id = interfaz.leerIdVenta();

					if (ventas.buscarVenta(id) == -1) {

						interfaz.mensaje("El id que ingresaste no existe");

					} else {

						ventas.eliminarVenta(id);

					}

					break;
				
				case 3: // BUSCAR (READ)

					id = interfaz.leerIdVenta();

					int posicion = ventas.buscarVenta(id);

					if (posicion == -1) {

						interfaz.mensaje("El id que ingresaste no existe");

					} else {

						Venta ventaEscrita = ventas.getVenta(posicion);

						interfaz.mensaje(ventaEscrita.imprimirDatos());
					}
				
					break;
				
				case 4: // LISTAR (READ) 
				
					interfaz.escribirVentas(ventas);
				
					break;
				
				
				case 0: // SALIR
				
					break;
				
				
				default:

					break;
				

				}

		} while (opcion != 0);

	}

}
