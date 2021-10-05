package com.example.demo.service;

import com.example.demo.dao.CarrelloDao;
import com.example.demo.model.Carrello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AssemblatiService {

    @Autowired

    private AssemblatiDao assemblatiDao;

    public List<Assemblati> getAssemblati(){
        return assemblatiDao.getAssemblati();
    }

    public Assemblati getAssemblatiById(Integer id){
        return assemblatiDao.getAssemblatiById(id);
    }

    public void saveOrUpdateAssemblati(List<Assemblati> assemblati){
        assemblatiDao.saveOrUpdateAssemblati(assemblati);
    }

    public void deleteAssemblati(List<Assemblati> assemblati){
        assemblatiDao.deleteAssemblati(assemblati);
    }

    public void deleteAssemblatiById(Integer id){
        assemblatiDao.deleteAssemblatiById(id);
    }
}
