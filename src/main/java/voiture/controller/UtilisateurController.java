package voiture.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import voiture.auth.AuthenticationRequest;
import voiture.auth.RegisterRequest;
import voiture.service.AuthenticationService;
import voiture.tools.Util;

@RestController
@RequestMapping("/login")
public class UtilisateurController {

    @Autowired
    private AuthenticationService service;

    @GetMapping("/hello")
    public String register() {
        return "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody RegisterRequest request) {
        Map<String, Object> response = Util.getDefaultResponse();
        response.put("response", service.register(request));
        return new ResponseEntity<Map<String, Object>>(
                response,
                HttpStatusCode.valueOf(400)
        );
    }

    @PostMapping("/auth")
    public ResponseEntity<Map<String, Object>> auth(@RequestBody AuthenticationRequest request) {
        Map<String, Object> response = Util.getDefaultResponse();
        response.put("response", service.authenticate(request));
        return new ResponseEntity<Map<String, Object>>(
                response,
                HttpStatusCode.valueOf(400)
        );
    }

    
}

