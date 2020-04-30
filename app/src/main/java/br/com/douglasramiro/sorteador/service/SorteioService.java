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
        return sortearDoBanco();
    }

    public Participante sortearDoBanco(){
        List<Participante> participantes = participanteRepository.findAllByOrderByNome();
        Random randomNumberGenerator = new Random();
        return participantes.get(randomNumberGenerator.nextInt(participantes.size()));
    }

    public Participante retornarFixo(){
        return Participante.builder()
                .nome("Douglas Ramiro")
                .cpf("xxx.xxx.131-40")
                .email("contato@douglasramiro.com.br")
                .build();
    }
}
