package com.example.demo.controller;

import com.example.demo.model.ProdottiAssemblato;
import com.example.demo.service.ComponentiAssemblatoService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ComponentiAssemblatoController {

    @Autowired

    private ComponentiAssemblatoService componentiAssemblatoService;

    @GetMapping("/get-componentiAssemblato")
    public List<ProdottiAssemblato> getComponentiAssemblato(){
        return componentiAssemblatoService.getComponentiAssemblato();
    }

    @GetMapping("/get-componentiAssemblato/{id}")
    public ProdottiAssemblato getComponentiAssemblatoById(@PathVariable("id") Integer id){
        return componentiAssemblatoService.getComponentiAssemblatoById(id);
    }

    @PostMapping("/save-componentiAssemblato")
    public void saveComponentiAssemblato(@RequestBody @NotNull List<ProdottiAssemblato> prodottiAssemblatoes){
        componentiAssemblatoService.saveOrUpdateComponentiAssemblato(prodottiAssemblatoes);
    }

    @DeleteMapping("/cancella-componentiAssemblato")
    public void deleteComponentiAssemblato(@RequestBody @NotNull List<ProdottiAssemblato> componentiAssemblati){
        componentiAssemblatoService.deleteComponentiAssemblato(componentiAssemblati);
    }

    @DeleteMapping("/cancella-componenteAssemblato/{id}")
    public void deleteComponentiAssemblatoById(@PathVariable("id") Integer id){
        componentiAssemblatoService.deleteComponentiAssemblatoById(id);
    }

}