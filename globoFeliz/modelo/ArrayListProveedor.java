/**
Clase: ArrayListinventario
Autor: Alonso Martinez Juan Carlos 
Version: 1.0
*/

package globoFeliz.modelo;

import globoFeliz.modelo.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListProveedor{
	

// ATRIBUTOS 

	private ArrayList <Proveedor> proveedores = new ArrayList <Proveedor> ();
	private Scanner lector = new Scanner (System.in);



// METODOS (CRUD)

	// CREATE

	public Proveedor leerDatosProveedor () {

		Proveedor proveedorNuevo = new Proveedor();

		System.out.println ("\nIngrese los siguientes datos del proveedor: ");

		System.out.print ("\nNombre: ");
		proveedorNuevo.setNombreProveedor(lector.nextLine());


		System.out.print ("\nTelefono: ");
		proveedorNuevo.setTelefonoproveedor(lector.nextLine());


		System.out.print ("\nCorreo Electronico: ");
		proveedorNuevo.setCorreoProveedor(lector.nextLine());


		System.out.print ("\nDirección Fiscal: ");
		proveedorNuevo.setDireccionFiscal(lector.nextLine());

		System.out.print ("\nRFC: ");
		proveedorNuevo.setDireccionFiscal(lector.nextLine());

		return proveedorNuevo;

	}

	public boolean agregarProvedoor (Proveedor proveedorNuevo) {

		return proveedores.add(proveedorNuevo);
	}


	// READ

	public int buscarProveedor (String id) {

		if (proveedores.size() <= 0) {

			return -1;

		} else {

			int contador = 0;
			boolean encontrado = false;


			while ( (contador < proveedores.size()) && !encontrado ) {

				String idArreglo = proveedores.get(contador).getIdProveedor();

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

	public Proveedor getProveedor (int posicion) {

		return proveedores.get(posicion);
	}

	public void escribir () {

		String texto;
		Proveedor proveedorEscrito;

		for (int i = 0; i < proveedores.size(); i ++){
		
			proveedorEscrito = proveedores.get(i);

			texto = "\nID: " + proveedorEscrito.getIdProveedor() + "\nNombre: " + proveedorEscrito.getNombreProveedor()
					 + "\nTelefono: " + proveedorEscrito.getTelefonoProveedor() + "\nCorreo Electronico: "
					  + proveedorEscrito.getCorreoProveedor() + "\nDirección Fiscal: " + proveedorEscrito.getDireccionFiscal())
					  + "\nRFC: " + proveedorEscrito.getRfcProveedor();
			
			System.out.println(texto);
		}
	}


	// UPDATE

	public boolean remplazarProveeedor (String id, Proveedor proveedorNuevo) {

		if (proveedores.size() <= 0) {

			return false;
		
		} else {

			int posicion = buscarProveedor(id);

			if (posicion == -1) {

				return false;
			
			} else {

				Proveedor remplazo = proveedores.set(posicion, proveedorNuevo);

				return remplazo == null;
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