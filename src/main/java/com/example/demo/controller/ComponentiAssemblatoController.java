package com.example.demo.controller;

import com.example.demo.model.ComponentiAssemblato;
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

    @GetMapping("api/get-componentiAssemblato")
    public List<ComponentiAssemblato> getComponentiAssemblato(){
        return componentiAssemblatoService.getComponentiAssemblato();
    }

    @GetMapping("api/get-componentiAssemblato/{id}")
    public ComponentiAssemblato getComponentiAssemblatoById(@PathVariable("id") Integer id){
        return componentiAssemblatoService.getComponentiAssemblatoById(id);
    }

    @PostMapping("api/save-componentiAssemblato")
    public void saveComponentiAssemblato(@RequestBody @NotNull List<ComponentiAssemblato> componentiAssemblato){
        componentiAssemblatoService.saveOrUpdateComponentiAssemblato(componentiAssemblato);
    }

    @DeleteMapping("api/cancella-componentiAssemblato")
    public void deleteComponentiAssemblato(@RequestBody @NotNull List<ComponentiAssemblato> componentiAssemblati){
        componentiAssemblatoService.deleteComponentiAssemblato(componentiAssemblati);
    }

    @DeleteMapping("api/cancella-componenteAssemblato/{id}")
    public void deleteComponentiAssemblatoById(@PathVariable("id") Integer id){
        componentiAssemblatoService.deleteComponentiAssemblatoById(id);
    }

}