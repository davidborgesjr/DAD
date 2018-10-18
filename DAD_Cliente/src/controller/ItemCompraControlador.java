/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.ICarrinhoBean;
import ejb.IProdutoService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import model.Item;
import model.ItemCompraTabelaModelo;
import model.Produto;
import view.TelaGerenciarCompra;

/**
 *
 * @author davidborges
 */
public final class ItemCompraControlador {
    private final TelaGerenciarCompra tela;
    private List<Item> lista;
    private InitialContext contexto;
    private ICarrinhoBean service;
    private IProdutoService service2;
    
    public ItemCompraControlador(){
        this.tela = new TelaGerenciarCompra();
        this.tela.setVisible(true);        
        this.IniciarService();
        this.carregar();
        this.popularCombo();
        this.tela.btnIncluir(new BtnIncluir());
        this.tela.btnExcluir(new BtnExcluir());
        this.tela.btnFinalizar(new BtnFinalizar());
    }
    
    public void IniciarService(){
        try {
            this.contexto = new InitialContext(); 
            this.service2 = (IProdutoService) contexto.lookup("ejb:/ExercicioStateless/ProdutoService!ejb.IProdutoService?stateless");            
            this.service = (ICarrinhoBean) contexto.lookup("ejb:/DAD_EJB_stateful/CarrinhoBean!ejb.ICarrinhoBean?stateful");            
        } catch (NamingException ex) {
            Logger.getLogger(ProdutoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }           
    }
    
    public final void carregar() {
        this.lista = this.service.listar(); 
        this.setModeloTabela();
    }
    
    public void setModeloTabela(){
        ItemCompraTabelaModelo modelo = new ItemCompraTabelaModelo(this.lista);
        this.tela.setTabelaItem(modelo);      
    }
    
    public void popularCombo(){
        List<Produto> lista2 = this.service2.listar();
        
        for(Produto produto:lista2){
            String codigo = String.valueOf(produto.getIdProduto());
            String nome = produto.getNome();
            this.tela.carregarProdutos(codigo+"-"+nome);
        }                
    }
    
    public void finalizar(){
        
    }
    
    public void removerItem(){
        
    }
    
    class BtnIncluir implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
    class BtnFinalizar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {            
            finalizar();
        }    
    }
    
    class BtnExcluir implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            removerItem();
            carregar();
        }        
    }    
    
}
