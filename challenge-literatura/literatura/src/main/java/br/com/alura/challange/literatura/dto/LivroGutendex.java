package br.com.alura.challange.literatura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroGutendex(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<AutorGutendex> autores,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count") Integer downloads
) {
}
