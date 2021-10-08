package com.example.demo.service;

import com.example.demo.dao.CarrelloDao;
import com.example.demo.model.Carrello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarrelloService {

    @Autowired

    private CarrelloDao carrelloDao;

    public List<Carrello> getCarrello(){
        return carrelloDao.getCarrello();
    }

    public Carrello getCarrelloById(Integer id){
        return carrelloDao.getCarrelloById(id);
    }

    public void saveOrUpdateCarrello(List<Carrello> carrello){
        carrelloDao.saveOrUpdateCarrello(carrello);
    }

    public void deleteCarrello(List<Carrello> carrello){
        carrelloDao.deleteCarrello(carrello);
    }

    public void deleteCarrelloById(Integer id){
        carrelloDao.deleteCarrelloById(id);
    }
}
