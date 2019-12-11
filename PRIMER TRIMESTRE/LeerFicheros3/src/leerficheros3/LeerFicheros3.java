/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerficheros3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author RASPUTIN
 */
public class LeerFicheros3 {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
      
            if(args.length < 1){
              System.out.println("Indicar por favor nombre de fichero");
              return;
            }
            String nomFich = args[0];
            String nomFich2 = args[1];
            
           
             
            
            try(BufferedReader fbr = new BufferedReader(new FileReader(nomFich))) {
                
                    int i = 0;
                    String linea = fbr.readLine();
                    while (linea != null){
                         
                        System.out.format("[%5d] %s", i++, linea);
                        System.out.println();
                        linea = fbr.readLine();
                    }   
            } catch (FileNotFoundException e) {
               System.out.println("No existe fichero " + nomFich);
               
            } catch (IOException e) {   
               System.out.print("Error de E/S:" + e.getMessage());
               
            } catch (Exception e) {
            
            }
        }
    
}
