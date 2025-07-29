package br.com.alura.ForumHub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
public class Topico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Título é obrigatório")
    @Size(min = 5, max = 200, message = "Título deve ter entre 5 e 200 caracteres")
    @Column(nullable = false)
    private String titulo;
    
    @NotBlank(message = "Nome do curso é obrigatório")
    @Size(min = 2, max = 100, message = "Nome do curso deve ter entre 2 e 100 caracteres")
    @Column(name = "nome_curso", nullable = false)
    private String nomeCurso;
    
    @NotBlank(message = "Mensagem é obrigatória")
    @Size(min = 10, max = 2000, message = "Mensagem deve ter entre 10 e 2000 caracteres")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensagem;
    
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;
    
    public Topico() {
        this.dataCriacao = LocalDateTime.now();
    }
    
    public Topico(String titulo, String nomeCurso, String mensagem, Usuario autor) {
        this();
        this.titulo = titulo;
        this.nomeCurso = nomeCurso;
        this.mensagem = mensagem;
        this.autor = autor;
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
    
    public Usuario getAutor() {
        return autor;
    }
    
    public void setAutor(Usuario autor) {
        this.autor = autor;
    }
} 