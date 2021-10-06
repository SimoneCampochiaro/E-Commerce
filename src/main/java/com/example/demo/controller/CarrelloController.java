package com.example.demo.controller;

import com.example.demo.model.Carrello;
import com.example.demo.service.CarrelloService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CarrelloController {

    @Autowired

    private CarrelloService carrelloService;

    @GetMapping("/get-carrello")
    public List<Carrello> getCarrello(){
        return carrelloService.getCarrello();
    }

    @GetMapping("/get-carrello/{id}")
    public Carrello getCarrelloById(@PathVariable("id") Integer id){
        return carrelloService.getCarrelloById(id);
    }

    @PostMapping("/save-carrello")
    public void saveDipendenti(@RequestBody @NotNull List<Carrello> carrello){
        carrelloService.saveOrUpdateCarrello(carrello);
    }

    @DeleteMapping("/cancella-carrello")
    public void deleteCarrello(@RequestBody @NotNull List<Carrello> carrello){
        carrelloService.deleteCarrello(carrello);
    }

    @DeleteMapping("/cancella-carrello/{id}")
    public void deleteCarrelloById(@PathVariable("id") Integer id){
        carrelloService.deleteCarrelloById(id);
    }

}