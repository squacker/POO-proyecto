/*
Clase: Producto
Autor: Fernando Cordero 
*/

package globoFeliz.modelo;

public class Abastecimiento {

    ArrayListProductos inventario = new ArrayListProductos();

    ArrayListProveedor proveedores = new ArrayListProveedor();

// ATRIBUTOS
    
    private Identificador identificador = new Identificador ("ab");

	private Hora horaActual = new Hora();

	private Fecha fechaActual = new Fecha();


	private String idAbastecimiento, idProducto, horaAbastecimiento, fechaAbastecimiento;

    private int unidades;


// CONSTRUCTORES

	// sin parametros 

	public Abastecimiento () {

		setIdAbastecimiento(" ");
	}

	// con parametros 

	public Abastecimiento (String id, String idProducto, String hora, String fecha, int unidadesAbastecidas) {

		setIdAbastecimiento(id);
		setIdProducto(idProducto);
        setHoraAbastecimiento(hora);
		setFechaAbastecimiento(fecha);
		setUnidades(unidadesAbastecidas);

	}


// SETTERS 

    public void setIdAbastecimiento (String id) {

        if (id == " ") {

			this.idAbastecimiento = identificador.generarId();

		} else {

			this.idAbastecimiento = id;
		}

    }

    public void setIdProducto (String id) {

        this.idProducto = id;
    }

    public void setHoraAbastecimiento(String hora) {

		if (hora == " ") {

			this.horaAbastecimiento = horaActual.getHora();

		} else {

			this.horaAbastecimiento = hora;
		}
	}

	public void setFechaAbastecimiento(String fecha) {


		if (fecha == " ") {

			this.fechaAbastecimiento = fechaActual.getFecha();

		} else {

			this.fechaAbastecimiento = fecha;
		}
	}

    public void setUnidades(int unidadesAbastecidas) {

        this.unidades = unidadesAbastecidas;
	}


// GETTERS 

    public String getIdAbastecimiento() {

        return idAbastecimiento;
    }

    public String getIdProducto() {

        return idProducto;
    }

    public String getHoraAbastecimiento() {

        return horaAbastecimiento;
    }

    public String getFechaAbastecimiento() {

        return fechaAbastecimiento;
    }

    public int getUnidades() {

        return unidades;
    }


// METODOS 

    public String imprimirDatos () {

        String datosAbastecimiento = "\nId: " + idAbastecimiento +
                                "\nHora: " + horaAbastecimiento +
                                "\nFecha: " + fechaAbastecimiento +
                                "\n\nProducto: " + inventario.getProducto(inventario.buscarProducto(idProducto)).getNombreProducto() +
                                "\nUnidades: " + unidades +
                                "\nProveedor: " + proveedores.getProveedores().get(proveedores.buscarProveedor(inventario.getProducto(inventario.buscarProducto(idProducto)).getIdProveedorAsignado())).getNombreProveedor();

        return datosAbastecimiento;

    }

    public void sumarExistenciasProducto () {

        inventario.getProducto(inventario.buscarProducto(idProducto)).sumarExistencias(unidades);
    }

    public void restarExistenciasProducto () {

        inventario.getProducto(inventario.buscarProducto(idProducto)).restarExistencias(unidades);
    }

}
