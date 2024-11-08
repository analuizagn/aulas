package org.sd.aulas.aula06.controladores;

import org.sd.aulas.aula06.dto.LoginRequest;
import org.sd.aulas.aula06.servicos.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String token = authService.autenticar(loginRequest.getUsername(), loginRequest.getSenha());
        return ResponseEntity.ok(token);
    }
}
