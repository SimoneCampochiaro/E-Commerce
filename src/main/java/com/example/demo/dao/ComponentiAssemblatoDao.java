pacpackage com.example.demo.dao;

import it.adl.jaba37.model.Ruoli;
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

    public List<componenti_assemblato> getcomponenti_assemblato() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM componenti_assemblato", componenti_assemblato.class).getResultList();
    }

    public componenti_assemblato getcomponenti_assemblatoById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        componenti_assemblato ca = currentSession.find(Ruoli.getcomponenti_assemblato, id);
        return ca;
    }

    public void saveOrUpdatecomponenti_assemblato(List<getcomponenti_assemblato> ruolis) {
        Session currentSession = entityManager.unwrap(Session.class);

        for (componenti_assemblato ca : componentiAssemblato) {
            currentSession.saveOrUpdate(ca);
        }
    }

    public void deletecomponenti_assemblato(List<componenti_assemblato> componentiAssemblato) {
        Session currentSession = entityManager.unwrap(Session.class);
        for (componenti_assemblato ca : componentiAssemblato) {
            currentSession.delete(currentSession.find(componenti_assemblato.class, ca.getid_componente_assemblato()));
        }
    }

    public void deletecomponenti_assemblatoById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.delete(currentSession.find(componenti_assemblato.class, id));
    }

}
