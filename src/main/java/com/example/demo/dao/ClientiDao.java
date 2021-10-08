package com.example.demo.dao;

import com.example.demo.model.Clienti;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ClientiDao {
    @Autowired

    private EntityManager entityManager;

    public List<Clienti> getClienti(){
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM Clienti", Clienti.class).getResultList();
    }

    public Clienti getClientiById(Integer id){
        Session currentSession = entityManager.unwrap(Session.class);
        Clienti c = currentSession.find(Clienti.class, id);
        return c;
    }

    public void saveOrUpdateClienti(List<Clienti> clienti){
        Session currentSession = entityManager.unwrap(Session.class);
        Session updateSession = entityManager.unwrap(Session.class);
        for(Clienti cr: clienti){
            currentSession.saveOrUpdate(cr);
        }
    }

    public void deleteClienti(List<Clienti> clienti){
        Session currentSession = entityManager.unwrap(Session.class);
        for(Clienti c: clienti){
            currentSession.delete(currentSession.find(Clienti.class,c.getIdCliente()));
        }
    }

    public void deleteClientiById(Integer id){
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.delete(currentSession.find(Clienti.class, id));
    }
}
