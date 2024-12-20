package marceloviana1991.sergipe_vagas.contoller;

import marceloviana1991.sergipe_vagas.dto.UsuarioRequestDto;
import marceloviana1991.sergipe_vagas.dto.UsuarioResponseDto;
import marceloviana1991.sergipe_vagas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public UsuarioResponseDto post(@RequestBody UsuarioRequestDto usuarioRequestDto) {
        return usuarioService.post(usuarioRequestDto);
    }

    @GetMapping
    public List<UsuarioResponseDto> get() {
        return usuarioService.get();
    }
}
