/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.ICarrinhoBean;
import ejb.IClienteService;
import ejb.IProdutoService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import model.Cliente;
import model.Item;
import model.ItemCompraTabelaModelo;
import model.Produto;
import util.DataUtil;
import view.TelaGerenciarCompra;

/**
 *
 * @author davidborges
 */
public final class ItemCompraControlador {
    private final TelaGerenciarCompra tela;
    private List<Item> lista;
    private List<Produto> lista2;
    private List<Cliente> listaCliente;
    private InitialContext contexto;
    private ICarrinhoBean carrinhoService;
    private IProdutoService produtoService;
    private IClienteService clienteService;
    
    public ItemCompraControlador(){
        this.tela = new TelaGerenciarCompra();
        this.tela.setVisible(true);        
        this.IniciarService();        
        this.carregar();
        this.tela.btnIncluir(new BtnIncluir());
        this.tela.btnExcluir(new BtnExcluir());
        this.tela.btnFinalizar(new BtnFinalizar());
        this.tela.btnVoltar(new BtnVoltar());
        this.popularCombo();
    }
    
    public void IniciarService(){
        try {
            this.contexto = new InitialContext(); 
        } catch (NamingException ex) {
            Logger.getLogger(ProdutoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try { 
            this.carrinhoService = (ICarrinhoBean) contexto.lookup("ejb:/DAD_EJB_stateful/CarrinhoBean!ejb.ICarrinhoBean?stateful");
        } catch (NamingException ex) {
            Logger.getLogger(ItemCompraControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public final void carregar() {
        String total = "R$ "+String.valueOf(this.carrinhoService.valorGeral());
        String totalDesconto = "R$ "+String.valueOf(this.carrinhoService.valorDesconto());
        System.out.println("Retorno: "+total+"-"+totalDesconto);
        this.tela.setValorGeral(total);
        this.tela.setValorDesconto(totalDesconto);
        this.lista = this.carrinhoService.listar(); 
        this.setModeloTabela();
    }
    
    public void setModeloTabela(){
        ItemCompraTabelaModelo modelo = new ItemCompraTabelaModelo(this.lista);
        this.tela.setTabelaItem(modelo);      
    }
    
    public void popularCombo(){
        try {            
            this.produtoService = (IProdutoService) contexto.lookup("ejb:/ExercicioStateless/ProdutoService!ejb.IProdutoService");
            this.clienteService = (IClienteService) contexto.lookup("ejb:/DAD_EJB_stateful/ClienteService!ejb.IClienteService?stateful");
        
        } catch (NamingException ex) {
            Logger.getLogger(ItemCompraControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.lista2 = this.produtoService.listar();        
        for(Produto produto:lista2){
            String codigo = String.valueOf(produto.getIdProduto());
            String nome = produto.getNome();
            this.tela.carregarProdutos(codigo+"-"+nome);
        }            
        this.listaCliente = this.clienteService.listar();
        for(Cliente cliente: listaCliente){
            String id = String.valueOf(cliente.getClienteId());
            String nome = cliente.getNome();
            this.tela.carregarClientes(id+" - "+nome);
        }
    }
    
    public void incluirItem(){
        Item item = new Item();
        String produto = this.tela.getItemCompra(); 
        String[] words= produto.split("-");
        int idProduto = 0;
        for(String codigo:words){
            idProduto = Integer.parseInt(codigo);
            break;
        }
        for(Produto p : lista2){
            if(p.getIdProduto() == idProduto){
                int qtde = this.tela.getQtdeItem();
                item.setProduto(p);
                item.setQuantidade(qtde);
                this.carrinhoService.inserir(item);
            }
        }
        this.carregar();
        
        
    }
    
    public void finalizar(){
        Calendar data = DataUtil.ConverterTextoEmCalendar(this.tela.getData());
        int desconto = 1;
        try{
            desconto = Integer.parseInt(this.tela.getDesconto());
        }catch(NumberFormatException e){
            this.tela.enviarMensagem("Somentes numeros podem ser colocados no campo de desconto");
        }
        Cliente cliente = new Cliente();
        String dadosCliente = this.tela.getItemCompra(); 
        String[] words= dadosCliente.split("-");
        int idCliente = 0;
        for(String codigo:words){
            idCliente = Integer.parseInt(codigo);
            break;
        }
        for(Cliente c : listaCliente){
            if(c.getClienteId() == idCliente){
                this.carrinhoService.finalizarCompra(data, cliente, desconto);        
            }
        }
        
        
    }
    
    public void removerItem(){
        
    }
    
    public void voltar(){
        this.tela.setVisible(false);
        TelaPrincipalControlador controladorPrincipal = new TelaPrincipalControlador();
    }
    
    class BtnIncluir implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            incluirItem();
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
    
    class BtnVoltar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            voltar();
        }
        
    }
    
}
