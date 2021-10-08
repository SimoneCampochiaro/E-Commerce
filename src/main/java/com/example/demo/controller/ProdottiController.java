package com.example.demo.controller;

import com.example.demo.model.Prodotti;
import com.example.demo.service.ProdottiService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@CrossOrigin //url localhost??
@RestController
@RequestMapping//("/product") //usare jsv?
public class ProdottiController {

    @Autowired
    private ProdottiService prodottiService;
    @GetMapping("/get-prodotti")
    public List<Prodotti> getProdotti() {
        return prodottiService.getProdotti();
    }
/*
    public Map<Integer, Prodotti> convertList(List<Prodotti> list) {
        Map<Integer, Prodotti> map = list.stream().collect(Collectors.toMap(Prodotti::getIdProdotto,
                Function.identity()));
        return map;
    }

*/
    @GetMapping("/get-prodotti/{id}")
    public Prodotti getProdottiById(@PathVariable("id") Integer id){
        return prodottiService.getProdottiById(id);
    }

    @PostMapping("/save-prodotti")
    public void saveProdotti(@RequestBody @NotNull List<Prodotti> prodotti){
        prodottiService.saveOrUpdateProdotti(prodotti);
    }

    @DeleteMapping("/cancella-prodotti")
    public void deleteProdotti(@RequestBody @NotNull List<Prodotti> prodotti){
        prodottiService.deleteProdotti(prodotti);
    }

    @DeleteMapping("/cancella-prodotti/{id}")
    public void deleteProdottiById(@PathVariable("id") Integer id){
        prodottiService.deleteProdottiById(id);
    }


}
