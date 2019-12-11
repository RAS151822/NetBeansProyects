/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionmysql;

/**
 *
 * @author RASPUTIN
 */
public class Alumno extends ConexionMysql{
    
        String DNI;
        String nombre_alum;  

public Alumno() {

    DNI = "null";
    nombre_alum = "null";
    
}

public void PrintAlumno(){
    
    this.CrearConexion();
  
}


        
public Alumno(String DNI, String nombre_alum) {
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
