package com.example.demo.dao;

import com.example.demo.model.Prodotti;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.*;
import java.util.List;

@Repository
public class ProdottiDao {


    @Autowired
    private EntityManager entityManager;

    public List<Prodotti> getProdotti() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM Prodotti", Prodotti.class).getResultList();
    }

    public Prodotti getProdottiById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Prodotti p = currentSession.find(Prodotti.class, id);
        return p;
    }

    public void saveOrUpdateProdotti(List<Prodotti> prodotti) {
        Session currentSession = entityManager.unwrap(Session.class);

        for (Prodotti p : prodotti) {
            currentSession.saveOrUpdate(p);
        }
    }

    public void deleteProdotti(List<Prodotti> prodotti) {
        Session currentSession = entityManager.unwrap(Session.class);
        for (Prodotti p : prodotti) {
            currentSession.delete(currentSession.find(Prodotti.class, p.getIdProdotto()));
        }
    }

    public void deleteProdottiById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.delete(currentSession.find(Prodotti.class, id));
    }
}
