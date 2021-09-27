package br.com.zupacademy.natacha.casadocodigo.controller;

import br.com.zupacademy.natacha.casadocodigo.Repository.AutorRepository;
import br.com.zupacademy.natacha.casadocodigo.controller.dto.AutorForm;
import br.com.zupacademy.natacha.casadocodigo.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;


    @PostMapping
    public void salvarAutor(@RequestBody @Valid AutorForm autorForm) {
        Autor autor = autorForm.converterAutor();
        autorRepository.save(autor);
    }

}
