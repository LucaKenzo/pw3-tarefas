package br.com.etechas.tarefas.service;

import br.com.etechas.tarefas.dto.UsuarioaCadastroDTO;
import br.com.etechas.tarefas.dto.UsuarioaResponseDTO;
import br.com.etechas.tarefas.entity.Usuario;
import br.com.etechas.tarefas.mapper.UsuarioMapper;
import br.com.etechas.tarefas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioMapper usuarioMapper;


    public UsuarioaResponseDTO registrar(UsuarioaCadastroDTO dto) {
        Optional<Usuario> cadastro = repository.findByUsername(dto.username());

        if (cadastro.isPresent()) {
            throw new RuntimeException("Nome de usuário ja existe");
        }

        Usuario usuario = usuarioMapper.toEntity(dto);
        Usuario salvo = repository.save(usuario);

        return UsuarioMapper.toUsuarioResponseDTO(salvo);
    }
}
