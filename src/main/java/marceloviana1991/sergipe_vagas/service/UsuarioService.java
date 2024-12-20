package marceloviana1991.sergipe_vagas.service;

import marceloviana1991.sergipe_vagas.dto.CursoRequestDto;
import marceloviana1991.sergipe_vagas.dto.CursoResponseDto;
import marceloviana1991.sergipe_vagas.dto.UsuarioRequestDto;
import marceloviana1991.sergipe_vagas.dto.UsuarioResponseDto;
import marceloviana1991.sergipe_vagas.model.Curso;
import marceloviana1991.sergipe_vagas.model.Usuario;
import marceloviana1991.sergipe_vagas.repository.CursoRepository;
import marceloviana1991.sergipe_vagas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public UsuarioResponseDto post(UsuarioRequestDto usuarioRequestDto) {
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioRequestDto.email());
        usuario.setCpf(usuarioRequestDto.cpf());
        usuarioRepository.save(usuario);
        List<Curso> cursos = new ArrayList<>();
        for(CursoRequestDto cursoRequestDto : usuarioRequestDto.cursos()) {
            Curso curso = new Curso();
            curso.setNome(cursoRequestDto.nome());
            curso.setDuracao(cursoRequestDto.duracao());
            curso.setUsuario(usuario);
            cursoRepository.save(curso);
            cursos.add(curso);
        }
        List<CursoResponseDto> cursoResponseDtos = cursos
                .stream()
                .map(curso -> new CursoResponseDto(curso.getId(), curso.getNome(), curso.getDuracao()))
                .toList();
        return new UsuarioResponseDto(usuario.getId(), usuario.getEmail(), usuario.getCpf(), cursoResponseDtos);
    }

    public List<UsuarioResponseDto> get() {
        List<Curso> cursos = cursoRepository.findAll();
        List<CursoResponseDto> cursoResponseDtos = cursos
                .stream()
                .map(curso -> new CursoResponseDto(curso.getId(), curso.getNome(), curso.getDuracao()))
                .toList();
        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> new UsuarioResponseDto(usuario.getId(), usuario.getEmail(), usuario.getCpf(), cursoResponseDtos))
                .toList();
    }

}
