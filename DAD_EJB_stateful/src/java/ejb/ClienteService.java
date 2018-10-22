/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dao.ClienteDAO;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import model.Cliente;

@Stateful
@Remote(IClienteService.class)
public class ClienteService implements IClienteService{
    private EntityManager em;
    ClienteDAO dao = new ClienteDAO(em);

    @Override
    public void inserir(Cliente cliente) {
        dao.inserir(cliente);
    }

    @Override
    public void remover(Cliente cliente) {
        dao.remover(cliente);}

    @Override
    public List<Cliente> listar() {
        return dao.listar();
    }
}
