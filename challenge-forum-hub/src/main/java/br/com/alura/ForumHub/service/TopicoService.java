package br.com.alura.ForumHub.service;

import br.com.alura.ForumHub.dto.TopicoRequest;
import br.com.alura.ForumHub.dto.TopicoResponse;
import br.com.alura.ForumHub.model.Topico;
import br.com.alura.ForumHub.model.Usuario;
import br.com.alura.ForumHub.repository.TopicoRepository;
import br.com.alura.ForumHub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {
    
    @Autowired
    private TopicoRepository topicoRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public TopicoResponse criarTopico(TopicoRequest request, UserDetails userDetails) {
        Usuario autor = usuarioRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
        Topico topico = new Topico();
        topico.setTitulo(request.getTitulo());
        topico.setNomeCurso(request.getNomeCurso());
        topico.setMensagem(request.getMensagem());
        topico.setAutor(autor);
        
        Topico topicoSalvo = topicoRepository.save(topico);
        return new TopicoResponse(topicoSalvo);
    }
    
    public List<TopicoResponse> listarTodos() {
        return topicoRepository.findAll().stream()
                .map(TopicoResponse::new)
                .collect(Collectors.toList());
    }
    
    public TopicoResponse buscarPorId(Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        return new TopicoResponse(topico);
    }
    
    public List<TopicoResponse> buscarPorCurso(String nomeCurso) {
        return topicoRepository.findByNomeCurso(nomeCurso).stream()
                .map(TopicoResponse::new)
                .collect(Collectors.toList());
    }
    
    public List<TopicoResponse> buscarPorAutor(UserDetails userDetails) {
        Usuario autor = usuarioRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
        return topicoRepository.findByAutorId(autor.getId()).stream()
                .map(TopicoResponse::new)
                .collect(Collectors.toList());
    }
    
    public TopicoResponse atualizarTopico(Long id, TopicoRequest request, UserDetails userDetails) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        
        Usuario autor = usuarioRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
        if (!topico.getAutor().getId().equals(autor.getId())) {
            throw new RuntimeException("Você não tem permissão para editar este tópico");
        }
        
        topico.setTitulo(request.getTitulo());
        topico.setNomeCurso(request.getNomeCurso());
        topico.setMensagem(request.getMensagem());
        
        Topico topicoAtualizado = topicoRepository.save(topico);
        return new TopicoResponse(topicoAtualizado);
    }
    
    public void deletarTopico(Long id, UserDetails userDetails) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        
        Usuario autor = usuarioRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
        if (!topico.getAutor().getId().equals(autor.getId())) {
            throw new RuntimeException("Você não tem permissão para deletar este tópico");
        }
        
        topicoRepository.delete(topico);
    }
} 