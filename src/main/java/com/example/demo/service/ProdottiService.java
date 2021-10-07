package com.example.demo.service;


import com.example.demo.dao.ProdottiDao;
import com.example.demo.model.Prodotti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProdottiService {

    @Autowired
    private ProdottiDao prodottiDao;

    public List<Prodotti> getProdotti(){
        return prodottiDao.getProdotti();
    }

    public Prodotti getProdottiById(Integer id){
        return prodottiDao.getProdottiById(id);
    }

    public void saveOrUpdateProdotti(List<Prodotti> prodotti){
        prodottiDao.saveOrUpdateProdotti(prodotti);
    }

    public void deleteProdotti(List<Prodotti> prodotti){
        prodottiDao.deleteProdotti(prodotti);
    }

    public void deleteProdottiById(Integer id){
        prodottiDao.deleteProdottiById(id);
    }
}
