/* 
Clase: Identificador
(Clase Auxiliar: Esta clase sirve para generar un id aleatorio de 3 digitos,
es usada para generar identificadores para las clases principales)

Autor: Fernando Cordero

*/

package globoFeliz.modelo;

import java.util.Random;

public class Identificador {


// ATRIBUTOS

    private static Random random = new Random();

    private String tipoId;

    private int numId;


    
// CONSTRUCTOR

    public Identificador (String tipo) {

        setTipoId(tipo); 
        setNumId();
    }


// SETTERS

    private void setTipoId(String tipo) {

        this.tipoId = tipo;
    }

    private void setNumId() {

        this.numId = random.nextInt(900) + 100;
    }

// GETTERS

    public String getTipoId () {

        return tipoId;
    }

    public int getNumId () {

        return numId;
    }


// METODOS

    public String generarId () {

        return (tipoId + numId);
    }

   
}