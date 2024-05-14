/*

Modelo: Cliente

Autor: Uriel Solalíndez
Version: 1.0

*/

package globoFeliz.modelo;

public class Cliente {

// CONSTANTES

    public final int EDAD_MINIMA = 18;
    public final int EDAD_MAXIMA = 100;

// ATRIBUTOS

    private String idCliente, nombreCliente, emailCliente;
    private int edadCliente;
    private String telefonoCliente;

// CONSTRUCTORES

    // Sin parámetros

    public Cliente() {

        setIdCliente();
        
    }

    // Con parámetros

    public Cliente(String nombre, String email, int edad, String telefono) {
        setIdCliente()
        setNombreCliente(nombre);
        setEmailCliente(email);
        setEdadCliente(edad);
        setTelefonoCliente(telefono);
    }

// SETTERS

    public void setIdCliente(String id) {
        this.idCliente = id;
    }

    public void setNombreCliente(String nombre) {
        this.nombreCliente = nombre;
    }

    public void setEmailCliente(String email) {
        this.emailCliente = email;
    }

    public void setEdadCliente(int edad) {
        if (edad >= EDAD_MINIMA && edad <= EDAD_MAXIMA) {
            this.edadCliente = edad;
        } else {
            System.out.println("Edad no válida, debe estar entre " + EDAD_MINIMA + " y " + EDAD_MAXIMA);
        }
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

    public void actualizarEmail(String nuevoEmail) {
        setEmailCliente(nuevoEmail);
    }

    public void actualizarTelefono(String nuevoTelefono) {
        setTelefonoCliente(nuevoTelefono);
    }
}
