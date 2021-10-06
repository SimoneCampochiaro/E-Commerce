package com.example.demo.controller;

import com.example.demo.model.Componenti;
import com.example.demo.service.ComponentiService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ComponentiController {

    @Autowired
    private ComponentiService componentiService;

    @GetMapping("api/get-componente")
    public List<Componenti> getFornitori() {
        return componentiService.getComponenti();
    }

    @GetMapping("api/get-componente/{id}")
    public Componenti getComponentiById(@PathVariable("id") Integer id){
        return componentiService.getComponentiById(id);
    }

    @PostMapping("api/save-componente")
    public void saveComponenti(@RequestBody @NotNull List<Componenti> componenti){
        componentiService.saveOrUpdateComponenti(componenti);
    }

    @DeleteMapping("api/cancella-componenti")
    public void deleteComponenti(@RequestBody @NotNull List<Componenti> componenti){
        componentiService.deleteComponenti(componenti);
    }

    @DeleteMapping("api/cancella-componenti/{id}")
    public void deleteComponentiById(@PathVariable("id") Integer id){
        componentiService.deleteComponentiById(id);
    }


}
