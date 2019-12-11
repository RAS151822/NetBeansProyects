/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscribiryLeerXMLObjetos;

import java.io.*;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author RASPUTIN
 */
public class LeerClaseXML {
    
        public static void main(String[] args)
              throws FileNotFoundException, IOException, SAXException{
		
	 XMLReader  procesadorXML = XMLReaderFactory.createXMLReader();
	 GestionContenido gestor= new GestionContenido();  
	 procesadorXML.setContentHandler(gestor);
 	 InputSource fileXML = new InputSource("SuperHeroes.xml");	    
         procesadorXML.parse(fileXML);        	      
	}
}//fin PruebaSax1

class GestionContenido extends DefaultHandler {	 
	    public GestionContenido() {
	        super();
	    }	    
	    public void startDocument() {
	        System.out.println("Comienzo del Documento XML");
	    }	    
	    public void endDocument() {
	        System.out.println("Final del Documento XML");
	    }	 	    
	    public void startElement(String uri, String nombre,String nombreC, Attributes atts) {
	        System.out.printf("\t Principio Elemento: %s %n",nombre);	 	        
	    } 	
	    public void endElement(String uri, String nombre, 
                          String nombreC) {
	        System.out.printf("\tFin Elemento: %s %n", nombre);
	    }	
	    public void characters(char[] ch, int inicio, int longitud) 
                                            throws SAXException {
		   String car=new String(ch, inicio, longitud);
               //quitar saltos de línea	
		   car = car.replaceAll("[\t\n]","");	   
		   System.out.printf ("\t Caracteres: %s %n", car);		
	    }	

}//fin GestionContenido
