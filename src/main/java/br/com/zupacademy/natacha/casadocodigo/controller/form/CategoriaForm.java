package br.com.zupacademy.natacha.casadocodigo.controller.form;

import br.com.zupacademy.natacha.casadocodigo.model.Categoria;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;


public class CategoriaForm {

    @NotBlank
    @JsonProperty
    private String nomeCategoria;


    public String getNomeCategoria() {
        return nomeCategoria;
    }


    public Categoria converterCategoria() {
        return new Categoria(nomeCategoria);
    }



}

