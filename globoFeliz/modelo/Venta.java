/*
Clase: Venta
Autor: Fernando Cordero 
*/

package globoFeliz.modelo;

public class Venta {

// ATRIBUTOS

	private Identificador identificador = new Identificador ("vt");

	private Hora horaActual = new Hora();

	private Fecha fechaActual = new Fecha();


	private String idVenta, horaVenta, fechaVenta;
	
	private float montoTotalVenta;


// CONSTRUCTORES

	// sin parametros 

	public Venta () {

		setIdVenta(" ");
	}

	// con parametros 

	public Venta (String id, String hora, String fecha, float monto) {

		setIdVenta(id);
		setHoraVenta(hora);
		setFechaVenta(fecha);
		setMontoTotalVenta(monto);
	}

// SETTERS 

	public void setIdVenta (String id) {
		
		if (id == " ") {

			this.idVenta = identificador.generarId();

		} else {

			this.idVenta = id;
		}

	}

	public void setHoraVenta(String hora) {

		if (hora == " ") {

			this.horaVenta = horaActual.getHora();

		} else {

			this.horaVenta = hora;
		}
	}

	public void setFechaVenta(String fecha) {


		if (fecha == " ") {

			this.fechaVenta = fechaActual.getFecha();

		} else {

			this.fechaVenta = fecha;
		}
	}

	public void setMontoTotalVenta(float monto) {

		if (monto == 0.0f) {

			this.montoTotalVenta = 0.0f;
			// productosVendidos.calcularMontoTotal();

		} else {

			this.montoTotalVenta = monto;
		}
	}


// GETTERS 

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

	public String imprimirDatos () {

		String datosVenta = "\nId: " + idVenta +
								"\nHora: " + horaVenta +
								"\nFecha: " + fechaVenta +
								"\nTotal: " + montoTotalVenta;

		return datosVenta;

	}


}