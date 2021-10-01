package br.com.zupacademy.natacha.casadocodigo.controller.dto;

import br.com.zupacademy.natacha.casadocodigo.model.Autor;

public class AutorLivroDto {

    private String nome;
    private String descricao;

    public AutorLivroDto(Autor autor) {
        nome = autor.getNome();
        descricao = autor.getDescricao();
    }




    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}