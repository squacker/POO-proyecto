/*
Clase: Cliente

(Clase Principal)

Autor: Fernando Cordero 
Version: 1.0
*/

package globoFeliz.modelo;

import globoFeliz.modelo.*;

@SuppressWarnings("unused")
public class Producto {


// ATRIBUTOS

	private String idProducto, nombreProducto, descripcionProducto;

	private int existenciasProducto;

	private float precioProducto;


// CONSTRUCTORES

	// Sin parametros

	public Producto () {

		setIdProducto();
	}

	// Con parametros 

	public Producto (String nombre, String descripcion, float precio, int existencias) {

		setIdProducto();
		setNombreProducto(nombre);
		setDescripcionProducto(descripcion);
		setPrecioProducto(precio);
		setExistenciasProducto(existencias);
	}


// SETTERS

	public void setIdProducto () {
		
		this.idProducto = generarIdProducto();				
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

	public void setExistenciasProducto (int existencias) {

		this.existenciasProducto = existencias;
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

	public int getExistenciasProducto () {

		return existenciasProducto;
	}


// METODOS 

	public static String generarIdProducto () {

        Identificador id = new Identificador ("pr");

        return id.getId();
	}

	public String imprimirDatos () {

		String datosProducto = "\nId: " + idProducto +
								"\nNombre: " + nombreProducto +
								"\nDescripción: " + descripcionProducto +
								"\nPrecio: " + precioProducto +
								"\nExistencias: " + existenciasProducto;

		return datosProducto;

	}

	public void restarExistencias (int cantidad) {

		existenciasProducto = existenciasProducto - cantidad;
	}

	public void sumarExistencias (int cantidad) {

		existenciasProducto = existenciasProducto + cantidad;
	}




}