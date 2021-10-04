package br.com.zupacademy.natacha.casadocodigo.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteDto {

    @JsonProperty
    private Long id;

    public ClienteDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
