/*
Clase: ArrayListVenta
Autor: Fernando Cordero 
*/

package globoFeliz.modelo;

import java.util.ArrayList;


public class ArrayListVenta {
    
    
// ATRIBUTOS 

	private ArrayList <Venta> ventas = new ArrayList <Venta> ();

    
// METODOS (CRUD)

	// CREATE

	public boolean agregarVenta (Venta ventaNueva) {

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

    public Venta getVenta (int posicion) {

		return ventas.get(posicion);
	}
    
    public int getTamaño () {

		return ventas.size();
	}
    
    // DELETE

	public boolean eliminarVenta (String id) {

		if (ventas.size() <= 0) {

			return false;

		} else {

			int contador = buscarVenta (id);

			if (contador > -1) {

				Venta ventaBorrada = ventas.remove(contador);

				return ventaBorrada != null;

			} else {

				return false;

			}

		}

	}

}
