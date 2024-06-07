/*
Clase: ArrayListAbastecimientos
*/

package globoFeliz.modelo;

import java.util.ArrayList;

public class ArrayListAbastecimientos {
    
    
// ATRIBUTOS 

    private static ArrayList <Abastecimiento> abastecimientos = new ArrayList <Abastecimiento> ();


// CONSTRUCTOR

	// SIN PARAMTEROS 
        
    public ArrayListAbastecimientos () {

    }

	public ArrayListAbastecimientos (String db) {

		leerAbastecimientosBD();
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

	private void leerAbastecimientosBD() {

		Abastecimiento abastecimientoBD = new Abastecimiento("ab000", "pt000", " ", " ", 6);
        
        abastecimientos.add(abastecimientoBD);

	}

	public boolean agregarAbastecimiento (Abastecimiento abastecimientoNuevo) {

		abastecimientoNuevo.sumarExistenciasProducto();

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

				Abastecimiento abastecimientoBorrado = abastecimientos.remove(contador);

				abastecimientoBorrado.restarExistenciasProducto();

				return abastecimientoBorrado != null;

			} else {

				return false;

			}

		}

	}
}
