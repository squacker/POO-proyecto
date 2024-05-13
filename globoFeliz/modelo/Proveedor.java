package globoFeliz.modelo;

/**
 *  Modelo: Proveedor
 *  Autor:  Alonso Martinez Juan Carlos.
 *  Versión:1.0 
 * 
 */
public class Proveedor {

    //atributos

    private String idProveedor, nombreProveedor, telefonoProveedor, correoProveedor, direccionFiscal, rfcProveedor;

    //Constructor 
    public Proveedor(){

		setIdProovedor();
	}

	// Con parametros 

	public Proveedor(String nombreProveedor, String correoProveedor, String telefonoProveedor, String direccionFiscal, String rfcProveedor ) {

		setIdProovedor();
		setNombreProveedor(nombreProveedor);
		setTelefonoproveedor(telefonoProveedor);
        setCorreoProveedor(correoProveedor);
        setDireccionFiscal(direccionFiscal);
        setRfcProveedor(rfcProveedor);

	}

    //Setters

    public void setIdProovedor(){

        this.idProveedor = generarIdProveedor();

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

    public static String generarIdProveedor() {

        Identificador id = new Identificador ("pv");

        return id.getId();
	}

    public String imprimirDatospv () {

		String datosProducto = "\nId: " + idProveedor +
								"\nNombre: " + nombreProveedor +
								"\nTeléfono: " + telefonoProveedor +
								"\nCorreo electrino: " + correoProveedor +
                                "\nDirreción Fiscal: " + direccionFiscal +
								"\nRFC: " + rfcProveedor;

		return datosProducto;

	}
}
