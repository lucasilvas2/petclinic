package petcc.minicurso.springboot.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Veterinario extends Pessoa {
    @Column(columnDefinition = "TEXT", unique = true)
    private String idCRMV;

    public String getIdCRMV() {
        return idCRMV;
    }

    public void setIdCRMV(String idCRMV) {
        this.idCRMV = idCRMV;
    }
}
