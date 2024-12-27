package marceloviana1991.sergipe_vagas.contoller;

import jakarta.validation.Valid;
import marceloviana1991.sergipe_vagas.dto.CursoRequestDto;
import marceloviana1991.sergipe_vagas.dto.UsuarioRequestDto;
import marceloviana1991.sergipe_vagas.dto.UsuarioResponseDto;
import marceloviana1991.sergipe_vagas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioResponseDto> post(@RequestBody @Valid UsuarioRequestDto usuarioRequestDto,
                                  UriComponentsBuilder uriComponentsBuilder) {

        UsuarioResponseDto usuarioResponseDto = usuarioService.post(usuarioRequestDto);
        var uri = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuarioResponseDto.id()).toUri();
        return ResponseEntity.created(uri).body(usuarioResponseDto);
    }

    @GetMapping
    public List<UsuarioResponseDto> get() {
        return usuarioService.get();
    }

    @PostMapping("/{id}/adicionar-curso")
    @Transactional
    public ResponseEntity<UsuarioResponseDto> postCurso(@PathVariable Long id, @RequestBody @Valid CursoRequestDto cursoRequestDto) {
        return ResponseEntity.ok().body(usuarioService.postCurso(id, cursoRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> getUsuario(@PathVariable Long id) {
        return ResponseEntity.ok().body(usuarioService.getUsuario(id));
    }
}
