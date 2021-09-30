package br.com.zupacademy.natacha.casadocodigo.controller.dto;

import br.com.zupacademy.natacha.casadocodigo.model.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class ListaLivrosDto {

    private Long id;
    private String titulo;


    public ListaLivrosDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static  List<ListaLivrosDto> converterLista(List<Livro> livros){
        return livros.stream().map(ListaLivrosDto::new).collect(Collectors.toList());
    }
}
