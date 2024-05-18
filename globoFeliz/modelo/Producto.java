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

	private static Identificador identificador = new Identificador ("pt");

	private String idProducto, nombreProducto, descripcionProducto;

	private int existenciasProducto;

	private float precioProducto;


// CONSTRUCTORES

	// Sin parametros

	public Producto () {

		setIdProducto(" ");
	}

	// Con parametros 

	public Producto (String id, String nombre, String descripcion, float precio, int existencias) {

		setIdProducto(id);
		setNombreProducto(nombre);
		setDescripcionProducto(descripcion);
		setPrecioProducto(precio);
		setExistenciasProducto(existencias);
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