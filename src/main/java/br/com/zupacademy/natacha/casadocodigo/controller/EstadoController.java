package br.com.zupacademy.natacha.casadocodigo.controller;

import br.com.zupacademy.natacha.casadocodigo.controller.form.EstadoForm;
import br.com.zupacademy.natacha.casadocodigo.model.Estado;
import br.com.zupacademy.natacha.casadocodigo.validate.generic.EstadosValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @PersistenceContext
    private EntityManager manager;


    @Autowired
    private EstadosValidator estadosValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(estadosValidator);
    }

    @PostMapping
    @Transactional
    public void cadastrarEstado(@RequestBody @Valid EstadoForm estadoForm) {
        Estado estado = estadoForm.converterEstado(manager);
        manager.persist(estado);
    }


}
