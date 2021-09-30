package br.com.zupacademy.natacha.casadocodigo.controller;

import br.com.zupacademy.natacha.casadocodigo.controller.form.LivroForm;
import br.com.zupacademy.natacha.casadocodigo.model.Livro;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public void criarLivro(@RequestBody @Valid LivroForm livroForm) {
        Livro livro = livroForm.converterLivro(manager);
        manager.persist(livro);
    }


}