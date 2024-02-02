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

        String imageUrl = "https://res.cloudinary.com/dnwzliif9/image/upload/e_background_removal/e_dropshadow:azimuth_220;elevation_60;spread_20/f_png/v1706807940/lindo-pinguino-volando-globos-ilustracion-vectorial-dibujos-animados-vector-aislado-concepto-amor-animal-estilo-dibujos-animados-plana_138676-2016.jpg_brpk4f.jpg"; // Replace with the actual URL of your image

        String contenidoEmail = "¡Hola " + correoDTO.getNombre() + " " + correoDTO.getApellidos() + "!<br/><br/>"
        + "Bienvenido a TuEmpresa, tu destino para servicios increíbles. Estamos emocionados de tenerte con nosotros.<br/><br/>"
        + "En TuEmpresa, ofrecemos una amplia gama de servicios diseñados para hacer tu vida más fácil. Desde productos de alta calidad hasta un servicio al cliente excepcional, estamos aquí para ti.<br/><br/>"
        + "Si tienes alguna pregunta o necesitas asistencia, no dudes en ponerte en contacto con nuestro equipo. Estamos aquí para ayudarte.<br/><br/>"
        + "Gracias por unirte a TuEmpresa. ¡Esperamos que disfrutes de la experiencia!<br/><br/>"
        + "<p style='text-align: center;'><img src='" + imageUrl + "' alt='Welcome Image' style='max-width: 100%; height: auto; margin-bottom: 20px;' /></p>"
        + "Saludos,<br/>"
        + "El equipo de TuEmpresa";

        String cuerpoConDiseno = "<html>"
        + "<head>"
        + "<style>"
        + "body { font-family: 'Arial', sans-serif; background-color: #f2f2f2; margin: 0; padding: 0; }"
        + "header { background-color: #7F3B7F; color: #fff; text-align: center; padding: 20px; }"
        + "h1 { margin: 0; font-size: 36px; }"
        + ".content { background-color: #FDF9FD; padding: 30px; text-align: justify; border-radius: 8px; box-shadow: 0 0 15px rgba(0, 0, 0, 0.1); color: #333; }"
        + ".content p { line-height: 1.6; font-size: 16px; margin-bottom: 20px; }"
        + "footer { font-size: 12px; color: #777; text-align: center; padding: 10px; background-color: #ddd; }"
        + "</style>"
        + "</head>"
        + "<body>"
        + "<header>"
        + "<h1>¡Bienvenido a TuEmpresa!</h1>"
        + "</header>"
        + "<div class='content'>"
        + "<p>" + contenidoEmail + "</p>"
        + "</div>"
        + "<footer>© 2024 TuEmpresa | Todos los derechos reservados</footer>"
        + "</body>"
        + "</html>";

        helper.setText(cuerpoConDiseno, true);


        javaMailSender.send(mimeMessage);
    }
}
