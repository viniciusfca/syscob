/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cobranca.dao;

import br.com.cobranca.entity.Devedor;
import br.com.cobranca.util.Conexao;
import br.com.cobranca.util.Util;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Vinicius
 */
public class DevedorDAO {
    
    
    
    public ArrayList<Devedor> get() throws Exception {

        Conexao conexao = new Conexao();
        ArrayList<Devedor> devedores = new ArrayList<Devedor>();

        try {

            String strSql = "SELECT * FROM PESSOA";
            PreparedStatement ps = conexao.conectar().prepareStatement(strSql);

          

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Devedor p = Util.atribuirValores(Devedor.class, rs);
                devedores.add(p);

            }

            rs.close();
            ps.close();

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {
            conexao.desconectar();
        }

        return devedores;
    }
    
     public int post(Devedor devedor) throws Exception {

        Conexao conexao = new Conexao();
        int id = 0;

        try {
            
            devedor.setCpf(Util.retirarMascara(devedor.getCpf()));
            devedor.setCelular(Util.retirarMascara(devedor.getCelular()));
            devedor.setTelefone(Util.retirarMascara(devedor.getTelefone()));
            
            id = Util.inserirRegistro(devedor, conexao.conectar());

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {
            conexao.desconectar();
        }

        return id;
    }
     
     public boolean put(Devedor devedor) throws Exception {

        Conexao conexao = new Conexao();
        try {

            String strSQL = "UPDATE DEVEDOR SET NOME = ? WHERE ID = ? "; // Falta finalizar
            PreparedStatement ps = conexao.conectar().prepareStatement(strSQL);
            
            //Set
            ps.setString(1, devedor.getNome());
            
            //Where
            ps.setInt(2, devedor.getId());
           
            
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
