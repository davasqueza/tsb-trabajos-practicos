/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tsb_tp3.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ale
 */
public class BaseDatos {
        private  static BaseDatos instancia;
        private static String dbURL = "jdbc:derby://localhost:1527/tsb_tp4_bd;user=root;password=toor";
                //"jdbc:derby://localhost:1527/myDB;create=true;user=me;password=mine";
        private static String tableName = "restaurants";
        private  Connection conn = null;
 private BaseDatos(){}
 
 public static BaseDatos get(){
 if(instancia==null)
     instancia=new BaseDatos();
 return instancia;
 }
 
 private void conectar(){
 try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); 
        }
        catch (Exception except)
        {
            except.printStackTrace();
        } 
 
 };
 
 public Connection getConexion(){
 return conn;
 }
 
 public void ejecutarSQL(String sql){
 
 };
 
 public ResultSet ejecutarSelect(String sql){
 return null;
 };

 
    
}
