/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuenta;

/**
 *
 * @author RASPUTIN
 */
public class Persona {
    
    private String DNI;
    private String nombre;
    private int edad;
    private char sexo;
    private double peso;
    private double altura;

    public Persona() {
        
        this.DNI = "45931367E";
        this.nombre = null;
        this.edad = 0;
        this.sexo = 'H';
        this.peso = 0.0;
        this.altura = 0.0; 
    }

    public Persona(String DNI, String nombre, int edad, char sexo, double peso, double altura) {
        
        this.DNI = DNI;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    
        
    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public char getSexo() {
        return sexo;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }
    
    
    
    public void CalcularIMC(){
        double peso = 0.0;
        double altura = 0.0;
        double pesoideal = 0.0;
        
        peso = this.getPeso();
        altura = this.getAltura();
       
        
       pesoideal = peso/Math.pow(altura, 2); 
        
       if(pesoideal <20){
           
           pesoideal = -1;
       }
       if(pesoideal >=20 && pesoideal <= 25){
           
           pesoideal = 0;
       }
       
       if(pesoideal > 25){
           
           pesoideal = 1;
       }
    }
    
    public boolean EsMayorDeEdad(){
        boolean mayor = false;
      
        if(this.edad >= 18){
        
            mayor = true;
        }
        return mayor;
    }
    
    public boolean ComprobarSexo(char sexo){
        boolean hombre = false;
        
        if(sexo == 'H'){
        
           hombre = true;
        }
        
        return hombre;
    }
    
    public void print(){
        
      System.out.println("DNI : " + this.nombre);
      System.out.println("Nombre : "+ this.nombre);
      System.out.println("Edad : "+ this.nombre);
      System.out.println("Sexo : "+ this.nombre);
      System.out.println("Peso : "+ this.nombre);
      System.out.println("Altura : "+ this.nombre);
     
    }
    
    public String generarDNI(){
        int numero_DNI = 0;
        String DNI = null;
        
        numero_DNI = (int)Math.floor(Math.random()*(99999999-0)+0);
       
        // (int)Math.floor(Math.random()*(num_maximo-num_minimo)+num_minimo).
        //System.out.println("DNI = " + DNI );
       
       DNI = numero_DNI + "" + generarLetras(numero_DNI);
       
        return DNI;
    }
    
    public char generarLetras(int dni){

        String letra_aleatoria="TRWAGMYFPDXBNJZSQVHLCKE";

        int modulo= dni % 23;

        char letra = letra_aleatoria.charAt(modulo);

       
     
     return letra;
    }
}
