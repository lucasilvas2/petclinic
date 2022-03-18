package petcc.minicurso.springboot.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petcc.minicurso.springboot.petclinic.model.Consulta;
import petcc.minicurso.springboot.petclinic.model.Status;
import petcc.minicurso.springboot.petclinic.repository.ConsultaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> buscarConsultas(){
        return consultaRepository.findAll();
    }
    public List<Consulta> buscarPorData(LocalDate data){
        return consultaRepository.findByData(data);
    }

    public List<Consulta> buscarPorStatus(Status status){
        return consultaRepository.findByStatus(status);
    }

    public Optional<Consulta> buscarPorId(Long id){
        return consultaRepository.findById(id);
    }

    public Consulta salvar(Consulta consulta){
        return consultaRepository.save(consulta);
    }

    public void deletar(Long id){
        consultaRepository.deleteById(id);
    }
}
