package com.example.demo.dao;


import com.example.demo.model.Ordini;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OrdiniDao {

    @Autowired
    private EntityManager entityManager;

    public List<Ordini> getOrdini() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM Ordini", Ordini.class).getResultList();
    }

    public Ordini getOrdiniById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Ordini o = currentSession.find(Ordini.class, id);
        return o;
    }

    public void saveOrUpdateOrdini(List<Ordini> ordini) {
        Session currentSession = entityManager.unwrap(Session.class);

        for (Ordini o : ordini) {
            currentSession.saveOrUpdate(o);
        }
    }

    public void deleteOrdini(List<Ordini> ordini) {
        Session currentSession = entityManager.unwrap(Session.class);
        for (Ordini o : ordini) {
            currentSession.delete(currentSession.find(Ordini.class, o.getIdOrdine()));

        }
    }

    public void deleteAOrdiniById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.delete(currentSession.find(Ordini.class, id));
    }
}
