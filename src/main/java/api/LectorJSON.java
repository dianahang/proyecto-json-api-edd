package api;

import org.json.*;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LectorJSON {
	public static void main(String[] args) {
		try {
			//Instancia para la petición al endpoint (Rick y Morty API)
			URL url = new URL("https://rickandmortyapi.com/api/character");
			
			//Generar conexión a protocolo HTTP
			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
			
			//Método de consulta (PUT, GET, POST, DELETE, ETC)
			conexion.setRequestMethod("GET");
			
			//Validar Status Code (200, 300, 400, etc) -> Conexión exitosa o no
			int statusCode = conexion.getResponseCode();
			
			if (statusCode == 200) {
				//Leer el flujo de bytes del input stream
				InputStream input = conexion.getInputStream();
				byte[] arrBytes = input.readAllBytes();
				
				//Construir el contenido de JSON
				String contJson = "";
				
				//Recorrer respuesta con un for each
				for (byte aux: arrBytes) {
					contJson += (char)aux;
				}

				//Instancia de un JSONObject (ya interpretado)
				JSONObject json = new JSONObject(contJson);
				
				//Arreglo para manipular los resultados de la API
				JSONArray arrResults = json.getJSONArray("results"); 
				
				//Extraer propiedades del JSON
				for(Object obj : arrResults) {
					JSONObject personaje = (JSONObject)obj;
					System.out.println(personaje.toString(4));
					System.out.println("\n");
					
				}
				
				conexion.disconnect();
				
			} else {
				//Si no hay éxito de conexión, lanza una excepción
				throw new RuntimeException("Error de conexión con la API. Code: " + statusCode);
			}
		} catch (Exception e) {
			/*	Lanzar excepciones para el control del endpoint y de la conexión
			 * 	al protocolo HTTP. 
			 */
			throw new RuntimeException("Ha habido un error: \n" + e);
		}
	} //Main

}
