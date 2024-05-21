/*
Clase: ArrayListAbastecimientoBorrado
Autor: Fernando Cordero 
*/

package globoFeliz.modelo;

import java.util.ArrayList;


public class ArrayListAbastecimiento {
    
    
// ATRIBUTOS 

	private static ArrayList <Abastecimiento> abastecimientos = new ArrayList <Abastecimiento> ();


// CONSTRUCTORES

	public ArrayListAbastecimiento () {

		

	}

	public ArrayListAbastecimiento (Abastecimiento abastecimientoPrueba) {

		ArrayList <String> listaProductos = new ArrayList <String> ();

		ArrayList <Integer> listaUnidades = new ArrayList <Integer> ();


		listaProductos.add("pt000");

		listaUnidades.add(1);



		abastecimientoPrueba = new Abastecimiento ("ab000", listaProductos, listaUnidades, " ", " ");

		agregarAbastecimiento(abastecimientoPrueba);
		
	}

// GETTERS 

	public ArrayList <Abastecimiento> getAbastecimientos () {

		return abastecimientos;
	}

	public Abastecimiento getAbastecimiento (int posicion) {

		return abastecimientos.get(posicion);
	}

    
// METODOS (CRUD)

	// CREATE

	public boolean agregarAbastecimiento (Abastecimiento abastecimientoNuevo) {

		abastecimientoNuevo.sumarExistenciasProductos();

		return abastecimientos.add(abastecimientoNuevo);
	}


    // READ

	public int buscarAbastecimiento (String id) {

		if (abastecimientos.size() <= 0) {

			return -1;

		} else {

			int contador = 0;
			boolean encontrado = false;


			while ( (contador < abastecimientos.size()) && !encontrado ) {

				String idArreglo = abastecimientos.get(contador).getIdAbastecimiento();

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

	public boolean eliminarAbastecimiento (String id) {

		if (abastecimientos.size() <= 0) {

			return false;

		} else {

			int contador = buscarAbastecimiento (id);

			if (contador > -1) {

				Abastecimiento abastecimientoBorrado;

				abastecimientoBorrado = abastecimientos.remove(contador);

				abastecimientoBorrado.restarExistenciasProducto();

				return abastecimientoBorrado != null;

			} else {

				return false;

			}

		}

	}

}
