/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dao.CompraDAO;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Compra;
import model.Item;
import remote.ICarrinhoBean;

@Stateful
@Remote(ICarrinhoBean.class)
public class CarrinhoBean implements ICarrinhoBean{
    private Compra compra = new Compra();
    
    private CompraDAO compraDAO;
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void inserir(Item item) {        
        if(compra.getItens().contains(item)){
            for(Item it: compra.getItens()){
                if(it.equals(item)){
                    it.setQuantidade(it.getQuantidade() + item.getQuantidade() );
                    break;
                }
            }
        }
        else{
            compra.getItens().add(item);
        }
    }

    @Override
    public void remover(Item item) {
        compra.getItens().remove(item);
    }

    @Override
    public List<Item> listar() {
        return compra.getItens();
    }
    
    @Override
    public void finalizarCompra(Compra compra){
        compraDAO = new CompraDAO(this.em);
        compraDAO.finalizarCompra(compra);
    
    }
    
}
