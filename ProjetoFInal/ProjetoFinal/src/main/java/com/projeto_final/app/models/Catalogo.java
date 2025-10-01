package com.projeto_final.app.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Catalogo implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCatalogo;
    private String nomeCatalogo;
    private String descricaoCatalogo;

    @ManyToOne
    @JoinColumn(name = "idEmpresa", nullable = false)
    private Empresa empresa;

    @OneToMany(mappedBy = "catalogo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> itens;

    public Catalogo() {
    }

    public long getIdCatalogo() {
        return this.idCatalogo;
    }

    public void setIdCatalogo(long idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public String getNomeCatalogo() {
        return this.nomeCatalogo;
    }

    public void setNomeCatalogo(String nomeCatalogo) {
        this.nomeCatalogo = nomeCatalogo;
    }

    public String getDescricaoCatalogo() {
        return this.descricaoCatalogo;
    }

    public void setDescricaoCatalogo(String descricaoCatalogo) {
        this.descricaoCatalogo = descricaoCatalogo;
    }

     public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Item> getItem() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

}
