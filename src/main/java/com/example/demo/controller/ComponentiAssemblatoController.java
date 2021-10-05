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
public class ComponentiAssemblato {

    @Autowired

    private ComponentiAssemblato componentiAssemblato;

    @GetMapping("/get-componentiAssemblato")
    public List<ComponentiAssemblato> getComponentiAssemblato(){
        return componentiAssemblatoService.getComponentiAssemblato();
    }

    @GetMapping("/get-componentiAssemblato/{id}")
    public ComponentiAssemblati getComponentiAssemblatoById(@PathVariable("id") Integer id){
        return componentiAssemblatoService.getComponentiAssemblatoById(id);
    }

    @PostMapping("/save-componentiAssemblato")
    public void saveComponentiAssemblato(@RequestBody @NotNull List<ComponentiAssemblato> componentiAssemblato){
        componentiAssemblatoService.saveOrUpdateComponentiAssemblato(componentiAssemblato);
    }

    @DeleteMapping("/cancella-componentiAssemblato")
    public void deleteComponentiAssemblato(@RequestBody @NotNull List<ComponentiAssemblato> componentiAssemblati){
        componentiAssemblatoService.deleteComponentiAssemblato(componentiAssemblati);
    }

    @DeleteMapping("/cancella-componenteAssemblato/{id}")
    public void deleteComponentiAssemblatoById(@PathVariable("id") Integer id){
        componentiAssemblatoService.deleteComponentiAssemblatoById(id);
    }

}