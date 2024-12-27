package marceloviana1991.sergipe_vagas.repository;

import marceloviana1991.sergipe_vagas.model.Curso;
import marceloviana1991.sergipe_vagas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByUsuario(Usuario usuario);

    List<Curso> findAllByUsuario(Usuario usuario);
}
