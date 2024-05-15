/*
Clase: Producto
Autor: Fernando Cordero 
*/

package globoFeliz.modelo;

public class Producto {

// CONSTANTES

	public final int EXISTENCIAS_MINIMAS = 5;
	public final int EXISTENCIAS_MAXIMAS = 50;

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

	// METODOS QUE INTERACTUAN CON CLASE VENTA 

	public void restarExistencias (int cantidadRestada) {

		existenciasProducto = existenciasProducto - cantidadRestada;
	}

	public void sumarExistencias (int cantidadSumada) {

		existenciasProducto = existenciasProducto + cantidadSumada;
	}

}