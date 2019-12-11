/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuenta;


import java.util.Scanner;


/**
 *
 * @author RASPUTIN
 */
public class Cuenta {

   private String titular;
   private double sueldo;

   

   
     
   
    public void setTitular(String titular) {
        this.titular = titular;
        // TODO code application logic here
    }

    
    public void setSueldo(double cantidad) {
        this.sueldo = cantidad;
    }

    public String getTitular() {
        return titular;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void Ingreasar(){
        
         Scanner lector = new Scanner(System.in);
        double cantidad = (double) 0.0;
       System.out.println("Introduzca la cantidad que desea Ingresar"+ "\n");
         Scanner entradaEscanner = new Scanner(System.in);
         cantidad = entradaEscanner.nextDouble();
         
         if(cantidad > 0){
             
                this.setSueldo(cantidad);
                
         }else{
             
             System.out.println("Siempre debe ingresar una cantidad positiva... intentelo de nuevo.");   
         }
         
           
       
    }
    
    
    public void Retirar(){
        
        Scanner lector = new Scanner(System.in);
        double cantidad = (double) 0.0;
        System.out.println("Introduzca la cantidad que desea Retirar"+ "\n");
         Scanner entradaEscanner = new Scanner(System.in);
         cantidad = entradaEscanner.nextDouble();
         
         if(cantidad > 0){
                
                double sueldo = (double) 0.0;
                sueldo = this.getSueldo();
                
                if (cantidad > sueldo){
                        
                       System.out.println("No puede retirar una cantidad mayor a su sueldo en la cuenta corriente.");
                       sueldo = 0.0;
                       this.setSueldo(sueldo);
                      
                       System.out.println("Su saldo actual es: "+ sueldo);
                         
                         
                }else{
                    
                    double salario_actual = sueldo - cantidad;
                    
                         System.out.println("Su saldo actual es: "+ salario_actual);
                         
                }
         }else{
             
             System.out.println("Siempre debe retirar una cantidad positiva... intentelo de nuevo.");   
         }
         
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Cuenta c = new Cuenta();
   
       c.Ingreasar();
       c.Retirar();
        
        Persona p = new Persona();
        System.out.println("DNI = " + p.generarDNI());
    }
    
}
