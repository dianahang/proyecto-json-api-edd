package api;

import org.json.*;

import java.net.HttpURLConnection;
import java.net.URL;

public class LectorJSON {
	/*	Lanzar excepciones para el control del endpoint y de la conexión
	 * 	al protocolo HTTP. 
	 */
	
	public static void main(String[] args) throws Exception {
		//Instancia para la petición al endpoint (Rick y Morty API)
		URL url = new URL("https://rickandmortyapi.com/api/character");
		
		//Generar conexión a protocolo HTTP
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		
		//Método de consulta (PUT, GET, POST, DELETE, ETC)
		conexion.setRequestMethod("GET");
		
		//Validar Status Code (200, 300, 400, etc) -> Conexión exitosa o no
		int statusCode = conexion.getResponseCode();
		
		if (statusCode == 200) {
			
		} else {
			//Si no hay éxito de conexión, lanza una excepción
			throw new RuntimeException("Error de conexión con la API. Code: " + statusCode);
		}
	}

}
