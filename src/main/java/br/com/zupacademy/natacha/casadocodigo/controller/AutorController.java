package br.com.zupacademy.natacha.casadocodigo.controller;

import br.com.zupacademy.natacha.casadocodigo.Repository.AutorRepository;
import br.com.zupacademy.natacha.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.natacha.casadocodigo.model.Autor;
import br.com.zupacademy.natacha.casadocodigo.validate.EmailDuplicadoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private EmailDuplicadoValidator emailDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(emailDuplicadoValidator);
    }

    @PostMapping
    public void salvarAutor(@RequestBody @Valid AutorForm autorForm) {
        Autor autor = autorForm.converterAutor();
        autorRepository.save(autor);
    }

}
