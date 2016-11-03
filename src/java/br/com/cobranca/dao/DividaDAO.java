/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cobranca.dao;

import br.com.cobranca.entity.Divida;
import br.com.cobranca.util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Vinicius
 */
public class DividaDAO {
    
    private final String INSERT = "INSERT INTO Divida (idDevedor,IdCliente,valordivida,status,observacao,datacadastro) VALUES(?,?,?,?,?,CURDATE())";
    
    /**
     * Metodo para cadastrar uma nova divida
     * @param divida 
     */
    public Divida CadastrarDivida(Divida divida){
        Conexao conexao = new Conexao();
        PreparedStatement ps = null;
        
        try{
            ps = conexao.conectar().prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
             ps.setInt(1, divida.getDevedor().getId());
             ps.setInt(2, divida.getCliente().getId());
             ps.setDouble(3, divida.getValorDivida());
             ps.setString(4, divida.getStatus());
             ps.setString(5, divida.getObservacao());
             
             ps.execute();
             ResultSet rs = ps.getGeneratedKeys();
             
             if(rs.next()){
                 divida.setId(rs.getInt(1));
             }
             
        }catch(Exception e){
            System.out.println("Erro: " + e );
        }finally{
            conexao.desconectar();
        }
     
        return divida;
    }
    
}
