package com.example.demo.service;

import com.example.demo.dao.ClientiDao;
import com.example.demo.model.Clienti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientiService {

    @Autowired

    private ClientiDao clientiDao;

    public List<Clienti> getClienti(){
        return clientiDao.getClienti();
    }

    public Clienti getClientiById(Integer id){
        return clientiDao.getClientiById(id);
    }

    public void saveOrUpdateClienti(List<Clienti> clienti){
        clientiDao.saveOrUpdateClienti(clienti);
    }

    public void deleteClienti(List<Clienti> clienti){
        clientiDao.deleteClienti(clienti);
    }

    public void deleteClientiById(Integer id){
        clientiDao.deleteClientiById(id);
    }
}
