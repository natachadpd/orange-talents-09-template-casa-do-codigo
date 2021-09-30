package br.com.zupacademy.natacha.casadocodigo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal precoLivro;
    private Integer numeroPaginas;
    private Integer isbn;
    private LocalDate dataPublicacao;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;



    @Deprecated
    public Livro() {

    }

    public Livro(String titulo, String resumo, String sumario, BigDecimal precoLivro, Integer numeroPaginas, Integer isbn, LocalDate dataPublicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.precoLivro = precoLivro;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;

    }
}