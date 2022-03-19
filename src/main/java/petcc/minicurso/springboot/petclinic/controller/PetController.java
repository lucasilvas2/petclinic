package petcc.minicurso.springboot.petclinic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petcc.minicurso.springboot.petclinic.model.Pet;
import petcc.minicurso.springboot.petclinic.service.PetService;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class PetController {
    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping(value = "/pet/cadastrar/{id_dono}")
    public ResponseEntity<?> cadastrar(@RequestBody Pet pet, @PathVariable Long id_dono){
        Pet petSalvo = petService.cadastrar(pet, id_dono);
        if (pet != null){
            return new ResponseEntity<>(petSalvo, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping(value = "/pet/deletar/{id_pet}")
    public ResponseEntity<?> deletar(@PathVariable Long id_dono){
        Pet petSalvo = petService.buscarPorId(id_dono);
        if (petSalvo != null){
            petService.deletar(id_dono);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/pet/buscar/")
    public ResponseEntity<?> buscar(){
        List<Pet> lista_pet = petService.buscarTodosPets();
        if (!lista_pet.isEmpty()){
            return new ResponseEntity<>(lista_pet, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/pet/buscar/{id_pet}")
    public ResponseEntity<?> buscar(@PathVariable Long id_pet){
        Pet petSalvo = petService.buscarPorId(id_pet);
        if (petSalvo != null){
            return new ResponseEntity<>(petSalvo, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
