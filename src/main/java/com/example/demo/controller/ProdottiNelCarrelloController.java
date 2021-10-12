package com.example.demo.controller;

import com.example.demo.model.Carrello;
import com.example.demo.model.Prodotti;
import com.example.demo.model.ProdottiNelCarrello;
import com.example.demo.service.CarrelloService;
import com.example.demo.service.ProdottiNelCarrelloService;
import com.example.demo.service.ProdottiService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
public class ProdottiNelCarrelloController {

    @Autowired
    private ProdottiNelCarrelloService prodottiNelCarrelloService;
    @Autowired
    private CarrelloService carrelloService;
    @Autowired
    private ProdottiService prodottiService;

    @GetMapping("/get-prodotti-carrello")
    public List<ProdottiNelCarrello> getProdottiNelCarrello(){
        return prodottiNelCarrelloService.getProdottiNelCarrello();
    }

    @GetMapping("/get-prodotti-carrello/{id}")
    public ProdottiNelCarrello getProdottiNelCarrelloById(@PathVariable("id") Integer id){
        return prodottiNelCarrelloService.getProdottiNelCarrelloById(id);
    }

    @PostMapping(value = {"/save-prodotti-carrello/{idProdotto}","/save-prodotti-carrello/{idProdotto}/{idCarrello}"})
    public Carrello saveProdottiNelCarrello(@PathVariable("idProdotto") Integer idProdotto , @PathVariable(value = "idCarrello",required = false) Integer idCarrello){
        Prodotti p = prodottiService.getProdottiById(idProdotto);
        Carrello c = null;
        if(idCarrello != null){
            c = carrelloService.getCarrelloById(idCarrello);

        }else{
            c= new Carrello();
            c.setDataCarrello(new Date());
        }
        ProdottiNelCarrello pnc = new ProdottiNelCarrello();
        pnc.setProdotti(p);
        pnc.setCarrello(c);
        prodottiNelCarrelloService.saveOrUpdateProdottiNelCarrello(pnc);
        return c;
    }

    @DeleteMapping("/cancella-prodotti-carrello")
    public void deleteProdottiNelCarrello(@RequestBody @NotNull List<ProdottiNelCarrello> prodottiNelCarrello){
        prodottiNelCarrelloService.deleteProdottiNelCarrello(prodottiNelCarrello);
    }

    @DeleteMapping("/cancella-prodotti-carrello/{id}")
    public void deleteProdottiNelCarrelloById(@PathVariable("id") Integer id){
        prodottiNelCarrelloService.deleteProdottiNelCarrelloById(id);
    }

}