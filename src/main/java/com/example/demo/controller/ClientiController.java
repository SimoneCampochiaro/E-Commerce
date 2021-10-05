package com.example.demo.controller;

import com.example.demo.model.Clienti;
import com.example.demo.service.ClientiService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ClientiController {

    @Autowired

    private ClientiService clientiService;

    @GetMapping("api/get-cliente")
    public List<Clienti> getClienti(){
        return clientiService.getClienti();
    }

    @GetMapping("api/get-cliente/{id}")
    public Clienti getClientiById(@PathVariable("id") Integer id){
        return clientiService.getClientiById(id);
    }

    @PostMapping("api/save-cliente")
    public void saveClienti(@RequestBody @NotNull List<Clienti> clienti){
        clientiService.saveOrUpdateClienti(clienti);
    }

    @DeleteMapping("api/cancella-cliente")
    public void deleteClienti(@RequestBody @NotNull List<Clienti> clienti){
        clientiService.deleteClienti(clienti);
    }

    @DeleteMapping("api/cancella-cliente/{id}")
    public void deleteClientiById(@PathVariable("id") Integer id){
        clientiService.deleteClientiById(id);
    }

}
