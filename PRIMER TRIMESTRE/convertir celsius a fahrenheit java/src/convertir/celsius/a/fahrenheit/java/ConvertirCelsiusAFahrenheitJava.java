/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertir.celsius.a.fahrenheit.java;

import java.util.Scanner;


/**
 *
 * @author RASPUTIN
 */
public class ConvertirCelsiusAFahrenheitJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Convertir grados centigrads en farenheit
        Scanner scn=new Scanner(System.in);
        System.out.println("Introducir Grados Centigrados");
        double centigrados=scn.nextDouble();
        
        double farenheit=centigrados*1.82+32;
        
        System.out.println("Grados Farenheit:" + farenheit);
    }
    
}
