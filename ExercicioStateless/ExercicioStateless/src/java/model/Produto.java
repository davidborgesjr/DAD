package model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(
            name="Produto",
            query="SELECT p FROM Produto p"
    ) 
public class Produto implements Serializable{
    
    private static final long serialVersion = 1L;
    @Id
    @GeneratedValue
    private int id;
    private String codigo;
    private String nome;
    private double valor;

    public Produto(int id, String codigo, String nome, double valor) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
    }

    public Produto() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
