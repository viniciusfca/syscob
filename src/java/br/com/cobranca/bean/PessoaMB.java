/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cobranca.bean;

import br.com.cobranca.dao.PessoaDAO;
import br.com.cobranca.entity.Pessoa;
import br.com.cobranca.util.Util;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "PessoaMB", eager = true)
@ViewScoped
public class PessoaMB {

    private String msg;

    private String tipoConsulta;
    private String valorConsulta;

    private boolean habilitarBotaoIncluir;
    private boolean habilitarBotaoAlterar;

    private final PessoaDAO dao;
    private Pessoa pessoa;

    public ArrayList<Pessoa> pessoas;

    public PessoaMB() {
        this.pessoa = new Pessoa();
        this.dao = new PessoaDAO();
        this.pessoas = new ArrayList<>();

        habilitarBotaoIncluir = true;
        habilitarBotaoAlterar = false;
    }

    private boolean validarPessoa() {

        msg = "";

        if (pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
            msg = "Nome inválido!";
        } else if (pessoa.getCpf() == null || pessoa.getCpf().trim().length() < 11) {
            msg = "CPF inválido!";
        } else if (pessoa.getRg() == null || pessoa.getRg().trim().length() < 9) {
            msg = "RG inválido!";
        } else if (pessoa.getDatanascimento() == null || pessoa.getDatanascimento().getTime() >= (new Date()).getTime()) {
            msg = "Data de Nascimento inválida!";
        } else if (pessoa.getSexo() == null || (!pessoa.getSexo().trim().equals("F") && !pessoa.getSexo().trim().equals("M"))) {
            msg = "Sexo inválido!";
        } else if (pessoa.getEndereco() == null || pessoa.getEndereco().isEmpty()) {
            msg = "Endereço inválido!";
        } else if (pessoa.getNumero() == null || pessoa.getNumero().equals(0l)) {
            msg = "Número inválido!";
        } else if (pessoa.getBairro() == null || pessoa.getBairro().isEmpty()) {
            msg = "Bairro inválido!";
        } else if (pessoa.getCidade() == null || pessoa.getCidade().isEmpty()) {
            msg = "Cidade inválida!";
        } else if (pessoa.getUf() == null) {
            msg = "Estado inválido!";
        } else if (pessoa.getTelefone() == null || pessoa.getTelefone().trim().length() < 10) {
            msg = "Número de telefone inválido!";
        } else if (pessoa.getCelular() == null || pessoa.getCelular().trim().length() < 10) {
            msg = "Número de celular inválido!";
        } else if (pessoa.getEmail() == null || !Util.ValidarEmail(pessoa.getEmail())) {
            msg = "E-mail inválido!";
        } else if (pessoa.getUsername() == null || pessoa.getUsername().isEmpty()) {
            msg = "Usuário inválido!";
        } else if (pessoa.getSenha() == null || pessoa.getSenha().isEmpty()) {
            msg = "Senha inválida!";
        }

        if (msg.equals("")) {
            return true;
        }
        return false;
    }

    public void atualizarPessoa() {

    }

    public void inserirPessoa(String tipo) {

        try {

            if (validarPessoa()) {
                
                pessoa.setTipo(tipo);
                int id = dao.post(pessoa);

                if (id > 0) {
                    msg = "Inclusão realizada com sucesso!";
                } else {
                    msg = "Inclusão não efetuada!";
                }
            }
        } catch (Exception ex) {
            msg = "Erro ao efetuar a inclusão: " + ex.getMessage();
            //Logger.getLogger(PessoaMB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void consultarPessoas(String tipo) {
        
        try {
            pessoas = dao.get(tipoConsulta, valorConsulta, tipo);
        } catch (Exception ex) {
            Logger.getLogger(PessoaMB.class.getName()).log(Level.SEVERE, null, ex);
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public String getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(String valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public boolean isHabilitarBotaoIncluir() {
        return habilitarBotaoIncluir;
    }

    public void setHabilitarBotaoIncluir(boolean habilitarBotaoIncluir) {
        this.habilitarBotaoIncluir = habilitarBotaoIncluir;
    }

    public boolean isHabilitarBotaoAlterar() {
        return habilitarBotaoAlterar;
    }

    public void setHabilitarBotaoAlterar(boolean habilitarBotaoAlterar) {
        this.habilitarBotaoAlterar = habilitarBotaoAlterar;
    }

}
