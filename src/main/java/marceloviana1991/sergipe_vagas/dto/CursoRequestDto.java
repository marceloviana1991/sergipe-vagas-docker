package marceloviana1991.sergipe_vagas.dto;

import jakarta.validation.constraints.NotBlank;

public record CursoRequestDto(
        @NotBlank
        String nome,
        @NotBlank
        Integer duracao
) {
}
