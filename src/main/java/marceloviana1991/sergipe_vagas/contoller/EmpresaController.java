package marceloviana1991.sergipe_vagas.contoller;

import jakarta.validation.Valid;
import marceloviana1991.sergipe_vagas.domain.empresa.EmpresaRequestDto;
import marceloviana1991.sergipe_vagas.domain.empresa.EmpresaResponseDto;
import marceloviana1991.sergipe_vagas.domain.empresa.EmpresaService;
import marceloviana1991.sergipe_vagas.domain.empresa.VagaRequestDto;
import marceloviana1991.sergipe_vagas.domain.login.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    @Transactional
    public ResponseEntity<EmpresaResponseDto> post(@RequestBody @Valid EmpresaRequestDto empresaRequestDto,
                                                   UriComponentsBuilder uriComponentsBuilder) {
        EmpresaResponseDto empresaResponseDto = empresaService.post(empresaRequestDto);
        var uri = uriComponentsBuilder.path("/empresas/{id}").buildAndExpand(empresaResponseDto.id()).toUri();
        return ResponseEntity.created(uri).body(empresaResponseDto);
    }

    @GetMapping
    public List<EmpresaResponseDto> get() {
        return empresaService.get();
    }

    @PostMapping("/{id}/adicionar-vaga")
    @Transactional
    public ResponseEntity<EmpresaResponseDto> postVaga(@PathVariable Long id,
                                                       @RequestBody @Valid VagaRequestDto vagaRequestDto,
                                                       @AuthenticationPrincipal Login login) {
        return ResponseEntity.ok().body(empresaService.postVaga(id, vagaRequestDto, login));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaResponseDto> getEmpresa(@PathVariable Long id) {
        return ResponseEntity.ok().body(empresaService.getEmpresa(id));
    }

    @DeleteMapping("/vagas/{idVaga}")
    @Transactional
    public ResponseEntity<?> deleteVaga(@PathVariable Long idVaga, @AuthenticationPrincipal Login login) {
        empresaService.deleteVaga(idVaga, login);
        return ResponseEntity.noContent().build();
    }

}
