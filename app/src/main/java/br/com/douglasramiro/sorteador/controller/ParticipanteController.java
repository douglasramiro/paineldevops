package br.com.douglasramiro.sorteador.controller;

import br.com.douglasramiro.sorteador.util.PainelException;
import br.com.douglasramiro.sorteador.conversor.ParticipanteMapper;
import br.com.douglasramiro.sorteador.domain.Participante;
import br.com.douglasramiro.sorteador.dto.ParticipanteDto;
import br.com.douglasramiro.sorteador.service.ParticipanteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

@RestController
@Api("Api para operações na entidade de participante")
@RequestMapping(value = "/participante",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ParticipanteController{

    private final ParticipanteMapper mapper;
    private final ParticipanteService participanteService;

    @PostMapping
    @ApiOperation("Cadastra um novo participante")
    public ResponseEntity cadastrar(@Valid @RequestBody ParticipanteDto participanteDto) {
        try {
            Participante participante = mapper.toEntity(participanteDto);
            participanteService.cadastrar(participante);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (PainelException e) {
            return ResponseEntity.badRequest().body(e.getErro());
        }catch (ConstraintViolationException e){
            throw e;
        }catch (Exception e){
            System.out.println(e.getClass());
            e.printStackTrace();
            return ResponseEntity.badRequest().body(PainelException.Erro.ERRO_DESCONHECIDO);
        }
    }

    @GetMapping
    @ApiOperation("Lista os participantes cadastrados")
    public ResponseEntity listar() {
        try {
           return ResponseEntity.ok(mapper.toDtoList(participanteService.listar()));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(PainelException.Erro.ERRO_DESCONHECIDO);
        }
    }
}
