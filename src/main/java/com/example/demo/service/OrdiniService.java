package com.example.demo.service;

import com.example.demo.dao.OrdiniDao;
import com.example.demo.model.Ordini;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdiniService {

    @Autowired

    private OrdiniDao ordiniDao;

    public List<Ordini> getOrdini(){
        return ordiniDao.getOrdini();
    }

    public Ordini getOrdiniById(Integer id){
        return ordiniDao.getOrdiniById(id);
    }

    public void saveOrUpdateOrdini(List<Ordini> ordini){
        ordiniDao.saveOrUpdateOrdini(ordini);
    }

    public void deleteOrdini(List<Ordini> ordini){
        ordiniDao.deleteOrdini(ordini);
    }

    public void deleteOrdiniById(Integer id){
        ordiniDao.deleteAOrdiniById(id);
    }

    public List<Ordini> getOrdiniWhere(){ return ordiniDao.getOrdiniWhere();}
}
