/*
Clase: Venta
Autor: Fernando Cordero 
*/

package globoFeliz.modelo;

public class Venta {

// ATRIBUTOS

	private static Identificador identificador = new Identificador ("vt");

	private String idVenta, horaVenta, fechaVenta;
	
	private float montoTotalVenta;


// CONSTRUCTORES

	// sin parametros 

	public Venta () {

		setIdVenta(" ");
	}

	// con parametros 

	public Venta (String id, float monto) {

		setIdVenta(id);
		setHoraVenta();
		setFechaVenta();
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

	public void setHoraVenta() {

		this.horaVenta = registrarHoraVenta();
	}

	public void setFechaVenta() {

		this.fechaVenta = registrarFechaVenta();
	}

	public void setMontoTotalVenta(float monto) {

		this.montoTotalVenta = monto;
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




	// public static void main (String [] args) {

	// 	Venta venta = new Venta (115.41f);

	// 	System.out.println(venta.imprimirDatos());

		

	// } 



}