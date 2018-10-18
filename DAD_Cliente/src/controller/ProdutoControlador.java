/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.IProdutoService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JTable;
import model.Produto;
import model.ProdutoTabelaModelo;
import view.TelaGerenciarProduto;

/**
 *
 * @author Aluno
 */
public final class ProdutoControlador {
    private final TelaGerenciarProduto tela;
    private List<Produto> lista;
    private InitialContext contexto;
    private IProdutoService service;
    
    public void IniciarService(){
        try {
            this.contexto = new InitialContext();           
            this.service = (IProdutoService) contexto.lookup("ejb:/ExercicioStateless/ProdutoService!ejb.IProdutoService?stateless");            
        } catch (NamingException ex) {
            Logger.getLogger(ProdutoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }           
    }
    
    public ProdutoControlador(){
        this.tela = new TelaGerenciarProduto();          
        this.tela.addBtnSalvar(new btnSalvar());
        this.tela.BtnExcluir(new BtnExcluir());
        this.IniciarService();
        this.carregar();
        this.tela.setVisible(true);             
    }
    
    class btnSalvar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {            
            try {
                salvar();
            } catch (NamingException ex) {
                Logger.getLogger(ProdutoControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }
    
    class BtnExcluir implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            removerProduto();
            carregar();
        }        
    }    
     
    public void removerProduto(){
        String codigo, nome;
        int resposta;
        resposta = this.tela.enviarMensagemConfirmacao("Deseja excluir o produto?");
        System.out.println("Valor da resposta"+resposta);
        if(resposta == 0){
            codigo = this.tela.getCodigo();
            nome = this.tela.getNome();                
            for(Produto p: this.lista){
                String pCodigo = p.getCodigo();
                String pNome = p.getNome();
                if(pCodigo.equals(codigo) && pNome.equals(nome)){                               
                    this.service.remover(p);
                    this.tela.enviarMensagem("Produto excluido com sucesso!");
                    break;
                }            
            }
            
        }
        
    }
    
    public void salvar() throws NamingException{
        this.service.inserir(this.tela.getProduto());       
        this.lista = this.service.listar();
        this.setModeloTabela();
    }
    
    public final void carregar() {
        this.lista = this.service.listar(); 
        this.setModeloTabela();
    }
    
    public void setModeloTabela(){
        ProdutoTabelaModelo modelo = new ProdutoTabelaModelo(this.lista);
        this.tela.setTabelaProduto(modelo);
    }
    
    
    
}
