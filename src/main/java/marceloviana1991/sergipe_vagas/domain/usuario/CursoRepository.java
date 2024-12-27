package marceloviana1991.sergipe_vagas.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findAllByUsuario(Usuario usuario);
}
