package aplicacionBasesDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Metodos {
	private Connection conexion = null;
	PreparedStatement sentencia = null;
//FIJO	
	
	
	public void conectar() {
		
		try {

		String servidor="jdbc:mysql://localhost:3306/";
		String bbdd = "netflix";
		String user = "root";
		String password = "";
		
			conexion = DriverManager.getConnection(servidor+bbdd,user,password);
		} catch (SQLException e) {
			System.out.println("Error de conexión");
		}
	}

	
	public void mostrarUsuario() {
		String setenceSql= "SELECT * FROM usuario";
		try {
		
		sentencia=conexion.prepareStatement(setenceSql);

		ResultSet resultado= sentencia.executeQuery();
		
		while(resultado.next())	{
			System.out.println(
					resultado.getString(2)+ " , " +
					resultado.getString(3)+ " , " +
					resultado.getDate(4) + " , " + 
					resultado.getDate(5) + " , " + 
					resultado.getString(6) + " , " +
					resultado.getString(7) + " , "
					);
		}
		
		} catch (SQLException e) {
	
			System.out.println("Error al mostrar datos");
		}
			
	}
	
	public void mostrarPerfil() {
		String setenceSql= "SELECT * FROM perfil";
		try {
			sentencia=conexion.prepareStatement(setenceSql);
		
		
		ResultSet resultado= sentencia.executeQuery();
		
		while(resultado.next())	{
			System.out.println(
					resultado.getString(2)+ " , " +
					resultado.getString(3)+ " , " +
					resultado.getInt(4) + " ,  "
					);
		}
		} catch (SQLException e) {
			
			System.out.println("Error al mostrar datos");
		}
	}
	
	public void mostrarContenido() {
		try {
		String setenceSql= "SELECT * FROM contenido";
		
		
		sentencia=conexion.prepareStatement(setenceSql);
		
		ResultSet resultado;
		
			resultado = sentencia.executeQuery();
		
		
		while(resultado.next())	{
			System.out.println(
					resultado.getString(2)+ " , " +
					resultado.getString(3)+ " , " +
					resultado.getString(4) + " , " +
					resultado.getDate(5) + " , " 
					);
		}
		} catch (SQLException e) {
			
			System.out.println("Error al mostrar Datos");
		}
	}
	
	public void mostrarTemporada()  {
		try {
		String setenceSql= "SELECT * FROM temporada";
		
			sentencia=conexion.prepareStatement(setenceSql);
		
		
		ResultSet resultado= sentencia.executeQuery();
		
		while(resultado.next())	{
			System.out.println(
					resultado.getInt(2) + " ,  " + 
					resultado.getDate(3) + "," + 
					resultado.getString(4)+ "," +
					resultado.getInt(5) + " ,  " 
					
					);
		}
		} catch (SQLException e) {
			
			System.out.println("Error al mostrar datos");
		}
	}
	

	
	public void insertarContenido(String titulo, String paisOrigen, String sinopsis, LocalDate fecha ) {
		try {
		String insertarSql = "INSERT INTO contenido(titulo, pais_origen, sinopsis, estreno) VALUES	(?, ?, ?, ?)" ;
		
		PreparedStatement pstmt;
		
		pstmt = conexion.prepareStatement(insertarSql);
		
		
		pstmt.setString(1, titulo);
		pstmt.setString(2, paisOrigen);
		pstmt.setString(3, sinopsis);
		pstmt.setDate(4, java.sql.Date.valueOf(fecha));
		
		int filasAfectadas = pstmt.executeUpdate();
		System.out.println(filasAfectadas + "Filas(s) insertadas(s)");
		} catch (SQLException e) {
			
			System.out.println("Error al insertar.");
		}
		
	}
	//FECHA
	public static LocalDate convertirFecha(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(fecha, formatter);
    }
	
	public void insertarGenero(String descripcion, String nombre ) {
		try {

		String insertarSql = "INSERT INTO genero(descripcion, nombre) VALUES (?, ?)" ;
		
		PreparedStatement pstmt;
			pstmt = conexion.prepareStatement(insertarSql);
		
		
		pstmt.setString(1, descripcion);
		pstmt.setString(2, nombre);

		int filasAfectadas = pstmt.executeUpdate();
		System.out.println(filasAfectadas + "Filas(s) insertadas(s)");
		} catch (SQLException e) {
			
			System.out.println("Error al insertar");
		}
		
	}
	
	public void insertarActor(int numero_premios, String tipo) {
		try {
		String insertarSql = "INSERT INTO actor(numero_premios, tipo) VALUES (?, ?)" ;
		
		PreparedStatement pstmt;
		
		pstmt = conexion.prepareStatement(insertarSql);
		
		
		pstmt.setInt(1, numero_premios);
		pstmt.setString(2, tipo);

		
		int filasAfectadas = pstmt.executeUpdate();
		System.out.println(filasAfectadas + " Filas(s) insertadas(s)");
		
		} catch (SQLException e) {
		
			System.out.println("Error al insertar");
		}
	}
	
	
	public void insertarDirector(int numero_premios, String estilo) {
		try {
		String insertarSql = "INSERT INTO director(numero_premios, estilo) VALUES (?, ?)" ;
		
		PreparedStatement pstmt;
		
		pstmt = conexion.prepareStatement(insertarSql);
		
		
		pstmt.setInt(1, numero_premios);
		pstmt.setString(2, estilo);

		int filasAfectadas = pstmt.executeUpdate();
		System.out.println(filasAfectadas + " Fila(s) insertada(s)");
		
		} catch (SQLException e) {
			
			System.out.println("Error al insertar");
			}
	}
	
	//MODIFICAR
	public void modificarContenido(String titulo, String paisOrigen, String sinopsis, LocalDate fecha) {
		try {
		String sentenciaSql = "UPDATE contenido set pais_origen=?,sinopsis=?,estreno=? WHERE titulo=?";
		sentencia=conexion.prepareStatement(sentenciaSql);
		
		sentencia.setString(1, paisOrigen);
		sentencia.setString(2, sinopsis);
		sentencia.setDate(3, java.sql.Date.valueOf(fecha));
		sentencia.setString(4, titulo);
		
		sentencia.executeUpdate();
		
		} catch (SQLException e) {
			
			System.out.println("Error al modificar");
		}
	}
	
	public void mostrarGenero()  {
		try {
		String setenceSql= "SELECT * FROM genero";
		
		sentencia=conexion.prepareStatement(setenceSql);
		
		
		ResultSet resultado= sentencia.executeQuery();
		
		while(resultado.next())	{
			System.out.println(
					resultado.getInt(1) + " , " + 
					resultado.getString(2) + " ,  " + 
					resultado.getString(3) + "," 
					
					
					);
		}
		} catch (SQLException e) {
			
			System.out.println("Error al mostrar datos");
		}
			
	}
	
	public void modificarGenero(int id, String descripcion, String nombre)  {		
		try {
		String sentenciaSql = "UPDATE genero set descripcion=?, nombre=? WHERE id=?";
		
		sentencia=conexion.prepareStatement(sentenciaSql);
		
		sentencia.setString(1, descripcion);
		sentencia.setString(2, nombre);
		sentencia.setInt(3, id);
		
		sentencia.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al modificar");
		}
	}
	
	public void mostrarActor()  {
		try {
		String setenceSql= "SELECT * FROM actor";
		
		sentencia=conexion.prepareStatement(setenceSql);
		
		
		ResultSet resultado= sentencia.executeQuery();
		
		while(resultado.next())	{
			System.out.println(
					resultado.getInt(1) + " , "  +
					resultado.getInt(2) + " ,  " + 
					resultado.getString(3) + "," 
					
					
					);
		}
		} catch (SQLException e) {
	
			System.out.println("Error al mostrar datos");
		}
			
	}
	
	public void modificarActor(int id, int numero_premios, String tipo) {
		try {
		String sentenciaSql = "UPDATE actor set numero_premios=?,tipo=? WHERE id=?";
		
		sentencia=conexion.prepareStatement(sentenciaSql);
		
		
		sentencia.setInt(1, numero_premios);
		sentencia.setString(2, tipo);
		sentencia.setInt(3, id);
		

		sentencia.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al modificar");
		}
	}
	
	public void mostrarDirector() {
		try {
		String setenceSql= "SELECT * FROM director";
		
		sentencia=conexion.prepareStatement(setenceSql);
		
		
		ResultSet resultado= sentencia.executeQuery();
		
		while(resultado.next())	{
			System.out.println(
					resultado.getInt(1) + " , " +
					resultado.getInt(2) + " ,  " + 
					resultado.getString(3) + " , " 
					
					
					);
			
		}
		} catch (SQLException e) {
			
			System.out.println("Error al mostrar datos");
		}
			
	}
	
	public void modificarDirector(int id, int numero_premios, String estilo) {
		try {
		String sentenciaSql = "UPDATE director set numero_premios=?,estilo=? WHERE id=?";
		
		sentencia=conexion.prepareStatement(sentenciaSql);
		
		sentencia.setInt(1, numero_premios);
		sentencia.setString(2, estilo);
		sentencia.setInt(3, id);
		
		sentencia.executeUpdate();
		} catch (SQLException e) {
			
			System.out.println("Error al modificar");
		}
		
	}
	
	
	//ELIMINAR
	public void borrarContenido(String titulo)  {
		try {
		String sentenciaSql = "DELETE FROM contenido WHERE titulo = ?";
		
		sentencia=conexion.prepareStatement(sentenciaSql);
		
		sentencia.setString(1, titulo);
		sentencia.executeUpdate();	
		} catch (SQLException e) {
			
			System.out.println("Error al eliminar");
		}
	}
	
	public void borrarGenero(int id ) {
		try {
		String sentenciaSql = "DELETE FROM genero WHERE id=? ";
		
			sentencia=conexion.prepareStatement(sentenciaSql);
		
		sentencia.setInt(1, id);
		sentencia.executeUpdate();	
		
		} catch (SQLException e) {
			
			System.out.println("Error al eliminar");
		}
	}
	
	public void borrarActor(String numero_premios2, String tipo) {
		try {
		String sentenciaSql = "DELETE FROM actor WHERE numero_premios = ? AND tipo= ?";
		
		sentencia=conexion.prepareStatement(sentenciaSql);
		
		sentencia.setString(1, numero_premios2);
		sentencia.setString(2, tipo);
		
		sentencia.executeUpdate();	
		} catch (SQLException e) {
			
			System.out.println("Error al eliminar");
		}
	}
	
	public void borrarDirector(String numero_premios, String  estilo) {
		try {
		String sentenciaSql = "DELETE FROM director WHERE numero_premios = ? AND estilo= ?";
		
		sentencia=conexion.prepareStatement(sentenciaSql);
		
		sentencia.setString(1, numero_premios);
		sentencia.setString(2, estilo);
		
		sentencia.executeUpdate();	
		} catch (SQLException e) {
			
			System.out.println("Error al eliminar");
		}
	}
	
	
	public void consulta1() {
		try {
		String sentenciaSql = "SELECT usuario.nombre AS nombre_usuario,usuario.correo_electronico,usuario.estado_subscripcion, COUNT(perfil.id) AS cantidad_perfiles FROM usuario LEFT JOIN perfil ON usuario.id = perfil.id_usuario WHERE usuario.estado_subscripcion = 'activado' GROUP BY usuario.id, usuario.nombre, usuario.correo_electronico, usuario.estado_subscripcion";
		
		sentencia=conexion.prepareStatement(sentenciaSql);
		
		ResultSet resultado= sentencia.executeQuery();
		
		while (resultado.next()) {
            System.out.println(
                    resultado.getString("nombre_usuario") + " , " +
                    resultado.getString("correo_electronico") + " , " +
                    resultado.getString("estado_subscripcion") + " , " +
                    resultado.getInt("cantidad_perfiles")
            );
		}
		
		} catch (SQLException e) {
			
			System.out.println("ERROR en la consulta");
		}

	}
	
	public void consulta2() {
		try {
		String sentenciaSql = "SELECT contenido.titulo AS titulo_serie, COUNT(DISTINCT temporada.id) AS total_temporadas, COUNT(episodio.id) AS total_episodios FROM serie JOIN contenido ON serie.id_contenido = contenido.id LEFT JOIN temporada ON serie.id = temporada.id_serie LEFT JOIN episodio ON temporada.id = episodio.id_temporada WHERE serie.estado_de_emision = 'activo' GROUP BY serie.id, contenido.titulo";
		
		sentencia=conexion.prepareStatement(sentenciaSql);
		
		ResultSet resultado= sentencia.executeQuery();
		
		while (resultado.next()) {
            System.out.println(
                    resultado.getString("titulo_serie") + " , " +
                    resultado.getInt("total_temporadas") + " , " +
                    resultado.getInt("total_episodios")
            );
		}
		
		} catch (SQLException e) {
			
			System.out.println("ERROR en la consulta");
		}

	}
	
	
	public void consulta3() {
		try {
		String sentenciaSql = "SELECT contenido.titulo,pelicula.duracion FROM pelicula JOIN contenido ON pelicula.id_contenido = contenido.id WHERE pelicula.duracion > (SELECT AVG(pelicula.duracion) FROM pelicula)";
		
		sentencia=conexion.prepareStatement(sentenciaSql);
		
		ResultSet resultado= sentencia.executeQuery();
		
		while (resultado.next()) {
            System.out.println(
                    resultado.getString("titulo") + " , " +
                    resultado.getInt("duracion") + " min"
            );
		}
		
		} catch (SQLException e) {
			
			System.out.println("ERROR en la consulta");
		}

	}
	
	public void consulta4() {
		try {
		String sentenciaSql = "SELECT genero.nombre AS genero, COUNT(contenido_genero.id_contenido) AS cantidad_contenido FROM genero JOIN contenido_genero ON genero.id = contenido_genero.id_genero GROUP BY genero.id, genero.nombre";
		
		sentencia=conexion.prepareStatement(sentenciaSql);
		
		ResultSet resultado= sentencia.executeQuery();
		
		while (resultado.next()) {
            System.out.println(
                    resultado.getString("genero") + " , " +
                    resultado.getInt("cantidad_contenido")
            );
		}
		
		} catch (SQLException e) {
		
			System.out.println("ERROR en la consulta");
		}

	}
	public void desconectar() {
		try {
			sentencia.close();
		} catch (SQLException e) {
			System.out.println("Error al desconectar");
		}
	}
	
}
