import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ArduinoAPIClient {
    private static final String API_URL = ""; // URL da API do Arduino

    public static void main(String[] args) {
        while (true) {
            try {
                String response = getArduinoData();
                System.out.println("================================");
                System.out.println(" Leitura dos Sensores:");
                System.out.println(response);
                System.out.println("================================");
                
                Thread.sleep(3000); // Aguarda 3 segundos antes de nova requisição
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String getArduinoData() throws Exception {
        URL url = new URL(API_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Erro HTTP: " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            response.append(line).append("\n");
        }
        
        conn.disconnect();
        return response.toString();
    }
}
