package br.com.alura.ForumHub.dto;

import br.com.alura.ForumHub.model.Topico;
import br.com.alura.ForumHub.model.Usuario;

import java.time.LocalDateTime;

public class TopicoResponse {
    
    private Long id;
    private String titulo;
    private String nomeCurso;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String autorNome;
    private String autorEmail;
    
    public TopicoResponse() {}
    
    public TopicoResponse(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.nomeCurso = topico.getNomeCurso();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        
        if (topico.getAutor() != null) {
            this.autorNome = topico.getAutor().getNome();
            this.autorEmail = topico.getAutor().getEmail();
        }
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
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
    
    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
    
    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    public String getAutorNome() {
        return autorNome;
    }
    
    public void setAutorNome(String autorNome) {
        this.autorNome = autorNome;
    }
    
    public String getAutorEmail() {
        return autorEmail;
    }
    
    public void setAutorEmail(String autorEmail) {
        this.autorEmail = autorEmail;
    }
} 