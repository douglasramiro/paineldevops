package br.com.douglasramiro.sorteador.service;

import br.com.douglasramiro.sorteador.domain.Participante;
import br.com.douglasramiro.sorteador.repository.ParticipanteRepository;
import br.com.douglasramiro.sorteador.util.PainelException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class ParticipanteService {

    private final ParticipanteRepository participanteRepository;

    public Participante cadastrar(Participante participante){

        participante.setCpf(participante.getCpf().replace(".","").replace("-",""));

        participanteRepository
                .findByCpf(participante.getCpf())
                .ifPresent(s -> {
                    throw new PainelException(PainelException.Erro.PARTICIPANTE_JA_CADASTRADO);
                });


        return participanteRepository.save(participante);
    }

    public List<Participante> listar() {
        List<Participante> participantes = participanteRepository.findAllByOrderByNome();
        participantes.forEach(p -> {
            p.setCpf("xxx.xxx."+p.getCpf().substring(6,9)+"-"+p.getCpf().substring(9,11));
            p.setEmail("xxx"+p.getEmail().substring(3));
        });
        return participantes;
    }
}
