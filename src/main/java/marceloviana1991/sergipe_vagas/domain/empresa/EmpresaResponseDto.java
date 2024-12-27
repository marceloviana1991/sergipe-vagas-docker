package marceloviana1991.sergipe_vagas.domain.empresa;

import java.util.List;

public record EmpresaResponseDto(

        Long id,
        String email,
        String cnpj,
        List<VagaResponseDto> vagas
) {
}
