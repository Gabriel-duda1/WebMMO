package com.MMOCHARACTERS.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {

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

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Curtida> curtidas;

    public Post() {}

    public Post(String conteudo, LocalDateTime dataCriacao, Personagem personagem) {
        this.conteudo = conteudo;
        this.dataCriacao = dataCriacao;
        this.personagem = personagem;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getConteudo() { return conteudo; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }

    public Personagem getPersonagem() { return personagem; }
    public void setPersonagem(Personagem personagem) { this.personagem = personagem; }

    public List<Comentario> getComentarios() { return comentarios; }
    public void setComentarios(List<Comentario> comentarios) { this.comentarios = comentarios; }

    public List<Curtida> getCurtidas() { return curtidas; }
    public void setCurtidas(List<Curtida> curtidas) { this.curtidas = curtidas; }
}