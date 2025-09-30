package br.com.etechas.tarefas.service;

import br.com.etechas.tarefas.dto.TarefaCreationDTO;
import br.com.etechas.tarefas.dto.TarefaResponseDTO;
import br.com.etechas.tarefas.entity.Tarefa;
import br.com.etechas.tarefas.enums.StatusEnum;
import br.com.etechas.tarefas.mapper.TarefaMapper;
import br.com.etechas.tarefas.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    @Autowired
    private TarefaMapper tarefaMapper;

    public List<TarefaResponseDTO> findAll(){
        return tarefaMapper.toResponseDTOList(repository.findAll());
    }
/*
    public boolean excluirPorId(Long id) {
        Optional<Tarefa> tarefaOpt = repository.findById(id);

        if (tarefaOpt.isEmpty()) {
            return false; // tarefa não encontrada
        }

        Tarefa tarefa = tarefaOpt.get();

        if (tarefa.getStatus() != StatusEnum.PENDING) {
            throw new RuntimeException("Tarefa em progresso ou concluída");
        }

        repository.deleteById(id);
        return true;
    }
<<<<<<< HEAD
*/
    public boolean deleteByid(Long id){

        var tarefa = repository.findById(id);

        if(tarefa.isPresent()){
            repository.deleteById(id);
            return true;
        }

        return false;
    }

    public Tarefa postar(TarefaCreationDTO dto) {
        if (dto.dataLimite().isBefore(LocalDate.now())) {
            throw new RuntimeException("Data limite não pode ser anterior a data atual");
        }
        Tarefa tarefa = tarefaMapper.toEntity(dto);
        tarefa.setStatus(StatusEnum.PENDING);
        return repository.save(tarefa);
    }
}
