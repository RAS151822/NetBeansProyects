/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorteoejemploabstract;

/**
 *
 * @author RASPUTIN
 */
public class Moneda extends SorteoEjemploAbstract {

    @Override
    public int lanzar() {
   
        int numero = 0;

        
        numero = (int)Math.floor(Math.random()*(2-0)+1);
       
       return numero;
    }
    
    
}
