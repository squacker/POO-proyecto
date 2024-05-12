/* 
Clase: Identificador
(Esta clase sirve para generar un id aleatorio de 3 digitos,
es usada para generar identificadores para las clases principales) 

(Clase Auxiliar)

Autor: Fernando Cordero
Version: 1.0
*/

package globoFeliz.modelo;

import globoFeliz.modelo.*;
import java.util.Random;

public class Identificador {


// ATRIBUTOS

    Random random = new Random();

    String tipoId;

    int numId;

    String id;

    
// CONSTRUCTOR

    public Identificador (String tipo) {

        setTipoId(tipo); 
        setNumId();
        setId();
    }


// SETTERS

    private void setTipoId(String tipo) {

        this.tipoId = tipo;
    }

    private void setNumId() {

        this.numId = random.nextInt(900) + 100;
    }

    private void setId() {

        this.id = getTipoId()  + getNumId();
    }

// GETTERS

    public String getTipoId () {

        return tipoId;
    }

    public int getNumId () {

        return numId;
    }

    public String getId () {

        return id;
    }

   
}