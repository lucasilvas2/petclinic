package petcc.minicurso.springboot.petclinic.service;

import org.springframework.stereotype.Service;
import petcc.minicurso.springboot.petclinic.model.Veterinario;
import petcc.minicurso.springboot.petclinic.repository.VeterinarioRepository;

import java.util.List;

@Service
public class VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    public VeterinarioService(VeterinarioRepository veterinarioRepository) {
        this.veterinarioRepository = veterinarioRepository;
    }

    public Veterinario cadastrar(Veterinario veterinario){
        return veterinarioRepository.save(veterinario);
    }

    public void deletar(Long id){
        veterinarioRepository.deleteById(id);
    }
    public List<Veterinario> buscarVeterinarios(){
        return veterinarioRepository.findAll();
    }

    public List<Veterinario> buscarPetPorNome(String nome){
        return veterinarioRepository.findByNome(nome);
    }

    public Veterinario buscarPorId(Long id){
        return veterinarioRepository.findById(id).isPresent() ? veterinarioRepository.findById(id).get() : null;
    }


}
