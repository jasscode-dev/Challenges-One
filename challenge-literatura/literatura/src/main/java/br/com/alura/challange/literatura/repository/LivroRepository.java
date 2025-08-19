package br.com.alura.challange.literatura.repository;

import br.com.alura.challange.literatura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    
    Optional<Livro> findByTituloContainingIgnoreCase(String titulo);
    
    List<Livro> findByIdiomaIgnoreCase(String idioma);
    
    @Query("SELECT l FROM Livro l ORDER BY l.downloads DESC")
    List<Livro> findTop10ByDownloads();
    
    boolean existsByTituloContainingIgnoreCase(String titulo);
}
