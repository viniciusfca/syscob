/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cobranca.bean;

import br.com.cobranca.dao.PessoaDAO;
import br.com.cobranca.entity.Pessoa;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Kenneth
 */
@ManagedBean(name="ClienteMB", eager = true)
@ViewScoped
public class ClienteMB {
    
    private PessoaDAO dao;
    private Pessoa pessoa;
    
    public ArrayList<Pessoa> pessoas ;

    public ClienteMB() {
        this.pessoa = new Pessoa();
        this.dao =  new PessoaDAO();
        this.pessoas = new ArrayList<Pessoa>();
    }
    
    public void inserirCliente() {
        
        try {
            
            dao.post(pessoa);
        } catch (Exception ex) {
            Logger.getLogger(ClienteMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    //
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
}
