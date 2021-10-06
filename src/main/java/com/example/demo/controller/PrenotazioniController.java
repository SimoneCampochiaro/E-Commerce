package com.example.demo.controller;

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

    @GetMapping("/get-prenotazione")
    public List<Prenotazioni> getPrenotazioni(){
        return prenotazioniService.getPrenotazioni();
    }

    @GetMapping("/get-prenotazione/{id}")
    public Prenotazioni getPrenotazioniById(@PathVariable("id") Integer id){
        return prenotazioniService.getPrenotazioniById(id);
    }

    @PostMapping("/save-prenotazione")
    public void savePrenotazione(@RequestBody @NotNull List<Prenotazioni> prenotazioni){
        prenotazioniService.saveOrUpdatePrenotazioni(prenotazioni);
    }

    @DeleteMapping("/cancella-prenotazione")
    public void deletePrenotazioni(@RequestBody @NotNull List<Prenotazioni> prenotazioni){
        prenotazioniService.deletePrenotazioni(prenotazioni);
    }

    @DeleteMapping("/cancella-prenotazione/{id}")
    public void deletePrenotazioniById(@PathVariable("id") Integer id){
        prenotazioniService.deletePrenotazioniById(id);
    }

}