/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorteoejemploabstract;

import java.util.Scanner;

/**
 *
 * @author RASPUTIN
 */
public abstract class SorteoEjemploAbstract {

        protected int posibilades;
        public abstract int lanzar();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opcion = 0;
        Dado d = new Dado();
        Moneda m = new Moneda();
    
         System.out.println("Diga si quiere lanzar, ELIJA ENTRE LAS SIGUIENTES OPCIONES [1]SI , [2]NO");
         Scanner entradaEscanner = new Scanner(System.in);
         opcion = (int) entradaEscanner.nextDouble();
         
         if(opcion==1){
             int dado = 0;
             int moneda = 0;
             
             dado = d.lanzar();
             moneda = m.lanzar();
             
             if(moneda == 1){
                 
                 System.out.println("La Moneda callo en:  CARA" ); 
             }
             if(moneda == 2){
                 
                 System.out.println("La Moneda callo en:  CRUZ" ); 
             }
             
             System.out.println("El número obtenido el dado es: " + dado );
              
         }else{
         
              System.out.println("Decidió no lanzar"); 
         }
    }
    
}

