package marceloviana1991.sergipe_vagas.domain.usuario;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

public record UsuarioRequestDto(
        @Email
        String email,
        @CPF
        String cpf,
        List<CursoRequestDto> cursos
) {
}
