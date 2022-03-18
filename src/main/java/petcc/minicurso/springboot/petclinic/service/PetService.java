package petcc.minicurso.springboot.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petcc.minicurso.springboot.petclinic.model.Pet;
import petcc.minicurso.springboot.petclinic.repository.PetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<Pet> buscarPets(){
        return petRepository.findAll();
    }

    public List<Pet> buscarPetPorNome(String nome){
        return petRepository.findByNome(nome);
    }

    public Optional<Pet> buscarPorId(Long id){
        return petRepository.findById(id);
    }

    public Pet salvar(Pet pet){
        return petRepository.save(pet);
    }

    public void deletar(Long id){
        petRepository.deleteById(id);
    }
}
