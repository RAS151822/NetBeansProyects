/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerficheros2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author RASPUTIN
 */
public class LeerFicheros2 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
     public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
      
            if(args.length < 1){
              System.out.println("Indicar por favor nombre de fichero");
              return;
            }
            String nomFich = args[0];
            String palabra = args[1];
            int VecesEncontradas = 0;
            int fila = 0;
            int cont_columna = 0;
            
            //System.out.println("La palabra es: " + palabra);
            
            try(BufferedReader fbr = new BufferedReader(new FileReader(nomFich))) {
                
                    
                    
                    String linea = fbr.readLine();
                    
                  System.out.println("La palabra [" + palabra + "] esta en la posicion del fichero en:");
                    while (linea != null){
                       
                        
                        
                        if(linea.contains(palabra)){
                          
                           VecesEncontradas ++;
                           cont_columna = linea.indexOf(palabra);
                        }   
                         
                       
                        System.out.println("[" + fila++ + "," + cont_columna + "]" + linea);
                        linea = fbr.readLine();
                        VecesEncontradas = 0;
                        cont_columna = 0;
                    }   
            } catch (FileNotFoundException e) {
               System.out.println("No existe fichero " + nomFich);
               
            } catch (IOException e) {   
               System.out.print("Error de E/S:" + e.getMessage());
               
            } catch (Exception e) {
            
            }
        }
    
}
