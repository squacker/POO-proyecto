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

	private ArrayListProveedor proveedores = new ArrayListProveedor();

	private Identificador identificador = new Identificador ("pt");

	private String idProducto, nombreProducto, descripcionProducto;

	private int existenciasProducto;

	private float precioProducto;

	private String idProveedorProducto;

	private Proveedor proveedorProducto;


// CONSTRUCTORES

	// Sin parametros

	public Producto () {

		setIdProducto(" ");
	}

	// Con parametros 

	public Producto (String id, String nombre, String descripcion, float precio, int existencias, String idProveedor) {

		setIdProducto(id);
		setNombreProducto(nombre);
		setDescripcionProducto(descripcion);
		setPrecioProducto(precio);
		setExistenciasProducto(existencias);
		setIdProveedorProducto(idProveedor);
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

	public void setIdProveedorProducto (String idProveedor) {

		this.idProveedorProducto = idProveedor;

		setProveedorProducto(idProveedor);
	}

	public void setProveedorProducto (String idProveedor) {

		int posicionProveedor = proveedores.buscarProveedor(idProveedor);

		this.proveedorProducto = proveedores.getProveedor(posicionProveedor);
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

	public Proveedor getProveedorProducto () {

		return proveedorProducto;
	}


// METODOS 

	public String imprimirDatos () {

		String datosProducto = "\nId: " + idProducto +
								"\nNombre: " + nombreProducto +
								"\nDescripción: " + descripcionProducto +
								"\nPrecio: " + precioProducto +
								"\nExistencias: " + existenciasProducto +
								"\nProveedor: " + proveedorProducto.getNombreProveedor() + " (" + idProveedorProducto + ")";
		
		return datosProducto;

	}

	// METODOS QUE INTERACTUAN CON CLASE VENTA 
	// probablemente no se usen estos metodos

	public void restarExistencias (int cantidadRestada) {

		existenciasProducto = existenciasProducto - cantidadRestada;
	}

	public void sumarExistencias (int cantidadSumada) {

		existenciasProducto = existenciasProducto + cantidadSumada;
	}

}