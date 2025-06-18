package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.cdimascio.dotenv.Dotenv;
import models.ConvertCurrency;
import models.Exchange;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeService {
    Dotenv dotenv = Dotenv.load();
    String apiKey = dotenv.get("API_KEY");

  public Exchange exchangeCurrency(String baseCurrency,String targetCurrency ,double conversionCurrency) {

      URI url = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/"+"pair/"+baseCurrency+"/"+targetCurrency+"/"+conversionCurrency);
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder().uri(url).build();


      try {
          HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
          String json = response.body();
          int statusCode = response.statusCode();

          Gson gson = new GsonBuilder()
                  .setPrettyPrinting()
                  .create();

          if(statusCode != 200){
              throw new RuntimeException("Erro na requisição: HTTP " + statusCode);

          }
          return gson.fromJson(json,  Exchange.class);


      } catch (Exception e) {
          throw new RuntimeException("Erro ao acessar a API: " + e.getMessage());
      }

  }




}