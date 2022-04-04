package petcc.minicurso.springboot.petclinic.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petcc.minicurso.springboot.petclinic.model.Consulta;
import petcc.minicurso.springboot.petclinic.model.Veterinario;
import petcc.minicurso.springboot.petclinic.service.ConsultaService;
import petcc.minicurso.springboot.petclinic.service.VeterinarioService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api")
public class VeterinarioController {

    private VeterinarioService veterinarioService;
    private ConsultaService consultaService;

    public VeterinarioController(VeterinarioService veterinarioService, ConsultaService consultaService) {
        this.veterinarioService = veterinarioService;
        this.consultaService = consultaService;
    }

    @PostMapping(value = "/veterinario/cadastrar/")
    @ApiOperation(value = "Rota para cadastro de Veterinários")
    public ResponseEntity<?> cadastrar(@ApiParam(value = "Informações do Veterinário em formato em JSON") @RequestBody Veterinario veterinario){
        Veterinario veterinarioSalvo = veterinarioService.cadastrar(veterinario);
        if (veterinarioSalvo != null){
            return new ResponseEntity<>(veterinarioSalvo, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping( value = "/veterinario/deletar/{id_veterianrio}")
    @ApiOperation(value = "Rota para deletar um Veterinário no cadastro por ID")
    public ResponseEntity<?> deletar(@ApiParam(value = "id_pessoa do Veterinário") @PathVariable Long id_veterianrio){
        Veterinario veterinarioSalvo = veterinarioService.buscarPorId(id_veterianrio);
        if (veterinarioSalvo != null){
            veterinarioService.deletar(id_veterianrio);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/veterinario/buscar/")
    @ApiOperation(value = "Rota para buscar todos os Veterinários cadastrados")
    public ResponseEntity<?> buscar(){
        List<Veterinario> lista_veterinario = veterinarioService.buscarVeterinarios();
        if (!lista_veterinario.isEmpty()) {
            return new ResponseEntity<>(lista_veterinario, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/veterinario/buscar/{id_veterinario}")
    @ApiOperation(value = "Rota para buscar um Veterinário por ID")
    public ResponseEntity<?> buscar(@ApiParam(value = "id_pessoa do Veterinário") @PathVariable Long id_veterinario){
        Veterinario veterinarioSalvo = veterinarioService.buscarPorId(id_veterinario);
        if (veterinarioSalvo != null) {
            return new ResponseEntity<>(veterinarioSalvo, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/veterinario/consulta/alterar/{id_veterinario}/{id_consulta}/{status_consulta}")
    @ApiOperation(value = "Rota para alterar a consulta de um veterinario (Aceitar ou Recusar)")
    public ResponseEntity<?> buscar(@ApiParam(value = "id_pessoa do Veterinário") @PathVariable Long id_veterinario,
                                    @ApiParam(value = "id_consulta da Consulta") @PathVariable Long id_consulta,
                                    @ApiParam(value = "status da cosulta") @PathVariable String status_consulta){
        Consulta consultaSalva = consultaService.buscarPorId(id_consulta);
        Veterinario veterinarioSalvo = veterinarioService.buscarPorId(id_veterinario);
        if (veterinarioSalvo != null && consultaSalva != null && consultaSalva.getVeterinario().equals(veterinarioSalvo)) {
            consultaSalva.setStatusConsulta(status_consulta);
            consultaService.cadastrar(consultaSalva, id_veterinario, consultaSalva.getPet().getIdPet());
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
