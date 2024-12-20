package marceloviana1991.sergipe_vagas.dto;

import java.util.List;

public record UsuarioRequestDto(
        String email,
        String cpf,
        List<CursoRequestDto> cursos
) {
}
