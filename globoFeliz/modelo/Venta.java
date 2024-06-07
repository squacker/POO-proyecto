/*
Clase: Venta
*/

package globoFeliz.modelo;

import java.util.ArrayList;

public class Venta {


// ATRIBUTOS

	ArrayListProductos inventario = new ArrayListProductos();

	private Identificador identificador = new Identificador ("vt");

	private Hora horaActual = new Hora();

	private Fecha fechaActual = new Fecha();

	
	private ArrayList <String> listaIdProductos;

	private String idVenta, horaVenta, fechaVenta;
	
	private float montoTotalVenta;


// CONSTRUCTORES

	// sin parametros 

	public Venta () {

		setIdVenta(" ");
	}

	// con parametros 

	public Venta (String id, ArrayList <String> lista, String hora, String fecha, float monto) {

		setIdVenta(id);
		setListaIdProductos(lista);
		setHoraVenta(hora);
		setFechaVenta(fecha);
		setMontoTotalVenta(monto);
	}

// SETTERS 

	public void setListaIdProductos (ArrayList <String> lista) {

		this.listaIdProductos = lista;
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

			this.montoTotalVenta = calcularMontoTotal();

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
								"\n\nProductos: \n" + imprimirVenta() + "\n\n" +
								"\nTotal: " + montoTotalVenta;

		return datosVenta;

	}

	public void restarExistenciasProducto () {

		for (int i = 0; i < listaIdProductos.size(); i++) {

			int existencias;

			existencias = inventario.getInventario().get(inventario.buscarProducto(listaIdProductos.get(i))).getExistenciasProducto();

			existencias --;

			inventario.getInventario().get(inventario.buscarProducto(listaIdProductos.get(i))).setExistenciasProducto(existencias);

		}

	}

	public void sumarExistenciasProducto () {

		for (int i = 0; i < listaIdProductos.size(); i++) {

			int existencias;

			existencias = inventario.getInventario().get(inventario.buscarProducto(listaIdProductos.get(i))).getExistenciasProducto();

			existencias ++;

			inventario.getInventario().get(inventario.buscarProducto(listaIdProductos.get(i))).setExistenciasProducto(existencias);

		}
	}

	
	public float calcularMontoTotal() {

		float sumaPrecios = 0.0f;

		for (int i = 0; i < listaIdProductos.size(); i++) {

			float precioProducto = inventario.getInventario().get(inventario.buscarProducto(listaIdProductos.get(i))).getPrecioProducto();

			sumaPrecios = sumaPrecios + precioProducto;

		}

		return sumaPrecios;

	}

	public String imprimirVenta () {

		String ventasEscritas = "";

		for (int i = 0; i < listaIdProductos.size(); i++) {

			String idProducto, nombreProducto;
			float precioProducto;

			idProducto = inventario.getInventario().get(inventario.buscarProducto(listaIdProductos.get(i))).getIdProducto();

			nombreProducto = inventario.getInventario().get(inventario.buscarProducto(listaIdProductos.get(i))).getNombreProducto();
			precioProducto = inventario.getInventario().get(inventario.buscarProducto(listaIdProductos.get(i))).getPrecioProducto();

			ventasEscritas += "\nId: " + idProducto + "       " + 
								 "Nombre: " + nombreProducto + "       " +  
								 "Precio: " + precioProducto + "\n";

		}

			
		return ventasEscritas;


	}

}