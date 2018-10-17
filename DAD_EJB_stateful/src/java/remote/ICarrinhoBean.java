/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import java.util.List;
import model.Compra;
import model.Item;

public interface ICarrinhoBean {
    public void inserir(Item item);
    public void remover(Item item);
    public List<Item> listar();
    public void finalizarCompra(Compra compra);
    
}
