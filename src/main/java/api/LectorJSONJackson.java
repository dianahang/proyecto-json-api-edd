package api;

import java.io.InputStream;
import java.net.URL;
import java.net.HttpURLConnection;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LectorJSONJackson {
    public static void main(String[] args) {
        // Atributo (endpoint Rick y Morty API)
        String endpoint = "https://rickandmortyapi.com/api/character";

        try {
            // Mandar a llamar métodos
            String jsonString = leerAPI(endpoint);
            imprimirJSONOrdenado(jsonString);

        } catch (Exception e) {
            throw new RuntimeException("Error de ejecución: \n" + e);
        }
    }

    // Consumir API. Devuelve el JSON como String
    public static String leerAPI(String urlString) throws Exception {
        // Instancia para la petición al endpoint
        URL url = new URL(urlString);
        // Generar conexión a protocolo HTTP con un cast
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        // Elección del método de consulta
        conexion.setRequestMethod("GET");

        // Validar Status Code
        int status = conexion.getResponseCode();
        if (status != 200) {
            throw new RuntimeException("Error HTTP: " + status);
        }

        // Leer el flujo de bytes del input stream
        InputStream input = conexion.getInputStream();
        byte[] bytes = input.readAllBytes();

        // Construir el contenido de JSON
        StringBuilder jsonBuilder = new StringBuilder();
        for (byte b : bytes) {
            jsonBuilder.append((char) b);
        }

        conexion.disconnect();

        return jsonBuilder.toString();
    }

    // Imprimir JSON en orden y con formato
    public static void imprimirJSONOrdenado(String jsonString) throws Exception {

        // Crear el ObjectMapper de Jackson
        ObjectMapper mapper = new ObjectMapper();

        // Convertir el String JSON a un JsonNode (LinkHashMap)
        JsonNode results = mapper.readTree(jsonString);

        // Obtener el arreglo de los personajes
        JsonNode personajes = results.get("results");

        // Imprimir el JSON formateado
        String jsonFormateado = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(personajes);

        System.out.println(jsonFormateado);
    }
}
