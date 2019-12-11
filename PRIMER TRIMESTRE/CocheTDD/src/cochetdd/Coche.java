/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cochetdd;

    
/**
 *
 * @author RASPUTIN
 */
public class Coche {
   
    String marca;
    String matricula;
   

    public Coche(String marca, String matricula) {
        this.matricula = matricula;
        this.marca = marca;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }
    
}
