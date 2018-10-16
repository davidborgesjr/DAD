package model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Compra implements Serializable{
    
    
    private static final long serialVersion = 1L;
    @Id
    @GeneratedValue
    private int compraId;
    private Calendar dataCompra;
    
    @OneToMany
    private List<Item> itens;

    public Compra() {
        itens = new ArrayList<Item>();
    }
    
    

    public Calendar getDataCompra() {
        return dataCompra;
    }
    public void setDataCompra(Calendar dataCompra) {
        this.dataCompra = dataCompra;
    }

    public int getCompraId() {
        return compraId;
    }

    public void setCompraId(int compraId) {
        this.compraId = compraId;
    }
    
    public Double getTotalGeral(){
        Double totalGeral = 0.0;
        for(Item item: itens){
            totalGeral+=item.getTotalItem();
        }
        return totalGeral;
    }
    
}