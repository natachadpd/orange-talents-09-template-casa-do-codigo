package br.com.zupacademy.natacha.casadocodigo.controller;

import br.com.zupacademy.natacha.casadocodigo.controller.form.PaisForm;
import br.com.zupacademy.natacha.casadocodigo.model.Pais;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController{

        @PersistenceContext
        private EntityManager manager;

        @PostMapping
        @Transactional
        public void cadastrarPais(@RequestBody @Valid PaisForm paisForm) {
            Pais pais = paisForm.converterPais();
            manager.persist(pais);

        }

    }

