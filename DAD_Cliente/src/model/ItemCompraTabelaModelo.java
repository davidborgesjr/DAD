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
public class ItemCompraTabelaModelo extends AbstractTableModel {
    private List<Item> item;

    public ItemCompraTabelaModelo(List<Item> item) {
        this.item = item;
    }
    
    @Override
    public int getRowCount() {
        return item.size();
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
            case 3:                
                return "Quantidade"; 
            case 4:
                return "Total";
        }
        return null;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Item item = this.item.get(linha);
        switch(coluna){
            case 0:
                return item.getProduto().getCodigo();
            case 1:           
                return item.getProduto().getNome();
            case 2:                
                return item.getProduto().getValor();
            case 3:                
                return item.getQuantidade();
            case 4:
                return item.getTotalItem();
        }
        return null;
    }
    
}
