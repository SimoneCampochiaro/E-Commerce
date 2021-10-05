package com.example.demo.dao;


import com.example.demo.model.ComponentiAssemblato;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.List;

@Repository
public class ComponentiAssemblatoDao {

    @Autowired
    private EntityManager entityManager;

    public List<ComponentiAssemblato> getComponentiAssemblato() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM ComponentiAssemblato", ComponentiAssemblato.class).getResultList();
    }

    public ComponentiAssemblato getComponentiAssemblatoById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        ComponentiAssemblato ca = currentSession.find(ComponentiAssemblato.class, id);
        return ca;
    }

    public void saveOrUpdateComponentiAssemblato(List<ComponentiAssemblato> componentiAssemblato) {
        Session currentSession = entityManager.unwrap(Session.class);

        for (ComponentiAssemblato ca : componentiAssemblato) {
            currentSession.saveOrUpdate(ca);
        }
    }

    public void deleteComponentiAssemblato(List<ComponentiAssemblato> componentiAssemblato) {
        Session currentSession = entityManager.unwrap(Session.class);
        for (ComponentiAssemblato ca : componentiAssemblato) {
            currentSession.delete(currentSession.find(ComponentiAssemblato.class, ca.getIdComponentiAssemblato()));
        }
    }

    public void deleteComponentiAssemblatoById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.delete(currentSession.find(ComponentiAssemblato.class, id));
    }

}
