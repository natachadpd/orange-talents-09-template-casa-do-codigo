package br.com.zupacademy.natacha.casadocodigo.Repository;

import br.com.zupacademy.natacha.casadocodigo.model.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {
    Optional<Autor> findByEmail(String Email);

}
