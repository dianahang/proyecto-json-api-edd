package api;

import org.json.*;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LectorJSON {
	public static void main(String[] args) {
		//Atributo (endpoint Rick y Morty API)
		String url = "https://rickandmortyapi.com/api/character";
		
		try {
			String json = consumirAPI(url);
			JSONObject object = castJSON(json);
			mostrarResultados(object);
			
		} catch (Exception e) {
			throw new RuntimeException("Ha ocurrido un error:\n" + e.getMessage());
		}
			
	} //Main
	
	/*	Métodos*********************************************************
	 * 	Consumir API y devolver el JSON: Lanzar excepciones para el 
	 * 	control del endpoint y de la conexión al protocolo HTTP. 
	 */
	public static String consumirAPI(String link) throws Exception {
		//Instancia para la petición al endpoint 
		URL url = new URL(link);
		
		//Generar conexión a protocolo HTTP
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		
		//Método de consulta (PUT, GET, POST, DELETE, ETC)
		conexion.setRequestMethod("GET");
		
		//Validar Status Code (200, 300, 400, etc) -> Conexión exitosa o no
		int statusCode = conexion.getResponseCode();
		
		if (statusCode != 200) {
			throw new RuntimeException("Error de conexión HTTP: " + statusCode);
		}
		
		//Leer el flujo de bytes del input stream
		InputStream input = conexion.getInputStream();
		byte[] arrBytes = input.readAllBytes();
		
		//Construir el contenido de JSON
		String contJson = "";
		
		//Recorrer respuesta con un for each
		for (byte aux: arrBytes) {
			contJson += (char)aux;
		}
		
		conexion.disconnect();
		
		return contJson;
	}
	
	// Castear String de JSON a un JSONObject
	public static JSONObject castJSON(String contJson) {
		return new JSONObject(contJson);
	}
	
	// Imprimir resultados en consola
	public static void mostrarResultados(JSONObject json) {
		//Arreglo para manipular los resultados de la API
		JSONArray arrResults = json.getJSONArray("results"); 
		
		//Extraer propiedades del JSON
		for(Object obj : arrResults) {
			JSONObject personaje = (JSONObject)obj;
			System.out.println(personaje.toString(4));
			System.out.println("\n");
		}
	}
}
