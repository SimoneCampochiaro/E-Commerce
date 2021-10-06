package com.example.demo.service;

import com.example.demo.dao.ComponentiAssemblatoDao;
import com.example.demo.model.ProdottiAssemblato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ComponentiAssemblatoService {

    @Autowired
    private ComponentiAssemblatoDao componentiAssemblatoDao;

    public List<ProdottiAssemblato> getComponentiAssemblato(){
        return componentiAssemblatoDao.getComponentiAssemblato();
    }

    public ProdottiAssemblato getComponentiAssemblatoById(Integer id){
        return componentiAssemblatoDao.getComponentiAssemblatoById(id);
    }

    public void saveOrUpdateComponentiAssemblato(List<ProdottiAssemblato> prodottiAssemblatoes){
        componentiAssemblatoDao.saveOrUpdateComponentiAssemblato(prodottiAssemblatoes);
    }

    public void deleteComponentiAssemblato(List<ProdottiAssemblato> prodottiAssemblatoes){
        componentiAssemblatoDao.deleteComponentiAssemblato(prodottiAssemblatoes);
    }

    public void deleteComponentiAssemblatoById(Integer id){
        componentiAssemblatoDao.deleteComponentiAssemblatoById(id);
    }
}