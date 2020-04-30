package br.com.douglasramiro.sorteador.controller;

import br.com.douglasramiro.sorteador.conversor.ParticipanteMapper;
import br.com.douglasramiro.sorteador.service.SorteioService;
import br.com.douglasramiro.sorteador.util.PainelException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("Api para realizar o sorteio entre os participantes")
@RequestMapping(value = "/sortear",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class SorteioController {

    private final ParticipanteMapper mapper;
    private final SorteioService sorteioService;

    @GetMapping
    @ApiOperation("Retorna um participante sorteado")
    public ResponseEntity listar() {
        try {
            return ResponseEntity.ok(mapper.toDto(sorteioService.sortear()));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(PainelException.Erro.ERRO_DESCONHECIDO);
        }
    }
}
