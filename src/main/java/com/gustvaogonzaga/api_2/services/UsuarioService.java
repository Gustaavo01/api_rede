package com.gustvaogonzaga.api_2.services;

import com.gustvaogonzaga.api_2.entities.Usuario;
import com.gustvaogonzaga.api_2.exceptions.ErroHandler;
import com.gustvaogonzaga.api_2.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criar(Usuario usuario){
        usuario.setNome(usuario.getNome());
        usuario.setEmail(usuario.getEmail());
        usuario.setApelido(usuario.getApelido());
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(Long id){
        return usuarioRepository.findById(id).orElseThrow();
    }

    public void delete(Long id){
        usuarioRepository.deleteById(id);
    }
    public Usuario atualizar(Long id, Usuario usuario){
        Usuario usarioExistente = usuarioRepository.findById(id).orElseThrow(() -> new ErroHandler("Usuario Não Encontrado"));
        usarioExistente.setNome(usuario.getNome());
        usarioExistente.setEmail(usuario.getEmail());
        usarioExistente.setApelido(usuario.getApelido());
        return usuarioRepository.save(usarioExistente);

    }
}
