package br.com.zupacademy.natacha.casadocodigo.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String descricao;
    @NotNull
    private LocalDateTime cadastrado = LocalDateTime.now();

    @Deprecated
    public Autor(){
    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }


}