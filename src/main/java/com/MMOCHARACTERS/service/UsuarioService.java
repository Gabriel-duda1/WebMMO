package com.MMOCHARACTERS.service;

import com.MMOCHARACTERS.model.Usuario;
import com.MMOCHARACTERS.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrar(Usuario usuario) {

        if (usuarioRepository.existsByUsername(usuario.getUsername())) {
            throw new RuntimeException("Username já cadastrado.");
        }

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("Email já cadastrado.");
        }

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}