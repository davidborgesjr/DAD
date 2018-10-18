/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Produto.FindAll", query="SELECT p FROM Produto p")
public class Produto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduto;
    private String codigo;
    private String nome;
    private Double valor;
    
    public Produto(){}
    
    public Produto(String codigo, String nome, Double valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
    }

    public Produto(int idProduto, String codigo, String nome, Double valor) {
        this.idProduto = idProduto;
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object obj) {
        Produto produto = (Produto) obj;
        return this.nome.equals(produto.getNome());
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
