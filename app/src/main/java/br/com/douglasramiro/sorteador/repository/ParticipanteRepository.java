package br.com.douglasramiro.sorteador.repository;

import br.com.douglasramiro.sorteador.domain.Participante;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ParticipanteRepository extends CrudRepository<Participante,Long> {

    Optional<Participante> findByCpf(String cpf);

    List<Participante> findAllByOrderByNome();
}
