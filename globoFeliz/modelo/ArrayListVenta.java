/*
Clase: ArrayListVenta
*/


package globoFeliz.modelo;

import java.util.ArrayList;


public class ArrayListVenta {
    
    
// ATRIBUTOS 

	private static ArrayList <Venta> ventas = new ArrayList <Venta> ();


// CONSTRUCTOR 


	// SIN PARAMETROS

	public ArrayListVenta () {

		
	}

	public ArrayListVenta (String db) {

		leerVentasBD();
		
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

	private void leerVentasBD () {

		Venta ventaBD;

		ArrayList <String> listaIdProductos = new ArrayList <String> ();

		listaIdProductos.add("pt000");
		listaIdProductos.add("pt000");
		listaIdProductos.add("pt000");		


		ventaBD = new Venta ("vt000", listaIdProductos, " ", " ", 0.0f);

		ventas.add(ventaBD);

	}

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

				Venta ventaBorrada = ventas.remove(contador);

				ventaBorrada.sumarExistenciasProducto();

				return ventaBorrada != null;

			} else {

				return false;

			}

		}

	}

}
