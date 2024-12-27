package marceloviana1991.sergipe_vagas.domain.empresa;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "empresas")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Empresa {
    @Id
    private Long id;
    private String email;
    private String cnpj;
}
