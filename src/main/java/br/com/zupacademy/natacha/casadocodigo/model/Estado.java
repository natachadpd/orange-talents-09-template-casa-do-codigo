package br.com.zupacademy.natacha.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeEstado;
    @NotNull
    @ManyToOne
    private Pais pais;

    @Deprecated
    public Estado() {
    }

    public Estado(String nomeEstado, Pais pais) {
        this.nomeEstado = nomeEstado;
        this.pais = pais;
    }


}
