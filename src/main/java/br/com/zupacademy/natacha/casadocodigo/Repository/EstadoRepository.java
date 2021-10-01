package br.com.zupacademy.natacha.casadocodigo.Repository;

import br.com.zupacademy.natacha.casadocodigo.model.Estado;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EstadoRepository extends CrudRepository<Estado, Long> {

    Optional<Estado> findByNomeEstado(String nomeEstado);
    Optional<Estado> findByNomeEstadoAndPaisId(String nomeEstado, Long idPais);
}
