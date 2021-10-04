package br.com.zupacademy.natacha.casadocodigo.controller;

import br.com.zupacademy.natacha.casadocodigo.controller.dto.ClienteDto;
import br.com.zupacademy.natacha.casadocodigo.controller.form.ClienteForm;
import br.com.zupacademy.natacha.casadocodigo.model.Cliente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @PersistenceContext
    private EntityManager manager;



    @PostMapping
    @Transactional
    public ClienteDto cadastrarCliente(@RequestBody @Valid ClienteForm clienteForm){
        Cliente cliente = clienteForm.converterCliente(manager);
        manager.persist(cliente);
        return new ClienteDto(cliente.getId());
    }

}
