package com.example.demo.dao;


import com.example.demo.model.Carrello;
import com.example.demo.model.Clienti;
import com.example.demo.model.Ordini;
import com.example.demo.model.ProdottiNelCarrello;
import org.hibernate.Session;
import org.hibernate.query.Query;
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

    public List<String> getOrdiniWhere() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<String> query = currentSession.createQuery("SELECT p.componente FROM Prodotti p INNER JOIN p.prodottiNelCarrello pc INNER JOIN pc.carrello c INNER JOIN c.ordini o INNER JOIN o.clienti ac" +
                " WHERE (p.idProdotto = pc.idProdottoNelCarrello) AND (pc.idProdottoNelCarrello = c.idCarrello) AND (c.idCarrello = o.carrello.idCarrello)" +
                " AND (o.clienti.idCliente = ac.idCliente) AND ac.idCliente = 2 ", String.class);
        System.out.println(query);
        return query.getResultList();
    }
    /*
    *
    * public List<Prenotazioni> getPrenotazioniByIdUtente(Integer id){
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Prenotazioni> query = currentSession.createQuery("FROM Prenotazioni WHERE anagrafica.idAnagrafica = :id", Prenotazioni.class);
        query.setParameter("id", id);
        return query.getResultList();
    }*/



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
