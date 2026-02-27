package com.MMOCHARACTERS.controller;

import com.MMOCHARACTERS.model.Usuario;
import com.MMOCHARACTERS.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }
}