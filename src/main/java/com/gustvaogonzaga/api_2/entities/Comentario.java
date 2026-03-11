package com.gustvaogonzaga.api_2.entities;

import jakarta.persistence.*;

@Entity
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String frase;
    @ManyToOne
    @JoinColumn(name = "postagem_id")
    private Postagem postagem;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Comentario(Long id, String frase, Postagem postagem, Usuario usuario) {
        this.id = id;
        this.frase = frase;
        this.postagem = postagem;
        this.usuario = usuario;
    }
    public Comentario(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
