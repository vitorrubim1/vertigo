package br.com.fiap.vertigo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do usuário não pode estar vazío.")
    private String nome;

    @NotBlank(message = "O nome do email não pode estar vazío.")
    @Email(message = "O email tem que ser válido.")
    private String email;

    @NotBlank(message = "A senha do usuário não pode estar vazía.")
    private String senha;

}
