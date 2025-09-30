package br.com.etechas.tarefas.dto;

import br.com.etechas.tarefas.enums.RoleEnum;

public record UsuarioaCadastroDTO(
        String username,
        String password,
        RoleEnum role
        )
{

}
