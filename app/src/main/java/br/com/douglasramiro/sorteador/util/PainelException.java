package br.com.douglasramiro.sorteador.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class PainelException extends RuntimeException{

    private Erro erro;

    @AllArgsConstructor
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Erro {
        PARTICIPANTE_JA_CADASTRADO("0001","O cpf informado já foi cadastrado"),
        ERRO_DESCONHECIDO("0099", "Desculpe, um erro aconteceu");

        private String codigo;
        private String msg;

    }
}
