package petcc.minicurso.springboot.petclinic.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPet;

    @ApiModelProperty(value = "Nome do pet", dataType = "STRING", example = "Totó")
    @Column(columnDefinition = "TEXT")
    private String nome;

    @ApiModelProperty(value = "Data de aniversário", dataType = "DATE", example = "2000-02-20")
    @Column(columnDefinition = "DATE")
    private LocalDate aniversario;

    @ApiModelProperty(value = "Id_pessoa do dono", dataType = "LONG", example = "1")
    @ManyToOne
    @JoinColumn(name = "id_dono")
    private Dono dono;

    public Long getIdPet() {
        return idPet;
    }

    public void setIdPet(Long idPet) {
        this.idPet = idPet;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getAniversario() {
        return aniversario;
    }

    public void setAniversario(LocalDate aniversario) {
        this.aniversario = aniversario;
    }

    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }
}
