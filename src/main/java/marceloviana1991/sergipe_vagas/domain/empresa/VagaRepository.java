package marceloviana1991.sergipe_vagas.domain.empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
    @Query("SELECT v FROM Vaga v WHERE v.empresa = :empresa AND v.ativa = true")
    List<Vaga> capturaVagasAtivasDaEmpresa(Empresa empresa);
}
