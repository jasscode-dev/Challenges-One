package br.com.alura.ForumHub.controller;

import br.com.alura.ForumHub.dto.TopicoRequest;
import br.com.alura.ForumHub.dto.TopicoResponse;
import br.com.alura.ForumHub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topicos")
@CrossOrigin(origins = "*")
public class TopicoController {
    
    @Autowired
    private TopicoService topicoService;
    
    @PostMapping
    public ResponseEntity<TopicoResponse> criarTopico(
            @Valid @RequestBody TopicoRequest request,
            @AuthenticationPrincipal UserDetails userDetails) {
        try {
            TopicoResponse response = topicoService.criarTopico(request, userDetails);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<TopicoResponse>> listarTodos() {
        try {
            List<TopicoResponse> topicos = topicoService.listarTodos();
            return ResponseEntity.ok(topicos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TopicoResponse> buscarPorId(@PathVariable Long id) {
        try {
            TopicoResponse topico = topicoService.buscarPorId(id);
            return ResponseEntity.ok(topico);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/curso/{nomeCurso}")
    public ResponseEntity<List<TopicoResponse>> buscarPorCurso(@PathVariable String nomeCurso) {
        try {
            List<TopicoResponse> topicos = topicoService.buscarPorCurso(nomeCurso);
            return ResponseEntity.ok(topicos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/meus-topicos")
    public ResponseEntity<List<TopicoResponse>> buscarMeusTopicos(@AuthenticationPrincipal UserDetails userDetails) {
        try {
            List<TopicoResponse> topicos = topicoService.buscarPorAutor(userDetails);
            return ResponseEntity.ok(topicos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TopicoResponse> atualizarTopico(
            @PathVariable Long id,
            @Valid @RequestBody TopicoRequest request,
            @AuthenticationPrincipal UserDetails userDetails) {
        try {
            TopicoResponse response = topicoService.atualizarTopico(id, request, userDetails);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTopico(
            @PathVariable Long id,
            @AuthenticationPrincipal UserDetails userDetails) {
        try {
            topicoService.deletarTopico(id, userDetails);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
} 