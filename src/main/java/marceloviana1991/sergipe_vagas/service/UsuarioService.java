package marceloviana1991.sergipe_vagas.service;

import marceloviana1991.sergipe_vagas.dto.UsuarioRequestDto;
import marceloviana1991.sergipe_vagas.dto.UsuarioResponseDto;
import marceloviana1991.sergipe_vagas.model.Usuario;
import marceloviana1991.sergipe_vagas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResponseDto post(UsuarioRequestDto usuarioRequestDto) {
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioRequestDto.email());
        usuario.setCpf(usuarioRequestDto.cpf());
        usuarioRepository.save(usuario);
        return new UsuarioResponseDto(usuario.getId(), usuario.getEmail(), usuario.getCpf());
    }

    public List<UsuarioResponseDto> get() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> new UsuarioResponseDto(usuario.getId(), usuario.getEmail(), usuario.getCpf()))
                .toList();
    }

}
