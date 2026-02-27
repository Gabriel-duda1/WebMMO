package com.MMOCHARACTERS.service;

import com.MMOCHARACTERS.model.Comentario;
import com.MMOCHARACTERS.model.Personagem;
import com.MMOCHARACTERS.model.Post;
import com.MMOCHARACTERS.repository.ComentarioRepository;
import com.MMOCHARACTERS.repository.PersonagemRepository;
import com.MMOCHARACTERS.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private PersonagemRepository personagemRepository;

    @Autowired
    private PostRepository postRepository;

    public Comentario criarComentario(Long personagemId, Long postId, String conteudo) {

        Personagem personagem = personagemRepository.findById(personagemId)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));

        Comentario comentario = new Comentario();
        comentario.setConteudo(conteudo);
        comentario.setDataCriacao(LocalDateTime.now());
        comentario.setPersonagem(personagem);
        comentario.setPost(post);

        return comentarioRepository.save(comentario);
    }

    public List<Comentario> listarPorPost(Long postId) {
        return comentarioRepository.findByPost_Id(postId);
    }

    public void deletarComentario(Long id) {
        comentarioRepository.deleteById(id);
    }
}