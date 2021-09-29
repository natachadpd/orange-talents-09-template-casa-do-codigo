package br.com.zupacademy.natacha.casadocodigo.controller;

import br.com.zupacademy.natacha.casadocodigo.Repository.CategoriaRepository;
import br.com.zupacademy.natacha.casadocodigo.controller.form.CategoriaForm;
import br.com.zupacademy.natacha.casadocodigo.model.Categoria;
import br.com.zupacademy.natacha.casadocodigo.validate.NomeCategoriaDuplicadoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private NomeCategoriaDuplicadoValidator nomeCategoriaDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(nomeCategoriaDuplicadoValidator);
    }

    @PostMapping
    public void salvarCategoria(@RequestBody @Valid CategoriaForm categoriaForm) {
        Categoria categoria = categoriaForm.converterCategoria();
        categoriaRepository.save(categoria);
    }

}
