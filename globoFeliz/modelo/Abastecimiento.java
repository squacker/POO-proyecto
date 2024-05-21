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

        Producto productoAbastecido; 

        Proveedor provedorAsignado;

        int unidades;

        // float monto;


        // CONSTRUCTORES

        public AbastecimientoPorProducto (Producto producto, Proveedor proveedor, int unidades) {

            setProductoAbastecido(producto);

            setProvedorAsignado(proveedor);

            setUnidades(unidades);

        }

        // SETTERS

        public void setProductoAbastecido(Producto productoAbastecido) {

            this.productoAbastecido = productoAbastecido;
        }

        public void setProvedorAsignado(Proveedor provedorAsignado) {
         
            this.provedorAsignado = provedorAsignado;
        }

        public void setUnidades(int unidades) {
         
            this.unidades = unidades;
        }


        // GETTERS

        public Producto getProductoAbastecido() {
         
            return productoAbastecido;
        }

        public Proveedor getProvedorAsignado() {
         
            return provedorAsignado;
        }

        public int getUnidades() {
         
            return unidades;
        }

        
         
    }
    
    public class  ListaAbastecimientosPorProducto {
    
        // ATRIBUTOS

        private ArrayList <AbastecimientoPorProducto> abastecimientos = new ArrayList <AbastecimientoPorProducto> ();


        // CONSTRUCTOR

        public ListaAbastecimientosPorProducto () {

            setAbastecimientos();
        }

        // GETTERS 

        ArrayList <AbastecimientoPorProducto> getAbastecimientos () {

            return abastecimientos;
        }

        AbastecimientoPorProducto getAbastecimiento (int posicion) {

            return abastecimientos.get(posicion);
        }
      

        // METODOS 

        void setAbastecimientos () {

            for (int i = 0; i < listaIdProductos.size(); i++) {

                Producto productoAbastecido = inventario.getProducto(inventario.buscarProducto(listaIdProductos.get(i)));

                AbastecimientoPorProducto abastecimiento = new AbastecimientoPorProducto(productoAbastecido, productoAbastecido.getProveedorProducto(), unidadesProductos.get(i).intValue());

                abastecimientos.add(abastecimiento);
            }
        }
    
        void restarExistencias () {

            for (int i = 0; i < listaIdProductos.size(); i++) {

				int existencias;

				existencias = inventario.getInventario().get(inventario.buscarProducto(listaIdProductos.get(i))).getExistenciasProducto();

				existencias --;

				inventario.getInventario().get(inventario.buscarProducto(listaIdProductos.get(i))).setExistenciasProducto(existencias);

			}

        }

        void sumarExistencias () {

            for (int i = 0; i < listaIdProductos.size(); i++) {

				int existencias;

				existencias = inventario.getInventario().get(inventario.buscarProducto(listaIdProductos.get(i))).getExistenciasProducto();

				existencias ++;

				inventario.getInventario().get(inventario.buscarProducto(listaIdProductos.get(i))).setExistenciasProducto(existencias);

			}
            
        }

    }
    
// ATRIBUTOS

	private Identificador identificador = new Identificador ("ab");

    private Hora horaActual = new Hora();

	private Fecha fechaActual = new Fecha();


    private ArrayList <String> listaIdProductos;

    private String idAbastecimiento, horaAbastecimiento, fechaAbastecimiento;

    private ArrayList <Integer> unidadesProductos;

	// private float montoTotalAbastecimiento;

    private ListaAbastecimientosPorProducto productosAbastecidos = new ListaAbastecimientosPorProducto();



// CONSTRUCTORES

	// sin parametros 

    public Abastecimiento () {

        setIdAbastecimiento(" ");
    }

    // con parametros 

	public Abastecimiento (String id, ArrayList <String> listaProductos, ArrayList <Integer> listaUnidades, String hora, String fecha) {

        setIdAbastecimiento(id);

        setListaIdProductos(listaProductos);

        setUnidadesProductos(listaUnidades);

        setHoraAbastecimiento(hora);

        setFechaVenta(fecha);

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

    public void setUnidadesProductos (ArrayList <Integer> unidades) {

		this.unidadesProductos = unidades;
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


// GETTERS

    public String getIdAbastecimiento () {

        return idAbastecimiento;
    }

    public ArrayList <String> getListaIdProductos () {

        return listaIdProductos;
    }

    public ArrayList <Integer> getUnidadesProductos () {

        return unidadesProductos;
    }

   
    public String getHoraAbastecimiento() {

		return horaAbastecimiento;
	}

	public String getFechaAbastecimiento() {

		return fechaAbastecimiento;
	}

    
// METODOS

    public String imprimirDatos () {

        // pendiente

        return "";
    }

    public void restarExistenciasProducto () {

		productosAbastecidos.restarExistencias();
	}

	public void sumarExistenciasProductos () {

		productosAbastecidos.sumarExistencias();
	}



}
