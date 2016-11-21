/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import classededados.Socio;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Gui Freitas
 */
public interface CRUD {
    public void incluir(Socio objeto)throws SQLException;
    public void excluir(String nome) throws SQLException;
    public void alterar(Socio objeto) throws SQLException;
    public Socio consultar(String nome) throws SQLException;
    public ArrayList listar() throws SQLException;
}
