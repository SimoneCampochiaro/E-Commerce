package com.example.demo.service;


import com.example.demo.dao.ComponentiDao;
import com.example.demo.model.Prodotti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ComponentiService {

    @Autowired
    private ComponentiDao componentiDao;

    public List<Prodotti> getComponenti(){
        return componentiDao.getComponenti();
    }

    public Prodotti getComponentiById(Integer id){
        return componentiDao.getComponentiById(id);
    }

    public void saveOrUpdateComponenti(List<Prodotti> prodotti){
        componentiDao.saveOrUpdateComponenti(prodotti);
    }

    public void deleteComponenti(List<Prodotti> prodotti){
        componentiDao.deleteComponenti(prodotti);
    }

    public void deleteComponentiById(Integer id){
        componentiDao.deleteComponentiById(id);
    }
}
