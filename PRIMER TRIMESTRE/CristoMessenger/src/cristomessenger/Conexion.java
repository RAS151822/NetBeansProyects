/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristomessenger;

/**
 *
 * @author RASPUTIN
 */
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author RASPUTIN
 */
public class Conexion{

  
   
  public static Connection CrearConexion(){
      Connection c = null;
      
      try{
          
        c = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306","root","admin");
       // viewTable( c, "cristomessenger", Usuarios2DAM); 
        } catch(SQLException e){
      
                 System.out.print(e.getMessage());
        
        } 
     
     return c; 
  }

   
}
