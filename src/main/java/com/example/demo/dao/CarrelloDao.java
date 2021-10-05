package com.example.demo.dao;

import com.example.demo.model.Carrello;
import com.example.demo.model.Clienti;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CarrelloDao {
    @Autowired

        private EntityManager entityManager;

        public List<Carrello> getCarrello(){
            Session currentSession = entityManager.unwrap(Session.class);
            return currentSession.createQuery("FROM Carrello", Carrello.class).getResultList();
        }

        public Carrello getCarrelloById(Integer id){
            Session currentSession = entityManager.unwrap(Session.class);
            Carrello cr = currentSession.find(Carrello.class, id);
            return cr;
        }

        public void saveOrUpdateCarrello(List<Carrello> carrello){
            Session currentSession = entityManager.unwrap(Session.class);
            for(Carrello cr: carrello){
                currentSession.saveOrUpdate(cr);
            }
        }

        public void deleteCarrello(List<Carrello> carrello){
            Session currentSession = entityManager.unwrap(Session.class);
            for(Carrello cr: carrello){
                currentSession.delete(currentSession.find(Clienti.class,cr.getIdCarrello()));
            }
        }

        public void deleteCarrelloById(Integer id){
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.delete(currentSession.find(Carrello.class, id));
        }
}
