package com.MMOCHARACTERS.model;

import jakarta.persistence.*;

@Entity
public class PersonagemSeguidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seguidor_id")
    private Personagem seguidor;

    @ManyToOne
    @JoinColumn(name = "seguido_id")
    private Personagem seguido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Personagem getSeguidor() {
        return seguidor;
    }

    public void setSeguidor(Personagem seguidor) {
        this.seguidor = seguidor;
    }

    public Personagem getSeguido() {
        return seguido;
    }

    public void setSeguido(Personagem seguido) {
        this.seguido = seguido;
    }
}