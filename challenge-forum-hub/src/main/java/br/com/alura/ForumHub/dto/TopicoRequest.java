package br.com.alura.ForumHub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TopicoRequest {
    
    @NotBlank(message = "Título é obrigatório")
    @Size(min = 5, max = 200, message = "Título deve ter entre 5 e 200 caracteres")
    private String titulo;
    
    @NotBlank(message = "Nome do curso é obrigatório")
    @Size(min = 2, max = 100, message = "Nome do curso deve ter entre 2 e 100 caracteres")
    private String nomeCurso;
    
    @NotBlank(message = "Mensagem é obrigatória")
    @Size(min = 10, max = 2000, message = "Mensagem deve ter entre 10 e 2000 caracteres")
    private String mensagem;
    
    public TopicoRequest() {}
    
    public TopicoRequest(String titulo, String nomeCurso, String mensagem) {
        this.titulo = titulo;
        this.nomeCurso = nomeCurso;
        this.mensagem = mensagem;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getNomeCurso() {
        return nomeCurso;
    }
    
    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }
    
    public String getMensagem() {
        return mensagem;
    }
    
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
} 