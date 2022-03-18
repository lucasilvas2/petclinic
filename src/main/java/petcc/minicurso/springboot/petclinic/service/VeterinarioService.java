package petcc.minicurso.springboot.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petcc.minicurso.springboot.petclinic.model.Veterinario;
import petcc.minicurso.springboot.petclinic.repository.VeterinarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public List<Veterinario> buscarVeterinarios(){
        return veterinarioRepository.findAll();
    }

    public List<Veterinario> buscarPetPorNome(String nome){
        return veterinarioRepository.findByNome(nome);
    }

    public Optional<Veterinario> buscarPorId(Long id){
        return veterinarioRepository.findById(id);
    }

    public Veterinario salvar(Veterinario veterinario){
        return veterinarioRepository.save(veterinario);
    }

    public void deletar(Long id){
        veterinarioRepository.deleteById(id);
    }
}
