/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import model.Item;

public class ItemDAO {
    
    private EntityManager em;

    public ItemDAO(EntityManager em) {
        this.em = em;
    }
    
    public void inserir(Item item){
        this.em.persist(item);
    }
    
}
