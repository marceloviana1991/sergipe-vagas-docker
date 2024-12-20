package marceloviana1991.sergipe_vagas.repository;

import marceloviana1991.sergipe_vagas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
