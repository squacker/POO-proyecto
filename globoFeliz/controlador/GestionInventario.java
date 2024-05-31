/*
Clase: GestionInventario
Autor: Fernando Cordero 
*/

package globoFeliz.controlador;

import globoFeliz.modelo.*;
import globoFeliz.vista.*;

public class GestionInventario {

// ATRIBUTOS

	Producto producto;

	private ArrayListProductos inventario = new ArrayListProductos(producto); // MODELO

	private IGUProductos interfaz = new IGUProductos(); // VISTA

	
// METODO PRINCIPAL CLASE PRODUCTO

	public void ejecutarControlador () {


		// VARIABLES AUXILIARES

		String id;
		int opcion;
		Producto productoNuevo;

		// CONTROLADOR DE MENU PRINCIPAL

		do {

			opcion = interfaz.menuInventario();

			// SWITCH MENU

			switch (opcion) {


				

				case 1: // AGREGAR (CREATE)

					productoNuevo = interfaz.leerDatosProducto();
					inventario.agregarProducto(productoNuevo);
					
					break;


				
				
				case 2: // REEMPLAZAR (UPDATE)

					id = interfaz.leerIdProducto();

					if (inventario.buscarProducto(id) == -1) {

						interfaz.mensaje("El id que ingresaste no existe");

					} else {

						productoNuevo = interfaz.leerDatosProducto();
						inventario.remplazarProducto(id, productoNuevo);

					}

					break;


				
				case 3: // MODIFICAR (UPDATE)

					id = interfaz.leerIdProducto();

					if (inventario.buscarProducto(id) == -1) {

						interfaz.mensaje("El id que ingresaste no existe");

					} else {

						int opcionModificar;

						String nuevaCadena;
						float nuevoPrecio;
						int nuevoExistencias;

						opcionModificar = interfaz.leerOpcionModificar();

						switch (opcionModificar) {

							case 1: // MODIFICAR NOMBRE
								
								nuevaCadena = interfaz.leerNombreNuevo();

								inventario.modificarProducto(id, opcionModificar, nuevaCadena, 0.0f, 0);
		
								break;
						
							case 2: // MODIFICAR PESCRIPCION
								
								nuevaCadena = interfaz.leerDescripcionNuevo();
								
								inventario.modificarProducto(id, opcionModificar, nuevaCadena, 0.0f, 0);
		
								break;	
		
							case 3: // MODIFICAR PRECIO
								
								nuevoPrecio = interfaz.leerPrecioNuevo();
								
								inventario.modificarProducto(id, opcionModificar, " ", nuevoPrecio, 0);
		
								break;	
		
							case 4: // MODIFICAR EXISTENCIAS
								
								nuevoExistencias = interfaz.leerExistenciasNuevo();
								
								inventario.modificarProducto(id, opcionModificar, " ", 0.0f, nuevoExistencias);
		
								break;	
							
							
							case 0: // CANCELAR

								break;

							default:
								break;
						}

					}

					break;
				
				case 4: // ELIMINAR (DELETE)

					id = interfaz.leerIdProducto();

					if (inventario.buscarProducto(id) == -1) {

						interfaz.mensaje("El id que ingresaste no existe");

					} else {

						inventario.eliminarProducto(id);

					}

					break;
				
				case 5: // BUSCAR (READ)

					id = interfaz.leerIdProducto();

					int posicion = inventario.buscarProducto(id);

					if (posicion == -1) {

						interfaz.mensaje("El id que ingresaste no existe");

					} else {

						Producto productoEscrito = inventario.getProducto(posicion);

						interfaz.mensaje(productoEscrito.imprimirDatos());
					}
				
					break;
				
				case 6: // LISTAR (READ) 
				
					interfaz.escribirInventario(inventario);
				
					break;
				
				
				case 0: // SALIR
				
					break;
				
				
				default:

					break;
				

				}

		} while (opcion != 0);
	
	} 
	
	
}





