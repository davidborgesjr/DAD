/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.Calendar;
import java.util.List;
import model.Cliente;
import model.Item;

public interface ICarrinhoBean {
    public void inserir(Item item);
    public void remover(Item item);
    public double valorGeral();
    public double valorDesconto();
    public List<Item> listar();
    public void finalizarCompra(Calendar data, Cliente cliente, int desconto);
    
}
