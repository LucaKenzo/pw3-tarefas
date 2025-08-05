package br.com.etechas.tarefas.service;

import br.com.etechas.tarefas.entity.Tarefa;
import br.com.etechas.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    public List<Tarefa> findAll(){
        return repository.findAll();
    }
}
