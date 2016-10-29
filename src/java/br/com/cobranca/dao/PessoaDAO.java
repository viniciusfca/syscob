/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cobranca.dao;

import br.com.cobranca.entity.Pessoa;
import br.com.cobranca.util.Conexao;
import br.com.cobranca.util.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Vinicius
 */
public class PessoaDAO {

    
    public Pessoa get(int id) throws Exception {

        Conexao conexao = new Conexao();
        Pessoa p = new Pessoa();
        
        try {

            String strSql = "SELECT * FROM PESSOA WHERE ID = ?";
            PreparedStatement ps = conexao.conectar().prepareStatement(strSql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = Util.atribuirValores(Pessoa.class, rs);
            }

            rs.close();
            ps.close();

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {
            conexao.desconectar();
        }

        return p;
    }
    
    public ArrayList<Pessoa> get(String tipo) throws Exception {

        Conexao conexao = new Conexao();
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

        try {

            String strSql = "SELECT * FROM PESSOA WHERE TIPO = ?";
            PreparedStatement ps = conexao.conectar().prepareStatement(strSql);

            ps.setString(1, tipo);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Pessoa p = Util.atribuirValores(Pessoa.class, rs);
                pessoas.add(p);

            }

            rs.close();
            ps.close();

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {
            conexao.desconectar();
        }

        return pessoas;
    }

    public int post(Pessoa pessoa) throws Exception {

        Conexao conexao = new Conexao();
        int id = 0;

        try {
            
            //Retirar as máscaras
            pessoa.setCpf(Util.retirarMascara(pessoa.getCpf()));
            pessoa.setCelular(Util.retirarMascara(pessoa.getCelular()));
            pessoa.setTelefone(Util.retirarMascara(pessoa.getTelefone()));
            
            id = Util.inserirRegistro(pessoa, conexao.conectar());

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {
            conexao.desconectar();
        }

        return id;
    }

    public boolean put(Pessoa pessoa) throws Exception {

        Conexao conexao = new Conexao();
        try {

            String strSQL = "UPDATE PESSOA SET NOME = ?, SET BAIRRO = ? WHERE ID = ? AND TIPO = ?"; // Falta finalizar
            PreparedStatement ps = conexao.conectar().prepareStatement(strSQL);
            
            //Set
            ps.setString(1, pessoa.getNome());
            
            //Where
            ps.setInt(2, pessoa.getId());
            ps.setString(3, pessoa.getTipo());
            
            int qtdLinhasAfetadas = ps.executeUpdate();

            ps.close();
            
            if (qtdLinhasAfetadas > 0) {
                return true;
            }
            
            else{
                return false;
            }
            
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {
            conexao.desconectar();
        }

    }
    
    public boolean delete(int id) throws Exception {
    
        Conexao conexao = new Conexao();
        try {

            String strSQL = "DELETE FROM PESSOA WHERE ID = ?";
            PreparedStatement ps = conexao.conectar().prepareStatement(strSQL);
            
            //Where
            ps.setInt(1, id);
            
            int qtdLinhasAfetadas = ps.executeUpdate();

            ps.close();
            
            if (qtdLinhasAfetadas > 0) {
                return true;
            }
            
            else{
                return false;
            }
            
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {
            conexao.desconectar();
        }
    }
}
