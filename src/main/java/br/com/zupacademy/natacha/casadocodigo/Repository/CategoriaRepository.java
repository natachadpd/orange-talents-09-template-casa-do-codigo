package br.com.zupacademy.natacha.casadocodigo.Repository;

import br.com.zupacademy.natacha.casadocodigo.model.Autor;
import br.com.zupacademy.natacha.casadocodigo.model.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    Optional<Categoria> findByNomeCategoria(String nomeCategoria);

}