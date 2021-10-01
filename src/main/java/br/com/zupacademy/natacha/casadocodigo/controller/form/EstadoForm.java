package br.com.zupacademy.natacha.casadocodigo.controller.form;

import br.com.zupacademy.natacha.casadocodigo.model.Estado;
import br.com.zupacademy.natacha.casadocodigo.model.Pais;
import br.com.zupacademy.natacha.casadocodigo.validate.generic.ValorUnico;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

public class EstadoForm {

    @NotBlank
    private String nomeEstado;
    private Long idPais;

    public EstadoForm(String nomeEstado, Long idPais) {
        this.nomeEstado = nomeEstado;
        this.idPais = idPais;
    }

    public Estado converterEstado(EntityManager manager) {
        Pais pais = manager.find(Pais.class, idPais);
        return new Estado(nomeEstado, pais);
    }

    public Long getIdPais() {
        return idPais;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }
}
