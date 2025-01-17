package br.com.zupacademy.natacha.casadocodigo.controller;

import br.com.zupacademy.natacha.casadocodigo.controller.dto.DetalhesLivrosDto;
import br.com.zupacademy.natacha.casadocodigo.controller.dto.ListaLivrosDto;
import br.com.zupacademy.natacha.casadocodigo.controller.form.LivroForm;
import br.com.zupacademy.natacha.casadocodigo.model.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

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


    @GetMapping(value = "/search")
    @Transactional
    public List<ListaLivrosDto> findAll(){
        List<Livro> livro = manager.createQuery("SELECT a FROM Livro a", Livro.class).getResultList();
        return ListaLivrosDto.converterLista(livro);
    }


    @GetMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<DetalhesLivrosDto> findById(@PathVariable long id){
        Livro livro = manager.find(Livro.class, id);

        try {
            return ResponseEntity.ok().body(new DetalhesLivrosDto(livro));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}