/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cobranca.entity;

import java.util.Date;

/**
 *
 * @author Vinicius
 */
public class Divida {
    
    private int id;
    private double valor;
    private String devedor;
    private Date dataCadstro;
    private Date dataUltimaCobranca;
    private String status;
    private String procedimento;
    private String telefone;
    private String endereco;
    private String numero;
    private String bairro;
    private String CPF;
    private String Cidade;
    private String celular;
    private String uf;
    private String rg;

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDevedor() {
        return devedor;
    }

    public void setDevedor(String devedor) {
        this.devedor = devedor;
    }

    public Date getDataCadstro() {
        return dataCadstro;
    }

    public void setDataCadstro(Date dataCadstro) {
        this.dataCadstro = dataCadstro;
    }

    public Date getDataUltimaCobranca() {
        return dataUltimaCobranca;
    }

    public void setDataUltimaCobranca(Date dataUltimaCobranca) {
        this.dataUltimaCobranca = dataUltimaCobranca;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }
    
    
    
}
