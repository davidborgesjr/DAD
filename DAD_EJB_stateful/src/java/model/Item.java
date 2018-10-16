/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Aluno
 */
public class Item implements Serializable {
    private  long Uid = 1L;
    private String produto;
    private Double valor;
    private Integer QTD ;

    public Item() {
    }

    public Item(String produto, Double valor, Integer QTD) {
        this.produto = produto;
        this.valor = valor;
        this.QTD = QTD;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQTD() {
        return QTD;
    }

    public void setQTD(Integer QTD) {
        this.QTD = QTD;
    }
    
    
    
}
