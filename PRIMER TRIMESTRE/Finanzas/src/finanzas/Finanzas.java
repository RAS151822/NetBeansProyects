/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finanzas;


import java.util.Scanner;

/**
 *
 * @author RASPUTIN
 */
public class Finanzas {
    
    private  double valoreurodefecto;
   
     Finanzas(){
     
          valoreurodefecto = 1.38;
     }

     Finanzas(double nuevopordefecto){
     
          valoreurodefecto = nuevopordefecto;
     }
     
     public double euro_a_dolar(double cantidad){
         
            return valoreurodefecto*cantidad;
     }
     void PrintFinanzas(double cantidad){
     
            System.out.println("Valor de una moneda de un euro : "+ this.valoreurodefecto+ "$" + "\n");
            System.out.print("La cantidad que has insertado es: "+ cantidad + "$"  + "\n");
     }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic her
        
        Scanner lector = new Scanner(System.in);
        double cantidad = (double) 0.0;
         System.out.println("Introduzca la cantidad que desea realizar el cambio"+ "\n");
         Scanner entradaEscanner = new Scanner(System.in);
         cantidad = entradaEscanner.nextDouble();
         
         Finanzas f = new Finanzas();
       
         f.PrintFinanzas(cantidad);
         cantidad = f.euro_a_dolar(cantidad);
         
          System.out.println("\n" + "El valor en dolares es:"+ cantidad + "$"  + "\n");
    }
    
}
