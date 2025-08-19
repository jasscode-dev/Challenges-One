package br.com.alura.challange.literatura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GutendexResponse(
        @JsonAlias("results") List<LivroGutendex> livros
) {
}
