package ejb;




import java.rmi.Remote;
import java.util.List;
import model.Produto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public interface IProdutoService extends Remote{

    public void inserir(Produto p);
    public void remover(Produto p);
    public  List<Produto> listar();
}
