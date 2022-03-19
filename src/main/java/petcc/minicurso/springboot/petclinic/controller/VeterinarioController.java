package petcc.minicurso.springboot.petclinic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petcc.minicurso.springboot.petclinic.model.Veterinario;
import petcc.minicurso.springboot.petclinic.service.VeterinarioService;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class VeterinarioController {

    private VeterinarioService veterinarioService;

    public VeterinarioController(VeterinarioService veterinarioService) {
        super();
        this.veterinarioService = veterinarioService;
    }

    @PostMapping(value = "/veterinario/cadastrar/")
    public ResponseEntity<?> cadastrar(@RequestBody Veterinario veterinario){
        Veterinario veterinarioSalvo = veterinarioService.cadastrar(veterinario);
        if (veterinarioSalvo != null){
            return new ResponseEntity<>(veterinarioSalvo, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping( value = "/veterinario/deletar/{id_veterianrio}")
    public ResponseEntity<?> deletar(@PathVariable Long id_veterianrio){
        Veterinario veterinarioSalvo = veterinarioService.buscarPorId(id_veterianrio);
        if (veterinarioSalvo != null){
            veterinarioService.deletar(id_veterianrio);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/veterinario/buscar/")
    public ResponseEntity<?> buscar(){
        List<Veterinario> lista_veterinario = veterinarioService.buscarVeterinarios();
        if (!lista_veterinario.isEmpty()) {
            return new ResponseEntity<>(lista_veterinario, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/veterinario/buscar/{id_veterinario}")
    public ResponseEntity<?> buscar(@PathVariable Long id_veterinario){
        Veterinario veterinarioSalvo = veterinarioService.buscarPorId(id_veterinario);
        if (veterinarioSalvo != null) {
            return new ResponseEntity<>(veterinarioSalvo, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
