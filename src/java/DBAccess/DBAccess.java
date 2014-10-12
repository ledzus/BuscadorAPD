/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Matheus
 */
public class DBAccess {
    public static void ExecuteQueryNonReturn(String query){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
                String url = "jdbc:derby://localhost:1527/sample";
                Connection conn;
                conn = DriverManager.getConnection(url, "app", "app");
                Statement statement;
                statement = conn.createStatement();
                statement.executeUpdate(query);
                conn.close();
        } catch (ClassNotFoundException ex) {
                System.err.println("Classe do driver não encontrada!");
            } catch (SQLException ex) {
                System.err.println("SQLException!");
            }
        
    }
    
    public static ResultSet ExecuteQueryReturn(String query){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
                String url = "jdbc:derby://localhost:1527/sample";
                Connection conn;
                conn = DriverManager.getConnection(url, "app", "app");
                Statement statement;
                statement = conn.createStatement();
                ResultSet resultados;
                resultados = statement.executeQuery(query);
                return resultados;
                //conn.close();
                
        } catch (ClassNotFoundException ex) {
                System.err.println("Classe do driver não encontrada!");
            } catch (SQLException ex) {
                System.err.println("SQLException!");
            }
        return null;
      }
}
