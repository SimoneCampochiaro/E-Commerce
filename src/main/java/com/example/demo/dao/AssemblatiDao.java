package com.example.demo.dao;


import com.example.demo.model.ComponentiAssemblato;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.List;

@Repository
public class AssemblatiDao {

    @Autowired
    private EntityManager entityManager;

    public List<Assemblati> getAssemblati() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM Assemblati", Assemblati.class).getResultList();
    }

    public Assemblati getAssemblatiById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Assemblati a = currentSession.find(Assemblati.class, id);
        return a;
    }

    public void saveOrUpdateAssemblati(List<Assemblati> assemblati) {
        Session currentSession = entityManager.unwrap(Session.class);

        for (Assemblati a : assemblati) {
            currentSession.saveOrUpdate(a);
        }
    }

    public void deleteAssemblati(List<Assemblati> assemblati) {
        Session currentSession = entityManager.unwrap(Session.class);
        for (Assemblati a : assemblati) {
            currentSession.delete(currentSession.find(Assemblati.class, ca.getIdAssemblati()));
        }
    }

    public void deleteAssemblati(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.delete(currentSession.find(Assemblati.class, id));
    }

}