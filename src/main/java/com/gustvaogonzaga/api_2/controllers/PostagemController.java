package com.gustvaogonzaga.api_2.controllers;

import com.gustvaogonzaga.api_2.entities.Postagem;
import com.gustvaogonzaga.api_2.entities.Usuario;
import com.gustvaogonzaga.api_2.exceptions.ErroHandler;
import com.gustvaogonzaga.api_2.repository.PostagemRepository;
import com.gustvaogonzaga.api_2.repository.UsuarioRepository;
import com.gustvaogonzaga.api_2.services.PostagemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagem")
public class PostagemController {
   private final PostagemService postagemService;
   private final UsuarioRepository usuarioRepository;
   private final PostagemRepository postagemRepository;

    public PostagemController(PostagemService postagemService, UsuarioRepository usuarioRepository,  PostagemRepository postagemRepository) {
        this.postagemService = postagemService;
        this.usuarioRepository = usuarioRepository;
        this.postagemRepository = postagemRepository;
    }

    @PostMapping("/{usuarioId}/postagem")
    public Postagem criar( @PathVariable Long usuarioId ,@RequestBody Postagem postagem){
       Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new ErroHandler("Usuario Não Encontrado"));
       postagem.setUsuario(usuario);
       return postagemRepository.save(postagem);
    }
    @GetMapping("/usuarios/{id}/postagem")
    public List<Postagem> buscarPostagemPorUsuario(@PathVariable Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ErroHandler("Usuario Não Encontrado"));
        return postagemRepository.findByUsuario(usuario);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        Postagem postagem = postagemRepository.findById(id).orElseThrow(() -> new ErroHandler("Postagem Não Encontrada"));
        postagemRepository.deleteById(id);
    }
}
