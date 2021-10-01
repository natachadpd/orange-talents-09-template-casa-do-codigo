package br.com.zupacademy.natacha.casadocodigo.controller.form;

import br.com.zupacademy.natacha.casadocodigo.model.Pais;
import br.com.zupacademy.natacha.casadocodigo.validate.generic.ValorUnico;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class PaisForm {

    @NotBlank
    @JsonProperty
    @ValorUnico(domainClass = Pais.class, fieldName = "nomePais")
    private String nomePais;



    public Pais converterPais() {

        return new Pais(nomePais);
    }
}


