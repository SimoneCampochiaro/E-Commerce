package com.example.demo.utils;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


@Component
public class MailSender2 {
    private final static String SMTP_HOST = "smtp.libero.it";
    private final static String SMTP_PORT = "465";
    private final static String SMTP_AUTH = "true";
    private final static String SMTP_USER = "e-commerce-jaba37@libero.it";
    private final static String SMTP_PWD = "37Jaba37!";

    public void send(String destinatario, String oggetto, String messaggio){
        try {
            InternetAddress address = new InternetAddress(destinatario);
            Properties props = new Properties();
            props.put("mail.smtp.host", SMTP_HOST);
            props.put("mail.smtp.auth", SMTP_AUTH);
            props.put("mail.smtp.port", SMTP_PORT);
            props.put("mail.smtp.starttls.enable", "true");
            Authenticator auth = new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(SMTP_USER, SMTP_PWD);
                }
            };
            Session session = Session.getDefaultInstance(props, auth);
            Message msg = new MimeMessage(session);
            InternetAddress addressFrom = new InternetAddress(SMTP_USER);
            msg.setFrom(addressFrom);
            msg.setRecipient(Message.RecipientType.TO, address);
            msg.setSubject(oggetto);
            msg.setText(messaggio);
            Transport.send(msg);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
