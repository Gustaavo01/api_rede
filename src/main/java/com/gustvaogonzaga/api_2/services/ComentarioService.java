package com.gustvaogonzaga.api_2.services;

import com.gustvaogonzaga.api_2.entities.Comentario;
import com.gustvaogonzaga.api_2.exceptions.ErroHandler;
import com.gustvaogonzaga.api_2.repository.ComentarioRepository;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {
    private final ComentarioRepository comentarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public Comentario criar(Comentario comentario){
        comentario.setFrase(comentario.getFrase());
        return comentarioRepository.save(comentario);
    }
    public Comentario atualizar(Comentario comentario){
        Comentario comentarioExistente = new Comentario();
        comentarioExistente.setFrase(comentario.getFrase());
        return comentarioRepository.save(comentarioExistente);
    }
    public Comentario buscarPorId(Long id){
        return comentarioRepository.findById(id).orElseThrow(() -> new ErroHandler("Erro Ao Buscar Id"));
    }

    public void deletar(Long id){
        comentarioRepository.deleteById(id);
    }
}
