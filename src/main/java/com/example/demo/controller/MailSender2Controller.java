package com.example.demo.controller;

import com.example.demo.utils.MailSender2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping
public class MailSender2Controller {
    @Autowired
    private MailSender2 mailSender2;

    @PostMapping("/send-email/{dest}/{ogg}/{mess}")
    public void sendMmail(@PathVariable("dest") String dest, @PathVariable("ogg") String ogg, @PathVariable("mess") String mess){
       mailSender2.send(dest,ogg,mess);
    }
}
