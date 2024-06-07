/*
Clase: ArrayListinventario
*/

package globoFeliz.modelo;


import java.util.ArrayList;

public class ArrayListProveedor{
	

// ATRIBUTOS 

	private static ArrayList <Proveedor> proveedores = new ArrayList <Proveedor> ();


// CONSTRUCTOR 

	// SIN PARAMETROS

	public ArrayListProveedor () {


	}

	public ArrayListProveedor (String db) {

		leerProveedoresBD();

	}


// GETTERS 

	public ArrayList <Proveedor> getProveedores () {

		return proveedores;
	}

	public Proveedor getProveedor (int posicion) {

		return proveedores.get(posicion);
	}


// METODOS (CRUD)

	// CREATE

	private void leerProveedoresBD () {
		

		Proveedor proveedorBD1 = new Proveedor ("pv000", "Provedor Uno", "5520528105", "proveedor1@gmail.com", "Emperadores 789, CDMX, México", "ABC1234567890");
		
		Proveedor proveedorBD2 = new Proveedor ("pv526", "Provedor Dos", "5559876543", "proveedor2@gmail.com", "Avenida Tezonco 456, CDMX, México", "DEF0987654321");

		Proveedor proveedorBD3 = new Proveedor ("pv987", "Provedor Tres", "5556543210", "proveedor3@gmail.com", "Suiza 345, CDMX, México", "GHI1234567890");

		Proveedor proveedorBD4 = new Proveedor ("pv478", "Provedor Cuatro", "5551234567 ", "proveedor4@gmail.com", "Porfirio Diaz 39, CDMX, Mexico", "BJK0341892398");

		Proveedor proveedorBD5 = new Proveedor ("pv657", "Provedor Cinco", "5520053157", "proveedor5@gmail.com", "Calle Arneses 123, CDMX, Mexico", "ORC9085687457");


		proveedores.add(proveedorBD1);
		proveedores.add(proveedorBD2);
		proveedores.add(proveedorBD3);
		proveedores.add(proveedorBD4);
		proveedores.add(proveedorBD5);

	}

	public boolean agregarProveedor (Proveedor proveedorNuevo) {

		return proveedores.add(proveedorNuevo);
	}
	

	// READ

	public int buscarProveedor (String idProveedor) {

		if (proveedores.size() <= 0) {

			return -1;

		} else {

			int contador = 0;
			boolean encontrado = false;


			while ( (contador < proveedores.size()) && !encontrado ) {

				String idArreglo = proveedores.get(contador).getIdProveedor();

				if (!(idProveedor.equals(idArreglo))) {

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

	public boolean remplazarProveedor (String idProveedor, Proveedor proveedorNuevo) {

		if (proveedores.size() <= 0) {

			return false;
		
		} else {

			int posicion = buscarProveedor(idProveedor);

			if (posicion == -1) {

				return false;
			
			} else {

				Proveedor remplazo = proveedores.set(posicion, proveedorNuevo);

				return remplazo == null;
			}

		}
	}

	public boolean modificarProveedor (String idProveedor, int opcion, String modificaCadena) {
		
		if (proveedores.size() <= 0) {

			return false;
		
		} else {

			int posicion = buscarProveedor(idProveedor);

			if (posicion == -1) {

				return false;
			
			} else {

				Proveedor proveedorModificado = proveedores.get(posicion);

				switch (opcion) {
					case 1:
						
						 proveedorModificado.setNombreProveedor(modificaCadena);

						break;
				
					case 2:
						
						proveedorModificado.setTelefonoproveedor(modificaCadena);

					    break;	

					case 3:
						
						proveedorModificado.setCorreoProveedor(modificaCadena);

					    break;	

					case 4:
						
						proveedorModificado.setDireccionFiscal(modificaCadena);

					    break;
					
					case 5:
						
						proveedorModificado.setRfcProveedor(modificaCadena);

					    break;		
					
					default:
						break;
				}

				return true;
				
			}
		}

	}

	// DELETE

	public boolean eliminarProveedor (String id) {

		if (proveedores.size() <= 0) {

			return false;

		} else {

			int contador = buscarProveedor(id);

			if (contador > -1) {

				Proveedor proveedorBorrado = proveedores.remove(contador);

				return proveedorBorrado != null;

			} else {

				return false;

			}

		}

	}


}