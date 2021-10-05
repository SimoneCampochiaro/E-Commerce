package com.example.demo.service;

import com.example.demo.dao.PrenotazioniDao;
import com.example.demo.model.Prenotazioni;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PrenotazioniService {
    @Autowired

    private PrenotazioniDao prenotazioniDao;

    public List<Prenotazioni> getPrenotazioni(){
        return prenotazioniDao.getPrenotazioni();
    }

    public Prenotazioni getPrenotazioniById(Integer id){
        return prenotazioniDao.getPrenotazioniById(id);
    }

    public void saveOrUpdatePrenotazioni(List<Prenotazioni> prenotazioni){
        prenotazioniDao.saveOrUpdatePrenotazioni(prenotazioni);
    }

    public void deletePrenotazioni(List<Prenotazioni> prenotazioni){
        prenotazioniDao.deletePrenotazioni(prenotazioni);
    }

    public void deletePrenotazioniById(Integer id){
        prenotazioniDao.deletePrenotazioniById(id);
    }
}
