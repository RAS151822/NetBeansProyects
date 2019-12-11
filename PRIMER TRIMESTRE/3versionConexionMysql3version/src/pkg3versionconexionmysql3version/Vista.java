/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3versionconexionmysql3version;

import java.util.ArrayList;

/**
 *
 * @author RASPUTIN
 */
public class Vista {
    
    private ArrayList<Alumno_Model> Alumnos2DAM;
     
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vista v = new Vista();
        v.Alumnos2DAM = new ArrayList();
        
        Alumno_Controler C = new Alumno_Controler();
        
        C.Alumno_Controler(v.Alumnos2DAM);
        C.PrintAlumnos(v.Alumnos2DAM); 
    }
    
}
