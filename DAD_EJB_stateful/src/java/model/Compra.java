
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Compra implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int compraId;
    
    @OneToMany
    private List<Item> itens;
    private Calendar dataCompra;
   
    
    public Compra(){
        itens = new ArrayList<Item>();
    }

    public Calendar getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Calendar dataCompra) {
        this.dataCompra = dataCompra;
    }

    
    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
    
    public Double getTotalGeral(){
        Double totalGeral = 0.0;
        for(Item item: itens){
            totalGeral+= item.getTotalItem();
        }
        return totalGeral;
    }
    
    @Override
    public boolean equals(Object obj) {
        Compra compra = (Compra) obj;
        return this.itens.equals(compra.itens);
    }

    public int getCompraId() {
        return compraId;
    }

    public void setCompraId(int compraId) {
        this.compraId = compraId;
    }
    
    
    
}
