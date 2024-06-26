/*
Clase: Producto
*/

package globoFeliz.modelo;

import java.util.ArrayList;

public class Producto {


// ATRIBUTOS

	private Identificador identificador = new Identificador ("pt");

	private String idProducto, nombreProducto, descripcionProducto;

	private int existenciasProducto, existenciasMinimas, existenciasMaximas;;

	private float precioProducto, costoProducto;

	private ArrayList <String> idProveedoresAsignados;

	


// CONSTRUCTORES

	// Sin parametros

	public Producto () {

		setIdProducto(" ");
	}

	// Con parametros 

	public Producto (String id, String nombre, String descripcion, float precio, float costo, int existencias, int existenciasMin, int existenciasMax) {

		setIdProducto(id);
		setNombreProducto(nombre);
		setDescripcionProducto(descripcion);
		setPrecioProducto(precio);
		setCostoProducto(costo);
		setExistenciasProducto(existencias);
		setExistenciasMinimas(existenciasMin);
		setExistenciasMaximas(existenciasMax);
		
	}


// SETTERS

	public void setIdProducto (String id) {
		
		if (id == " ") {

			this.idProducto = identificador.generarId();

		} else {

			this.idProducto = id;
		}			
	}

	public void setNombreProducto (String nombre) {

		this.nombreProducto = nombre;
	}

	public void setDescripcionProducto (String descripcion) {

		this.descripcionProducto = descripcion;
	}

	public void setPrecioProducto (float precio) {

		this.precioProducto = precio; 
	}

	public void setCostoProducto (float costo) {

		this.costoProducto = costo;
	}

	public void setExistenciasProducto (int existencias) {

		this.existenciasProducto = existencias;
	}

	public void setExistenciasMinimas (int existenciasMin) {

		this.existenciasMinimas = existenciasMin;
	}

	public void setExistenciasMaximas (int existenciasMax) {

		this.existenciasMaximas = existenciasMax;
	}

	public void setProveedorAsignado(String idProveedor) {

		idProveedoresAsignados.add(idProveedor);
	}


// GETTERS

	public String getIdProducto () {

		return idProducto;
	}

	public String getNombreProducto () {

		return nombreProducto;
	}

	public String getDescripcionProducto () {

		return descripcionProducto;
	}

	public float getPrecioProducto () {

		return precioProducto;
	}

	public float getCostoProducto () {

		return costoProducto;
	}

	public int getExistenciasProducto () {

		return existenciasProducto;
	}

	public int getExistenciasMinimas () {

		return existenciasMinimas;
	}

	public int getExistenciasMaximas () {

		return existenciasMaximas;
	}

	public String getProveedorAsignado (int posicion) {

		return idProveedoresAsignados.get(posicion);
	}

	public ArrayList <String> getIdProveedoresAsignados () {

		return idProveedoresAsignados;
	}


// METODOS 

	public String imprimirDatos () {

		String idProveedores = "Sin proveedores asignados";

		if (idProveedoresAsignados != null) {

			idProveedores = "";

			for (String id : idProveedoresAsignados) {

				idProveedores += id + ", ";
			}
		}

		String datosProducto = "\nId: " + idProducto +
								"\nNombre: " + nombreProducto +
								"\nDescripción: " + descripcionProducto +
								"\nPrecio: " + precioProducto +
								"\nCosto: " + costoProducto +
								"\nExistencias: " + existenciasProducto +
								"\nExistencias Minimas: " + existenciasMinimas +
								"\nExistencias Maximas: " + existenciasMaximas +
								"\nProveedores: " + idProveedores;

		return datosProducto;

	}

	public void restarExistencias (int cantidadRestada) {

		existenciasProducto = existenciasProducto - cantidadRestada;
	}

	public void sumarExistencias (int cantidadSumada) {

		existenciasProducto = existenciasProducto + cantidadSumada;
	}

}