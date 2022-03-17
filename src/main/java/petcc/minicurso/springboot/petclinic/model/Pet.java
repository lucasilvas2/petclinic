package petcc.minicurso.springboot.petclinic.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPet;

    @Column(columnDefinition = "TEXT")
    private String nome;

    @Column(columnDefinition = "DATE")
    private LocalDate aniversario;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Dono dono;

    public long getIdPet() {
        return idPet;
    }

    public void setIdPet(long idPet) {
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
