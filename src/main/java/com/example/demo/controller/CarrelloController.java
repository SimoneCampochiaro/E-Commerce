package com.example.demo.controller;

import com.example.demo.model.Carrello;
import com.example.demo.model.Clienti;
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

    @GetMapping("api/get-carrello")
    public List<Carrello> getCarrello(){
        return carrelloService.getCarrello();
    }

    @GetMapping("api/get-carrello/{id}")
    public Carrello getCarrelloById(@PathVariable("id") Integer id){
        return carrelloService.getCarrelloById(id);
    }

    @PostMapping("api/save-carrello")
    public void saveDipendenti(@RequestBody @NotNull List<Carrello> carrello){
        carrelloService.saveOrUpdateCarrello(carrello);
    }

    @DeleteMapping("api/cancella-carrello")
    public void deleteCarrello(@RequestBody @NotNull List<Carrello> carrello){
        carrelloService.deleteCarrello(carrello);
    }

    @DeleteMapping("api/cancella-carrello/{id}")
    public void deleteCarrelloById(@PathVariable("id") Integer id){
        carrelloService.deleteCarrelloById(id);
    }

}