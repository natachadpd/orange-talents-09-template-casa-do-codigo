package br.com.zupacademy.natacha.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomePais;

    @Deprecated
    public Pais(){

    }

    public Pais(String nomePais) {;
        this.nomePais = nomePais;
    }

    public Long getId() {
        return id;
    }
}


