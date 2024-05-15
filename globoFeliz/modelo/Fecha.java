/* 
Clase: Fecha
(Clase Auxiliar: Esta clase sirve para registrar la fecha del dia en curso,
es usada para registrar la fecha de ventas y de abastecimientos) 

Autor: Fernando Cordero
*/

package globoFeliz.modelo;

import java.time.LocalDate; 
import java.time.format.DateTimeFormatter;


public class Fecha {


// ATRIBUTOS

	private LocalDate fechaActual = LocalDate.now();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	private String fecha;

// CONSTRUCTOR 

	public Fecha() {

		setFecha();
    }


// SETTERS

    public void setFecha() {


        this.fecha = fechaActual.format(formatter);
    }


// GETTERS

    public String getFecha() {

        return fecha;
    }


}

