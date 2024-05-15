/*
Clase: GestionProveedores
Autor: Alonso Martienz Juan Carlos
*/

package globoFeliz.controlador;

import globoFeliz.modelo.*;
import globoFeliz.vista.*;

public class GestionProveedores {

	// ATRIBUTOS

	private ArrayListProveedor proveedores = new ArrayListProveedor(); // MODELO

	private IGUProveedor interfaz = new IGUProveedor(); // VISTA

	// CONSTRUCTOR

	// sin parametros

	public GestionProveedores () {

		// DATOS INICIALES (PRUEBA)

		Proveedor ProveedorPrueba = new Proveedor ("Juan", "5520528105", "juaneio@hotmail.com", "oracle", "aomj020228ec3");

		Proveedor ProveedorPrueba1 = new Proveedor ("Juan", "5520528105", "juaneio@hotmail.com", "oracle", "aomj020228ec3");

		Proveedor ProveedorPrueba2 = new Proveedor ("Juan", "5520528105", "juaneio@hotmail.com", "oracle", "aomj020228ec3");

		Proveedor ProveedorPrueba3 = new Proveedor ("Juan", "5520528105", "juaneio@hotmail.com", "oracle", "aomj020228ec3");

		Proveedor ProveedorPrueba4 = new Proveedor ("Juan", "5520528105", "juaneio@hotmail.com", "oracle", "aomj020228ec3");


		proveedores.agregarProveedor(ProveedorPrueba);
		proveedores.agregarProveedor(ProveedorPrueba1);
		proveedores.agregarProveedor(ProveedorPrueba2);
		proveedores.agregarProveedor(ProveedorPrueba3);
		proveedores.agregarProveedor(ProveedorPrueba4);

	}

	// con parametros (pendiente)

	// METODO PRINCIPAL CLASE PROVEEDOR

	public void ejecutarControlador() {

		// VARIABLES AUXILIARES

		String id;

		int opcion;

		Proveedor proveedorNuevo;

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
						

						opcionModificar = interfaz.leerOpcionModificar();

						switch (opcionModificar) {

							case 1: // MODIFICAR NOMBRE

								nuevaCadena = interfaz.leerNombreProveedorNuevo();

								proveedores.modificarProveedor(id, opcionModificar, nuevaCadena);

								break;

							case 2: // MODIFICAR TELEFONO

								nuevaCadena = interfaz.leerTelefonoNuevo();

								proveedores.modificarProveedor(id, opcionModificar, nuevaCadena);

								break;

							case 3: // MODIFICAR CORREO

								nuevaCadena = interfaz.leerCorreoProveedorNuevo();

								proveedores.modificarProveedor(id, opcionModificar, nuevaCadena);

								break;

							case 4: // MODIFICAR DIRECCION FISCAL

								nuevaCadena = interfaz.leerDirecionFiscalNuevo();

								proveedores.modificarProveedor(id, opcionModificar, nuevaCadena);

								break;
							
							case 5: // MODIFICAR RFC

								nuevaCadena = interfaz.leerRfcProveedorNuevo();

								proveedores.modificarProveedor(id, opcionModificar, nuevaCadena);

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

					interfaz.escribirProveedores(proveedores);

					break;

				case 0: // SALIR

					break;

				default:

					break;

			}

		} while (opcion != 0);

	}

}
