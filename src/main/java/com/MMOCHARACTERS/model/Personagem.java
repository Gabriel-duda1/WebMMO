package com.MMOCHARACTERS.model;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "personagem")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 50)
    private String classe;

    @Column
    private Integer nivel = 1;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "jogo_id", nullable = false)
    private Jogo jogo;

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL)
    private List<Curtida> curtidas;

    @OneToMany(mappedBy = "seguidor", cascade = CascadeType.ALL)
    private List<Seguidor> seguindo;

    @OneToMany(mappedBy = "seguido", cascade = CascadeType.ALL)
    private List<Seguidor> seguidores;

    public Personagem() {}

    public Personagem(String nome, String classe, Integer nivel, Usuario usuario, Jogo jogo) {
        this.nome = nome;
        this.classe = classe;
        this.nivel = nivel;
        this.usuario = usuario;
        this.jogo = jogo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getClasse() { return classe; }
    public void setClasse(String classe) { this.classe = classe; }

    public Integer getNivel() { return nivel; }
    public void setNivel(Integer nivel) { this.nivel = nivel; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Jogo getJogo() { return jogo; }
    public void setJogo(Jogo jogo) { this.jogo = jogo; }

    public List<Post> getPosts() { return posts; }
    public void setPosts(List<Post> posts) { this.posts = posts; }

    public List<Comentario> getComentarios() { return comentarios; }
    public void setComentarios(List<Comentario> comentarios) { this.comentarios = comentarios; }

    public List<Curtida> getCurtidas() { return curtidas; }
    public void setCurtidas(List<Curtida> curtidas) { this.curtidas = curtidas; }

    public List<Seguidor> getSeguindo() { return seguindo; }
    public void setSeguindo(List<Seguidor> seguindo) { this.seguindo = seguindo; }

    public List<Seguidor> getSeguidores() { return seguidores; }
    public void setSeguidores(List<Seguidor> seguidores) { this.seguidores = seguidores; }
}