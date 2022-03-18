package petcc.minicurso.springboot.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petcc.minicurso.springboot.petclinic.model.Veterinario;

import java.util.List;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
    List<Veterinario> findByNome(String nome);
}
