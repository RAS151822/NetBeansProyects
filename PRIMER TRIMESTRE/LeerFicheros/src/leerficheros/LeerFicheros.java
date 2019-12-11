/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerficheros;

import java.io.File;
import java.util.Arrays;

/**
 *
 * @author RASPUTIN
 */
public class LeerFicheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       int contenido = 0;
       String ruta = ".";
        

       if (args.length != 0)
           ruta = args[0];
       
       File fichero=new File(ruta);
       
       if(!fichero.exists()){
        //System.out.println("Tamaño" + Arrays.toString(ruta.getBytes()));
       
        }
    }
}
