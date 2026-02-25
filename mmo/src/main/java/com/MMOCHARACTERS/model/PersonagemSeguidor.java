package com.MMOCHARACTERS.model;

import jakarta.persistence.*;

@Entity
@Table(name = "personagem_seguidor")
@IdClass(PersonagemSeguidorId.class)
public class PersonagemSeguidor {

    @Id
    @ManyToOne
    @JoinColumn(name = "personagem_id", nullable = false)
    private Personagem personagem;

    @Id
    @ManyToOne
    @JoinColumn(name = "seguidor_id", nullable = false)
    private Personagem seguidor;

    public PersonagemSeguidor() {}

    public PersonagemSeguidor(Personagem personagem, Personagem seguidor) {
        this.personagem = personagem;
        this.seguidor = seguidor;
    }

    public Personagem getPersonagem() { return personagem; }
    public void setPersonagem(Personagem personagem) { this.personagem = personagem; }

    public Personagem getSeguidor() { return seguidor; }
    public void setSeguidor(Personagem seguidor) { this.seguidor = seguidor; }
}