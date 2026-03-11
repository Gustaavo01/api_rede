package com.gustvaogonzaga.api_2.controllers;

import com.gustvaogonzaga.api_2.entities.Usuario;
import com.gustvaogonzaga.api_2.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario){
        return usuarioService.criar(usuario);
    }
    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id){
        return usuarioService.buscarPorId(id);
    }
    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioService.atualizar(id,usuario);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        usuarioService.delete(id);
    }
}
