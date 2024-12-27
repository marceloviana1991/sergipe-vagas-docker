package marceloviana1991.sergipe_vagas.domain.empresa;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "vagas")
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String atribuicao;
    private boolean ativa;
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    public Vaga(String nome, String atribuicao, Empresa empresa) {
        this.nome = nome;
        this.atribuicao = atribuicao;
        this.empresa = empresa;
        this.ativa = true;
    }
}
