/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.rmi.RemoteException;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateful;

import model.ICarrinho;
import model.Item;

/**
 *
 * @author Aluno
 */

@Stateful
@Remote(ICarrinho.class)
public class ItemService implements ICarrinho{

    @Override
    public Item inserir(Item item) throws RemoteException {
       
       List<Item> itens = null;
       item.setProduto("Arros");
       item.setValor(2.50);
       item.setQTD(2);
       itens.add(item);
       return (Item) itens;
       
    }

    @Override
    public Item remover(Item item) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Item> lista(Item item) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


