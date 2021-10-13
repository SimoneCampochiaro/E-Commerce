package com.example.demo.controller;


import com.example.demo.model.*;
import com.example.demo.service.CarrelloService;
import com.example.demo.service.ClientiService;
import com.example.demo.service.OrdiniService;
import com.example.demo.utils.MailSender2;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
public class OrdiniController {

    @Autowired
    private OrdiniService ordiniService;
    @Autowired
    private CarrelloService carrelloService;
    @Autowired
    private ClientiService clientiService;
    @Autowired
    private MailSender2 mailSender2;

    @GetMapping("/get-ordine")
    public List<Ordini> getOrdini(){
        return ordiniService.getOrdini();
    }

    @GetMapping("/get-ordine/{id}")
    public Ordini getOrdiniById(@PathVariable("id") Integer id){
        return ordiniService.getOrdiniById(id);
    }

    @GetMapping("/get-ordine-where/{id}")
    public List<String> getOrdiniWhere(@PathVariable("id") Integer id){
        return ordiniService.getOrdiniWhere(id);
    }

    @PostMapping("/save-ordine/{idCarrello}/{idCliente}")
    public Ordini saveOrdini(@PathVariable("idCarrello") Integer idCarrello, @PathVariable("idCliente") Integer idCliente){
        Clienti c= clientiService.getClientiById(idCliente);
        Carrello carrello= carrelloService.getCarrelloById(idCarrello);
        Ordini ordine =new Ordini();
        ordine.setClienti(c);
        ordine.setCarrello(carrello);
        LocalDateTime ldt = LocalDateTime.now().plusDays(15);
        ordine.setDataConsegna(Date.from(ldt.atZone(ZoneId.of("Europe/Rome")).toInstant()));
        double totale= 0;
        for(ProdottiNelCarrello pnc : carrello.getProdottiNelCarrello()){
           totale+= pnc.getProdotti().getPrezzoDiVendita();
        }
        ordine.setImporto(totale);
        ordiniService.saveOrUpdateOrdini(ordine);
        String dest = "iacovelli210302@gmail.com";
                //c.getEmail();
        String oggetto= "E-Commerce Comunicazione di Servizio";
        String messaggio="Complimenti!! Hai completato il tuo ordine, ti aspettiamo in negozio per il ritiro delle merce il "+ldt;
        mailSender2.send(dest, oggetto, messaggio);

        return ordine;
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
