package br.com.zupacademy.natacha.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nome;
    private String sobrenome;
    private String documento;
    private String endereco;
    private String complemento;
    private String cidade;
    private String telefone;
    private String cep;

    @NotNull
    @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;

    @Deprecated
    public Cliente(){

    }

    public Cliente(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, String telefone, String cep, Pais pais, Estado estado) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.pais = pais;
        this.estado = estado;
    }


    }

