package marceloviana1991.sergipe_vagas.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Autowired
    private FiltroTokenAcesso filtroTokenAcesso;

    @Bean
    public SecurityFilterChain filtrosDeSeguranca(HttpSecurity http) throws Exception {
        return http
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(
                        req -> {
                            req.requestMatchers(HttpMethod.POST, "/usuarios", "/empresas", "/login").permitAll();
                            req.requestMatchers(HttpMethod.GET, "/ativar/{tokenVerificacao}").permitAll();
                            req.requestMatchers(HttpMethod.GET, "/empresas/**").hasRole("USUARIO");
                            req.requestMatchers(HttpMethod.GET, "/usuarios/**").hasRole("EMPRESA");
                            req.requestMatchers(HttpMethod.POST, "/empresas/{id}/adicionar-vaga").hasRole("EMPRESA");
                            req.requestMatchers(HttpMethod.DELETE, "/empresas/vagas/{idVaga}").hasRole("EMPRESA");
                            req.requestMatchers(HttpMethod.POST, "/usuarios/{id}/adicionar-curso").hasRole("USUARIO");
                            req.anyRequest().authenticated();
                        }
                )
                .csrf(csrf -> csrf.disable())
                .addFilterBefore(filtroTokenAcesso, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder encriptador() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
