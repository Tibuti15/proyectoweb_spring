package com.utc.proyecto1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarCorreoBienvenida(String destinatario, String nombreUsuario) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(destinatario);
        mensaje.setSubject("¡Bienvenido a Proyecto1!");
        mensaje.setText("Hola " + nombreUsuario + ",\n\n" +
                "Tu cuenta ha sido creada exitosamente. " +
                "Ya puedes iniciar sesión en nuestro sistema.\n\n" +
                "Saludos cordiales.");

        mailSender.send(mensaje);
    }
}