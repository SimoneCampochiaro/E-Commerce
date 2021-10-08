package com.example.demo.service;


import com.example.demo.dao.FornitoriDao;
import com.example.demo.model.Fornitori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FornitoriService {

    @Autowired
    private FornitoriDao fornitoriDao;

    public List<Fornitori> getFornitori(){
        return fornitoriDao.getFornitori();
    }

    public Fornitori getFornitoriById(Integer id){
        return fornitoriDao.getFornitoriById(id);
    }

    public void saveOrUpdateFornitori(List<Fornitori> fornitori){
        fornitoriDao.saveOrUpdateFornitori(fornitori);
    }

    public void deleteFornitori(List<Fornitori> fornitori){
        fornitoriDao.deleteFornitori(fornitori);
    }

    public void deleteFornitoriById(Integer id){
        fornitoriDao.deleteFornitortiById(id);
    }
}
