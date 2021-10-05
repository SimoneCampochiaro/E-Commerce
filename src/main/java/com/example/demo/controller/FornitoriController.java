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

    @GetMapping("api/get-fornitore")
    public List<Fornitori> getFornitori() {

        return fornitoriService.getFornitori();
    }

    @GetMapping("api/get-fornitore/{id}")
    public Fornitori getFornitoriById(@PathVariable("id") Integer id){
        return fornitoriService.getFornitoriById(id);
    }

    @PostMapping("api/save-fornitore")
    public void saveFornitori(@RequestBody @NotNull List<Fornitori> fornitori){
        fornitoriService.saveOrUpdateFornitori(fornitori);
    }

    @DeleteMapping("api/cancella-fornitore")
    public void deleteFornitori(@RequestBody @NotNull List<Fornitori> fornitori){
        fornitoriService.deleteFornitori(fornitori);
    }

    @DeleteMapping("api/cancella-fornitore/{id}")
    public void deleteFornitoriById(@PathVariable("id") Integer id){
        fornitoriService.deleteFornitoriById(id);
    }
}
