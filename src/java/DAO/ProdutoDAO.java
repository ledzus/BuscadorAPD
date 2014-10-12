/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBAccess.DBAccess;
import Model.Produto;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class ProdutoDAO {
    
    public ProdutoDAO(){
        
    }
    
/* Faz o select com a cláusula where, seguindo em ordem de colunas como na query de criação de tabelas. Quando true, o campo será selecionado, quando false, não. O último parâmetro deve ser passado como em um comando sql, respeitando as aspas e a própria linguagem*/	
public ArrayList selectWithWhere(boolean first, boolean second, boolean third, boolean fourth, boolean fifth, boolean sixth, String where) throws SQLException {
        String query;
        ResultSet result;
        Produto produto;
	String resultado = "";
        String[] vetorResultado;
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
			resultado += result.getString(cont) + "|";
		}
                
                vetorResultado = resultado.split("|");
                
		retorno.add(resultado);
        }
        
        return retorno;
    }    
}









