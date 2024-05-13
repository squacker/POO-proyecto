/*
Clase: ArrayListinventario

(Controlador de Clase Producto)

Autor: Fernando Cordero 
Version: 1.0
*/

package globoFeliz.controlador;

import globoFeliz.modelo.*;
import java.util.Scanner;


public class GestionInventario {


	public static void main (String [] args) {


// ARRAY LIST PRODUCTO

		ArrayListProductos inventario = new ArrayListProductos();


// DATOS INICIALES

		Producto productoPrueba = new Producto ("Paquete de Globos 0", "aaa", 115.41f, 35);

		Producto productoPrueba1 = new Producto ("Paquete de Globos 1", "eee", 224.61f, 20);

		Producto productoPrueba2 = new Producto ("Paquete de Globos 2", "iii", 123.43f, 56);

		Producto productoPrueba3 = new Producto ("Paquete de Globos 3", "ooo", 321.51f, 66);

		Producto productoPrueba4 = new Producto ("Paquete de Globos 4", "uuu", 150.00f, 67);


		inventario.agregarProducto(productoPrueba);
		inventario.agregarProducto(productoPrueba1);
		inventario.agregarProducto(productoPrueba2);
		inventario.agregarProducto(productoPrueba3);
		inventario.agregarProducto(productoPrueba4);

		System.out.println("\n\n\n_____INVENTARIO GLOBO FELIZ_____");
		inventario.escribir();


// VARIABLES AUXILIARES

		int opcion;
		Producto productoNuevo;
		String id;

		@SuppressWarnings("resource")
		Scanner lector = new Scanner (System.in);


// SWITCH MENU

		do {

			System.out.println("\n\n1. Agregar   2. Reemplazar   3. Modificar   4. Borrar   5. Buscar   6. Listar   0. Salir\n\n");
			System.out.printf("¿Que deseas hacer?: ");

			opcion = lector.nextInt();
			lector.nextLine();


			switch (opcion) {

				case 1: 

					productoNuevo = inventario.leerDatosProducto();
					inventario.agregarProducto(productoNuevo);

					break;

				case 2:

					System.out.printf("Introduce el id del producto que deseas reemplazar: ");

					id = lector.nextLine();

					if (inventario.buscarProducto(id) == -1) {

						System.out.println("El id que ingresaste no existe");

					} else {

						productoNuevo = inventario.leerDatosProducto();
						inventario.remplazarProducto(id, productoNuevo);

					}

					break;


				
				case 3:

					System.out.printf("Introduce el id del producto que deseas modificar: ");
					id = lector.nextLine();

					if (inventario.buscarProducto(id) == -1) {

						System.out.println("El id que ingresaste no existe");

						break;

					} else {

						int opcionModificar;

						String nuevaCadena;
						float nuevoPrecio;
						int nuevoExistencias;

						System.out.printf("1. Nombre   2. Descripcion   3. Precio   4. Existencias\n\n¿Que dato deseas modificar?: ");
						opcionModificar = lector.nextInt();
						lector.nextLine();


						switch (opcionModificar) {
							case 1:
								
								System.out.printf("Ingresa nuevo nombre: ");
								nuevaCadena = lector.nextLine();

								
								inventario.modificarProducto(id, opcionModificar, nuevaCadena, 0.0f, 0);
		
								break;
						
							case 2:
								
								System.out.printf("Ingresa nueva Descripcion: ");
								nuevaCadena = lector.nextLine();

								
								inventario.modificarProducto(id, opcionModificar, nuevaCadena, 0.0f, 0);
		
								break;	
		
							case 3:
								
								System.out.printf("Ingresa nuevo Precio: ");
								nuevoPrecio = lector.nextFloat();
								
								inventario.modificarProducto(id, opcionModificar, " ", nuevoPrecio, 0);
		
								break;	
		
							case 4:
								
								System.out.printf("Ingresa nuevas Existencias: ");
								nuevoExistencias = lector.nextInt();
								
								inventario.modificarProducto(id, opcionModificar, " ", 0.0f, nuevoExistencias);
		
								break;	
							
							default:
								break;
						}

						break;

					}

				case 4:

					System.out.printf("Introduce el id del producto que deseas borrar: ");

					id = lector.nextLine();

					if (inventario.buscarProducto(id) == -1) {

						System.out.println("El id que ingresaste no existe");

					} else {

						inventario.eliminarProducto(id);

					}

					break;

				case 5:

					System.out.printf("\n\nIntroduce el id del producto que deseas buscar: ");

					id = lector.nextLine();

					int posicion = inventario.buscarProducto(id);
					Producto productoEscrito = inventario.getProducto(posicion);

					System.out.println(productoEscrito.imprimirDatos());

				case 6: 

					inventario.escribir();

					break;


				case 0: 

					break;


				default:
					break;

				}

			} while (opcion != 0);
		}

		
	}


	

	


