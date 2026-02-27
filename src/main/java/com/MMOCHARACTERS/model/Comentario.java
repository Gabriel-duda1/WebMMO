package com.MMOCHARACTERS.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String conteudo;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "personagem_id", nullable = false)
    private Personagem personagem;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    public Comentario() {}

    public Comentario(String conteudo, LocalDateTime dataCriacao, Personagem personagem, Post post) {
        this.conteudo = conteudo;
        this.dataCriacao = dataCriacao;
        this.personagem = personagem;
        this.post = post;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getConteudo() { return conteudo; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }

    public Personagem getPersonagem() { return personagem; }
    public void setPersonagem(Personagem personagem) { this.personagem = personagem; }

    public Post getPost() { return post; }
    public void setPost(Post post) { this.post = post; }
}