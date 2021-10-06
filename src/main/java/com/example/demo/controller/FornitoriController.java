package com.example.demo.controller;


import com.example.demo.model.Fornitori;
import com.example.demo.service.FornitoriService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class FornitoriController {

    @Autowired
    private FornitoriService fornitoriService;

    @GetMapping("/get-fornitore")
    public List<Fornitori> getFornitori() {

        return fornitoriService.getFornitori();
    }

    @GetMapping("/get-fornitore/{id}")
    public Fornitori getFornitoriById(@PathVariable("id") Integer id){
        return fornitoriService.getFornitoriById(id);
    }

    @PostMapping("/save-fornitore")
    public void saveFornitori(@RequestBody @NotNull List<Fornitori> fornitori){
        fornitoriService.saveOrUpdateFornitori(fornitori);
    }

    @DeleteMapping("/cancella-fornitore")
    public void deleteFornitori(@RequestBody @NotNull List<Fornitori> fornitori){
        fornitoriService.deleteFornitori(fornitori);
    }

    @DeleteMapping("/cancella-fornitore/{id}")
    public void deleteFornitoriById(@PathVariable("id") Integer id){
        fornitoriService.deleteFornitoriById(id);
    }
}
