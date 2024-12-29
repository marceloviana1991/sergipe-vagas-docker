package marceloviana1991.sergipe_vagas.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoRequestDto(
        @NotBlank
        String nome,
        @NotNull
        Integer duracao
) {
}
