package br.com.zupacademy.natacha.casadocodigo.controller.form;

import br.com.zupacademy.natacha.casadocodigo.model.Autor;
import br.com.zupacademy.natacha.casadocodigo.model.Categoria;
import br.com.zupacademy.natacha.casadocodigo.model.Livro;
import br.com.zupacademy.natacha.casadocodigo.validate.generic.ValorUnico;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EntityManager;
import javax.persistence.Lob;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;


public class LivroForm {


    @NotBlank
    @ValorUnico(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @Length(max = 500)
    @NotBlank
    private String resumo;
    @Lob
    private String sumario;
    @Min(20)
    @NotNull
    private BigDecimal precoLivro;
    @Min(100)
    @NotNull
    private Integer numeroPaginas;
    @ValorUnico(domainClass = Livro.class, fieldName = "isbn")
    @NotNull
    @Lob
    private Integer isbn;
    @NotNull
    @Future
    private LocalDate dataPublicacao;
    private Long idCategoria;
    private Long idAutor;



    public LivroForm(String titulo, String resumo, String sumario, BigDecimal precoLivro, Integer numeroPaginas, Integer isbn, LocalDate dataPublicacao, Long idCategoria, Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.precoLivro = precoLivro;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;

    }

    
    public Livro converterLivro(EntityManager manager) {
        Autor autor = manager.find(Autor.class, idAutor);
        Categoria categoria = manager.find(Categoria.class, idCategoria);
        return new Livro(titulo, resumo, sumario, precoLivro, numeroPaginas, isbn, dataPublicacao, categoria, autor);
    }
}