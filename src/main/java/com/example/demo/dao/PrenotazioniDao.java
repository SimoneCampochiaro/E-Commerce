package com.example.demo.dao;
import com.example.demo.model.Prenotazioni;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class PrenotazioniDao {

    @Autowired
    private EntityManager entityManager;

    public List<Prenotazioni> getPrenotazioni() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM Prenotazioni", Prenotazioni.class).getResultList();
    }

    public Prenotazioni getPrenotazioniById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Prenotazioni p = currentSession.find(Prenotazioni.class, id);
        return p;
    }

    public void saveOrUpdatePrenotazioni(List<Prenotazioni> prenotazioni) {
        Session currentSession = entityManager.unwrap(Session.class);

        for (Prenotazioni p: prenotazioni) {
            currentSession.saveOrUpdate(p);
        }
    }

    public void deletePrenotazioni(List<Prenotazioni> prenotazioni) {
        Session currentSession = entityManager.unwrap(Session.class);
        for (Prenotazioni p : prenotazioni) {
            currentSession.delete(currentSession.find(Prenotazioni.class, p.getIdPrenotazione()));
        }
    }

    public void deletePrenotazioniById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.delete(currentSession.find(Prenotazioni.class, id));
    }
}
