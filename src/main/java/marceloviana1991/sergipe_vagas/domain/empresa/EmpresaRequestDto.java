package marceloviana1991.sergipe_vagas.domain.empresa;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.List;

public record EmpresaRequestDto(
        @Email
        String email,
        @CNPJ
        String cnpj,
        List<VagaRequestDto> vagas
) {
}
