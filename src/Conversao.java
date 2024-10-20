import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Conversao {
    private static final String API_KEY = "ad6fb46a1e36ec5b4272998b"; // chave API
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private static final Logger logger = Logger.getLogger(Conversao.class.getName()); // Logger

    // Método para realizar a conversão
    public static void converterMoeda(String moedaOrigem, String moedaDestino, double valor) {
        double taxaConversao = obterTaxaDeCambio(moedaOrigem, moedaDestino);

        if (taxaConversao != 0.0) {
            double valorConvertido = valor * taxaConversao;
            System.out.printf("O valor de %.2f %s corresponde a %.2f %s\n", valor, moedaOrigem, valorConvertido, moedaDestino);
        } else {
            System.out.println("Não foi possível obter a taxa de conversão.");
        }
    }

    // Método para obter a taxa de câmbio da API
    public static double obterTaxaDeCambio(String moedaOrigem, String moedaDestino) {
        String urlString = BASE_URL + API_KEY + "/pair/" + moedaOrigem + "/" + moedaDestino;
        double taxa = 0.0;

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();

                JsonObject jsonResponse = JsonParser.parseString(content.toString()).getAsJsonObject();
                taxa = jsonResponse.get("conversion_rate").getAsDouble();

            } else {
                logger.log(Level.WARNING, "Erro ao se conectar à API: {0}", responseCode);
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao obter a taxa de câmbio", e); // Utiliza o logger
        }

        return taxa;
    }
}