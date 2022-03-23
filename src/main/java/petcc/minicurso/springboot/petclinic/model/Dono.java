package petcc.minicurso.springboot.petclinic.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Dono extends Pessoa{
    @ApiModelProperty( value = "Telefone", dataType = "STRING", example = "00 11111-0000")
    @Column(columnDefinition = "TEXT")
    private String telefone;

    @ApiModelProperty( value = "Rua", dataType = "STRING", example = "Rua logradouro")
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
