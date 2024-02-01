package com.api.correo.service;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.api.correo.dto.CorreoDTO;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void enviarCorreo(CorreoDTO correoDTO) throws MessagingException{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");

        helper.setTo(correoDTO.getDestinatario());
        helper.setSubject(correoDTO.getAsunto());
        // Construir el cuerpo HTML con diseño estilizado
        String contenidoEmail = "¡Hola " + correoDTO.getNombre() + " " + correoDTO.getApellidos() + "!<br/><br/>"
        + "Bienvenido a Digital, tu destino para servicios increíbles. Estamos emocionados de tenerte con nosotros.<br/><br/>"
        + "En Digital, ofrecemos una amplia gama de servicios diseñados para hacer tu vida más fácil. Desde productos de alta calidad hasta un servicio al cliente excepcional, estamos aquí para ti.<br/><br/>"
        + "Si tienes alguna pregunta o necesitas asistencia, no dudes en ponerte en contacto con nuestro equipo. Estamos aquí para ayudarte.<br/><br/>"
        + "Gracias por unirte a Digital. ¡Esperamos que disfrutes de la experiencia!<br/><br/>"
        + "Saludos,<br/>"
        + "El equipo de Digital";

        String cuerpoConDiseno = "<html>"
        + "<head>"
        + "</head>"
        + "<body style='font-family: \"Arial\", sans-serif; background-color: #f2f2f2; margin: 0; padding: 0;'>"
        + "<table width='100%' cellspacing='0' cellpadding='0'>"
        + "<tr>"
        + "<td style='background-color: #89FCDB; padding: 20px; text-align: center; color: #fff;'>"
        + "<h1 style='margin: 0; font-size: 36px;'>¡Bienvenido a Digital!</h1>"
        + "</td>"
        + "</tr>"
        + "<tr>"
        + "<td style='background-color: #ffffff; padding: 20px; text-align: justify; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); color: #333;'>"
        + "<p style='line-height: 1.6; font-size: 16px; margin-bottom: 20px;'>" + contenidoEmail + "</p>"
        + "</td>"
        + "</tr>"
        + "<tr>"
        + "<td style='font-size: 12px; color: #777; text-align: center; padding: 10px; background-color: #ddd;'>© 2024 Digital | Todos los derechos reservados</td>"
        + "</tr>"
        + "</table>"
        + "</body>"
        + "</html>";

        helper.setText(cuerpoConDiseno, true);
        javaMailSender.send(mimeMessage);
    }
}