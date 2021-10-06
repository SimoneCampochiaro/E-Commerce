package com.example.demo.dao;

import com.example.demo.model.Prodotti;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.*;
import java.util.List;

@Repository
public class ComponentiDao {


    @Autowired
    private EntityManager entityManager;

    public List<Prodotti> getComponenti() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM Prodotti", Prodotti.class).getResultList();
    }

    public Prodotti getComponentiById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Prodotti c = currentSession.find(Prodotti.class, id);
        return c;
    }

    public void saveOrUpdateComponenti(List<Prodotti> prodotti) {
        Session currentSession = entityManager.unwrap(Session.class);

        for (Prodotti c : prodotti) {
            currentSession.saveOrUpdate(c);
        }
    }

    public void deleteComponenti(List<Prodotti> prodotti) {
        Session currentSession = entityManager.unwrap(Session.class);
        for (Prodotti c : prodotti) {
            currentSession.delete(currentSession.find(Prodotti.class, c.getIdComponente()));
        }
    }

    public void deleteComponentiById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.delete(currentSession.find(Prodotti.class, id));
    }
}
