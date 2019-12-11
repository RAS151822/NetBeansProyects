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
public class SuperHeroesLeerEscribirFicheros {
    
    public static void EscribirFicherosSuperHeroes(ArrayList<SuperHeroe> superheroes){
        
        BorrarFicheroSuperHeroes();
         try{
           File ruta = new File("SuperHeroes.dat");            
           FileOutputStream fileout = new FileOutputStream(ruta,true);
           ObjectOutputStream dataOS = new ObjectOutputStream(fileout);  
         
           dataOS.writeObject(superheroes);
           dataOS.flush();
           dataOS.close();
           
       }catch (IOException e){} 
    }
    
     public static ArrayList LeerFicheroSuperHeroes(){
            
        ArrayList <SuperHeroe> superheroes = new ArrayList(); 
       
       try{
           File fichero = new File("SuperHeroes.dat");
           ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));

           try {
               while (true) {
                      superheroes = (ArrayList<SuperHeroe>) dataIS.readObject();
                     //  region.add(r);
               }
           } catch (EOFException | StreamCorruptedException eo) {}

           dataIS.close();
       }catch (IOException | ClassNotFoundException e){ }
       
      
   
       return superheroes;
   }
    
    public static void BorrarFicheroSuperHeroes(){
        
         File ruta = new File("SuperHeroes.dat");    
         ruta.delete();
    }
    
}
