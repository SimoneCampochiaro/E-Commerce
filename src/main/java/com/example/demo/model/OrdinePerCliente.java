package com.example.demo.model;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "ordinepercliente")
@Data

public class OrdinePerCliente {
    @Id
    private String componente;

    public String getPrezzoVendita() {
        return prezzoVendita.toString();
    }

    private Double prezzoVendita;




}
