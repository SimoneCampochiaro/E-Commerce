package com.example.demo.controller;

import com.example.demo.model.ProdottiAssemblato;
import com.example.demo.service.ProdottiAssemblatoService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
public class ProdottiAssemblatoController {

    @Autowired

    private ProdottiAssemblatoService prodottiAssemblatoService;

    @GetMapping("/get-componentiAssemblato")
    public List<ProdottiAssemblato> getComponentiAssemblato(){
        return prodottiAssemblatoService.getComponentiAssemblato();
    }

    @GetMapping("/get-componentiAssemblato/{id}")
    public ProdottiAssemblato getComponentiAssemblatoById(@PathVariable("id") Integer id){
        return prodottiAssemblatoService.getComponentiAssemblatoById(id);
    }

    @PostMapping("/save-componentiAssemblato")
    public void saveComponentiAssemblato(@RequestBody @NotNull List<ProdottiAssemblato> prodottiAssemblatoes){
        prodottiAssemblatoService.saveOrUpdateComponentiAssemblato(prodottiAssemblatoes);
    }

    @DeleteMapping("/cancella-componentiAssemblato")
    public void deleteComponentiAssemblato(@RequestBody @NotNull List<ProdottiAssemblato> componentiAssemblati){
        prodottiAssemblatoService.deleteComponentiAssemblato(componentiAssemblati);
    }

    @DeleteMapping("/cancella-componenteAssemblato/{id}")
    public void deleteComponentiAssemblatoById(@PathVariable("id") Integer id){
        prodottiAssemblatoService.deleteComponentiAssemblatoById(id);
    }

}