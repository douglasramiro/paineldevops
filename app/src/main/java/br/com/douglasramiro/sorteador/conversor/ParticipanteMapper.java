package br.com.douglasramiro.sorteador.conversor;

import br.com.douglasramiro.sorteador.domain.Participante;
import br.com.douglasramiro.sorteador.dto.ParticipanteDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParticipanteMapper {

    Participante toEntity(ParticipanteDto dto);

    ParticipanteDto toDto(Participante participante);

    List<ParticipanteDto> toDtoList(List<Participante> participantes);
}
