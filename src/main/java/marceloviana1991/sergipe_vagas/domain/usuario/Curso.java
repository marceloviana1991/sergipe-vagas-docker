package marceloviana1991.sergipe_vagas.domain.usuario;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "cursos")
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer duracao;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Curso(String nome, Integer duracao, Usuario usuario) {
        this.nome = nome;
        this.duracao = duracao;
        this.usuario = usuario;
    }
}
