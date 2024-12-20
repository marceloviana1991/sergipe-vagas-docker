package marceloviana1991.sergipe_vagas.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuarios")
@Entity(name = "Usuarios")
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String cpf;

    public Usuario() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

