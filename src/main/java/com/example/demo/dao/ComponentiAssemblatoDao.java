package com.example.demo.dao;


import com.example.demo.model.ProdottiAssemblato;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.*;
import java.util.List;

@Repository
public class ComponentiAssemblatoDao {

    @Autowired
    private EntityManager entityManager;

    public List<ProdottiAssemblato> getComponentiAssemblato() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM ProdottiAssemblato", ProdottiAssemblato.class).getResultList();
    }

    public ProdottiAssemblato getComponentiAssemblatoById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        ProdottiAssemblato ca = currentSession.find(ProdottiAssemblato.class, id);
        return ca;
    }

    public void saveOrUpdateComponentiAssemblato(List<ProdottiAssemblato> prodottiAssemblatoes) {
        Session currentSession = entityManager.unwrap(Session.class);

        for (ProdottiAssemblato ca : prodottiAssemblatoes) {
            currentSession.saveOrUpdate(ca);
        }
    }

    public void deleteComponentiAssemblato(List<ProdottiAssemblato> prodottiAssemblatoes) {
        Session currentSession = entityManager.unwrap(Session.class);
        for (ProdottiAssemblato ca : prodottiAssemblatoes) {
            currentSession.delete(currentSession.find(ProdottiAssemblato.class, ca.getIdComponentiAssemblato()));
        }
    }

    public void deleteComponentiAssemblatoById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.delete(currentSession.find(ProdottiAssemblato.class, id));
    }

}
