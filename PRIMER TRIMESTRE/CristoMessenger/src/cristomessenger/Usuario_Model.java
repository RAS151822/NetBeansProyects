/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristomessenger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RASPUTIN
 */
public class Usuario_Model extends Conexion{
    
        String id_user;
        String name;
        String password;
        String surname1;
        String surname2;
        String photo;
        int state;

        public Usuario_Model() {

            this.id_user = null;
            this.name = null;
            this.password = null;
            this.surname1 = null;
            this.surname2 = null;
            this.photo = null;
            this.state = 0;
        }

        public Usuario_Model(ArrayList<Usuario_Model> Usuarios2DAM) {

        super();
        Statement stmt = null;
        String query = "select id_user, name, password, surname1, surname2, photo, state from cristomessenger.user";
        
        
        try {
            
        Connection c = null;
        c = CrearConexion();  
        stmt = (Statement) c.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
            while (rs.next()) {


                id_user=rs.getString("id_user");
                name=rs.getString("name");
                password=rs.getString("password");
                surname1=rs.getString("surname1");
                surname2=rs.getString("surname2");
                photo=rs.getString("photo");
                state=rs.getInt("state");



               Usuario_Model a = new Usuario_Model(); 
               a.setId_user(id_user); //Guardo la instancia  Dni de el alumno mientras recorremos la base de datos 
               a.setName(name);
               a.setPassword(password);
               a.setSurname1(surname1);
               a.setSurname2(surname2);
               a.setPhoto(photo);
               a.setState(state);
               // System.out.println("\t" + dni + "\t" + nombre);
               Usuarios2DAM.add(a);

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
        
        public void InsertarUsuario(){
            
       
        Statement stmt = null;
        String query = "INSERT IN cristomessenger.user values id_user, name, password, surname1, surname2, photo, state";
        
        
        
        }

        public ArrayList<Usuario_Model> getUsuarios(ArrayList<Usuario_Model>Usuarios2DAM){
             
          
            return Usuarios2DAM;
        }


        public Usuario_Model(String id_user, String name, String password, String surname1, String surname2, String photo, int state, Conexion c) {
            this.id_user = id_user;
            this.name = name;
            this.password = password;
            this.surname1 = surname1;
            this.surname2 = surname2;
            this.photo = photo;
            this.state = state;

        }


        public String getId_user() {
           return id_user;
        }

        public void setId_user(String id_user) {
           this.id_user = id_user;
        }

        public String getName() {
           return name;
        }

        public void setName(String name) {
           this.name = name;
        }

        public String getPassword() {
           return password;
        }

        public void setPassword(String password) {
           this.password = password;
        }

        public String getSurname1() {
           return surname1;
        }

        public void setSurname1(String surname1) {
           this.surname1 = surname1;
        }

        public String getSurname2() {
           return surname2;
        }

        public void setSurname2(String surname2) {
           this.surname2 = surname2;
        }

        public String getPhoto() {
           return photo;
        }

        public void setPhoto(String photo) {
           this.photo = photo;
        }

        public int getState() {
           return state;
        }

        public void setState(int state) {
           this.state = state;
        }

    private void set(int i, Usuario_Model get) {
        
        
    }


}

