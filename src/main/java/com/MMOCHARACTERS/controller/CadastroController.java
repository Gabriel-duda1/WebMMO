package com.MMOCHARACTERS.controller;

import com.MMOCHARACTERS.model.Usuario;
import com.MMOCHARACTERS.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CadastroController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Página de cadastro
    @GetMapping("/cadastro")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro"; // nome do HTML Thymeleaf
    }

    // Processa cadastro
    @PostMapping("/cadastro")
    public String cadastrarUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {
        // Verifica se já existe um usuário com o mesmo email
        if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
            model.addAttribute("erro", "Email já cadastrado!");
            return "cadastro";
        }

        // Criptografa a senha antes de salvar
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

        // Salva o usuário
        usuarioRepository.save(usuario);

        // Redireciona para login após cadastro
        return "redirect:/login?cadastroSucesso";
    }
}