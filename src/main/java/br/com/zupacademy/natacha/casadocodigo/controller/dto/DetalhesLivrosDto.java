package br.com.zupacademy.natacha.casadocodigo.controller.dto;

import br.com.zupacademy.natacha.casadocodigo.model.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetalhesLivrosDto {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal precoLivro;
    private Integer numeroPaginas;
    private Integer isbn;
    private LocalDate dataPublicacao;
    private AutorLivroDto autorLivroDto;

    public DetalhesLivrosDto(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.precoLivro = livro.getPrecoLivro();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.autorLivroDto = new AutorLivroDto(livro.getAutor());
    }



    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPrecoLivro() {
        return precoLivro;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public AutorLivroDto getAutorLivroDto() {
        return autorLivroDto;
    }

}