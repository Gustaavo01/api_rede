package com.gustvaogonzaga.api_2.services;

import com.gustvaogonzaga.api_2.entities.Postagem;
import com.gustvaogonzaga.api_2.repository.PostagemRepository;
import org.springframework.stereotype.Service;

@Service
public class PostagemService {
    private final PostagemRepository postagemRepository;

    public PostagemService(PostagemRepository postagemRepository) {
        this.postagemRepository = postagemRepository;
    }
    public Postagem criar(Postagem postagem){
      postagem.setImagem(postagem.getImagem());
      postagem.setLocal(postagem.getLocal());
      postagem.setMenção(postagem.getMenção());
      return postagemRepository.save(postagem);

    }
    public Postagem buscarPorId(Long id){
        Postagem postagemExistente = new Postagem();
        postagemExistente.setMenção(postagemExistente.getMenção());
        postagemExistente.setImagem(postagemExistente.getImagem());
        postagemExistente.setLocal(postagemExistente.getLocal());
        return postagemRepository.save(postagemExistente);
    }
    public Postagem atualizar(Postagem postagem){
        Postagem postagemExistente = new Postagem();
        postagemExistente.setLocal(postagem.getLocal());
        postagemExistente.setMenção(postagem.getMenção());
        postagemExistente.setImagem(postagem.getImagem());
        return postagemRepository.save(postagemExistente);
    }
    public void deletar(Long id){
        postagemRepository.deleteById(id);
    }
}
