/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazObjetosSerizableLeerEscribirFicheros;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

/**
 *
 * @author RASPUTIN
 */
public class VillanosLeeryEscribirFicheros {
    
     public static void EscribirFicheroVillanos(ArrayList<Villano> villanos){
        
        BorrarFicheroVillanos();
         try{
           File ruta = new File("Villanos.dat");            
           FileOutputStream fileout = new FileOutputStream(ruta,true);
           ObjectOutputStream dataOS = new ObjectOutputStream(fileout);  
         
           dataOS.writeObject(villanos);
           dataOS.flush();
           dataOS.close();
           
       }catch (IOException e){} 
    }
    
     public static ArrayList LeerFicheroVillanos(){
            
        ArrayList <Villano> villanos = new ArrayList(); 
       
       try{
           File fichero = new File("Villanos.dat");
           ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));

           try {
               while (true) {
                      villanos = (ArrayList<Villano>) dataIS.readObject();
                     //  region.add(r);
               }
           } catch (EOFException | StreamCorruptedException eo) {}

           dataIS.close();
       }catch (IOException | ClassNotFoundException e){ }
       
      
   
       return villanos;
   }
    
    public static void BorrarFicheroVillanos(){
        
         File ruta = new File("FicheroVillanos.dat");    
         ruta.delete();
    }
    
}
