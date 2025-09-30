package br.com.etechas.tarefas.controller;

import br.com.etechas.tarefas.dto.UsuarioaCadastroDTO;
import br.com.etechas.tarefas.dto.UsuarioaResponseDTO;
import br.com.etechas.tarefas.mapper.UsuarioMapper;
import br.com.etechas.tarefas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioMapper usuarioMapper;

    @PostMapping
    ResponseEntity<UsuarioaResponseDTO> registrar(@RequestBody UsuarioaCadastroDTO cadastro) {
        usuarioService.registrar(cadastro);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
