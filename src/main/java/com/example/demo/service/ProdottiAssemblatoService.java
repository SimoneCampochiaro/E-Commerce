package com.example.demo.service;

import com.example.demo.dao.ProdottiAssemblatoDao;
import com.example.demo.model.ProdottiAssemblato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProdottiAssemblatoService {

    @Autowired
    private ProdottiAssemblatoDao prodottiAssemblatoDao;

    public List<ProdottiAssemblato> getComponentiAssemblato(){
        return prodottiAssemblatoDao.getComponentiAssemblato();
    }

    public ProdottiAssemblato getComponentiAssemblatoById(Integer id){
        return prodottiAssemblatoDao.getComponentiAssemblatoById(id);
    }

    public void saveOrUpdateComponentiAssemblato(List<ProdottiAssemblato> prodottiAssemblatoes){
        prodottiAssemblatoDao.saveOrUpdateComponentiAssemblato(prodottiAssemblatoes);
    }

    public void deleteComponentiAssemblato(List<ProdottiAssemblato> prodottiAssemblatoes){
        prodottiAssemblatoDao.deleteComponentiAssemblato(prodottiAssemblatoes);
    }

    public void deleteComponentiAssemblatoById(Integer id){
        prodottiAssemblatoDao.deleteComponentiAssemblatoById(id);
    }
}