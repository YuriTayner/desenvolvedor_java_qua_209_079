package com.projeto_final.app.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Item implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idItem;
    private String nomeItem;
    private String descricaoItem;
    private double precoItem;
    private Boolean disponivel;

    @ManyToOne
    @JoinColumn(name = "idCatalogo", nullable = false)
    private Catalogo catalogo;

    public Item() {
    }

    public long getIdItem() {
        return this.idItem;
    }

    public void setIdItem(long idItem) {
        this.idItem = idItem;
    }

    public String getNomeItem() {
        return this.nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getDescricaoItem() {
        return this.descricaoItem;
    }

    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public double getPrecoItem() {
        return this.precoItem;
    }

    public void setPrecoItem(double precoItem) {
        this.precoItem = precoItem;
    }

    public Boolean isDisponivel() {
        return this.disponivel;
    }

    public Boolean getDisponivel() {
        return this.disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Catalogo getCatalogo() {
        return this.catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

}
