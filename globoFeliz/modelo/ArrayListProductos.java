/*
Clase: ArrayListinventario

(Clase Arreglo Principal)

Autor: Fernando Cordero 
Version: 1.0
*/

package globoFeliz.modelo;

import globoFeliz.modelo.*;
import java.util.ArrayList;


@SuppressWarnings("unused")
public class ArrayListProductos {
	

// ATRIBUTOS 

	private ArrayList <Producto> inventario = new ArrayList <Producto> ();


// METODOS (CRUD)

	// CREATE

	public boolean agregarProducto (Producto productoNuevo) {

		return inventario.add(productoNuevo);
	}


	// READ

	public int buscarProducto (String id) {

		if (inventario.size() <= 0) {

			return -1;

		} else {

			int contador = 0;
			boolean encontrado = false;


			while ( (contador < inventario.size()) && !encontrado ) {

				String idArreglo = inventario.get(contador).getIdProducto();

				if (!(id.equals(idArreglo))) {

					contador++;

				} else {

					encontrado = true;
				}
			}

			if(encontrado){

				return contador;

			} else {
			
				return -1;

			}
		}
	}

	public Producto getProducto (int posicion) {

		return inventario.get(posicion);
	}

	public void escribir () {

		String texto;
		Producto productoEscrito;

		for (int i = 0; i < inventario.size(); i ++){
		
			productoEscrito = inventario.get(i);

			System.out.println(productoEscrito.imprimirDatos());
		}
	}


	// UPDATE

	public boolean remplazarProducto (String id, Producto productoNuevo) {

		if (inventario.size() <= 0) {

			return false;
		
		} else {

			int posicion = buscarProducto(id);

			if (posicion == -1) {

				return false;
			
			} else {

				Producto remplazo = inventario.set(posicion, productoNuevo);

				return remplazo == null;
			}

		}
	}

	public boolean modificarProducto (String id, int opcion, String modificaCadena, float modificaPrecio, int modificaExistencias) {
		
		if (inventario.size() <= 0) {

			return false;
		
		} else {

			int posicion = buscarProducto(id);

			if (posicion == -1) {

				return false;
			
			} else {

				Producto productoModificado = inventario.get(posicion);

				switch (opcion) {
					case 1:
						
						 productoModificado.setNombreProducto(modificaCadena);

						break;
				
					case 2:
						
						productoModificado.setDescripcionProducto(modificaCadena);;

					    break;	

					case 3:
						
						productoModificado.setPrecioProducto(modificaPrecio);;

					    break;	

					case 4:
						
						productoModificado.setExistenciasProducto(modificaExistencias);;

					    break;	
					
					default:
						break;
				}

				return true;
				
			}
		}

	}


	// DELETE

	public boolean eliminarProducto (String id) {

		if (inventario.size() <= 0) {

			return false;

		} else {

			int contador = buscarProducto (id);

			if (contador > -1) {

				Producto productoBorrado = inventario.remove(contador);

				return productoBorrado != null;

			} else {

				return false;

			}

		}

	}


}