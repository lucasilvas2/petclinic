package petcc.minicurso.springboot.petclinic.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petcc.minicurso.springboot.petclinic.model.Consulta;
import petcc.minicurso.springboot.petclinic.service.ConsultaService;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ConsultaController {

    private ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping(value = "/consulta/cadastrar/{id_veterinario}/{id_pet}")
    @ApiOperation(value = "Rota para cadastro de Consulta")
    public ResponseEntity<?> cadastrar(@ApiParam(value = "Informações da Consulta em formato em JSON") @RequestBody Consulta consulta,
                                       @ApiParam(value = "id_pessoa do Veterinário") @PathVariable Long id_veterinario,
                                       @ApiParam(value = "id_pet do Pet") @PathVariable Long id_pet){
        Consulta consultaSalva = consultaService.cadastrar(consulta, id_veterinario, id_pet);
        if (consultaSalva != null){
            return new ResponseEntity<>(consultaSalva, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping(value = "/consulta/deletar/{id_consulta}")
    @ApiOperation(value = "Rota para deletar uma Consulta no cadastro por ID")
    public ResponseEntity<?> deletar(@ApiParam(value = "id_consulta da Consulta") @PathVariable Long id_consulta){
        Consulta consultaSalva = consultaService.buscarPorId(id_consulta);
        if (consultaSalva != null){
            consultaService.deletar(id_consulta);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping(value = "/consulta/buscar/")
    @ApiOperation(value = "Rota para buscar todas as Consultas cadastradas")
    public ResponseEntity<?> buscar(){
        List<Consulta> lista_consulta = consultaService.buscarConsultas();
        if(!lista_consulta.isEmpty()){
            return new ResponseEntity<>(lista_consulta, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/consulta/buscar/{id_consulta}")
    @ApiOperation(value = "Rota para buscar uma Consulta por ID")
    public ResponseEntity<?> buscar(@ApiParam(value = "id_consulta da Consulta") @PathVariable Long id_consulta){
        Consulta consultaSalva = consultaService.buscarPorId(id_consulta);
        if(consultaSalva != null){
            return new ResponseEntity<>(consultaSalva, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
