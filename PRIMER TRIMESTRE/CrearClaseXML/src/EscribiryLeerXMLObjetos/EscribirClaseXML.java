/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscribiryLeerXMLObjetos;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author RASPUTIN
 */
public class EscribirClaseXML {

    static ArrayList<SuperHeroe> superheroes;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException {
        // TODO code application logic here
        //Doy memoria a el array List de donde voy a leer y crear mi XML
        
        superheroes = new ArrayList();
        EscribirClaseXML.InsertarDatosArray();
        
        /*
        for(int i=0; i<superheroes.size(); i++){
            
            System.out.println("Nombre SuperHeroe " + superheroes.get(i).getNombre());
        }
        */
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
  
        try{
            
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = 
            implementation.createDocument(null, "SuperHeroes", null);
            document.setXmlVersion("1.0"); 
            
            
            for(int i=0; i<superheroes.size();i++){
                
                Element raiz = 
                document.createElement("SuperHeroe"); //nodo super
                document.getDocumentElement().appendChild(raiz);

               // CrearElemento(superheroes.get(i).getGenero(), raiz, document);
               /*
              
               */
               
               CrearElemento("Nombre",superheroes.get(i).getNombre(),raiz, document);
               CrearElemento("Habilidad", superheroes.get(i).getHabilidad(), raiz, document);
               CrearElemento("Capa", Boolean.toString(superheroes.get(i).isCapa()), raiz, document);
               CrearElemento("Genero",Character.toString(superheroes.get(i).getGenero()), raiz, document);
              
            }//fin del for que recorre el vector
		
                Source source = new DOMSource(document);
                Result result = 
                new StreamResult(new java.io.File("SuperHeroes.xml"));        
                Transformer transformer =
                TransformerFactory.newInstance().newTransformer();
                transformer.transform(source, result);
            
        }catch(Exception e){ System.err.println("Error: "+e); }
        
        
    }
    
    public static void CrearElemento(String AtributoSuperHeroe, String contenido,Element raiz, Document document) {
        
       
        Element elem = document.createElement(AtributoSuperHeroe); 
        Text text = document.createTextNode(contenido); //damos valor
       
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor	
    }
    
    public static void  InsertarDatosArray(){
        
        //Creo los vectores con los valores de cada superheroe que voy a crear y guardar en mi vector de objetos
       
        int[]id_SuperHeroe = {1,2,3,4,5,6,7,8,9};
         
        String nombre[] = {"Spiderman","Batman","Joker","DoctorStrange","DoctorOctopus","Venom",
                        "DeadPool","Punisher","Lovezno"};

        String[] Habilidad = {"HombreAraña","Murcielago","PayasoLoco","ControlDimensional","TentaculosMecanicos","Simbioide","Indestructible","Castigador","Garras"};

        boolean capa[] = {false,true,false,false,false,false,false,false,false};

        char genero[] = {'H','H','H','H','H','H','H','H','H'};
    
        for (int i=0;i<Habilidad.length; i++){ //recorro los arrays  

            SuperHeroe NuevoVengador = new SuperHeroe(nombre[i],Habilidad[i], capa[i], genero[i]); //creo al superheroe
            NuevoVengador.setId_SuperHeroe(i);
            superheroes.add(NuevoVengador);
          
        }  
        
    }
}
