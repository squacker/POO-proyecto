/*
Clase: ArrayListProductos
Autor: Fernando Cordero 
*/

package globoFeliz.modelo;

import java.util.ArrayList;


public class ArrayListProductos {
	

// ATRIBUTOS 

	private static ArrayList <Producto> inventario = new ArrayList <Producto> ();


// CONSTRUCTOR 
	
	public ArrayListProductos () {

		
	}

	public ArrayListProductos (Producto productoPrueba) {

		productoPrueba = new Producto ("pt000", "Paquete de Globos 0", "aaa", 115.41f, 35);

		Producto productoPrueba1 = new Producto (" ", "Paquete de Globos 1", "eee", 224.61f, 20);

		Producto productoPrueba2 = new Producto (" ", "Paquete de Globos 2", "iii", 123.43f, 56);

		Producto productoPrueba3 = new Producto (" ", "Paquete de Globos 3", "ooo", 321.51f, 66);

		Producto productoPrueba4 = new Producto (" ", "Paquete de Globos 4", "uuu", 150.00f, 67);

		agregarProducto(productoPrueba);
		agregarProducto(productoPrueba1);
		agregarProducto(productoPrueba2);
		agregarProducto(productoPrueba3);
		agregarProducto(productoPrueba4);

	}

// GETTERS 

	public ArrayList <Producto> getInventario () {

		return inventario;
	}

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

	public int getTamaño () {

		return inventario.size();
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