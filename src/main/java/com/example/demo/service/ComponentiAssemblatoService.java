package com.example.demo.service;

import com.example.demo.dao.CarrelloDao;
import com.example.demo.dao.ComponentiAssemblatoDao;
import com.example.demo.model.Carrello;
import com.example.demo.model.ComponentiAssemblato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ComponentiAssemblatoService {

    @Autowired

    private ComponentiAssemblatoDao componentiAssemblatoDao;

    public List<ComponentiAssemblato> getComponentiAssemblato(){
        return componentiAssemblatoDao.getComponentiAssemblato();
    }

    public ComponentiAssemblato getComponentiAssemblatoById(Integer id){
        return componentiAssemblatoDao.getComponentiAssemblatoById(id);
    }

    public void saveOrUpdateComponentiAssemblato(List<ComponentiAssemblato> componentiAssemblato){
        componentiAssemblatoDao.saveOrUpdateComponentiAssemblato(componentiAssemblato);
    }

    public void deleteComponentiAssemblato(List<ComponentiAssemblato> componentiAssemblato){
        componentiAssemblatoDao.deleteComponentiAssemblato(componentiAssemblato);
    }

    public void deleteComponentiAssemblatoById(Integer id){
        componentiAssemblatoDao.deleteComponentiAssemblatoById(id);
    }
}