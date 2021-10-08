package com.example.demo.controller;

import com.example.demo.model.ProdottiNelCarrello;
import com.example.demo.service.ProdottiNelCarrelloService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
public class ProdottiNelCarrelloController {

    @Autowired

    private ProdottiNelCarrelloService prodottiNelCarrelloService;

    @GetMapping("/get-prodotti-carrello")
    public List<ProdottiNelCarrello> g(){
        return prodottiNelCarrelloService.getProdottiNelCarrello();
    }

    @GetMapping("/get-prenotazione-carrello/{id}")
    public ProdottiNelCarrello getPrenotazioniById(@PathVariable("id") Integer id){
        return prodottiNelCarrelloService.getProdottiNelCarrelloById(id);
    }

    @PostMapping("/save-prodotti-carrello")
    public void savePrenotazione(@RequestBody @NotNull List<ProdottiNelCarrello> prodottiNelCarrello){
        prodottiNelCarrelloService.saveOrUpdateProdottiNelCarrello(prodottiNelCarrello);
    }

    @DeleteMapping("/cancella-prodotti-carrello")
    public void deletePrenotazioni(@RequestBody @NotNull List<ProdottiNelCarrello> prodottiNelCarrello){
        prodottiNelCarrelloService.deleteProdottiNelCarrello(prodottiNelCarrello);
    }

    @DeleteMapping("/cancella-prodotti-carrello/{id}")
    public void deletePrenotazioniById(@PathVariable("id") Integer id){
        prodottiNelCarrelloService.deleteProdottiNelCarrelloById(id);
    }

}