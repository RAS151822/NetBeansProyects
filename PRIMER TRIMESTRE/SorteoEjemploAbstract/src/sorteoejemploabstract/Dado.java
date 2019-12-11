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
public class Dado extends SorteoEjemploAbstract{

    @Override
    public int lanzar() {
       int numero = 0;

        //Math.floor(Math.random()*2);
        numero = (int)Math.floor(Math.random()*6+1);
       
       return numero;
    }

    
}
