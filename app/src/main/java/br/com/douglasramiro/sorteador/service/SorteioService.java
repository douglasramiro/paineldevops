package br.com.douglasramiro.sorteador.service;

import br.com.douglasramiro.sorteador.domain.Participante;
import br.com.douglasramiro.sorteador.repository.ParticipanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class SorteioService {

    private final ParticipanteRepository participanteRepository;

    public Participante sortear(){
        List<Participante> participantes = participanteRepository.findAllByOrderByNome();
        Random randomNumberGenerator = new Random();
        return participantes.get(randomNumberGenerator.nextInt(participantes.size()));
    }
}
