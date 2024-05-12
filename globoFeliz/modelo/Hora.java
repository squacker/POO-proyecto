/* 
Clase: Hora
(Esta clase sirve para registrar la hora actual,
es usada para registrar la hora de ventas y de abastecimientos) 

(Clase Auxiliar)

Autor: Fernando Cordero
Version: 1.0
*/

package globoFeliz.modelo;

import globoFeliz.modelo.*;
import java.time.LocalTime; 
import java.time.format.DateTimeFormatter;


public class Hora {

// ATRIBUTOS

	private LocalTime horaActual = LocalTime.now();
	private DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("HH:mm");

    private String hora;


// CONSTRUCTOR 

	public Hora() {

		setHora();
		
    }


// SETTERS

    public void setHora() {

        this.hora = horaActual.format(formatter);
    }

    


// GETTERS

    public String getHora() {

        return hora;
    }

   

}