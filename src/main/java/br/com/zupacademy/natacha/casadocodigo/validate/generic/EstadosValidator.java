package br.com.zupacademy.natacha.casadocodigo.validate.generic;

import br.com.zupacademy.natacha.casadocodigo.Repository.EstadoRepository;
import br.com.zupacademy.natacha.casadocodigo.controller.form.EstadoForm;
import br.com.zupacademy.natacha.casadocodigo.model.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EstadosValidator implements Validator {

    @Autowired
    private EstadoRepository estadoRepository;


    @Override
    public boolean supports(Class<?> clazz) {
        return EstadoForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        EstadoForm estadoForm = (EstadoForm) target;
        Optional<Estado> valEstado = estadoRepository.findByNomeEstadoAndPaisId(estadoForm.getNomeEstado(), estadoForm.getIdPais());

        if(valEstado.isPresent())
            errors.rejectValue("nomeEstado", null, "No banco já existe este estado com este País");


    }
}
