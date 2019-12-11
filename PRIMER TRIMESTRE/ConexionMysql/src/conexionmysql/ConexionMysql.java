/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionmysql;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

/**
 *
 * @author RASPUTIN
 */
public class ConexionMysql {

  public static void viewTable(Connection con, String dbName) throws SQLException {

        Statement stmt = null;
        String query = "select DNI, nom_alum from alumnos.alumnos";
        
        try {
            
        stmt = (Statement) con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            
            String dni=rs.getString("DNI");
            String nombre=rs.getString("nom_alum");
   
            System.out.println("\t" + dni + "\t" + nombre);
            
        }
    } catch (SQLException e ) {
        JDBCTutorialUtilities.printSQLException(e);
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
   }
   
  public static void CrearConexion(){
  
      try{
           
        Connection c = null;
        c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306","root","admin");
        viewTable( c, "alumnos"); 
        } catch(SQLException e){
      
                 System.out.print(e.getMessage());
        
        } 
  }
  
  public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        Alumno a = new Alumno();
       
        a.PrintAlumno(); 
  }
}

