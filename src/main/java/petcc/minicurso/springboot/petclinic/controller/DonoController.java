package petcc.minicurso.springboot.petclinic.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @ApiOperation(value = "Rota para cadastro de Donos")
    public ResponseEntity<?> cadastrar(@ApiParam(value = "Informações do Dono em formato em JSON") @RequestBody Dono dono){
        Dono donoSalvo = donoService.cadastrar(dono);
        if(donoSalvo != null){
            return new ResponseEntity<>(donoSalvo, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping(value = "/dono/deletar/{id_dono}")
    @ApiOperation(value = "Rota para deletar um Dono no cadastro por ID")
    public ResponseEntity<?> deletar(@ApiParam(value = "id_pessoa do Dono") @PathVariable Long id_dono){
        Dono donoSalvo = donoService.buscarDonoPorID(id_dono);
        if (donoSalvo != null){
            donoService.deletar(id_dono);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/dono/buscar/")
    @ApiOperation(value = "Rota para buscar todos os Donos cadastrados")
    public ResponseEntity<?> buscar(){
        List<Dono> lista_dono = donoService.buscarTodosDonos();
        if (!lista_dono.isEmpty()){
            return new ResponseEntity<>(lista_dono, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/dono/buscar/{id_dono}")
    @ApiOperation(value = "Rota para buscar um Dono por ID")
    public ResponseEntity<?> buscar(@ApiParam(value = "id_pessoa do Dono") @PathVariable Long id_dono){
        Dono donoSalvo = donoService.buscarDonoPorID(id_dono);
        if (donoSalvo != null){
            return new ResponseEntity<>(donoSalvo, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
