/*
Clase: ArrayListinventario
Autor: Alonso Martinez Juan Carlos 
*/

package globoFeliz.modelo;


import java.util.ArrayList;

public class ArrayListProveedor{
	

// ATRIBUTOS 

	private ArrayList <Proveedor> proveedores = new ArrayList <Proveedor> ();


// CONSTRUCTOR 

	public ArrayListProveedor () {

		// DATOS INICIALES (PRUEBA)

		Proveedor ProveedorPrueba = new Proveedor ("pv000", "Juan", "5520528105", "juaneio@hotmail.com", "oracle", "aomj020228ec3");

		Proveedor ProveedorPrueba1 = new Proveedor (" ", "Juan", "5520528105", "juaneio@hotmail.com", "oracle", "aomj020228ec3");

		Proveedor ProveedorPrueba2 = new Proveedor (" ", "Juan", "5520528105", "juaneio@hotmail.com", "oracle", "aomj020228ec3");

		Proveedor ProveedorPrueba3 = new Proveedor (" ", "Juan", "5520528105", "juaneio@hotmail.com", "oracle", "aomj020228ec3");

		Proveedor ProveedorPrueba4 = new Proveedor (" ", "Juan", "5520528105", "juaneio@hotmail.com", "oracle", "aomj020228ec3");


		agregarProveedor(ProveedorPrueba);
		agregarProveedor(ProveedorPrueba1);
		agregarProveedor(ProveedorPrueba2);
		agregarProveedor(ProveedorPrueba3);
		agregarProveedor(ProveedorPrueba4);

	}


// METODOS (CRUD)

	// CREATE

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

	public Proveedor getProveedor (int posicion) {

		return proveedores.get(posicion);
	}

	public int getTamaño () {

		return proveedores.size();
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