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

    public ProdutoDAO() {

    }

    /* Faz o select com a cláusula where, seguindo em ordem de colunas como na query de criação de tabelas. Quando true, o campo será selecionado, quando false, não. O último parâmetro deve ser passado como em um comando sql, respeitando as aspas e a própria linguagem*/
    public ArrayList selectWithWhere(boolean first, boolean second, boolean third, boolean fourth, boolean fifth, boolean sixth, boolean seventh, String where) throws SQLException {
        String query;
        ResultSet result;
        Produto[] produto = new Produto[10];
        String resultado = "";
        String[] vetorResultado;
        ArrayList retorno = new ArrayList();
        int controle = 0;
        int cont;
        int lintCont = 0;

        query = "SELECT ";
        if (first == true) {
            query += "ID, ";
            controle++;
        }
        if (second == true) {
            query += "NOME, ";
            controle++;
        }
        if (third == true) {
            query += "DESCRICAO, ";
            controle++;
        }
        if (fourth == true) {
            query += "PRECO, ";
            controle++;
        }
        if (fifth == true) {
            query += "LOJA, ";
            controle++;
        }
        if (sixth == true) {
            query += "IMAGEM, ";
            controle++;
        }
        if (seventh == true) {
            query += "LINK, ";
            controle++;
        }
        query = query.substring(0, query.length() - 2);
        query += " FROM PRODUTOS WHERE " + where;
        result = DBAccess.ExecuteQueryReturn(query);
        if (result != null) {
            while (result.next()) {//está lançando nullpointer se nada for encontrado
                for (cont = 1; cont <= controle; cont++) {
                    resultado += result.getString(cont) + "#";
                }

                //adiciona o resultado em um objeto do tipo Produto
                vetorResultado = resultado.split("#");

                produto[lintCont] = new Produto();

                produto[lintCont].setNome(resultado.split("#")[1]);
                produto[lintCont].setDesc(resultado.split("#")[2]);
                produto[lintCont].setLink(resultado.split("#")[6]);
                produto[lintCont].setImg(resultado.split("#")[5]);
                produto[lintCont].setPreco(resultado.split("#")[3]);
                produto[lintCont].setLoja(resultado.split("#")[4]);

                retorno.add(produto[lintCont]);
                
                resultado = "";
                lintCont++;
            }
        }

        return retorno;

    }
}
