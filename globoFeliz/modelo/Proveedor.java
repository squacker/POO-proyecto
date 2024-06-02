/*
Clase: Proveedor
*/

package globoFeliz.modelo;

public class Proveedor {

// ATRIBUTOS

	private Identificador identificador = new Identificador ("pv");

    private String idProveedor, nombreProveedor, telefonoProveedor, correoProveedor, direccionFiscal, rfcProveedor;

// CONSTRUCTOR 

    // SIN PARAMETROS

    public Proveedor(){

		setIdProovedor(" ");
	}

    // CON PARAMETROS 

	public Proveedor(String id, String nombreProveedor, String correoProveedor, String telefonoProveedor, String direccionFiscal, String rfcProveedor ) {

		setIdProovedor(id);
		setNombreProveedor(nombreProveedor);
		setTelefonoproveedor(telefonoProveedor);
        setCorreoProveedor(correoProveedor);
        setDireccionFiscal(direccionFiscal);
        setRfcProveedor(rfcProveedor);

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


// METODOS 

    public String imprimirDatos () {

		String datosProducto = "\nId: " + idProveedor +
								"\nNombre: " + nombreProveedor +
								"\nTeléfono: " + telefonoProveedor +
								"\nCorreo electrino: " + correoProveedor +
                                "\nDirreción Fiscal: " + direccionFiscal +
								"\nRFC: " + rfcProveedor;

		return datosProducto;

	}

    // PENDIENTES LOS METODOS QUE INTERACTUAN CON CLASE ABASTECIMIENTO 

}
