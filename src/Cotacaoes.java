import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Cotacaoes {
    private String api = "SUA_API_KEY_AQUI";


    public Double buscarMoedas(String base_letras, String converte_letras) throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/"+api+"/latest/"+ base_letras;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 404) {
            Gson gson = new GsonBuilder().create();
            Moedas cotacaoes = gson.fromJson(response.body(), Moedas.class);

            if(cotacaoes.result().equals("success")) {
                return cotacaoes.conversion_rates().get(converte_letras);
            }else {
                System.out.println("moeda invalida");
                return null;
            }

        }else {
            return null;
        }


    }

}
