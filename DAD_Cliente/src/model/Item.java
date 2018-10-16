package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.hibernate.annotations.ManyToAny;


@Entity
public class Item implements Serializable{
    
    private static final long serialVersion = 1L;
    
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="idProduto")
    private Produto produto;
    private int qtd;

    public Item(Long id, Produto produto, int qtd) {
        this.id = id;
        this.produto = produto;
        this.qtd = qtd;
    }

    public Item() {
    }
    
    

    public Produto getProduto() {
        return produto;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    public double getTotalItem(){
        return produto.getValor()*qtd;
    }
    
}