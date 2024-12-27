package marceloviana1991.sergipe_vagas.contoller;

import jakarta.validation.Valid;
import marceloviana1991.sergipe_vagas.domain.empresa.EmpresaRequestDto;
import marceloviana1991.sergipe_vagas.domain.empresa.EmpresaResponseDto;
import marceloviana1991.sergipe_vagas.domain.empresa.EmpresaService;
import marceloviana1991.sergipe_vagas.domain.empresa.VagaRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
                                                        @RequestBody @Valid VagaRequestDto vagaRequestDto) {
        return ResponseEntity.ok().body(empresaService.postVaga(id, vagaRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaResponseDto> getUsuario(@PathVariable Long id) {
        return ResponseEntity.ok().body(empresaService.getEmpresa(id));
    }
}
