package br.com.zupacademy.natacha.casadocodigo.validate;

import br.com.zupacademy.natacha.casadocodigo.Repository.AutorRepository;
import br.com.zupacademy.natacha.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.natacha.casadocodigo.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;


@Component
public class EmailDuplicadoValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorForm.class.isAssignableFrom(clazz);
    }


    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        AutorForm autorForm = (AutorForm) target;
        Optional<Autor> valAutor = autorRepository.findByEmail(autorForm.getEmail());

        if(valAutor.isPresent()){
            errors.rejectValue("email", null, "Já existe um autor com este e-mail "
                    + autorForm.getEmail());
        }

    }




}
