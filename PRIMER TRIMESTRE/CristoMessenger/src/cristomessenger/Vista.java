/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristomessenger;

import static java.awt.PageAttributes.MediaType.C;
import java.util.ArrayList;

/**
 *
 * @author RASPUTIN
 */
public class Vista {

     ArrayList<Usuario_Model> Usuarios2DAM;
     private ArrayList<Friend_Model> FriendsUser;
     
    public Vista() {
        Usuarios2DAM = new ArrayList();
        FriendsUser = new ArrayList();
       
       
        //USER 
        Usuario_Controler C = new Usuario_Controler();
        C.Usuario_Controler(Usuarios2DAM);
        C.getUsuarios(Usuarios2DAM);
        
       
        //FRIENDS
        Friend_Controler F = new Friend_Controler();
        F.Friend_Controler(FriendsUser);
        F.getFriends(FriendsUser);
    }
    
     public boolean ComprobarRegistroSistema(String id_usuario, String password){
         boolean encontrado = false;
         
         Usuario_Controler C = new Usuario_Controler(); 
        encontrado = C.ComprobarRegistroSistema(id_usuario, password, Usuarios2DAM);
        // System.out.println("El boleano despues de comprobar l sistema vale = " + encontrado);
        return encontrado;
     }
     
     public void InsertarUsuario(String id_usuario, String password){
         
         Usuario_Controler C = new Usuario_Controler();
         
     }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic her
        
        
       /*
        //IMPRIMIR USUARIOS REGISTRADOS EN LA BASE DE DATOS
         for(int i=0; i< v.Usuarios2DAM.size(); i++){

               System.out.println(v.Usuarios2DAM.get(i).getId_user() +  "\t" + v.Usuarios2DAM.get(i).getName() +  "\t" + v.Usuarios2DAM.get(i).getPassword()+  "\t" + v.Usuarios2DAM.get(i).getSurname1()+  "\t" + v.Usuarios2DAM.get(i).getSurname2()+  "\t" + v.Usuarios2DAM.get(i).getPhoto()+  "\t" + v.Usuarios2DAM.get(i).getName());     
           }
         
         //IMPRIMIR AMIGOS REGISTRADOS EN LA BASE DE DATOS
         for(int i=0; i< v.FriendsUser.size(); i++){

               System.out.println(v.FriendsUser.get(i).getId_user_orig() +  "\t" + v.FriendsUser.get(i).getId_user_dest() +  "\t" + v.FriendsUser.get(i).getAccept_request());     
           }
         */ 
    }

    
}
