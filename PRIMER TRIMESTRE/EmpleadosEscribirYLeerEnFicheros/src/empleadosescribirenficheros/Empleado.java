/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadosescribirenficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author RASPUTIN
 */
public class Empleado {

    private int id;
    private String apellido;
    private double salario;
    private String departamento;
    private ArrayList<Empleado> Empleados;

    public Empleado() {
    }

   
    
    public int getId(){
    
        return id;
        
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }        

    public ArrayList<Empleado> getEmpleados() {
        return Empleados;
    }

    /**
     * @param args the command line arguments
     */
    public void setEmpleados(ArrayList<Empleado> Empleados) {
        this.Empleados = Empleados;
    }

    public Empleado(int id, String apellido, double salario, String departamento) {
        this.id = id;
        this.apellido = apellido;
        this.salario = salario;
        this.departamento = departamento;
    }

    public static void EscribirFicheroAleatorio(ArrayList<Empleado>Empleados) throws FileNotFoundException, IOException {
        //Creo el fichero con el nombre y el tipo
        File fichero = new File ("AleatorioEjemplo.dat");
        
        //declara el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
        
        //Construyo los objetos de tipo empleado, es decir, los empleados que guardaremos en el array
        Empleado Charly = new Empleado(1, "Estacio", 4987.85, "Turismo");
        Empleado pedro = new Empleado(2, "Infante", 5, "Programacion");
        Empleado Martin = new Empleado(3, "OstiaTio", 355.7, "NoFriega");
        Empleado Emilio = new Empleado(4, "Fuego", 74, "Doctor");
         // System.out.println("Entra4");
        //Introduzco en el array los objetos de la clase empleado en el vector de tipo empleado
        Empleados.add(Charly);
        // System.out.println("Entra5");
        Empleados.add(pedro);
        Empleados.add(Martin);
        Empleados.add(Emilio);
        
        //buffer para almacenar empleados. Convierte el string en cadena de caracteres para saber ...
        StringBuffer buffer = null;
          //System.out.println("Entra5");
        //numero de elementos del array
        int numero_de_empleados = Empleados.size();
        
        for (int i=0;i<numero_de_empleados; i++){ //recorro los arrays   
            
             //System.out.println("Entra");
            
            file.writeInt(i+1); //uso i+1 para identificar empleado
            buffer = new StringBuffer( Empleados.get(i).getApellido());      
            buffer.setLength(10); //10 caracteres para el apellido
            file.writeChars(buffer.toString());//insertar empleados
            file.writeInt(Empleados.get(i).getId());//insertar Id
            file.writeChars(Empleados.get(i).getApellido());//insertar apellido
            file.writeDouble(Empleados.get(i).getSalario());//insertar salario
             file.writeChars(Empleados.get(i).getDepartamento());//insertar departamento
             
        } 
        
         file.close();  //cerrar fichero 
   }
   
    
    public static void main(String[] args) throws FileNotFoundException, IOException {        
        
             // System.out.println("Entra1");
            Empleado a = new Empleado();
            a.Empleados = new ArrayList();
             // System.out.println("Entra2");
            Empleado.EscribirFicheroAleatorio(a.Empleados);
              //System.out.println("Entra3");
     }
}
