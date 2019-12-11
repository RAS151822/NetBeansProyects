/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristomessenger;

import java.util.ArrayList;

/**
 *
 * @author RASPUTIN
 */
public class Friend_Controler {
   
    Friend_Model M;
    
     
    public void Friend_Controler( ArrayList<Friend_Model>FriendsUser){

        M = new Friend_Model(FriendsUser);
        //M.ConexionUsuariosDataBase(Usuarios2DAM);//Esto va dentro del modelo el controlador solo hace un new model 
    }

   
    public void getFriends(ArrayList<Friend_Model>FriendsUser){//getAlumnos Procesamiento del array

        M.getFriends(FriendsUser);
    }
    
}
