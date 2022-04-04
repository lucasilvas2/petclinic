package petcc.minicurso.springboot.petclinic.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petcc.minicurso.springboot.petclinic.model.Pet;
import petcc.minicurso.springboot.petclinic.service.PetService;

import javax.persistence.GeneratedValue;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api")
public class PetController {
    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping(value = "/pet/cadastrar/{id_dono}")
    @ApiOperation(value = "Rota para cadastro de Pets informando o id_pessoa do Dono")
    public ResponseEntity<?> cadastrar(@ApiParam(value = "Informações do Pet em formato em JSON") @RequestBody Pet pet,
                                       @ApiParam(value = "id_pessoa do Dono (OBS: Caso deseje cadastrar sem o dono passe o valor 0)") @PathVariable Long id_dono){
//        System.out.println(id_dono);
        Pet petSalvo = petService.cadastrar(pet, id_dono);
        if (pet != null){
            return new ResponseEntity<>(petSalvo, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

//    @PostMapping(value = "/pet/cadastrar/")
//    @ApiOperation(value = "Rota para cadastro de Pets")
//    public ResponseEntity<?> cadastrar(@ApiParam(value = "Informações do Pet em formato em JSON") @RequestBody Pet pet)
//    {
//        Pet petSalvo = petService.cadastrar(pet, null);
//        if (pet != null){
//            return new ResponseEntity<>(petSalvo, HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
//        }
//    }

    @DeleteMapping(value = "/pet/deletar/{id_pet}")
    @ApiOperation(value = "Rota para deletar um Pet no cadastro por ID")
    public ResponseEntity<?> deletar(@ApiParam(value = "id_pet do Pet") @PathVariable Long id_pet){
        Pet petSalvo = petService.buscarPorId(id_pet);
        if (petSalvo != null){
            petService.deletar(id_pet);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/pet/buscar/")
    @ApiOperation(value = "Rota para buscar todos os Pet cadastrados")
    public ResponseEntity<?> buscar(){
        List<Pet> lista_pet = petService.buscarTodosPets();
        if (!lista_pet.isEmpty()){
            return new ResponseEntity<>(lista_pet, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/pet/buscar/{id_pet}")
    @ApiOperation(value = "Rota para buscar um Pet por ID")
    public ResponseEntity<?> buscar(@ApiParam(value = "id_pet do Pet") @PathVariable Long id_pet){
        Pet petSalvo = petService.buscarPorId(id_pet);
        if (petSalvo != null){
            return new ResponseEntity<>(petSalvo, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
