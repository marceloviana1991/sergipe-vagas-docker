package marceloviana1991.sergipe_vagas.domain.empresa;

import jakarta.validation.constraints.NotBlank;

public record VagaRequestDto(
        @NotBlank
        String nome,
        @NotBlank
        String atribuicao
) {
}
