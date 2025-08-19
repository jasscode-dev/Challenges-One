package br.com.alura.challange.literatura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    private String idioma;
    private Integer downloads;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id")
    private Autor autor;
    
    public Livro() {}
    
    public Livro(String titulo, String idioma, Integer downloads, Autor autor) {
        this.titulo = titulo;
        this.idioma = idioma;
        this.downloads = downloads;
        this.autor = autor;
    }
    
    // Getters e Setters
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
    
    public String getIdioma() {
        return idioma;
    }
    
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    public Integer getDownloads() {
        return downloads;
    }
    
    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }
    
    public Autor getAutor() {
        return autor;
    }
    
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", idioma='" + idioma + '\'' +
                ", downloads=" + downloads +
                ", autor=" + (autor != null ? autor.getNome() : "N/A") +
                '}';
    }
}
