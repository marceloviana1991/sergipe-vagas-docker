package marceloviana1991.sergipe_vagas.domain.usuario;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuarios")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    private Long id;
    private String email;
    private String cpf;
}

