package marceloviana1991.sergipe_vagas.contoller;

import marceloviana1991.sergipe_vagas.domain.login.Login;
import marceloviana1991.sergipe_vagas.domain.login.LoginRequestDto;
import marceloviana1991.sergipe_vagas.domain.login.LoginResponseDto;
import marceloviana1991.sergipe_vagas.domain.login.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> efetuarLogin(@RequestBody LoginRequestDto loginRequestDto) {
        var tokenAutenticacao = new UsernamePasswordAuthenticationToken(loginRequestDto.email(), loginRequestDto.senha());
        var autenticacao = authenticationManager.authenticate(tokenAutenticacao);
        String tokenAcesso = tokenService.gerarToken((Login) autenticacao.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDto(tokenAcesso));
    }
}
