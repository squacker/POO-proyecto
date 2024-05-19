/*
Clase: ArrayListVenta
Autor: Fernando Cordero 
*/

package globoFeliz.modelo;

import java.util.ArrayList;


public class ArrayListVenta {
    
    
// ATRIBUTOS 

	private ArrayList <Venta> ventas = new ArrayList <Venta> ();


// CONSTRUCTOR 

	public ArrayListVenta () {

		Venta ventaPrueba = new Venta ("vt000", "19:25", "20-04-2024", 10.0f);

		Venta ventaPrueba2 = new Venta (" ", " ", " ", 15.5f);

		Venta ventaPrueba3 = new Venta (" ", " ", " ", 20.0f);

		Venta ventaPrueba4 = new Venta (" ", " ", " ", 5.2f);

		Venta ventaPrueba5 = new Venta (" ", " ", " ", 17.8f);

		agregarVenta(ventaPrueba);
		agregarVenta(ventaPrueba2);
		agregarVenta(ventaPrueba3);
		agregarVenta(ventaPrueba4);
		agregarVenta(ventaPrueba5);

	}
    
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
