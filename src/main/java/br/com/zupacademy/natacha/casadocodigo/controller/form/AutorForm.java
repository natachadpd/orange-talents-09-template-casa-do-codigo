package br.com.zupacademy.natacha.casadocodigo.controller.form;

import br.com.zupacademy.natacha.casadocodigo.model.Autor;
import br.com.zupacademy.natacha.casadocodigo.validate.generic.ValorUnico;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutorForm {

    @NotBlank
    private String nome;
    @ValorUnico(domainClass = Autor.class, fieldName = "email")
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Length(max = 400, message = "Ultrapassou o limite de 400 caracteres")
    private String descricao;

    public AutorForm(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    public Autor converterAutor() {
        return new Autor(nome, email, descricao);
    }


}
