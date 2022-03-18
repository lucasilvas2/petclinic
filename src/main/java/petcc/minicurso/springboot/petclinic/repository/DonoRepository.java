package petcc.minicurso.springboot.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petcc.minicurso.springboot.petclinic.model.Dono;

import java.util.List;

public interface DonoRepository extends JpaRepository<Dono, Long> {
    List<Dono> findByNome(String nome);
}
