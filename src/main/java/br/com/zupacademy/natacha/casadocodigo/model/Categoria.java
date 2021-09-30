package br.com.zupacademy.natacha.casadocodigo.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCategoria;



    @Deprecated
    public Categoria() {
    }



    public Categoria(Long id, String nomeCategoria) {
        this.id = id;
        this.nomeCategoria = nomeCategoria;

    }



    public Categoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;

    }




}