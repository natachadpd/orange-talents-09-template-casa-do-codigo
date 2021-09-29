package br.com.zupacademy.natacha.casadocodigo.validate;

import br.com.zupacademy.natacha.casadocodigo.Repository.CategoriaRepository;
import br.com.zupacademy.natacha.casadocodigo.controller.form.CategoriaForm;
import br.com.zupacademy.natacha.casadocodigo.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class NomeCategoriaDuplicadoValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaForm.class.isAssignableFrom(clazz);
    }


    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        CategoriaForm categoriaForm = (CategoriaForm) target;
        Optional<Categoria> valCategoria = categoriaRepository.findByNomeCategoria(categoriaForm.getNomeCategoria());

        if(valCategoria.isPresent()){
            errors.rejectValue("nomeCategoria", null, "Já existe uma categoria com este nome. "
                    + categoriaForm.getNomeCategoria());
        }

    }

}


