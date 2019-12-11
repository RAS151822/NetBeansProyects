/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4versionconexionmysql;

import java.util.ArrayList;

/**
 *
 * @author RASPUTIN
 */
public class Alumno_Model{
    
        String DNI;
        String nombre_alum;
        Conexion c;

Alumno_Model( ArrayList<Alumno_Model>Alumnos2DAM) {

    DNI = "null";
    nombre_alum = "null";
    c.CrearConexion( Alumnos2DAM);
    //Alumnos2Dam = new ArrayList();
   
}

 void ConexionAlumnoDataBase(ArrayList<Alumno_Model> Alumnos2DAM) {
        
      c.CrearConexion( Alumnos2DAM);
    }

public void PrintAlumnos(ArrayList<Alumno_Model>Alumnos2Dam){
    
    for(int i=0; i< Alumnos2Dam.size(); i++){
            
            System.out.println(Alumnos2Dam.get(i).getDNI() +  "\t" + Alumnos2Dam.get(i).getNombre_alum());     
        }
}
        
public Alumno_Model(String DNI, String nombre_alum) {
    this.DNI = DNI;
    this.nombre_alum = nombre_alum;
}


public String getDNI() {
    return DNI;
}

public void setDNI(String DNI) {
    this.DNI = DNI;
}

public String getNombre_alum() {
    return nombre_alum;
}

public void setNombre_alum(String nombre_alum) {
    this.nombre_alum = nombre_alum;
}

  

}
