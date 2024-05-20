/*
Clase: ArrayListVenta
Autor: Fernando Cordero 
*/

package globoFeliz.modelo;

import java.util.ArrayList;


public class ArrayListVenta {
    
    
// ATRIBUTOS 

	private static ArrayList <Venta> ventas = new ArrayList <Venta> ();


// CONSTRUCTORES

	public ArrayListVenta () {

		

	}

	public ArrayListVenta (Venta ventaPrueba) {

		ArrayList <String> listaProductos = new ArrayList <String> ();

		listaProductos.add("pt000");
		listaProductos.add("pt000");
		listaProductos.add("pt000");		


		ventaPrueba = new Venta ("vt000", listaProductos, " ", " ", 0.0f);

		agregarVenta(ventaPrueba);
		
	}

// GETTERS 

	public ArrayList <Venta> getVentas () {

		return ventas;
	}

	public Venta getVenta (int posicion) {

		return ventas.get(posicion);
	}

    
// METODOS (CRUD)

	// CREATE

	public boolean agregarVenta (Venta ventaNueva) {

		ventaNueva.restarExistenciasProducto();

		return ventas.add(ventaNueva);
	}


    // READ

	public int buscarVenta (String id) {

		if (ventas.size() <= 0) {

			return -1;

		} else {

			int contador = 0;
			boolean encontrado = false;


			while ( (contador < ventas.size()) && !encontrado ) {

				String idArreglo = ventas.get(contador).getIdVenta();

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

   
    
    // DELETE

	public boolean eliminarVenta (String id) {

		if (ventas.size() <= 0) {

			return false;

		} else {

			int contador = buscarVenta (id);

			if (contador > -1) {

				Venta ventaBorrada;

				ventaBorrada = ventas.remove(contador);

				ventaBorrada.sumarExistenciasProductos();

				return ventaBorrada != null;

			} else {

				return false;

			}

		}

	}

}
