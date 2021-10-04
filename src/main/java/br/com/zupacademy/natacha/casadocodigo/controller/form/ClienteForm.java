package br.com.zupacademy.natacha.casadocodigo.controller.form;

import br.com.zupacademy.natacha.casadocodigo.model.Cliente;
import br.com.zupacademy.natacha.casadocodigo.model.Estado;
import br.com.zupacademy.natacha.casadocodigo.model.Pais;
import br.com.zupacademy.natacha.casadocodigo.validate.generic.CpfCnpjValidator;
import br.com.zupacademy.natacha.casadocodigo.validate.generic.ExistsId;
import br.com.zupacademy.natacha.casadocodigo.validate.generic.ValorUnico;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public class ClienteForm {



    @NotBlank
    @Email
    @ValorUnico(domainClass = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;

    @ValorUnico(domainClass = Cliente.class, fieldName = "documento")
    @Length(min=11, message = "Deve ter no minimo 11 caracters")
    @Length(max=18, message = "Deve ter no maximo 18 caracters")
    @CpfCnpjValidator(domainClass = Cliente.class, fieldName = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;
    @ExistsId(domainClass = Estado.class, fieldName = "id")
    private Long idEstado;


    public ClienteForm(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, String telefone, String cep, Long idPais, Long idEstado) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.idPais = idPais;
        this.idEstado = idEstado;
    }


    public Cliente converterCliente(EntityManager manager) {
        Pais pais = manager.find(Pais.class, idPais);
        Estado estado = null;
       if (idEstado != null) {
            estado = manager.find(Estado.class, idEstado);
       }
        return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, telefone, cep, pais, estado);
    }





}
