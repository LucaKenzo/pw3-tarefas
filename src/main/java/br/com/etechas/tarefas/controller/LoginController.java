package br.com.etechas.tarefas.controller;

import br.com.etechas.tarefas.dto.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AutenticationManager autenticationManager;

    public ResponseEntity<LoginResponseDTO> autenticar(
            @RequestBody LoginResponseDTO loginResponseDTO){
        var autenticado = autenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.usuario(),loginRequest.senha()));
    }

}
