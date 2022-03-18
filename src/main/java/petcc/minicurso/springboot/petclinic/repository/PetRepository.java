package petcc.minicurso.springboot.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petcc.minicurso.springboot.petclinic.model.Pet;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByNome(String nome);
}
