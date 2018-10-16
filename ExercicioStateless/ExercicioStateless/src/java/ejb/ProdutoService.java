package ejb;



import dao.ProdutoDAO;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Produto;

@Remote(IProdutoService.class)
@Stateless
public class ProdutoService implements IProdutoService{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void inserir(Produto produto) {
        ProdutoDAO dao = new ProdutoDAO(this.em);        
        dao.inserir(produto);
    }

    @Override
    public void remover(Produto produto) {
        ProdutoDAO dao = new ProdutoDAO(this.em);
        dao.remover(produto);
    }
    
    @Override
    public List<Produto> listar() {
        ProdutoDAO dao = new ProdutoDAO(this.em);
        return dao.listar();
    }
}
