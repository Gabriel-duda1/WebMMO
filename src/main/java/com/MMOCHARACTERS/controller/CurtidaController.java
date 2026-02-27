package com.MMOCHARACTERS.controller;

import com.MMOCHARACTERS.model.Curtida;
import com.MMOCHARACTERS.service.CurtidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curtidas")
public class CurtidaController {

    @Autowired
    private CurtidaService curtidaService;

    @PostMapping
    public Curtida curtirPost(
            @RequestParam Long personagemId,
            @RequestParam Long postId) {

        return curtidaService.curtirPost(personagemId, postId);
    }

    @DeleteMapping
    public void descurtirPost(
            @RequestParam Long personagemId,
            @RequestParam Long postId) {

        curtidaService.descurtirPost(personagemId, postId);
    }

    @GetMapping("/post/{postId}")
    public List<Curtida> listarCurtidas(@PathVariable Long postId) {
        return curtidaService.listarPorPost(postId);
    }
}