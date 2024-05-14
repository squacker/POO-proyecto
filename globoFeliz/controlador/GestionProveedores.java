/**
 * Clase: CntroladorProveedores
 * (Controlador de Clase Proveedor)
 * Autor: Alonso Martienz Juan Carlos
 * Version: 1.0
*/
package globoFeliz.controlador;

import globoFeliz.modelo.*;
import globoFeliz.vista.*;

public class GestionProveedores {

    // VARIABLES AUXILIARES
		
	IGUProveedor interfaz = new IGUProveedor();

	String id;

	int opcion;

	Proveedor proveedorNuevo;

 	ArrayListProveedor proveedores = new ArrayListProveedor();

// ProveedorS INICIALES

	Proveedor ProveedorPrueba = new Proveedor ("Juan", "5520528105", "juaneio@hotmail.com", "oracle", "aomj020228ec3");

	Proveedor ProveedorPrueba1 = new Proveedor ("Paquete de Globos 1", "eee", );

	Proveedor ProveedorPrueba2 = new Proveedor ("Paquete de Globos 2", "iii", 123.43f, 56);

	Proveedor ProveedorPrueba3 = new Proveedor ("Paquete de Globos 3", "ooo", 321.51f, 66);

	Proveedor ProveedorPrueba4 = new Proveedor ("Paquete de Globos 4", "uuu", 150.00f, 67);


	proveedores.agregarProveedor(ProveedorPrueba);
	proveedores.agregarProveedor(ProveedorPrueba1);
	proveedores.agregarProveedor(ProveedorPrueba2);
	proveedores.agregarProveedor(ProveedorPrueba3);
	proveedores.agregarProveedor(ProveedorPrueba4);


// CONTROLADOR DE MENU PRINCIPAL

	do {

		opcion = interfaz.menuProveedor();

	// SWITCH MENU

		switch (opcion) {


			

			case 1: // AGREGAR (CREATE)

				proveedorNuevo = interfaz.leerDatosProveedor();
				proveedores.agregarProveedor(proveedorNuevo);
				
				break;
				
				
			case 2: // REEMPLAZAR (UPDATE)

				id = interfaz.leerIdProveedor();

				if (proveedores.buscarProveedor(id) == -1) {

					interfaz.mensaje("El id que ingresaste no existe");

				} else {

					proveedorNuevo = interfaz.leerDatosProveedor();
					proveedores.remplazarProveedor(id, proveedorNuevo);

				}

				break;


				
			case 3: // MODIFICAR (UPDATE)

				id = interfaz.leerIdProveedor();

				if (proveedores.buscarProveedor(id) == -1) {

					interfaz.mensaje("El id que ingresaste no existe");

				} else {

					int opcionModificar;

					String nuevaCadena;
					float nuevoPrecio;
					int nuevoExistencias;

					opcionModificar = interfaz.leerOpcionModificar();

					switch (opcionModificar) {

						case 1: // MODIFICAR NOMBRE
							
							nuevaCadena = interfaz.leerNombreProveedorNuevo();

							proveedores.modificarProveedor(id, opcionModificar, nuevaCadena, 0.0f, 0);
		
							break;
						
						case 2: // MODIFICAR PESCRIPCION
								
							nuevaCadena = interfaz.leerDescripcionNuevo();
								
							proveedores.modificarProveedor(id, opcionModificar, nuevaCadena, 0.0f, 0);
		
							break;	
		
						case 3: // MODIFICAR PRECIO
								
							nuevoPrecio = interfaz.leerPrecioNuevo();
								
							proveedores.modificarProveedor(id, opcionModificar, " ", nuevoPrecio, 0);
		
							break;	
		
							case 4: // MODIFICAR EXISTENCIAS
								
								nuevoExistencias = interfaz.leerExistenciasNuevo();
								
								proveedores.modificarProveedor(id, opcionModificar, " ", 0.0f, nuevoExistencias);
		
								break;	
							
							
							case 0: // CANCELAR

								break;

							default:
								break;
						}

					}

					break;
				
				case 4: // ELIMINAR (DELETE)

					id = interfaz.leerIdProveedor();

					if (proveedores.buscarProveedor(id) == -1) {

						interfaz.mensaje("El id que ingresaste no existe");

					} else {

						proveedores.eliminarProveedor(id);

					}

					break;
				
				case 5: // BUSCAR (READ)

					id = interfaz.leerIdProveedor();

					int posicion = proveedores.buscarProveedor(id);

					if (posicion == -1) {

						interfaz.mensaje("El id que ingresaste no existe");

					} else {

						Proveedor ProveedorEscrito = proveedores.getProveedor(posicion);

						interfaz.mensaje(ProveedorEscrito.imprimirDatos());
					}
				
					break;
				
				case 6: // LISTAR (READ) 
				
					interfaz.escribirproveedores(proveedores);
				
					break;
				
				
				case 0: // SALIR
				
					break;
				
				
				default:

					break;
				

				}

		} while (opcion != 0);
	
	}

}
