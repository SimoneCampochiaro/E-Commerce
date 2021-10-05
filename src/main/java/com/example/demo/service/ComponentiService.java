package com.example.demo.service;


import com.example.demo.dao.ComponentiDao;
import com.example.demo.model.Componenti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ComponentiService {

    @Autowired
    private ComponentiDao componentiDao;

    public List<Componenti> getComponenti(){
        return componentiDao.getComponenti();
    }

    public Componenti getComponentiById(Integer id){
        return componentiDao.getComponentiById(id);
    }

    public void saveOrUpdateComponenti(List<Componenti> componenti){
        componentiDao.saveOrUpdateComponenti(componenti);
    }

    public void deleteComponenti(List<Componenti> componenti){
        componentiDao.deleteComponenti(componenti);
    }

    public void deleteComponentiById(Integer id){
        componentiDao.deleteComponentiById(id);
    }
}
