package br.com.alura.ForumHub.repository;

import br.com.alura.ForumHub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    
    List<Topico> findByNomeCurso(String nomeCurso);
    
    @Query("SELECT t FROM Topico t WHERE t.titulo LIKE %:titulo% OR t.mensagem LIKE %:mensagem%")
    List<Topico> findByTituloOrMensagemContaining(@Param("titulo") String titulo, @Param("mensagem") String mensagem);
    
    List<Topico> findByAutorId(Long autorId);
} 