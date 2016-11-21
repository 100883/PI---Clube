/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classededados.Socio;
import conexaobd.Conexao;
import java.sql.Connection;
import interfaces.CRUD;
/**
 *
 * @author Gui Freitas
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Gui Freitas
 */
public class SocioPersistencia implements CRUD{
    private Connection conectar = null;
    public SocioPersistencia(){
        conectar = Conexao.getConexao();
    }

    @Override
    public void incluir(Socio objeto) throws SQLException {
        String comando = "insert into Contatos(nome,telefone,email)values(?,?,?)";
        PreparedStatement ps = conectar.prepareStatement(comando);
        ps.setString(1, objeto.getNome());
        ps.setLong(2, objeto.getTelefone());
        ps.setString(3, objeto.getEmail());
        ps.executeUpdate();
    }

    @Override
    public void excluir(String nome) throws SQLException {
        String comando = "delete from  Contatos where  nome=?";
        PreparedStatement ps = conectar.prepareStatement(comando);
        ps.setString(1, nome);
        ps.executeUpdate();
    }

    @Override
    public void alterar(Socio objeto) throws SQLException {
        String comando = "update  Contatos set telefone=?,email=? where nome=?";
        PreparedStatement ps = conectar.prepareStatement(comando);
        ps.setString(3, objeto.getNome());
        ps.setLong(1, objeto.getTelefone());
        ps.setString(2, objeto.getEmail());
        ps.executeUpdate();
    }

    @Override
    public Socio consultar(String nome) throws SQLException {
        String comando = "select * from Contatos where nome = ?";
        PreparedStatement ps = conectar.prepareStatement(comando);
        ps.setString(1, nome);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            Socio pessoa = new Socio();
            pessoa.setNome(rs.getString("nome"));
            pessoa.setTelefone((int) rs.getLong("telefone"));
            pessoa.setEmail(rs.getString("email"));
            return pessoa;
        }
        return null;
    }

    @Override
    public ArrayList listar() throws SQLException {
       ArrayList dados = new ArrayList();
        String comando = "select * from Contatos";
        PreparedStatement ps = conectar.prepareStatement(comando);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Socio pessoa = new Socio();
            pessoa.setNome(rs.getString("nome"));
            pessoa.setTelefone((int)rs.getLong("telefone"));
            pessoa.setEmail(rs.getString("email"));
            dados.add(pessoa);
        }
        return dados;

    }
    
}
