package br.com.etechas.tarefas.mapper;

import br.com.etechas.tarefas.dto.UsuarioCadastroDTO;
import br.com.etechas.tarefas.dto.UsuarioResponseDTO;
import br.com.etechas.tarefas.entity.Usuario;
import br.com.etechas.tarefas.enums.RoleEnum;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public Usuario toEntity(UsuarioCadastroDTO cadastro) {
        Usuario usuario = new Usuario();
        usuario.setUsername(cadastro.username());
        usuario.setPassword(cadastro.password());
        usuario.setRole(RoleEnum.valueOf(cadastro.role().toString().toUpperCase()));

        return usuario;
    }

    public static UsuarioResponseDTO toUsuarioResponseDTO(Usuario salvo) {
        return new UsuarioResponseDTO(salvo.getId(), salvo.getUsername(), salvo.getRole());
    }
}
