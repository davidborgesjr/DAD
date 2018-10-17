/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import model.Compra;
import model.Item;
import model.Produto;

public class CompraDAO {
    
    private EntityManager em;
    
    public CompraDAO(EntityManager em){
        this.em = em;
    }
    
    public void finalizarCompra(Compra compra){
        ItemDAO itemDAO = new ItemDAO(this.em);
        for(Item item: compra.getItens()){
            item.setProduto(em.find(Produto.class, item.getProduto().getIdProduto()));
        }
        for(Item it: compra.getItens()){
            itemDAO.inserir(it);
        }
        this.em.persist(compra);  
    }
    
}
