package marceloviana1991.sergipe_vagas.domain.usuario;

import marceloviana1991.sergipe_vagas.domain.login.Login;
import marceloviana1991.sergipe_vagas.domain.login.LoginRepository;
import marceloviana1991.sergipe_vagas.domain.login.LoginService;
import marceloviana1991.sergipe_vagas.domain.login.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private LoginRepository loginRepository;

    public UsuarioResponseDto post(UsuarioRequestDto usuarioRequestDto) {
        Optional<Login> optionalLogin = loginRepository.findByEmailIgnoreCase(usuarioRequestDto.email());
        if (optionalLogin.isPresent()) {
            throw new RuntimeException("Já existe uma conta cadastrada com esse email!");
        }
        Login login = new Login(usuarioRequestDto.email(), usuarioRequestDto.senha(), Perfil.USUARIO);
        System.out.println(LocalDateTime.now() + " " + login.getToken() + " " + login.getEmail());
        loginRepository.save(login);
        Usuario usuario = new Usuario(login.getId(),usuarioRequestDto.email(), usuarioRequestDto.cpf());
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
