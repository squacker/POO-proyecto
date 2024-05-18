/*
Clase: Venta
Autor: Fernando Cordero 
*/

package globoFeliz.modelo;

public class Venta {

// ATRIBUTOS

	private static Identificador identificador = new Identificador ("vt");

	private ListaProductos productosVendidos;

	private String idVenta, horaVenta, fechaVenta;
	
	private float montoTotalVenta;


// CONSTRUCTORES

	// sin parametros 

	public Venta () {

		setIdVenta(" ");
	}

	// con parametros 

	public Venta (ListaProductos productos, String id, String hora, String fecha, float monto) {

		setProductosVendidos(productos);
		setIdVenta(id);
		setHoraVenta(hora);
		setFechaVenta(fecha);
		setMontoTotalVenta(monto);
	}

// SETTERS 

	public void setProductosVendidos (ListaProductos productos) {


		this.productosVendidos = productos;

	}

	public void setIdVenta (String id) {
		
		if (id == " ") {

			this.idVenta = identificador.generarId();

		} else {

			this.idVenta = id;
		}

	}

	public void setHoraVenta(String hora) {

		if (hora == " ") {

			this.horaVenta = registrarHoraVenta();

		} else {

			this.horaVenta = hora;
		}
	}

	public void setFechaVenta(String fecha) {


		if (fecha == " ") {

			this.fechaVenta = registrarFechaVenta();

		} else {

			this.fechaVenta = fecha;
		}
	}

	public void setMontoTotalVenta(float monto) {

		if (monto == 0.0f) {

			this.montoTotalVenta = productosVendidos.calcularMontoTotal();

		} else {

			this.montoTotalVenta = monto;
		}
	}


// GETTERS 

	public ListaProductos getListaProductos () {

		return productosVendidos;
	}

	public String getIdVenta() {

		return idVenta;
	}

	public String getHoraVenta() {

		return horaVenta;
	}

	public String getFechaVenta() {

		return fechaVenta;
	}

	public float getMontoTotalVenta() {

		return montoTotalVenta;
	}


// METODOS 

	public static String registrarHoraVenta () {

		Hora horaActual = new Hora ();

		return horaActual.getHora();
	}

	public String registrarFechaVenta () {

		Fecha fechaActual = new Fecha();

		return fechaActual.getFecha();
	}

	public String imprimirDatos () {

		String datosVenta = "\nId: " + idVenta +
								"\nHora: " + horaVenta +
								"\nFecha: " + fechaVenta +
								"\nTotal: " + montoTotalVenta;

		return datosVenta;

	}


}