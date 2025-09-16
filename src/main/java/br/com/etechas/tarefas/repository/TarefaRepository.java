package br.com.etechas.tarefas.repository;

import br.com.etechas.tarefas.entity.Tarefa;
import br.com.etechas.tarefas.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    //@Query("select t from Tarefa t where t.id = :id and " + "t.status = br.com.etechas.enums.StatusEnum.Pending")
    //Optional<Tarefa> findByIdAndPending(Long id);
}
