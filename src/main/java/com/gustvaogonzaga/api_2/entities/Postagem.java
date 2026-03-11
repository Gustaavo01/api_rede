package com.gustvaogonzaga.api_2.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imagem;
    private String local;
    private String menção;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @OneToMany(mappedBy = "postagem")
    private List<Comentario> comentarios;

    public Postagem(){

    }

    public Postagem(Long id, String imagem, String local, String menção) {
        this.id = id;
        this.imagem = imagem;
        this.local = local;
        this.menção = menção;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMenção() {
        return menção;
    }

    public void setMenção(String menção) {
        this.menção = menção;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
