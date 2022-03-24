package petcc.minicurso.springboot.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petcc.minicurso.springboot.petclinic.model.Consulta;
import petcc.minicurso.springboot.petclinic.model.Veterinario;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByVeterinario(Veterinario veterinario);
    List<Consulta> findByStatusConsulta(String status);
//    Consulta findById_consultaAndVeterinario(Long id_consulta, Veterinario veterinario);
}
