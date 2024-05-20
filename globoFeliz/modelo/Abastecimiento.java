/*
Clase: Abastecimiento
Autor: Fernando Cordero 
*/

package globoFeliz.modelo;

import java.util.ArrayList;


public class Abastecimiento {

// SE AÑADEN LOS REGISTROS DE INVENTARIO Y PROVEEDORES

    ArrayListProductos inventario = new ArrayListProductos();

    ArrayListProveedor proveedores = new ArrayListProveedor();
    

    public class AbastecimientoPorProducto {

        // Clase que almacena un registro de tres campos: producto, proveedor, cantidad y monto

        // metodos y constructores pendientes

    }
    
    public class  ListaAbastecimientosPorProducto {
    
        // ATRIBUTOS

        private ArrayList <AbastecimientoPorProducto> abastecimientos = new ArrayList <AbastecimientoPorProducto> ();

        // metodos y constructores pendientes

    }
    
// ATRIBUTOS

	private Identificador identificador = new Identificador ("ab");

    private Hora horaActual = new Hora();

	private Fecha fechaActual = new Fecha();


    private ArrayList <String> listaIdProductos;

    private ArrayList <String> listaIdProveedores;


    private String idAbastecimiento, horaAbastecimiento, fechaAbastecimiento;

	private float montoTotalAbastecimiento;

    private ListaAbastecimientosPorProducto productosAbastecidos = new ListaAbastecimientosPorProducto();



// CONSTRUCTORES

	// sin parametros 

    public Abastecimiento () {

        setIdAbastecimiento(" ");
    }

    // con parametros 

	public Abastecimiento (String id, ArrayList <String> listaProductos, ArrayList <String> listaProveedores, String hora, String fecha, float monto) {

        
    }

    
// SETTERS 

    public void setIdAbastecimiento(String id) {

        if (id == " ") {

			this.idAbastecimiento = identificador.generarId();

		} else {

			this.idAbastecimiento = id;
		}
    }

    public void setListaIdProductos (ArrayList <String> listaProdu) {

		this.listaIdProductos = listaProdu;
	}

    public void setListaIdProveedores (ArrayList <String> listaProve) {

		this.listaIdProveedores = listaProve;
	}

    public void setHoraAbastecimiento (String hora) {

		if (hora == " ") {

			this.horaAbastecimiento = horaActual.getHora();

		} else {

			this.horaAbastecimiento = hora;
		}
	}

    public void setFechaVenta(String fecha) {


		if (fecha == " ") {

			this.fechaAbastecimiento = fechaActual.getFecha();

		} else {

			this.fechaAbastecimiento = fecha;
		}
	}

    public void setMontoTotalAbastecimiento(float monto) {

		if (monto == 0.0f) {

			this.montoTotalAbastecimiento = 0.0f;
            // productosAbastecidos.calcularMontoTotal();

		} else {

			this.montoTotalAbastecimiento = monto;
		}
	}


// GETTERS

    public String getIdAbastecimiento () {

        return idAbastecimiento;
    }

    public ArrayList <String> getListaIdProductos () {

        return listaIdProductos;
    }

    public ArrayList <String> getListaIdProveedores () {

        return listaIdProveedores;
    }

    public String getHoraAbastecimiento() {

		return horaAbastecimiento;
	}

	public String getFechaAbastecimiento() {

		return fechaAbastecimiento;
	}

	public float getMontoTotalAbastecimiento() {

		return montoTotalAbastecimiento;
	}


// METODOS

    public String imprimirDatos () {

        // pendiente

        return "";
    }

    public void restarExistenciasProducto () {

		// productosAbastecidos.restarExistencias();
	}

	public void sumarExistenciasProductos () {

		// productosAbastecidos.sumarExistencias();
	}



}
