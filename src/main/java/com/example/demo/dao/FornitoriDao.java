package com.example.demo.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class FornitoriDao {

    @Autowired
    private EntityManager entityManager;

    public List<Fornitori> getFornitori() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM Fornitori", Fornitori.class).getResultList();
    }

    public Fornitori getFornitoriById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Fornitori f = currentSession.find(Fornitori.class, id);
        return f;
    }
    /*public void saveOrUpdateFornitori(List<Fornitori> progettis) {
        Session currentSession = entityManager.unwrap(Session.class);
        Session updateSession = entityManager.unwrap(Session.class);

        for (Progetti p : progettis) {
            for (Dipendenti d : p.getDipendentis()) {
                d.setProgettis(progettis);
                updateSession.saveOrUpdate(d);
            }
            currentSession.saveOrUpdate(p);
        }
    }*/

    public void deleteFornitori(List<Fornitori> fornitori) {
        Session currentSession = entityManager.unwrap(Session.class);
        for (Fornitori f : fornitori) {
            currentSession.delete(currentSession.find(Fornitori.class, f.getIdFornitori()));
        }
    }

    public void deleteFornitortiById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.delete(currentSession.find(Fornitori.class, id));
    }

}
