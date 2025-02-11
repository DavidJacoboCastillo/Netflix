package aplicacionBasesDatos;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;


public class Principal {
	static final Metodos MIS_DATOS = new Metodos();

	public static void main(String[] args) throws SQLException {
		Scanner input = new Scanner (System.in);
		
		int opcion;
		int subOpcion;
		
		//Iniciamos Bucle Menu
		do {
			System.out.println();
			System.out.println("_______________________________________________");
			System.out.println("MENU PRINCIPAL");
			System.out.println("_______________________________________________");
			System.out.println("1. Mostrar Datos");
			System.out.println("2. Alta de Datos");
			System.out.println("3. Modificar Datos");
			System.out.println("4. Eliminar Datos");
			System.out.println("5. Consultar Datos");
			System.out.println("6. Salir");
			System.out.println("_______________________________________________");


			
			System.out.println("Seleccione una opción: ");
			opcion = input.nextInt();
			
			//Primer Switch del menu Principal
			switch (opcion) {
			
			// Mostrar Datos
			case 1:
				
				//Segundo Switch Subopcion  de Mostrar Datos
				do {		
					System.out.println();
					System.out.println("1. MOSTRAR DATOS ");
					System.out.println("_______________________________________________");
					System.out.println("1. Mostrar tabla Usuarios");
					System.out.println("2. Mostrar tabla Perfil");
					System.out.println("3. Mostrar tabla Contenido");
					System.out.println("4. Mostrar tabla Temporada");
					System.out.println("5. Volver al menu principal");
					System.out.println("_______________________________________________");

					
					//PEDIMOS SUBOPCION
					System.out.println("Dime una opcion para mostrar por pantalla: ");
					subOpcion = input.nextInt();
					
					
					//DEFINIMOS PARA MOSTRAR DATOS MISDATOS

				
					switch (subOpcion) {
	
						case 1:
							System.out.println("_______________________________________________");
							System.out.println("Mostrando la tabla Usuario");
							System.out.println("_______________________________________________");
							MIS_DATOS.conectar();
							MIS_DATOS.mostrarUsuario();
							
							break;
							
						case 2: 
							System.out.println("_______________________________________________");
							System.out.println("Mostrando la tabla Perfil");
							System.out.println("_______________________________________________");
							MIS_DATOS.conectar();
							MIS_DATOS.mostrarPerfil();
							break;
							
						case 3: 
							System.out.println("_______________________________________________");
							System.out.println("Mostrando la tabla Contenido");
							System.out.println("_______________________________________________");
							MIS_DATOS.conectar();
							MIS_DATOS.mostrarContenido();
							break;
						case 4: 
							System.out.println("_______________________________________________");
							System.out.println("Mostrando la tabla Temporada");
							System.out.println("_______________________________________________");
							MIS_DATOS.conectar();
							MIS_DATOS.mostrarTemporada();
							break;
						
						case 5:
							System.out.println("Volviendo al menu principal...");
						break;
							}
						} while (subOpcion != 5);
					
				break; // BREAK CASE 1
				
				
			
			//Segundo Switch alta Datos
			case 2:
				
				do {
				System.out.println();
				System.out.println("2. INSERTAR DATOS ");
				System.out.println("_______________________________________________");
				System.out.println("1. Insertar datos Contenido");
				System.out.println("2. Insertar datos Genero");
				System.out.println("3. Insertar datos Actor");
				System.out.println("4. Insertar datos Director");
				System.out.println("5. Salir al menu principal");
				
				System.out.println("Dime una opción: ");
				subOpcion = input.nextInt();
				
				//Segundo Switch Subopcion  de alta Datos
				switch (subOpcion) {
		
					case 1: //INSERTAR CONTENIDO
						input.nextLine();
						
						System.out.println("_______________________________________________");
						System.out.println("Inserte datos en la tabla Contenido");
						System.out.println("_______________________________________________");
						
						System.out.println("Dime el titulo: ");
						String titulo = input.nextLine();
						
						System.out.println("Dime el pais_origen: ");
						String paisOrigen = input.nextLine();
						
						System.out.println("Dime la sinopsis: ");
						String sinopsis = input.nextLine();
						
						 System.out.print("Ingresa una fecha (yyyy-MM-dd)");
					     String estreno = input.nextLine();
					     
					     MIS_DATOS.conectar();
					     
					     LocalDate fecha = Metodos.convertirFecha(estreno);
						
					    
					     MIS_DATOS.insertarContenido(titulo, paisOrigen, sinopsis, fecha);
						break; 
						
					case 2: // GENERO
						input.nextLine();
						
						System.out.println("_______________________________________________");
						System.out.println("Inserte datos en la tabla Genero");
						System.out.println("_______________________________________________");
						
						System.out.println("Dime la descripción: ");
						String descripcion = input.nextLine();
						
						System.out.println("Dime un nombre: ");
						String nombre = input.nextLine();
						
						MIS_DATOS.conectar();
						MIS_DATOS.insertarGenero(descripcion, nombre);
						break;
						
					case 3: // ACTOR
						input.nextLine();
						
						System.out.println("_______________________________________________");
						System.out.println("Inserte datos en la tabla Actor");
						System.out.println("_______________________________________________");

						System.out.println("Dime el numero de premios: ");
						int numero_premios = input.nextInt();
						
						input.nextLine();

						System.out.println("Dime el tipo: ");
						String tipo = input.nextLine();
						
						MIS_DATOS.conectar();
						MIS_DATOS.insertarActor(numero_premios, tipo);
						break;
					
					case 4: // DIRECTOR
						input.nextLine();

						System.out.println("_______________________________________________");
						System.out.println("Inserte datos en la tabla Director");
						System.out.println("_______________________________________________");
						
						System.out.println("Dime el numero de premios: ");
						numero_premios = input.nextInt();
						input.nextLine();
						
						System.out.println("Dime el estilo cinematográfico: ");
						String estilo = input.nextLine();
						
						MIS_DATOS.conectar();
						MIS_DATOS.insertarDirector(numero_premios, estilo);;
						break;
						
					case 5: 
						System.out.println("Volviendo al menu principal...");
						break;
						
					}
				} while(subOpcion != 5);
				break; //BREAK CASE 2
				
				
				
			// SWITCH 3 Modificar datos
			case 3:
				
				
				System.out.println("1. Modificar tabla Contenido");
				System.out.println("2. Modificar tabla Genero");
				System.out.println("3. Modificar tabla Actor");
				System.out.println("4. Modificar tabla Director");
				System.out.println("5. Salir al menu principal");

				System.out.println("Dime una opcion 2: ");
				subOpcion = input.nextInt();
				

				//Segundo Switch Subopcion  de modificar Datos
				switch (subOpcion) {
		
				case 1: //MODIFICAR CONTENIDO
					input.nextLine();
					System.out.println("_______________________________________________");
					System.out.println("Modificar datos en la tabla Contenido");
					System.out.println("_______________________________________________");
					MIS_DATOS.conectar();

					MIS_DATOS.mostrarContenido();
					
					System.out.println("Dime el titulo: ");
					String titulo = input.nextLine();
					
					System.out.println("Dime el pais_origen: ");
					String paisOrigen = input.nextLine();
					
					System.out.println("Dime la sinopsis: ");
					String sinopsis = input.nextLine();
					
					 System.out.print("Ingresa una fecha (yyyy-MM-dd)");
				     String estreno = input.nextLine();
				     
				     LocalDate fecha = Metodos.convertirFecha(estreno);
					
					
					
				     MIS_DATOS.modificarContenido(titulo, paisOrigen, sinopsis, fecha);
				     MIS_DATOS.mostrarContenido();
					break; 
					
				case 2: // GENERO
					input.nextLine();
					MIS_DATOS.conectar();

					System.out.println("_______________________________________________");
					System.out.println("Modificar datos en la tabla Genero");
					System.out.println("_______________________________________________");
					MIS_DATOS.mostrarGenero();

					System.out.println("Dime la descripción: ");
					String descripcion = input.nextLine();
					
					System.out.println("Dime un nombre: ");
					String nombre = input.nextLine();
					
					MIS_DATOS.modificarGenero(descripcion, nombre);
					MIS_DATOS.mostrarGenero();

					break;
					
				case 3: // ACTOR
					input.nextLine();
					MIS_DATOS.conectar();

					System.out.println("_______________________________________________");
					System.out.println("Modificar datos en la tabla Actor");
					System.out.println("_______________________________________________");

					MIS_DATOS.mostrarActor();

					System.out.println("Dime el numero de premios: ");
					int numero_premios = input.nextInt();
					
					input.nextLine();

					System.out.println("Dime el tipo: ");
					String tipo = input.nextLine();
					

					MIS_DATOS.modificarActor(numero_premios, tipo);
					MIS_DATOS.mostrarActor();

					break;
				
				case 4: // DIRECTOR
					input.nextLine();
					MIS_DATOS.conectar();
					System.out.println("_______________________________________________");
					System.out.println("Modificar datos en la tabla Director");
					System.out.println("_______________________________________________");
					
					MIS_DATOS.mostrarDirector();

					System.out.println("Dime el numero de premios: ");
					numero_premios = input.nextInt();
					
					System.out.println("Dime su estilo cinematográfico: ");
					String estilo = input.nextLine();
					
					
					
					MIS_DATOS.modificarDirector(numero_premios, estilo);
					MIS_DATOS.mostrarDirector();

					break;
					
				case 5: 
					System.out.println("Volviendo al menu principal...");
					break;
				}
			break; //BREAK CASE 3
				
				
			//Case 4 Eliminar datos GENERAL
			case 4: 
				
				System.out.println("1. Eliminar Contenido");
				System.out.println("2. Eliminar Genero");
				System.out.println("3. Eliminar Actor");
				System.out.println("4. Eliminar Director");
				System.out.println("5. Salir al menu principal");

				System.out.println("Dime una opcion 2: ");
				subOpcion = input.nextInt();
				


				//Segundo Switch Subopcion  de ELiminar Datos
				switch (subOpcion) {
		
					case 1:
						System.out.println("_______________________________________________");
						System.out.println("Eliminar datos Contenido");
						System.out.println("_______________________________________________");
						input.nextLine();
						
						MIS_DATOS.conectar();
						MIS_DATOS.mostrarContenido();
						
						System.out.println("Dame el nombre del contenido: ");
						String titulo = input.nextLine();
						
						

						MIS_DATOS.borrarContenido(titulo);
						
						MIS_DATOS.mostrarContenido();

						break;
						
					case 2: 
						input.nextLine();
						System.out.println("_______________________________________________");
						System.out.println("Eliminar datos Genero");
						System.out.println("_______________________________________________");
						MIS_DATOS.conectar();
						MIS_DATOS.mostrarGenero();
						
						System.out.println("Dame el nombre del genero: ");
						String nombre = input.nextLine();
						
						

						MIS_DATOS.borrarGenero(nombre);;
						
						MIS_DATOS.mostrarGenero();
						break;
						
					case 3: 
						input.nextLine();
						System.out.println("_______________________________________________");
						System.out.println("Eliminar datos Actor");
						System.out.println("_______________________________________________");
						MIS_DATOS.conectar();
						MIS_DATOS.mostrarActor();
						
						System.out.println("Dame el numero de premios del actor: ");
						String numero_premios = input.nextLine();
						
						System.out.println("Dime el tipo de actor: ");
						String tipo= input.nextLine();
						

						MIS_DATOS.borrarActor(numero_premios, tipo);
						
						MIS_DATOS.mostrarActor();
						break;
					
					
					case 4: 
						input.nextLine();
						System.out.println("_______________________________________________");
						System.out.println("Eliminar datos Director");
						System.out.println("_______________________________________________");
						MIS_DATOS.conectar();
						
						MIS_DATOS.mostrarDirector();
						System.out.println("Dame el numero de premios del director: ");
						String numero_premios2 = input.nextLine();
						System.out.println("Dame el estilo cinematográfico: ");
						String estilo= input.nextLine();
						
					

						MIS_DATOS.borrarDirector(numero_premios2, estilo);
						
						MIS_DATOS.mostrarDirector();
						break;
						
					case 5: 
						System.out.println("Volviendo al menu principal...");
						break;

						
					}
				break; //BREAK CASE 4
				
				
			//CASE 5 CONSULTAS
			case 5:
				
				System.out.println("1. consulta tabla 1");
				System.out.println("2. consulta tabla 2");
				System.out.println("3. consulta tabla 3");
				System.out.println("4. consulta tabla 4");
				System.out.println("5. Salir al menu principal");

				System.out.println("Dime una opcion 2: ");
				subOpcion = input.nextInt();
				
				//Segundo Switch Subopcion  de consultas de Datos
				switch (subOpcion) {
		
					case 1:
						MIS_DATOS.conectar();

						MIS_DATOS.consulta1();
						break;
						
					case 2: 
						MIS_DATOS.conectar();

						MIS_DATOS.consulta2();
						break;
						
					case 3: 
						MIS_DATOS.conectar();

						MIS_DATOS.consulta3();
						break;
					case 4: 
						MIS_DATOS.conectar();

						MIS_DATOS.consulta4();
						break;
						
					case 5: 
						System.out.println("Volviendo al menu principal...");
						break;
					}
				break;
				
				
			//SALIR
			case 6:
				System.out.println("Fin del programa");
				break;
			
			default: 
				System.out.println("Has puesto una opcion que no entra en el rango de valores pedido.");
			} 
			
		} while (opcion != 6);
		
		
		input.close();
	}

}
