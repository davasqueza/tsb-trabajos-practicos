/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tsb_tp3.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ale
 */
public class BaseDatos {
        
        private static String dbURL = "jdbc:derby:tsb_tp4_bd;create=true;user=app;password=app";
     //   private static String dbURL ="jdbc:derby://localhost:1527/tsb_tp3_bd";       
        
        private static  Connection conn = null;
        private static Statement stmt = null;
 private BaseDatos(){}
 
 
 private static void  conectar(){
 try
        {   
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); 
        }
        catch (Exception except)
        {
            except.printStackTrace();
        } 
 
 };
 
 public static Connection getConexion(){
     if(conn==null){
     conectar();
     }
 return conn;
 }
 
 public static void ejecutarSQL(String sql){
 try
        {
            stmt = getConexion().createStatement();
            stmt.execute(sql);
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
 };
 
 public static ResultSet ejecutarSelect(String sql){
  ResultSet resultados=null;
     
     try
        {
            stmt = conn.createStatement();
             resultados = stmt.executeQuery(sql);
            stmt.close();
            
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
     
     return resultados;
 };

 
    
}
