package petcc.minicurso.springboot.petclinic.service;

import org.springframework.stereotype.Service;
import petcc.minicurso.springboot.petclinic.model.Dono;
import petcc.minicurso.springboot.petclinic.repository.DonoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DonoService {

    private final DonoRepository donoRepository;

    public DonoService(DonoRepository donoRepository){
        this.donoRepository = donoRepository;
    }

    public Dono cadastrar(Dono dono){
        return donoRepository.save(dono);
    }

    public void deletar(Long id){
        donoRepository.deleteById(id);
    }

    public List<Dono> buscarTodosDonos(){
        return donoRepository.findAll();
    }

    public List<Dono> buscarDonosPorNome(String nome){
        return donoRepository.findByNome(nome);
    }

//    public Optional<Dono> buscarDonoPorId(Long id){
//        return donoRepository.findById(id);
//    }

    public Dono buscarDonoPorID(Long id){
        return donoRepository.findById(id).isPresent() ? donoRepository.findById(id).get() : null;
    }
}
