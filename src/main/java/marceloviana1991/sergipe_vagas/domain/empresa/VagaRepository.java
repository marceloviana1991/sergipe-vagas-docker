package marceloviana1991.sergipe_vagas.domain.empresa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
    List<Vaga> findAllByEmpresa(Empresa empresa);
}
