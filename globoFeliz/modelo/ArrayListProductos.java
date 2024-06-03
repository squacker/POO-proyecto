/*
Clase: ArrayListProductos
*/

package globoFeliz.modelo;

import java.util.ArrayList;


public class ArrayListProductos {
	

// ATRIBUTOS 

	private static ArrayList <Producto> inventario = new ArrayList <Producto> ();


// CONSTRUCTOR 
	
	public ArrayListProductos () {

	}

	public ArrayListProductos (String db) {

		leerProductosBD();
	}


// GETTERS 

	public ArrayList <Producto> getInventario () {

		return inventario;
	}

	public Producto getProducto (int posicion) {

		return inventario.get(posicion);
	}

// METODOS (CRUD)

	private void leerProductosBD () {

		Producto productoBD1 = new Producto ("pt000", "Paquete de Globos 0", "aaa", 115.41f, 35, "pv000");

		Producto productoBD2 = new Producto (" ", "Paquete de Globos 1", "eee", 224.61f, 20, "pv000");

		Producto productoBD3 = new Producto (" ", "Paquete de Globos 2", "iii", 123.43f, 56, "pv000");

		Producto productoBD4 = new Producto (" ", "Paquete de Globos 3", "ooo", 321.51f, 66, "pv000");

		Producto productoBD5 = new Producto (" ", "Paquete de Globos 4", "uuu", 150.00f, 67, "pv000");

		inventario.add(productoBD1);
		inventario.add(productoBD2);
		inventario.add(productoBD3);
		inventario.add(productoBD4);
		inventario.add(productoBD5);




	}

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

					case 5:
						
						productoModificado.setIdProveedorAsignado(modificaCadena);
						productoModificado.setProveedorAsignado();

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

	public void setProveedorAsignado () {

		for (Producto producto : inventario) {

			producto.setProveedorAsignado();
		}
	}


}