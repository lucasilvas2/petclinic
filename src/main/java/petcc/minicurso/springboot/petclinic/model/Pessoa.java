package petcc.minicurso.springboot.petclinic.model;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import javax.persistence.*;
import javax.validation.constraints.Email;

@MappedSuperclass
public class Pessoa {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id_pessoa;

    @ApiModelProperty( value = "Nome da Pessoa", dataType = "STRING", example = "João Maria")
    @Column(columnDefinition = "TEXT")
    private String nome;

    @ApiModelProperty( value = "Email", dataType = "STRING", example = "seuEmail@email.com")
    @Email
    @Column(unique = true)
    private String email;

    public long getIdPessoa() {
        return id_pessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.id_pessoa = id_pessoa;
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
