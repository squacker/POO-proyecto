/*

Modelo: ArrayListCliente

Autor: Uriel Solalíndez
Version: 1.0

*/

package globoFeliz.modelo;

import java.util.ArrayList;

public class ArrayListCliente {

// ATRIBUTOS 

    private ArrayList <Cliente> listaClientes = new ArrayList <Cliente> ();

// METODOS (CRUD)

    // CREATE

    public boolean agregarCliente(Cliente clienteNuevo) {

        return listaClientes.add(clienteNuevo);
    }

    // READ

    public int buscarCliente(String id) {

        if (listaClientes.size() <= 0) {

            return -1;

        } else {

            int contador = 0;

            boolean encontrado = false;

            while ((contador < listaClientes.size()) && !encontrado) {
                
                String idArreglo = listaClientes.get(contador).getIdCliente();
                
                if (!(id.equals(idArreglo))) {
                    
                    contador++;

                } else {
                    
                    encontrado = true;
                
                }
                
            }
            
            if (encontrado) {
                
                return contador;
            
            } else {
                
                return -1;
            
            }
        }
    }


    public Cliente getCliente(int posicion) {

        return listaClientes.get(posicion);
    }

    public int getTamaño() {

        return listaClientes.size();
    }


    // UPDATE

    public boolean remplazarCliente(String id, Cliente clienteNuevo) {

        if (listaClientes.size() <= 0) {

            return false;

        } else {

            int posicion = buscarCliente(id);

            if (posicion == -1) {

                return false;

            } else {

                Cliente remplazo = listaClientes.set(posicion, clienteNuevo);

                return remplazo == null;
            }
        }
    }

    public boolean modificarCliente(String id, int opcion, String modificaCadena, int modificaEdad) {
        
        if (listaClientes.size() <= 0) {

            return false;

        } else {

            int posicion = buscarCliente(id);

            if (posicion == -1) {

                return false;

            } else {

                Cliente clienteModificado = listaClientes.get(posicion);

                switch (opcion) {

                    case 1:

                        clienteModificado.setNombreCliente(modificaCadena);

                        break;

                    case 2:

                        clienteModificado.setEmailCliente(modificaCadena);

                        break;

                    case 3:

                        clienteModificado.setEdadCliente(modificaEdad);

                        break;

                    case 4:

                        clienteModificado.setTelefonoCliente(modificaCadena);

                        break;

                    default:
                        break;
                }

                return true;
            }
        }
    }

    // DELETE

    public boolean eliminarCliente(String id) {

        if (listaClientes.size() <= 0) {

            return false;

        } else {

            int contador = buscarCliente(id);

            if (contador > -1) {

                Cliente clienteBorrado = listaClientes.remove(contador);

                return clienteBorrado != null;

            } else {

                return false;
                
            }

        }
    }
}
