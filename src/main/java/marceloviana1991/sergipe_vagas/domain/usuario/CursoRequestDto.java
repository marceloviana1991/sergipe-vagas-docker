package marceloviana1991.sergipe_vagas.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record CursoRequestDto(
        @NotBlank
        String nome,
        @NotBlank
        Integer duracao
) {
}
