/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristomessenger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import static cristomessenger.Conexion.CrearConexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RASPUTIN
 */
public class Friend_Model extends Conexion{
     
String id_user_orig;
String id_user_dest;
int accept_request;
    
    public Friend_Model() {

            this.id_user_orig = null;
            this.id_user_dest = null;
            this.accept_request = 0;
    }

    public Friend_Model(ArrayList<Friend_Model>FriendsUser) {

    super();
    Statement stmt = null;
    String query = "select id_user_orig, id_user_dest, accept_request from cristomessenger.friend";


    try {

    Connection c = null;
    c = CrearConexion();  
    stmt = (Statement) c.createStatement();
    ResultSet rs = stmt.executeQuery(query);

    while (rs.next()) {

        id_user_orig=rs.getString("id_user_orig");
        id_user_dest=rs.getString("id_user_dest");
        accept_request=rs.getInt("accept_request");




       Friend_Model f = new Friend_Model(); 
       f.setId_user_orig(id_user_orig); //Guardo la instancia  Dni de el alumno mientras recorremos la base de datos 
       f.setId_user_dest(id_user_dest);
       f.setAccept_request(accept_request);

       FriendsUser.add(f);

    }
    } catch (SQLException e ) {
        JDBCTutorialUtilities.printSQLException(e);
        
    } finally {
        if (stmt != null) {
            
            try {
            stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Usuario_Model.class.getName()).log(Level.SEVERE, null, ex);
              }
            }
        }
     
    }

    public void getFriends(ArrayList<Friend_Model>Usuarios2DAM){

    }

    public String getId_user_orig() {
        return id_user_orig;
    }

    public void setId_user_orig(String id_user_orig) {
        this.id_user_orig = id_user_orig;
    }

    public String getId_user_dest() {
        return id_user_dest;
    }

    public void setId_user_dest(String id_user_dest) {
        this.id_user_dest = id_user_dest;
    }

    public int getAccept_request() {
        return accept_request;
    }

    public void setAccept_request(int accept_request) {
        this.accept_request = accept_request;
    }
 
}
