package br.projeto.webform.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "Person")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer id;

    @Column(name = "name")
    @NotBlank(message = "O campo nome é obrigatórios")
    private String nome;

    @Column(name = "data_nascimento")
    @NotNull(message = "O campo Data é obrigatórios")
    private Date dataNascimento;

    @Column(name = "CPF")
    @NotBlank(message = "O campo CPF é obrigatórios")
    private String cpf;

    @Column(name = "sex")
    @NotNull(message = "O campo sexo é obrigatórios")
    private String sexo;

    @Column(name = "peso")
    @NotNull(message = "O campo peso é obrigatórios")
    private Float peso;

    @Column(name = "altura")
    @NotNull(message = "O campo altura é obrigatórios")
    private Float altura;
}
