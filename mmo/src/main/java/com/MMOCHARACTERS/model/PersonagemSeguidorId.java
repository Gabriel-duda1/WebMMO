package com.MMOCHARACTERS.model;

import java.io.Serializable;
import java.util.Objects;

public class PersonagemSeguidorId implements Serializable {

    private Long personagem;
    private Long seguidor;

    public PersonagemSeguidorId() {}

    public PersonagemSeguidorId(Long personagem, Long seguidor) {
        this.personagem = personagem;
        this.seguidor = seguidor;
    }

    public Long getPersonagem() { return personagem; }
    public void setPersonagem(Long personagem) { this.personagem = personagem; }

    public Long getSeguidor() { return seguidor; }
    public void setSeguidor(Long seguidor) { this.seguidor = seguidor; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonagemSeguidorId)) return false;
        PersonagemSeguidorId that = (PersonagemSeguidorId) o;
        return Objects.equals(personagem, that.personagem) &&
               Objects.equals(seguidor, that.seguidor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personagem, seguidor);
    }
}