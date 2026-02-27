package com.MMOCHARACTERS.model;

import jakarta.persistence.*;

@Entity
@Table(name = "curtida")
public class Curtida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "personagem_id", nullable = false)
    private Personagem personagem;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    public Curtida() {}

    public Curtida(Personagem personagem, Post post) {
        this.personagem = personagem;
        this.post = post;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Personagem getPersonagem() { return personagem; }
    public void setPersonagem(Personagem personagem) { this.personagem = personagem; }

    public Post getPost() { return post; }
    public void setPost(Post post) { this.post = post; }
}