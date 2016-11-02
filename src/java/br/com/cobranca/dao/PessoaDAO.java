package br.com.cobranca.dao;

import br.com.cobranca.entity.Pessoa;
import br.com.cobranca.util.Conexao;
import br.com.cobranca.util.Util;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PessoaDAO {

    public Pessoa get(int id) throws Exception {

        Conexao conexao = new Conexao();
        Pessoa pessoa = new Pessoa();

        try {

            String strSql = "SELECT * FROM PESSOA WHERE ID = ?";
            PreparedStatement ps = conexao.conectar().prepareStatement(strSql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pessoa = Util.atribuirValores(Pessoa.class, rs);
            }

            rs.close();
            ps.close();

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {
            conexao.desconectar();
        }

        return pessoa;
    }

    public ArrayList<Pessoa> get(String tipoConsulta, String valorConsulta, String tipoPessoa) throws Exception {

        Conexao conexao = new Conexao();
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        try {

            String strSql = "SELECT * FROM PESSOA WHERE TIPO = ? AND " + tipoConsulta + " = ?";
            PreparedStatement ps = conexao.conectar().prepareStatement(strSql);

            ps.setString(1, tipoPessoa);
            ps.setString(2, valorConsulta);

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
            if (validarPessoa(pessoa)) {
                id = Util.inserirRegistro(pessoa, conexao.conectar());
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {
            conexao.desconectar();
        }

        return id;
    }

    public boolean put(Pessoa pessoa) throws Exception {

        Conexao conexao = new Conexao();
        boolean retorno = false;

        try {

            if (validarPessoa(pessoa)) {
                String strWhere = "WHERE ID = " + pessoa.getId();
                retorno = Util.alterarRegistro(pessoa, Pessoa.class, conexao.conectar(), strWhere);
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {
            conexao.desconectar();
        }

        return retorno;
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

            return (qtdLinhasAfetadas > 0);

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {
            conexao.desconectar();
        }
    }

    private boolean validarPessoa(Pessoa pessoa) throws Exception {

        Conexao conexao = new Conexao();
        boolean retorno = false;
        
        try {
            String strSQL = "SELECT * FROM PESSOA WHERE TIPO = ? AND (CPF = ? OR USERNAME = ?)";
            PreparedStatement ps = conexao.conectar().prepareStatement(strSQL);

            //Where
            ps.setString(1, pessoa.getTipo());
            ps.setString(2, pessoa.getCpf());
            ps.setString(3, pessoa.getUsername());

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                retorno = true;
            }

            rs.close();
            ps.close();

            return retorno;

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {
            conexao.desconectar();
        }

    }

}
