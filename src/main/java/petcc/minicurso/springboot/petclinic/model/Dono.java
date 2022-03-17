package petcc.minicurso.springboot.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Dono extends Pessoa{
    @Column(columnDefinition = "TEXT")
    private String telefone;

    @Column(columnDefinition = "TEXT")
    private String endereco;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
