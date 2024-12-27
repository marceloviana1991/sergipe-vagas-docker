package marceloviana1991.sergipe_vagas.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuarios")
@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String cpf;

    public Usuario(String email, String cpf) {
        this.email = email;
        this.cpf = cpf;
    }
}

