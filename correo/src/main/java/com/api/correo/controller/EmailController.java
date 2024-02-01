package com.api.correo.controller;

import com.api.correo.dto.CorreoDTO;
import com.api.correo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/correo")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    public ResponseEntity<String> enviarCorreo(@RequestBody CorreoDTO correoDTO) {
        try {
            // Validaciones antes de enviar el correo
            if (correoDTO.getDestinatario() == null || correoDTO.getAsunto() == null || correoDTO.getContenido() == null|| correoDTO.getNombre()==null||correoDTO.getApellidos()==null) {
                return ResponseEntity.badRequest().body("Todos los campos deben ser proporcionados");
            }

            // Otras validaciones específicas si es necesario
            // ...

            // Ejemplo: enviar correo
            emailService.enviarCorreo(correoDTO);

            return ResponseEntity.ok("Correo enviado con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al enviar el correo: " + e.getMessage());
        }
    }
}