/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3versionconexionmysql3version;

/**
 *
 * @author RASPUTIN
 */
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;
import java.util.ArrayList;

/**
 *
 * @author RASPUTIN
 */
public class Conexion {

  public static void viewTable(Connection con, String dbName,  ArrayList<Alumno_Model> Alumnos) throws SQLException {

        Statement stmt = null;
        String query = "select DNI, nom_alum from alumnos.alumnos";
        
        
        try {
            
        stmt = (Statement) con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            
            String dni=rs.getString("DNI");
            String nombre=rs.getString("nom_alum");
            
            
           Alumno_Model a = new Alumno_Model(Alumnos); 
           a.setDNI(dni); //Guardo la instancia  Dni de el alumno mientras recorremos la base de datos 
           a.setNombre_alum(nombre);  
           // System.out.println("\t" + dni + "\t" + nombre);
           Alumnos.add(a);
           
        }
    } catch (SQLException e ) {
        JDBCTutorialUtilities.printSQLException(e);
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
     
    
   }
   
  public static void CrearConexion( ArrayList<Alumno_Model> Alumnos){
      
      try{
           
        Connection c = null;
        c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306","root","admin");
        viewTable( c, "alumnos", Alumnos); 
        } catch(SQLException e){
      
                 System.out.print(e.getMessage());
        
        } 
     
      
  }

   
}