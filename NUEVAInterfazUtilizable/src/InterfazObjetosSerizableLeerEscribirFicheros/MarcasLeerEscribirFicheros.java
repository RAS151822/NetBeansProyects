/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazObjetosSerizableLeerEscribirFicheros;

/**
 *
 * @author Ras
 */
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
public class MarcasLeerEscribirFicheros {
    
    public static void EscribirFicherosMarcas(ArrayList<Marca> marcas){
        
        BorrarFicheroMarcas();
         try{
           File ruta = new File("Marcas.dat");            
           FileOutputStream fileout = new FileOutputStream(ruta,true);
           ObjectOutputStream dataOS = new ObjectOutputStream(fileout);  
         
           dataOS.writeObject(marcas);
           dataOS.flush();
           dataOS.close();
           
       }catch (IOException e){} 
    }
    
     public static ArrayList LeerFicheroMarcas(){
            
        ArrayList <SuperHeroe> superheroes = new ArrayList(); 
       
       try{
           File fichero = new File("Marcas.dat");
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
    
    public static void BorrarFicheroMarcas(){
        
         File ruta = new File("Marcas.dat");    
         ruta.delete();
    }
    
}
