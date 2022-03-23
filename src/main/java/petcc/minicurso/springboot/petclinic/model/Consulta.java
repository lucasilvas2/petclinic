package petcc.minicurso.springboot.petclinic.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_consulta;

    @ApiModelProperty( value = "Status da consulta", dataType = "STRING", example = "Agendada")
    @Column(columnDefinition = "TEXT")
    private String statusConsulta;

    @ApiModelProperty(value = "Data da consulta", dataType = "DATE", example = "2022-02-20")
    @Column(columnDefinition = "DATE")
    private LocalDate data;

    @ApiModelProperty(value = "Id_veterinario do Veterinário", dataType = "LONG", example = "1")
    @ManyToOne
    @JoinColumn(name = "id_veterinario")
    private Veterinario veterinario;

    @ApiModelProperty(value = "Id_pet do Pet", dataType = "LONG", example = "1")
    @ManyToOne
    @JoinColumn(name = "id_pet")
    private Pet pet;

    public long getIdConsulta() {
        return id_consulta;
    }

    public void setIdConsulta(long idConsulta) {
        this.id_consulta = id_consulta;
    }

    public String getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(String statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }


}
