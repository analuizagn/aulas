package org.sd.aulas.aula06.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/publico")
    public String rotaPublica() {
        return "<h1>Rota Pública</h1>" +
                "<h2>Você é livre para olhar esta página 👍<h2>" ;
    }

    @GetMapping("/privado")
    public String rotaPrivada() {
        return "<h1>Rota Privada</h1>" +
                "<p>Apenas pessoas autorizadas podem acessar esses dados! 🔒</p>";
    }
}
