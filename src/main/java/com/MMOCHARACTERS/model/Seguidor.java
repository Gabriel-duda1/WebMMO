package com.MMOCHARACTERS.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "seguidor",
    uniqueConstraints = @UniqueConstraint(
        columnNames = {"seguidor_id", "seguido_id"}
    )
)
public class Seguidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seguidor_id", nullable = false)
    private Personagem seguidor;

    @ManyToOne
    @JoinColumn(name = "seguido_id", nullable = false)
    private Personagem seguido;

    public Seguidor() {}

    public Seguidor(Personagem seguidor, Personagem seguido) {
        this.seguidor = seguidor;
        this.seguido = seguido;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Personagem getSeguidor() { return seguidor; }
    public void setSeguidor(Personagem seguidor) { this.seguidor = seguidor; }

    public Personagem getSeguido() { return seguido; }
    public void setSeguido(Personagem seguido) { this.seguido = seguido; }
}