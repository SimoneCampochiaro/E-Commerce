/*
package com.example.demo.controller;


import com.example.demo.utils.MailSender2;
import com.example.demo.utils.eMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping
public class eMailSenderController {

        @Autowired
        private eMailSender emailSender;

        @PostMapping("/send-email/{dest}")
        public void sendMail(@PathVariable("dest") String dest){
            emailSender.send2(dest);
        }
    }

}
*/
