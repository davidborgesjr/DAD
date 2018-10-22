/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import model.Cliente;

public interface IClienteService {
    public void inserir(Cliente cliente);
    public void remover(Cliente cliente);
    public List<Cliente> listar();
    
}
