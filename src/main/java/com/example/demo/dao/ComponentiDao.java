package com.example.demo.dao;

import com.example.demo.model.Componenti;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.*;
import java.util.List;

@Repository
public class ComponentiDao {


    @Autowired
    private EntityManager entityManager;

    public List<Componenti> getComponenti() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM Componenti",Componenti.class).getResultList();
    }

    public Componenti getComponentiById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Componenti c = currentSession.find(Componenti.class, id);
        return c;
    }

    public void saveOrUpdateComponeti(List<Componenti> componenti) {
        Session currentSession = entityManager.unwrap(Session.class);

        for (Componenti c : componenti) {
            currentSession.saveOrUpdate(c);
        }
    }

    public void deleteComponenti(List<Componenti> componenti) {
        Session currentSession = entityManager.unwrap(Session.class);
        for (Componenti c : componenti) {
            currentSession.delete(currentSession.find(Componenti.class, c.getIdComponente()));
        }
    }

    public void deleteComponentiById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.delete(currentSession.find(Componenti.class, id));
    }
}
