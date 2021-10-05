package com.example.demo.controller;

import com.example.demo.model.Carrello;
import com.example.demo.model.Prenotazioni;
import com.example.demo.service.PrenotazioniService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PrenotazioniController {

    @Autowired

    private PrenotazioniService prenotazioniService;

    @GetMapping("api/get-prenotazione")
    public List<Prenotazioni> getPrenotazioni(){
        return prenotazioniService.getPrenotazioni();
    }

    @GetMapping("api/get-prenotazione/{id}")
    public Prenotazioni getPrenotazioniById(@PathVariable("id") Integer id){
        return prenotazioniService.getPrenotazioniById(id);
    }

    @PostMapping("api/save-prenotazione")
    public void savePrenotazione(@RequestBody @NotNull List<Prenotazioni> prenotazioni){
        prenotazioniService.saveOrUpdatePrenotazioni(prenotazioni);
    }

    @DeleteMapping("api/cancella-prenotazione")
    public void deletePrenotazioni(@RequestBody @NotNull List<Prenotazioni> prenotazioni){
        prenotazioniService.deletePrenotazioni(prenotazioni);
    }

    @DeleteMapping("api/cancella-prenotazione/{id}")
    public void deletePrenotazioniById(@PathVariable("id") Integer id){
        prenotazioniService.deletePrenotazioniById(id);
    }

}