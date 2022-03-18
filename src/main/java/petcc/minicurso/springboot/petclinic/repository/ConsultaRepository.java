package petcc.minicurso.springboot.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petcc.minicurso.springboot.petclinic.model.Consulta;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
