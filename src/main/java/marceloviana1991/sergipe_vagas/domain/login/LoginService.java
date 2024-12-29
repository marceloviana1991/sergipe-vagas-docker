package marceloviana1991.sergipe_vagas.domain.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loginRepository.findByEmailIgnoreCase(username).orElseThrow(
                () -> new UsernameNotFoundException("O usuário não foi encontrado!")
        );
    }

    public void ativarConta(String tokenVerificacao) {
        Login login = loginRepository.findByToken(tokenVerificacao).orElseThrow(
                () -> new UsernameNotFoundException("O usuário não foi encontrado!"));
        login.setVerificado(true);
    }
}
