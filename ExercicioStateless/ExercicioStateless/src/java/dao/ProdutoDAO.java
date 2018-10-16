/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Produto;

/*
link do site: https://www.objectdb.com/java/jpa/query/execute
hibernate
em 10/10/2018
*/

public class ProdutoDAO {
    private EntityManager em;
    
    public ProdutoDAO(EntityManager em){
        this.em = em;
    }
    
    public void inserir(Produto produto){
        this.em.persist(produto);
    }
    
    public void remover(Produto produto){
        produto = this.em.find(Produto.class, produto.getId());
        this.em.remove(produto);
    }
    
    public List<Produto> listar(){
        /*
        Both Query and TypedQuery define a getResultList method, but the version
        of Query returns a result list of a raw type (non generic) 
        instead of a parameterized (generic) type
        */
        
//        TypedQuery<Produto> query =
//            em.createQuery("select p from Produto p", Produto.class);
//        List<Produto> lista = query.getResultList();
        
        Query query = em.createQuery("select p from Produto p");
        List lista = query.getResultList();
        
        
                           
        return lista;
    }
}
