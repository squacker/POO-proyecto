/*
Clase: Proveedor
*/

package globoFeliz.modelo;

import java.util.ArrayList;

public class Proveedor {

// ATRIBUTOS

	private Identificador identificador = new Identificador ("pv");

    private String idProveedor, nombreProveedor, telefonoProveedor, correoProveedor, direccionFiscal, rfcProveedor;

    private ArrayList <String> idProductosAsignados = new ArrayList <String> () ;

// CONSTRUCTOR 

    // SIN PARAMETROS

    public Proveedor(){

		setIdProovedor(" ");
	}

    // CON PARAMETROS 

	public Proveedor(String id, String nombreProveedor, String correoProveedor, String telefonoProveedor, String direccionFiscal, String rfcProveedor) {

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

    public void setProductoAsignado (String idProducto) {

        idProductosAsignados.add(idProducto);
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

    public String getProductoAsignado (int posicion) {

        return idProductosAsignados.get(posicion);
    }
    
    public ArrayList <String> getIdProductosAsignados () {

        return idProductosAsignados;
    }

// METODOS 


    public boolean eliminarProductoAsignado (String idProducto) {


            int contador = 0;
            boolean encontrado = false;


            while ( (contador < idProductosAsignados.size()) && !encontrado ) {

                String idArreglo = idProductosAsignados.get(contador);

                if (!(idProducto.equals(idArreglo))) {

                    contador++;

                } else {

                    encontrado = true;
                }
            }


            String idProductoBorrado = idProductosAsignados.remove(contador);

            return idProductoBorrado != null;

    }

    public String imprimirDatos () {

        String idProductos = "Sin productos asignados";

		if (!idProductosAsignados.isEmpty()) {

			idProductos = "";

			for (String id : idProductosAsignados) {

				idProductos += "\n   " + id ;
			}
			
		}

		String datosProducto = "\nId: " + idProveedor +
								"\nNombre: " + nombreProveedor +
								"\nTeléfono: " + telefonoProveedor +
								"\nCorreo electrino: " + correoProveedor +
                                "\nDirreción Fiscal: " + direccionFiscal +
								"\nRFC: " + rfcProveedor + 
                                "\nProductos: " + idProductos;

		return datosProducto;

	}

}
