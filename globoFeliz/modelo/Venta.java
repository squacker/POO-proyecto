// /*
// Modelo: Venta

// (Clase Principal)

// Autor: Fernando Cordero 
// Version: 1.0
// */

package globoFeliz.modelo;

import globoFeliz.modelo.*;

@SuppressWarnings("unused")
public class Venta {

// ATRIBUTOS


	private String idVenta, horaVenta, fechaVenta;
	
	private float montoTotalVenta;


// CONSTRUCTORES

	// sin parametros 

	public Venta () {

		setIdVenta();
	}

	// con parametros 

	public Venta (float monto) {

		setIdVenta();
		setHoraVenta();
		setFechaVenta();
		setMontoTotalVenta(monto);
	}

// SETTERS 

	public void setIdVenta () {

		this.idVenta = generarIdVenta();
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

	public static String generarIdVenta () {

        Identificador id = new Identificador ("Vent");

        return id.getId();
	}

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