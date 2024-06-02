/*
Clase: Proveedor
*/

package globoFeliz.modelo;

import java.util.ArrayList;

public class Proveedor {

// ATRIBUTOS

    private ArrayListProductos inventario = new ArrayListProductos("db"); 

	private Identificador identificador = new Identificador ("pv");

    private ArrayList <String> idProductosAsignados;

    private ArrayList <Producto> productosAsignados;

    private String idProveedor, nombreProveedor, telefonoProveedor, correoProveedor, direccionFiscal, rfcProveedor;

// CONSTRUCTOR 

    // SIN PARAMETROS

    public Proveedor(){

		setIdProovedor(" ");
	}

    // CON PARAMETROS 

	public Proveedor(String id, String nombreProveedor, String correoProveedor, String telefonoProveedor, String direccionFiscal, String rfcProveedor, ArrayList <String> idProductos) {

		setIdProovedor(id);
		setNombreProveedor(nombreProveedor);
		setTelefonoproveedor(telefonoProveedor);
        setCorreoProveedor(correoProveedor);
        setDireccionFiscal(direccionFiscal);
        setRfcProveedor(rfcProveedor);
        setIdProductosAsignados(idProductos);

	}

// SETTERS

    public void setIdProovedor(String id){

        if (id == " ") {

			this.idProveedor = identificador.generarId();

		} else {

			this.idProveedor = id;
		}

    }

    public void setNombreProveedor (String nombreProveedor){

        this.nombreProveedor = nombreProveedor;

    }

    public void setTelefonoproveedor(String telefonoProveedor){


        this.telefonoProveedor = telefonoProveedor; 

    }

    public void setCorreoProveedor(String correoProveedor){

        this.correoProveedor = correoProveedor;

    }

    public void setDireccionFiscal(String direccionFiscal){

        this.direccionFiscal = direccionFiscal;

    }

    public void setRfcProveedor(String rfcProveedor){

        this.rfcProveedor = rfcProveedor;

    }

    public void setIdProductosAsignados (ArrayList <String> idProductos) {

        this.idProductosAsignados = idProductos;
    }

    public void setProductosAsignados () {
        
        for (String idProducto : idProductosAsignados) {

            productosAsignados.add(inventario.getProducto(inventario.buscarProducto(idProducto)));
        }

    }
//GETTERS

    public String getIdProveedor(){

        return idProveedor;

    }

    public String getNombreProveedor(){

        return nombreProveedor;

    }

    public String getTelefonoProveedor(){

        return telefonoProveedor;

    }

    public String getCorreoProveedor(){

        return correoProveedor;

    }

    public String getDireccionFiscal(){

        return direccionFiscal;

    }

    public String getRfcProveedor(){

        return rfcProveedor;

    }

    public ArrayList <Producto> getProductosAsignados () {

        return  productosAsignados;
    }
// METODOS 

    public String imprimirDatos () {

        String cadenaProductosAsignados = " ";

        for (Producto productoEscrito : productosAsignados) {

            cadenaProductosAsignados += "\n";

            cadenaProductosAsignados += productoEscrito.getNombreProducto();
        }

		String datosProducto = "\nId: " + idProveedor +
								"\nNombre: " + nombreProveedor +
								"\nTeléfono: " + telefonoProveedor +
								"\nCorreo electrino: " + correoProveedor +
                                "\nDirreción Fiscal: " + direccionFiscal +
								"\nRFC: " + rfcProveedor +
                                "\n\nProductos Asignados : " + cadenaProductosAsignados;

		return datosProducto;

	}

    // PENDIENTES LOS METODOS QUE INTERACTUAN CON CLASE ABASTECIMIENTO 

}
