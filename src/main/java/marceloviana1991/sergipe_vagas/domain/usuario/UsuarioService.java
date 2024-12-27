package marceloviana1991.sergipe_vagas.domain.usuario;

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
        Usuario usuario = new Usuario(usuarioRequestDto.email(), usuarioRequestDto.cpf());
        usuarioRepository.save(usuario);
        List<Curso> cursos = usuarioRequestDto.cursos()
                .stream()
                .map(cursoRequestDto -> new Curso(cursoRequestDto.nome(), cursoRequestDto.duracao(), usuario))
                .toList();
        cursos.forEach(curso -> cursoRepository.save(curso));
        List<CursoResponseDto> cursosResponseDto = cursos
                .stream()
                .map(curso -> new CursoResponseDto(curso.getId(), curso.getNome(), curso.getDuracao()))
                .toList();
        return new UsuarioResponseDto(usuario.getId(), usuario.getEmail(), usuario.getCpf(), cursosResponseDto);
    }

    public List<UsuarioResponseDto> get() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioResponseDto> usuariosResponseDto = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            List<CursoResponseDto> cursosResponseDto = getCursosByUsuario(usuario);
            usuariosResponseDto.add(new UsuarioResponseDto(
                    usuario.getId(), usuario.getEmail(), usuario.getCpf(), cursosResponseDto));
        }
        return usuariosResponseDto;
    }

    public UsuarioResponseDto postCurso(Long id, CursoRequestDto cursoRequestDto) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        Curso curso = new Curso(cursoRequestDto.nome(), cursoRequestDto.duracao(), usuario);
        cursoRepository.save(curso);
        List<CursoResponseDto> cursosResponseDto = getCursosByUsuario(usuario);
        return new UsuarioResponseDto(usuario.getId(), usuario.getEmail(), usuario.getCpf(), cursosResponseDto);
    }

    public UsuarioResponseDto getUsuario(Long id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        List<CursoResponseDto> cursosResponseDto = getCursosByUsuario(usuario);
        return new UsuarioResponseDto(usuario.getId(), usuario.getEmail(), usuario.getCpf(), cursosResponseDto);
    }

    private List<CursoResponseDto> getCursosByUsuario(Usuario usuario) {
        List<Curso> cursos = cursoRepository.findAllByUsuario(usuario);
        return cursos
                .stream()
                .map(c -> new CursoResponseDto(c.getId(), c.getNome(), c.getDuracao()))
                .toList();
    }
}
