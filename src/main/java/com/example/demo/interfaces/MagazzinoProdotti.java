package com.example.demo.interfaces;

import com.example.demo.model.Assemblati;
import com.example.demo.model.Componenti;

public interface MagazzinoProdotti {

    void addComponenti(Componenti componenti, int quantita) throws Exception;

    void addAssemblato(Assemblati assemblati, int quantita) throws Exception;

    void deleteComponenti(Componenti componenti, int quantita) throws Exception;

    void deleteAssemblati(Componenti componenti, int quantita) throws Exception;

    double prezzoTotale();

}
