package br.com.douglasramiro.sorteador.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "TB_Participante")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    @Length(min = 3, max = 100)
    @NotEmpty
    private String nome;

    @Column
    @NotEmpty
    @CPF
    private String cpf;
    
    @Column
    @NotEmpty
    @Email
    private String email;
}
