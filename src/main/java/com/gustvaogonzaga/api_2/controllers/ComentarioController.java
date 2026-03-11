package com.gustvaogonzaga.api_2.controllers;

import com.gustvaogonzaga.api_2.entities.Comentario;
import com.gustvaogonzaga.api_2.entities.Postagem;
import com.gustvaogonzaga.api_2.entities.Usuario;
import com.gustvaogonzaga.api_2.exceptions.ErroHandler;
import com.gustvaogonzaga.api_2.repository.ComentarioRepository;
import com.gustvaogonzaga.api_2.repository.PostagemRepository;
import com.gustvaogonzaga.api_2.repository.UsuarioRepository;
import com.gustvaogonzaga.api_2.services.ComentarioService;
import com.gustvaogonzaga.api_2.services.PostagemService;
import com.gustvaogonzaga.api_2.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
    private final UsuarioRepository usuarioRepository;
    private final PostagemRepository postagemRepository;
    private final UsuarioService usuarioService;
    private final PostagemService postagemService;
    private ComentarioRepository comentarioRepository;
    private ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService, ComentarioRepository comentarioRepository, PostagemService postagemService, UsuarioService usuarioService, PostagemRepository postagemRepository, UsuarioRepository usuarioRepository) {
        this.comentarioService = comentarioService;
        this.comentarioRepository = comentarioRepository;
        this.postagemService = postagemService;
        this.usuarioService = usuarioService;
        this.postagemRepository = postagemRepository;
        this.usuarioRepository = usuarioRepository;
    }
    @PostMapping("/usuarios/{usuarioId}/postagem/{postagemId}/comentarios")
    public Comentario criar(@PathVariable Long usuarioId, @PathVariable Long postagemId, @RequestBody Comentario comentario){
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new ErroHandler("Usuario Não Encontrado"));
        Postagem postagem = postagemRepository.findById(postagemId).orElseThrow(() -> new ErroHandler("Postagem Não Encontrado"));
        comentario.setFrase(comentario.getFrase());
        comentario.setPostagem(postagem);
        comentario.setUsuario(usuario);
        return comentarioRepository.save(comentario);
    }

    @GetMapping("/usuarios/{id}/postagem/comentario")
    public Optional<Comentario> buscarPostagemPorComentario(@PathVariable Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ErroHandler("Usuario Não Encontrado"));
        return comentarioRepository.findById(id);
    }
    @GetMapping("/postagem/{postagemId}/comentarios")
    public List<Comentario> buscarComentario(@PathVariable Long postagemId){
        Postagem postagem = postagemRepository.findById(postagemId).orElseThrow(() -> new ErroHandler("Postagem não Encontrada"));
        return comentarioRepository.findByPostagem(postagem);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
      Comentario comentario = comentarioRepository.findById(id).orElseThrow(() -> new ErroHandler("Comentario Não Encontrado"));
      comentarioRepository.deleteById(id);
    }
}
