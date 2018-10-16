/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Adriano
 */
public class ProdutoTabelaModelo extends AbstractTableModel {
    private List<Produto> produto;

    public ProdutoTabelaModelo(List<Produto> produto) {
        this.produto = produto;
    }
    
    @Override
    public int getRowCount() {
        return produto.size();
    }
    
    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public String getColumnName(int coluna){
        switch(coluna){
            case 0: 
                return "Codigo";
            case 1:
                return "Produto";                 
            case 2:
                return "Valor";                 
        }
        return null;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Produto prod = this.produto.get(linha);
        switch(coluna){
            case 0:
                return prod.getCodigo();
            case 1:           
                return prod.getNome();
            case 2:                
                return prod.getValor();
        }
        return null;
    }
    
}
