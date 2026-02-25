package com.MMOCHARACTERS.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "jogo")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 50)
    private String genero;

    @OneToMany(mappedBy = "jogo", cascade = CascadeType.ALL)
    private List<Personagem> personagens;

    public Jogo() {}

    public Jogo(String nome, String genero) {
        this.nome = nome;
        this.genero = genero;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public List<Personagem> getPersonagens() { return personagens; }
    public void setPersonagens(List<Personagem> personagens) { this.personagens = personagens; }
}