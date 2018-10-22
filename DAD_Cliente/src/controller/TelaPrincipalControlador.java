/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaPrincipal;

/**
 *
 * @author davidborges
 */
public class TelaPrincipalControlador {
    private TelaPrincipal tela;
    
    public TelaPrincipalControlador(){
        this.tela = new TelaPrincipal();
        this.tela.setVisible(true);   
        this.tela.btnCompra(new BtnCompra());
        this.tela.btnProduto(new BtnProduto());
    }
    
    class BtnProduto implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            tela.setVisible(false);
            ProdutoControlador controlador = new ProdutoControlador();
        }    
    }   
    
    class BtnCompra implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            tela.setVisible(false);
            ItemCompraControlador controlador = new ItemCompraControlador();
        }    
    }  
    
}
