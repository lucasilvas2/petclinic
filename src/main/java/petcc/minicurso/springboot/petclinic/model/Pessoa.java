package petcc.minicurso.springboot.petclinic.model;

import javax.persistence.*;
import javax.validation.constraints.Email;

@MappedSuperclass
public class Pessoa {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long idPessoa;

    @Column(columnDefinition = "TEXT")
    private String nome;

    @Email
    @Column(unique = true)
    private String email;

    public long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
