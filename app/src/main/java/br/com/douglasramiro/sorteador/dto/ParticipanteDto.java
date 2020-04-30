package br.com.douglasramiro.sorteador.dto;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;

@Data
public class ParticipanteDto {

    @CPF(message = "CPF Inválido")
    @NotEmpty(message = "CPF de preenchimento obrigatório")
    private String cpf;

    @NotEmpty(message = "Nome de preenchimento obrigatório")
    private String nome;
}
