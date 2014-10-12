/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import DBAccess.DBAccess;
import java.util.ArrayList;

/**
 *
 * @author Matheus
 */
public class ProdutoDAO {
    
    public ProdutoDAO(){
        
    }
    
	/* Faz o select sem a cláusula where, seguindo em ordem de colunas como na query de criação de tabelas. Quando true, o campo será selecionado, quando false, não. */	
    public ArrayList selectNonWhere(boolean first, boolean second, boolean third, boolean fourth, boolean fifth, boolean sixth) throws SQLException {
        String query;
        ResultSet result;
	String resultado = "";
	ArrayList retorno = new ArrayList();
	int controle = 0;
	int cont;
               
        query = "SELECT ";
	if (first == true){
		query += "ID, ";
		controle++;
	}
	if (second == true){
		query += "NOME, ";
		controle++;
	}
	if (third == true){
		query += "EMAIL, ";
		controle++;
	}
	if (fourth == true){
		query += "CEP, ";
		controle++;
	}
	if (fifth == true){
		query += "TIPO, ";
		controle++;
	}
	if (sixth == true){
		query += "TELEFONE, ";
		controle++;
	}
	query = query.substring(0,query.length()-2);
	query += " FROM USUARIOS";
        result = DBAccess.ExecuteQueryReturn(query);
        System.out.println(result.next());
        while (result.next()){
		for(cont=1;cont<=controle;cont++){
			resultado += result.getString(cont) + "| ";
		}
		retorno.add(resultado);
        }
        
        return retorno;
    }

/* Faz o select com a cláusula where, seguindo em ordem de colunas como na query de criação de tabelas. Quando true, o campo será selecionado, quando false, não. O último parâmetro deve ser passado como em um comando sql, respeitando as aspas e a própria linguagem*/	
public ArrayList selectWithWhere(boolean first, boolean second, boolean third, boolean fourth, boolean fifth, boolean sixth, String where) throws SQLException {
        String query;
        ResultSet result;
	String resultado = "";
	ArrayList retorno = new ArrayList();
	int controle = 0;
	int cont;
               
        query = "SELECT ";
	if (first == true){
		query += "ID, ";
		controle++;
	}
	if (second == true){
		query += "NOME, ";
		controle++;
	}
	if (third == true){
		query += "EMAIL, ";
		controle++;
	}
	if (fourth == true){
		query += "CEP, ";
		controle++;
	}
	if (fifth == true){
		query += "TIPO, ";
		controle++;
	}
	if (sixth == true){
		query += "TELEFONE, ";
		controle++;
	}
	query = query.substring(0,query.length()-2);
	query += " FROM USUARIOS WHERE " + where;
        result = DBAccess.ExecuteQueryReturn(query);
        while (result.next()){//está lançando nullpointer se nada for encontrado
		for(cont=1;cont<=controle;cont++){
			resultado += result.getString(cont) + " | ";
		}
		retorno.add(resultado);
        }
        
        return retorno;
    }
	/* Parâmetros devem ser passados como strings normais, sem se preocupar com a linguagem sql */	
	public void create(String nome, String email, String cep, String tipo, String telefone) throws SQLException {
        String query;
			               
        query = "INSERT INTO USUARIOS(NOME, EMAIL, CEP, TIPO, TELEFONE) VALUES('" + nome + "','" + email + "','" + cep + "','" + tipo + "','" + telefone + "')";
	
	DBAccess.ExecuteQueryNonReturn(query);
        
    	}

	/* Parâmetro deve ser passado respeitando a linguagem sql */
	public void delete(String where) throws SQLException {
        String query;
			               
        query = "DELETE FROM USUARIOS WHERE " + where;
	
	DBAccess.ExecuteQueryNonReturn(query);
        
    	}
	
	/* Parâmetro deve ser passado normalmente sem preocupação com o sql em campo e valor, porém em where, a linguagem deve ser respeitada */
	public void update(String campo, String valor, String where) throws SQLException {
        String query;
			               
        query = "UPDATE USUARIOS SET " + campo.toUpperCase() + " = " + valor + " WHERE " + where;
	
	DBAccess.ExecuteQueryNonReturn(query);
        
    	}
    
}









