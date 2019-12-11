/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosseriazables;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/**
 *
 * @author RASPUTIN
 */
public class SuperHeroe implements Serializable{

        private String nombre;
        private String superpoder;
        private boolean capa;
        private char genero;

    public SuperHeroe(String nombre, String superpoder, boolean capa, char genero) {
        this.nombre = nombre;
        this.superpoder = superpoder;
        this.capa = capa;
        this.genero = genero;
    }
   public static void EscribirFichero()throws IOException{
       
    SuperHeroe NuevosVengadores;//defino variable persona
   
    File fichero = new File("FichSpiderman.dat");//declara el fichero
    
    FileOutputStream fileout = new FileOutputStream(fichero);  //crea el flujo de salida
     //conecta el flujo de bytes al flujo de datos
    ObjectOutputStream dataOS = new ObjectOutputStream(fileout);  

    String nombre[] = {"Spiderman","Batman","Joker","DoctorStrange","DoctorOctopus","Venom",
                        "DeadPool","Punisher","Lovezno"};

    String superpoder[] = {"HombreAraña","Murcielago","PayasoLoco","ControlDimensional","TentaculosMecanicos","Simbioide","Indestructible","Castigador","Garras"};

    boolean capa[] = {false,true,false,false,false,false,false,false,false};

    char genero[] = {'H','H','H','H','H','H','H','H','H'};

    System.out.println("GRABO LOS DATOS DEL SUPERHEROE!!.");   
     System.out.println("\n");
    for (int i=0;i<superpoder.length; i++){ //recorro los arrays  
        
       NuevosVengadores = new SuperHeroe(nombre[i],superpoder[i], capa[i], genero[i]); //creo al superheroe	  
           dataOS.writeObject(NuevosVengadores); //escribo el superheroe en el fichero
           //System.out.println("GRABO LOS DATOS DE SUPERHEROE.");  
           
    }  

    dataOS.close();  //cerrar stream de salida 
   
   }
    
   public static void LeerFichero()throws IOException, ClassNotFoundException{
   
        
        SuperHeroe NuevosVengadores; // defino la variable SuperHeroe
        File fichero = new File("FichSpiderman.dat");
        ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));
            //System.out.print("entra"); 

            int i = 1;
            try {
                     
                    while (true) { // lectura del fichero
                       
                        NuevosVengadores = (SuperHeroe)dataIS.readObject(); // leer un Super Heroe
                        // System.out.println("ENTRA."); 
                        System.out.print(" " + i + " => ");
                        i++;
                        System.out.printf( NuevosVengadores.getNombre() + " " + NuevosVengadores.getGenero() + " " + NuevosVengadores.getSuperpoder() + " " + NuevosVengadores.isCapa());
                        System.out.println("\t\n");
                    }
            } catch (EOFException eo) {
                    System.out.println("FIN DE LECTURA.");
            } catch (StreamCorruptedException x) {
            }

            dataIS.close(); // cerrar stream de entrada
   }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSuperpoder() {
        return superpoder;
    }

    public void setSuperpoder(String superpoder) {
        this.superpoder = superpoder;
    }

    public boolean isCapa() {
        return capa;
    }

    public void setCapa(boolean capa) {
        this.capa = capa;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
      
        SuperHeroe n = new SuperHeroe("Spiderman", "Araña", false, 'H');
        n.EscribirFichero();
        n.LeerFichero();
    }

   
}
