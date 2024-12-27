package marceloviana1991.sergipe_vagas.domain.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private VagaRepository vagaRepository;

    public EmpresaResponseDto post(EmpresaRequestDto empresaRequestDto) {
        Empresa empresa = new Empresa(empresaRequestDto.email(), empresaRequestDto.cnpj());
        empresaRepository.save(empresa);
        List<Vaga> vagas = empresaRequestDto.vagas()
                .stream()
                .map(vagaRequestDto -> new Vaga(vagaRequestDto.nome(), vagaRequestDto.atribuicao(), empresa))
                .toList();
        vagas.forEach(vaga -> vagaRepository.save(vaga));
        List<VagaResponseDto> vagasResponseDto = vagas
                .stream()
                .map(vaga -> new VagaResponseDto(vaga.getId(), vaga.getNome(), vaga.getAtribuicao()))
                .toList();
        return new EmpresaResponseDto(
                empresa.getId(), empresaRequestDto.email(), empresaRequestDto.cnpj(), vagasResponseDto);
    }

    public List<EmpresaResponseDto> get() {
        List<Empresa> empresas = empresaRepository.findAll();
        List<EmpresaResponseDto> empresasResponseDto = new ArrayList<>();
        for (Empresa empresa : empresas) {
            List<VagaResponseDto> vagasResponseDto = getVagasByEmpresa(empresa);
            empresasResponseDto.add(new EmpresaResponseDto(
                    empresa.getId(), empresa.getEmail(), empresa.getCnpj(), vagasResponseDto));
        }
        return empresasResponseDto;
    }

    public EmpresaResponseDto postVaga(Long id, VagaRequestDto vagaRequestDto) {
        Empresa empresa = empresaRepository.getReferenceById(id);
        Vaga vaga = new Vaga(vagaRequestDto.nome(), vagaRequestDto.atribuicao(), empresa);
        vagaRepository.save(vaga);
        List<VagaResponseDto> vagasResponseDto = getVagasByEmpresa(empresa);
        return new EmpresaResponseDto(empresa.getId(), empresa.getEmail(), empresa.getCnpj(), vagasResponseDto);
    }

    public EmpresaResponseDto getEmpresa(Long id) {
        Empresa empresa = empresaRepository.getReferenceById(id);
        List<VagaResponseDto> vagasResponseDto = getVagasByEmpresa(empresa);
        return new EmpresaResponseDto(empresa.getId(), empresa.getEmail(), empresa.getCnpj(), vagasResponseDto);
    }

    private List<VagaResponseDto> getVagasByEmpresa(Empresa empresa) {
        List<Vaga> vagas = vagaRepository.findAllByEmpresa(empresa);
        return vagas
                .stream()
                .map(v -> new VagaResponseDto(v.getId(), v.getNome(), v.getAtribuicao()))
                .toList();
    }
}
