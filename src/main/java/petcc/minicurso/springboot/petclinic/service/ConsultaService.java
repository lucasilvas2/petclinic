package petcc.minicurso.springboot.petclinic.service;

import org.springframework.stereotype.Service;
import petcc.minicurso.springboot.petclinic.model.Consulta;
import petcc.minicurso.springboot.petclinic.repository.ConsultaRepository;

import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final VeterinarioService veterinarioService;
    private final PetService petService;

    public ConsultaService(ConsultaRepository consultaRepository, VeterinarioService veterinarioService, PetService petService) {
        this.consultaRepository = consultaRepository;
        this.veterinarioService = veterinarioService;
        this.petService = petService;
    }

    public Consulta salvar(Consulta consulta, Long id_veterinario, Long id_pet){
        consulta.setVeterinario(veterinarioService.buscarPorId(id_veterinario));
        consulta.setPet(petService.buscarPorId(id_pet));
        return consultaRepository.save(consulta);
    }

    public void deletar(Long id){
        consultaRepository.deleteById(id);
    }

    public List<Consulta> buscarConsultas(){
        return consultaRepository.findAll();
    }

    public Consulta buscarPorId(Long id){
        return consultaRepository.findById(id).isPresent() ? consultaRepository.findById(id).get() : null;
    }

}
