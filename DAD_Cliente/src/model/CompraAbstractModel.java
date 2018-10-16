/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Compra;

/**
 *
 * @author davidborges
 */
public class CompraAbstractModel extends AbstractTableModel{
    List<Compra> listaCompras = new ArrayList<>();
    String[] colunas = {"Código da compra", "Data da compra"};
    
    public CompraAbstractModel(List<Compra> listaCompras ){
        this.listaCompras = listaCompras;        
    }
    
    @Override
    public int getRowCount() {
        return listaCompras.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Compra compra = listaCompras.get(rowIndex);
        switch(columnIndex){
            case 0: return compra.getCompraId();
            case 1: return compra.getDataCompra();
        }
        return false;
    }
    
     @Override
    public String getColumnName(int row){
        return this.colunas[row];        
    }
    
}
