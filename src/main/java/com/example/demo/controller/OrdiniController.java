package com.example.demo.controller;


import com.example.demo.model.Ordini;
import com.example.demo.service.OrdiniService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
public class OrdiniController {

    @Autowired

    private OrdiniService ordiniService;

    @GetMapping("/get-ordine")
    public List<Ordini> getOrdini(){
        return ordiniService.getOrdini();
    }

    @GetMapping("/get-ordine/{id}")
    public Ordini getOrdiniById(@PathVariable("id") Integer id){
        return ordiniService.getOrdiniById(id);
    }

    @GetMapping("/get-ordine-where")
    public List<Ordini> getOrdiniWhere(){
        return ordiniService.getOrdiniWhere();
    }

    @PostMapping("/save-ordine")
    public void saveOrdini(@RequestBody @NotNull List<Ordini> ordini){
        ordiniService.saveOrUpdateOrdini(ordini);
    }

    @DeleteMapping("/cancella-ordine")
    public void deleteOrdini(@RequestBody @NotNull List<Ordini> ordini){
        ordiniService.deleteOrdini(ordini);
    }

    @DeleteMapping("/cancella-ordine/{id}")
    public void deleteOrdiniById(@PathVariable("id") Integer id){
        ordiniService.deleteOrdiniById(id);
    }



}
