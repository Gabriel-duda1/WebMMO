package com.MMOCHARACTERS.service;

import com.MMOCHARACTERS.model.Curtida;
import com.MMOCHARACTERS.model.Personagem;
import com.MMOCHARACTERS.model.Post;
import com.MMOCHARACTERS.repository.CurtidaRepository;
import com.MMOCHARACTERS.repository.PersonagemRepository;
import com.MMOCHARACTERS.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurtidaService {

    @Autowired
    private CurtidaRepository curtidaRepository;

    @Autowired
    private PersonagemRepository personagemRepository;

    @Autowired
    private PostRepository postRepository;

    public Curtida curtirPost(Long personagemId, Long postId) {

        if (curtidaRepository.existsByPost_IdAndPersonagem_Id(postId, personagemId)) {
            throw new RuntimeException("Já curtiu esse post");
        }

        Personagem personagem = personagemRepository.findById(personagemId)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));

        Curtida curtida = new Curtida();
        curtida.setPersonagem(personagem);
        curtida.setPost(post);

        return curtidaRepository.save(curtida);
    }

    public void descurtirPost(Long personagemId, Long postId) {
        curtidaRepository.deleteByPost_IdAndPersonagem_Id(postId, personagemId);
    }

    public List<Curtida> listarPorPost(Long postId) {
        return curtidaRepository.findByPost_Id(postId);
    }
}