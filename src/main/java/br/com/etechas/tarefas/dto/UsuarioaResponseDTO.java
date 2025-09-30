package br.com.etechas.tarefas.dto;

import br.com.etechas.tarefas.enums.RoleEnum;

public record UsuarioaResponseDTO(
        Long id,
        String username,
        RoleEnum role
        )
{

}
