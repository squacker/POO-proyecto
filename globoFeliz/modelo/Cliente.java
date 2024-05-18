/*
Clase: Cliente
Autor: Uriel Solalíndez
*/

package globoFeliz.modelo;

public class Cliente {

// CONSTANTES

    public final int EDAD_MINIMA = 18;
    public final int EDAD_MAXIMA = 100;

// ATRIBUTOS

    private static Identificador identificador = new Identificador ("vt");

    private String idCliente, nombreCliente, emailCliente;

    private int edadCliente;

    private String telefonoCliente;

// CONSTRUCTORES

    // Sin parámetros

    public Cliente() {

        setIdCliente(" ");
        
    }

    // Con parámetros

    public Cliente(String id, String nombre, String email, int edad, String telefono) {
        setIdCliente(id);
        setNombreCliente(nombre);
        setEmailCliente(email);
        setEdadCliente(edad);
        setTelefonoCliente(telefono);
    }

// SETTERS

    public void setIdCliente(String id) {

        if (id == " ") {

			this.idCliente = identificador.generarId();

		} else {

			this.idCliente = id;
		}
    }

    public void setNombreCliente(String nombre) {
        this.nombreCliente = nombre;
    }

    public void setEmailCliente(String email) {
        this.emailCliente = email;
    }

    public void setEdadCliente(int edad) {
        this.edadCliente = edad;
    }

    public void setTelefonoCliente(String telefono) {
        this.telefonoCliente = telefono;
    }

// GETTERS

    public String getIdCliente() {
        return idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public int getEdadCliente() {
        return edadCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

// MÉTODOS 

    public String imprimirDatos () {

		String datosCliente = "\nId: " + idCliente +
								"\nNombre: " + nombreCliente +
								"\nEmail: " + emailCliente +
								"\nTelefono: " + telefonoCliente +
								"\nEdad: " + edadCliente;

		return datosCliente;

	}
    
    // PENDIENTES LOS METODOS QUE INTERACTUAN CON LA CLASE VENTA
    
}
