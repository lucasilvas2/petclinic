package petcc.minicurso.springboot.petclinic.service;

import org.springframework.stereotype.Service;
import petcc.minicurso.springboot.petclinic.model.Dono;
import petcc.minicurso.springboot.petclinic.model.Pet;
import petcc.minicurso.springboot.petclinic.repository.PetRepository;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final DonoService donoService;

    public PetService(PetRepository petRepository, DonoService donoService){
        this.petRepository = petRepository;
        this.donoService = donoService;
    }
    public Pet cadastrar(Pet pet, Long id_pessoa){
        pet.setDono(donoService.buscarDonoPorID(id_pessoa));
        return petRepository.save(pet);
    }

    public void deletar(Long id){
        petRepository.deleteById(id);
    }

    public List<Pet> buscarTodosPets(){
        return petRepository.findAll();
    }

    public List<Pet> buscarPetPorNome(String nome){
        return petRepository.findByNome(nome);
    }

    public Pet buscarPorId(Long id){
        return petRepository.findById(id).isPresent() ? petRepository.findById(id).get() : null;
    }


}
