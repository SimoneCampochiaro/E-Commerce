package com.example.demo.interfaces;

import com.example.demo.model.Assemblati;
import com.example.demo.model.Prodotti;

public interface MagazzinoProdotti {

    void addComponenti(Prodotti prodotti, int quantita) throws Exception;

    void addAssemblato(Assemblati assemblati, int quantita) throws Exception;

    void deleteComponenti(Prodotti prodotti, int quantita) throws Exception;

    void deleteAssemblati(Prodotti prodotti, int quantita) throws Exception;

    double prezzoTotale();

}
