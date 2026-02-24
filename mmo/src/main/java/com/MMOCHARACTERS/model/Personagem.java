package com.MMOCHARACTERS.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String imagem;

    @ManyToOne
    @JoinColumn(name = "gamer_id")
    private Gamer gamer;

    @ManyToOne
    @JoinColumn(name = "jogo_id")
    private Jogo jogo;

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL)
    private List<Curtida> curtidas;

    @OneToMany(mappedBy = "seguidor", cascade = CascadeType.ALL)
    private List<PersonagemSeguidor> seguindo;

    @OneToMany(mappedBy = "seguido", cascade = CascadeType.ALL)
    private List<PersonagemSeguidor> seguidores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Gamer getGamer() {
        return gamer;
    }

    public void setGamer(Gamer gamer) {
        this.gamer = gamer;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Curtida> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<Curtida> curtidas) {
        this.curtidas = curtidas;
    }

    public List<PersonagemSeguidor> getSeguindo() {
        return seguindo;
    }

    public void setSeguindo(List<PersonagemSeguidor> seguindo) {
        this.seguindo = seguindo;
    }

    public List<PersonagemSeguidor> getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(List<PersonagemSeguidor> seguidores) {
        this.seguidores = seguidores;
    }
}