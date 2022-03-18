package petcc.minicurso.springboot.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petcc.minicurso.springboot.petclinic.model.Dono;
import petcc.minicurso.springboot.petclinic.repository.DonoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DonoService {

    @Autowired
    private DonoRepository donoRepository;

    public List<Dono> buscarDonos(){
        return donoRepository.findAll();
    }

    public List<Dono> buscarDonosPorNome(String nome){
        return donoRepository.findByNome(nome);
    }

    public Optional<Dono> buscarDonoPorId(Long id){
        return donoRepository.findById(id);
    }

    public Dono salvar(Dono dono){
        return donoRepository.save(dono);
    }

    public void deletar(Long id){
        donoRepository.deleteById(id);
    }
}
