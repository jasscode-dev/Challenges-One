package br.com.alura.challange.literatura.repository;

import br.com.alura.challange.literatura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    
    Optional<Autor> findByNomeContainingIgnoreCase(String nome);
    
    @Query("SELECT a FROM Autor a WHERE :ano BETWEEN a.anoNascimento AND a.anoFalecimento")
    List<Autor> findAutoresVivosNoAno(@Param("ano") Integer ano);
    
    @Query("SELECT a FROM Autor a WHERE :ano >= a.anoNascimento AND (a.anoFalecimento IS NULL OR :ano <= a.anoFalecimento)")
    List<Autor> findAutoresVivosNoAnoOuVivos(@Param("ano") Integer ano);
}
