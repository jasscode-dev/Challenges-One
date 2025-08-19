package br.com.alura.challange.literatura.service;

import br.com.alura.challange.literatura.dto.GutendexResponse;
import br.com.alura.challange.literatura.dto.LivroGutendex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GutendexService {
    
    @Value("${gutendex.api.url}")
    private String gutendexApiUrl;
    
    @Autowired
    private RestTemplate restTemplate;
    
    public List<LivroGutendex> buscarLivrosPorTitulo(String titulo) {
        String url = gutendexApiUrl + "?search=" + titulo.replace(" ", "%20");
        
        try {
            GutendexResponse response = restTemplate.getForObject(url, GutendexResponse.class);
            return response != null ? response.livros() : List.of();
        } catch (Exception e) {
            System.err.println("Erro ao buscar livros na API Gutendex: " + e.getMessage());
            return List.of();
        }
    }
}
