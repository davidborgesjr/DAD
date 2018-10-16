    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;


/**
 *
 * @author Adriano
 */
public interface ICarrinho extends Remote {
    
   
    public Item inserir(Item item) throws RemoteException;
    public Item remover(Item item) throws RemoteException;
    public List<Item> lista(Item item) throws RemoteException;
    
}
