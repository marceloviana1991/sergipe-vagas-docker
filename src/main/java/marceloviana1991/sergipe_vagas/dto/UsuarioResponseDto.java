package marceloviana1991.sergipe_vagas.dto;

import java.util.List;

public record UsuarioResponseDto(
        Long id,
        String email,
        String cpf,
        List<CursoResponseDto> cursos
) {
}
