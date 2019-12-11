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
public class Usuario_Controler {
     private Usuario_Model M;
    
     
    public void Usuario_Controler( ArrayList<Usuario_Model>Usuarios2DAM){

        M = new Usuario_Model(Usuarios2DAM);
        //M.ConexionUsuariosDataBase(Usuarios2DAM);//Esto va dentro del modelo el controlador solo hace un new model 
    }

   
    public void getUsuarios(ArrayList<Usuario_Model>Usuarios2DAM){//getAlumnos Procesamiento del array

       Usuarios2DAM =  M.getUsuarios(Usuarios2DAM);
    }
    
    public boolean ComprobarRegistroSistema(String id_usuario, String password, ArrayList<Usuario_Model>Usuarios2DAM){
      
    
       boolean encontrado = false;
       
       //DEBUG COMPROBAR SI EN EL VECTOR ESTAN LOS ALUMNOS 
       
       /*
       for(int i=0; i< Usuarios2DAM.size(); i++){

               System.out.println(Usuarios2DAM.get(i).getId_user() +  "\t" + Usuarios2DAM.get(i).getName() +  "\t" + Usuarios2DAM.get(i).getPassword()+  "\t" + Usuarios2DAM.get(i).getSurname1()+  "\t" + Usuarios2DAM.get(i).getSurname2()+  "\t" + Usuarios2DAM.get(i).getPhoto()+  "\t" + Usuarios2DAM.get(i).getName());     
           }
       */
       
       for(int i=0; i<Usuarios2DAM.size() && encontrado == false; i++){

            
          
            if((Usuarios2DAM.get(i).getId_user().equals(id_usuario)  && Usuarios2DAM.get(i).getPassword().equals(password))){
                
                encontrado = true; 
            } 
       }
       return encontrado;
    } 
      
    public void InsertarUsuario(){
        
        
    }
}
