package br.com.fiap.vertigo.model.dto;

public record Token(
        String token,
        String type,
        String prefix
) {}
