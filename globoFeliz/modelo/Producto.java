/*
Modelo: Cliente
Autor: Fernando Cordero 
Version: 1.0
*/

package globoFeliz.modelo;

import globoFeliz.modelo.*;

public class Producto {


// ATRIBUTOS

	private int existenciasProducto;

	private String idProducto, nombreProducto, descripcionProducto;

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

        Identificador id = new Identificador ("Prod");

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



	public static void main (String [] args) {

		Producto produ = new Producto ("Paquete de Globos Amscan", "Globos de látex llenos de confeti de 12 pulgadas", 115.41f, 35);

		System.out.println(produ.imprimirDatos());

		
	}


}
