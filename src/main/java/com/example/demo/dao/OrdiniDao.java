package com.example.demo.dao;


import com.example.demo.model.Carrello;
import com.example.demo.model.Clienti;
import com.example.demo.model.Ordini;
import com.example.demo.model.ProdottiNelCarrello;
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

    public List<Ordini> getOrdiniWhere() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("SELECT o FROM Prodotti AS p INNER JOIN ProdottiNelCarrello AS pc ON p.idProdotto = pc.idProdottoNelCarrello INNER JOIN Carrello AS c ON pc.idProdottoNelCarrello = c.idCarrello INNER JOIN Ordini AS o ON c.idCarrello = o.carrello.idCarrello INNER JOIN Clienti AS ac ON o.clienti.idCliente = ac.idCliente WHERE ac.idCliente = 2 ", Ordini.class).getResultList();
    }



    public Ordini getOrdiniById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Ordini o = currentSession.find(Ordini.class, id);
        return o;
    }

    public void saveOrUpdateOrdini(Ordini ordini) {
        Session currentSession = entityManager.unwrap(Session.class);

            currentSession.saveOrUpdate(ordini);

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
