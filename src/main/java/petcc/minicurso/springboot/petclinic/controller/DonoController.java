package petcc.minicurso.springboot.petclinic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petcc.minicurso.springboot.petclinic.model.Dono;
import petcc.minicurso.springboot.petclinic.service.DonoService;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class DonoController {

    private DonoService donoService;

    public DonoController(DonoService donoService) {
        this.donoService = donoService;
    }

    @PostMapping(value = "/dono/cadastrar/")
    public ResponseEntity<?> cadastrar(@RequestBody Dono dono){
        Dono donoSalvo = donoService.cadastrar(dono);
        if(donoSalvo != null){
            return new ResponseEntity<>(donoSalvo, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping(value = "/dono/deletar/{id_dono}")
    public ResponseEntity<?> deletar(@PathVariable Long id_dono){
        Dono donoSalvo = donoService.buscarDonoPorID(id_dono);
        if (donoSalvo != null){
            donoService.deletar(id_dono);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/dono/buscar/")
    public ResponseEntity<?> buscar(){
        List<Dono> lista_dono = donoService.buscarTodosDonos();
        if (!lista_dono.isEmpty()){
            return new ResponseEntity<>(lista_dono, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/dono/buscar/{id_dono}")
    public ResponseEntity<?> buscar(@PathVariable Long id_dono){
        Dono donoSalvo = donoService.buscarDonoPorID(id_dono);
        if (donoSalvo != null){
            return new ResponseEntity<>(donoSalvo, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
