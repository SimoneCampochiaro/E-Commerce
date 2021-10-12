package com.example.demo.service;

import com.example.demo.dao.ProdottiNelCarrelloDao;
import com.example.demo.model.ProdottiNelCarrello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProdottiNelCarrelloService {
    @Autowired

    private ProdottiNelCarrelloDao prodottiNelCarrelloDao;

    public List<ProdottiNelCarrello> getProdottiNelCarrello(){
        return prodottiNelCarrelloDao.getProdottiNelCarrello();
    }

    public ProdottiNelCarrello getProdottiNelCarrelloById(Integer id){
        return prodottiNelCarrelloDao.getProdottiNelCarrelloById(id);
    }

    public void saveOrUpdateProdottiNelCarrello(ProdottiNelCarrello prodottiNelCarrello){
        prodottiNelCarrelloDao.saveOrUpdateProdottiNelCarrello(prodottiNelCarrello);
    }

    public void deleteProdottiNelCarrello(List<ProdottiNelCarrello> prodottiNelCarrello){
        prodottiNelCarrelloDao.deleteProdottiNelCarrello(prodottiNelCarrello);
    }

    public void deleteProdottiNelCarrelloById(Integer id){
        prodottiNelCarrelloDao.deleteProdottiNelCarrelloById(id);
    }
}
