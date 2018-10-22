/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Cliente;

public class ClienteDAO { 
    private final EntityManager em;
    
    public ClienteDAO(EntityManager em){
        this.em = em;
    }
    
    public void inserir(Cliente cliente){
        this.em.persist(cliente);
    }
    
    public void remover(Cliente cliente){
        cliente = this.em.find(Cliente.class, cliente.getClienteId());
        this.em.remove(cliente);
    }
    
    public List<Cliente> listar(){        
        Query query = em.createQuery("select c from Cliente c");
        System.out.println("Dentro do listar: "+query.getParameters());
        List lista = query.getResultList();
        return lista;
    }
}
