package com.example.demo.dao;
import com.example.demo.model.ProdottiNelCarrello;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class ProdottiNelCarrelloDao {

    @Autowired
    private EntityManager entityManager;

    public List<ProdottiNelCarrello> getProdottiNelCarrello() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM ProdottiNelCarrello", ProdottiNelCarrello.class).getResultList();
    }

    public ProdottiNelCarrello getProdottiNelCarrelloById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        ProdottiNelCarrello p = currentSession.find(ProdottiNelCarrello.class, id);
        return p;
    }

    public void saveOrUpdateProdottiNelCarrello(ProdottiNelCarrello prodottiNelCarrello) {
        Session currentSession = entityManager.unwrap(Session.class);

            currentSession.saveOrUpdate(prodottiNelCarrello);

    }

    public void deleteProdottiNelCarrello(List<ProdottiNelCarrello> prodottiNelCarrello) {
        Session currentSession = entityManager.unwrap(Session.class);
        for (ProdottiNelCarrello p : prodottiNelCarrello) {
            currentSession.delete(currentSession.find(ProdottiNelCarrello.class, p.getIdProdottoNelCarrello()));
        }
    }

    public void deleteProdottiNelCarrelloById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.delete(currentSession.find(ProdottiNelCarrello.class, id));
    }
}
