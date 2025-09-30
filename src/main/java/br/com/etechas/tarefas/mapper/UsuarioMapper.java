package br.com.etechas.tarefas.mapper;

import br.com.etechas.tarefas.dto.UsuarioaCadastroDTO;
import br.com.etechas.tarefas.dto.UsuarioaResponseDTO;
import br.com.etechas.tarefas.entity.Usuario;
import br.com.etechas.tarefas.enums.RoleEnum;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioMapper {
    public Usuario toEntity(UsuarioaCadastroDTO cadastro) {
        Usuario usuario = new Usuario();
        usuario.setUsername(cadastro.username());
        usuario.setPassword(cadastro.password());
        usuario.setRole(RoleEnum.valueOf(cadastro.role().toString().toUpperCase()));

        return usuario;
    }

    public static UsuarioaResponseDTO toUsuarioResponseDTO(Usuario salvo) {
        return new UsuarioaResponseDTO(salvo.getId(), salvo.getUsername(), salvo.getRole());
    }
}
