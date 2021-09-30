package br.com.zupacademy.natacha.casadocodigo.controller.form;

import br.com.zupacademy.natacha.casadocodigo.model.Categoria;
import br.com.zupacademy.natacha.casadocodigo.validate.generic.ValorUnico;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;


public class CategoriaForm {

    private Long id;
    @NotBlank
    @JsonProperty
    @ValorUnico(domainClass = Categoria.class, fieldName = "nomeCategoria")
    private String nomeCategoria;


    public Long getId() {
        return id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public Categoria converterCategoria() {
        return new Categoria(nomeCategoria);
    }


}