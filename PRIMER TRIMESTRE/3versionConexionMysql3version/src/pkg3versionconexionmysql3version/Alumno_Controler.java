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
public class Alumno_Controler{
     Alumno_Model M;
    
     
    public void Alumno_Controler( ArrayList<Alumno_Model>Alumnos2DAM){
    
   
     M = new Alumno_Model(Alumnos2DAM);
     M.ConexionAlumnoDataBase(Alumnos2DAM);//Esto va dentro del modelo el controlador solo hace un new model 
    }
    
   public void PrintAlumnos(ArrayList<Alumno_Model>Alumnos2Dam){//getAlumnos Procesamiento del array
    
    M.PrintAlumnos(Alumnos2Dam);
}
    
}

