/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazObjetosSerizableLeerEscribirFicheros;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RASPUTIN
 */
public class NUEVAInterfazUtilizable extends javax.swing.JFrame {
    
    //DECLARO LOS MODELOS PARA ENGANCHAR CON EL LAYOUT DESPUES
     DefaultTableModel modelo1; 
     DefaultTableModel modelo2;
     DefaultTableModel modelo3;
     DefaultTableModel modelo4;
     
     //DECLARO MIS ARRAYS DE OBJETOS
     private ArrayList<SuperHeroe> superheroes;
     private ArrayList<SuperPoder> superpoderes;
     private ArrayList<Villano> villanos;
     private ArrayList<Marca> marcas;
     
    /**
     * Creates new form NUEVAInterfazUtilizable
     */
    public NUEVAInterfazUtilizable() throws IOException {
        initComponents();
         this.setLocationRelativeTo(null);
        
        //Pongo los comandos a false para que no pueda escribir a noser que sea insertar o modificar
        PrimeraTablaBloquearoDesbloquearEscrituraTextField(1);
        SegundaTablaBloquearoDesbloquearEscrituraTextField(1);
        TerceraTablaBloquearoDesbloquearEscrituraTextField(1);
        CuartaTablaBloquearoDesbloquearEscrituraTextField(1);
        
        
        //Bloqueo los combobox
        jComboBoxSuperPoderes.setEnabled(false);
        jComboBoxVillanos.setEnabled(false);
        jComboBoxMarcas.setEnabled(false);
        
         //Forma de no dejar escribir en la tabla
        
        modelo1 = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column==4){
                    
                    return true;
                }else{
                    
                    return false;
                }
            }
            
        };
        modelo2 = new DefaultTableModel(){
            
             @Override
            public boolean isCellEditable(int row, int column) {
                if(column==4){
                    
                    return true;
                }else{
                    
                    return false;
                }
            }
            
        };
        modelo3 = new DefaultTableModel(){
            
             @Override
            public boolean isCellEditable(int row, int column) {
                if(column==5){
                    
                    return true;
                }else{
                    
                    return false;
                }
            }
            
        };
        
         modelo4 = new DefaultTableModel(){
            
             @Override
            public boolean isCellEditable(int row, int column) {
                if(column==4){
                    
                    return true;
                }else{
                    
                    return false;
                }
            }
            
        };
       
        //INTRODUZC NOMBRES COLUMNAS , ENLAZO TABLAS Y DOY MEMORIA AL ARRAY CON SUS VALORES
        
        CrearTablaSuperHeroes();
        
        CrearTablaSuperPoderes();
        
        CrearTablaVillanos();
        
        CrearTablaMarcas();
        
        //ESCRIBIR Y LEER FICHEROS
        //EscribirFicherosSuperHeroes(); Al finalizar programa
        //LeerFicheroSuperHeroes();
    }
    
    //ESCRIBIR Y LEER FICHEROS
    
    
   
    //CREAR TABLAS
    
    public void CrearTablaSuperHeroes(){
        
        modelo1.addColumn("NAME");
        modelo1.addColumn("HABILIDAD");
        modelo1.addColumn("GENERO");
        modelo1.addColumn("CAPA");
        this.TablaSuperHeroes.setModel(modelo1);

        this.superheroes = new ArrayList();
       
        superheroes = SuperHeroesLeerEscribirFicheros.LeerFicheroSuperHeroes();
        
        //Comprobacion arrays ids
         for(int j=0; j<superheroes.size(); j++)
        System.out.println("Array superheroes nada mas leer fichero " + superheroes.get(j).getNombre() + " " + superheroes.get(j).getId_SuperHeroe());

        this.ActualizarTablaSuperHeroes(superheroes);
     
      
        
        //DatosSuperHeroesVector();
       
        
    }
    
    public void CrearTablaSuperPoderes(){
    
        modelo2.addColumn("NAME");
        modelo2.addColumn("DAÑO");
        modelo2.addColumn("POTENCIA");
        modelo2.addColumn("SUPERHEROE");
        this.TablaSuperPoderes.setModel(modelo2);
        
        this.superpoderes = new ArrayList();
        superpoderes = SuperPoderesLeerEscribirFicheros.LeerFicheroSuperPoderes();
        
         //Comprobacion arrays ids
        /*
         for(int j=0; j<superpoderes.size(); j++)
        System.out.println("Array superheroes nada mas leer fichero  " + superpoderes.get(j).getNombrePoder() + " " + " id_superheroe: " + superpoderes.get(j).getId_SuperHeroe()+ " " + superpoderes.get(j).getId_SuperPoder());
        */
        
        this.ActualizarTablaSuperPoderes(superpoderes);
        
        //this.DatosSuperPoderes();
       
    }
    
     public void CrearTablaVillanos(){
    
        modelo3.addColumn("NAME");
        modelo3.addColumn("HABILIDAD");
        modelo3.addColumn("GENERO");
        modelo3.addColumn("MASCARA");
        modelo3.addColumn("SUPERHEROE");
        
        this.TablaVillanos.setModel(modelo3);
        
         //System.out.println("ENTRA");
        
        this.villanos = new ArrayList();
        villanos = VillanosLeeryEscribirFicheros.LeerFicheroVillanos();
        
         //Comprobacion arrays ids
         for(int j=0; j<villanos.size(); j++)
        System.out.println("Array Villanos nada mas leer fichero " + villanos.get(j).getNombreVillano()+ " " + villanos.get(j).getId_Villano());

        
       
        this.ActualizarTablaVillanos(villanos);
        
    }

    public void CrearTablaMarcas(){
    
        modelo4.addColumn("NAME");
        modelo4.addColumn("AÑO");
        modelo4.addColumn("PELICULA");
        modelo4.addColumn("VILLANOS");
       
        this.TablaMarcas.setModel(modelo4);
        
        this.marcas = new ArrayList();
        marcas = MarcasLeerEscribirFicheros.LeerFicheroMarcas();
       
        
        //RELLENO LOS COMBOX
        this.ActualizarTablaMarcas(marcas);
        
    }
    
    //INSERCION DE DATOS EN LAS TABLAS CON ARRAYS
   
    public void DatosSuperHeroesVector(){
        
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
            //System.out.println(superheroes.get(i).getNombre());
            
             Object[] row = {superheroes.get(i).getNombre(), superheroes.get(i).getHabilidad(), superheroes.get(i).getGenero(), superheroes.get(i).isCapa()};
             modelo1.addRow(row);

        }  
    }
   
     /*
    public void DatosSuperPoderes(){
        
       
        String NombreMarca;
    Float Daño;
    int Potencia;
        
      
    
         int[]id_SuperHeroe = {1,2,3,4,5,6,7,8,9};
        
         String NombrePoder [] = {"Telarañas","Vampiro", "FuerzaLoca", "Mistico", "Pulpo", "Fuerza", "Inmortal","Armas", "Instinto Asesino"};
         int[] daño = {80,70,55,20,47,13,21,11,41};
         int[] potencia = {20,45,63,22,13,77,45,78,96};
         
         for(int i=0; i<9;i++){
         
            SuperPoder nuevosuperpoder = new SuperPoder(id_SuperHeroe[i],NombrePoder[i],daño[i],potencia[i]);
            nuevosuperpoder.setId_SuperPoder(i);
            superpoderes.add(nuevosuperpoder);
            System.out.println(superpoderes.get(i).getNombrePoder());
            Object[] row = {superpoderes.get(i).getNombrePoder(),superpoderes.get(i).getDaño(),superpoderes.get(i).getPotencia(),superheroes.get(i).getNombre()};
            modelo2.addRow(row);
            
         }
        
    }
     
    
     public void DatosVillanos(){
        
         //Creo los vectores con los valores de cada superheroe que voy a crear y guardar en mi vector de objetos
       
        int[]id_SuperHeroe = {1,2,3,4,5,6,7,8,9};
         
        String[] nombreVillano = {"DuendeVerde","CaraCortada","Pinguino","Magia Negra","Kimping","Carnage",
                        "Ciclope","Narco","Dientes de Sable"};

        String[] Habilidad = {"Bombas","Suerte","Paraguas Metralladora","Oscuridad","Dinero","Transformacion","Ojo laser","Armas","Armadura"};

        boolean[] mascara = {true,false,false,true,false,true,false,false,true};

        char genero[] = {'H','H','H','H','H','H','H','H','H'};
    
        for (int i=0;i<Habilidad.length; i++){ //recorro los arrays  

        //    Villano NuevoVillano = new Villano(id_SuperHeroe[i],nombreVillano[i],Habilidad[i], mascara[i], genero[i]); //creo al superheroe
            NuevoVillano.setId_Villano(i);
            villanos.add(NuevoVillano);
            //System.out.println(superheroes.get(i).getNombre());
            
             Object[] row = {villanos.get(i).getNombreVillano(), villanos.get(i).getHabilidad(), villanos.get(i).getGenero(), villanos.get(i).isMascara(),superheroes.get(i).getNombre()};
             modelo3.addRow(row);

        }  
    }
    
    public void DatosMarcas(){
        
        /*
        String NombreMarca;
    Float Daño;
    int Potencia;
        
        
    
         int[]id_Villanos = {1,2,3,4,5,6,7,8,9};
       
         String[] NombreMarca = {"Marvel","DCComics", "DCComics", "Marvel", "Marvel", "Marvel", "Marvel","Marvel", "Marvel"};
         int[] Año = {80,70,55,60,50,70,80,91,87};
         boolean[] Pelicula = {true,false,false,true,false,true,false,false,true};
         
         for(int i=0; i<9;i++){
         
            Marca nuevamarca = new Marca(id_Villanos[i],NombreMarca[i],Año[i],Pelicula[i]);
            nuevamarca.setId_Marca(i);
            marcas.add(nuevamarca);
            System.out.println(marcas.get(i).getNombreMarca());
            Object[] row = {marcas.get(i).getNombreMarca(),marcas.get(i).getAño(),marcas.get(i).isPelicula(),villanos.get(i).getNombreVillano()};
            modelo4.addRow(row);
            
         }
        
    }
    */
    
    //LLENAR COMBOXSSS
     public void LlenarComboBox(){
         jComboBoxSuperPoderes.removeAllItems();//BORRAR LOS DATOS PRIMERAMENTE
         jComboBoxVillanos.removeAllItems();
         
         for(int i=0; i<superheroes.size();i++){
             
              jComboBoxSuperPoderes.addItem(superheroes.get(i).getNombre());
              jComboBoxVillanos.addItem(superheroes.get(i).getNombre());
         }
     }
     
     public void LlenarComboBoxMarcas(){
         jComboBoxMarcas.removeAllItems();//BORRAR LOS DATOS PRIMERAMENTE
         
         
         for(int i=0; i<superheroes.size();i++){
             
             
               jComboBoxMarcas.addItem(villanos.get(i).getNombreVillano());
         }
     }
        
    //METODOS  
  
      public int TamañoSuperheroes(){
       
        return superheroes.size();
    }

    public boolean BuscarEnVector(){
        boolean encontrado = false;
         
            for(int i=0; i<superheroes.size() && encontrado == false; i++){

                  if(!this.TextFieldName.getText().equals(superheroes.get(i).getNombre())){

                      encontrado = true;
                  }
            }
         
        return encontrado;
    }
   
    
    //ACTUALIZAR TABLAS
    
    
    public void ActualizarTablaSuperHeroes(ArrayList<SuperHeroe> superheroes){
        
         
         //System.out.println("filas: "+ modelo1.getRowCount());
        
        for (int i = modelo1.getRowCount() -1; i >= 0; i--){
           
             modelo1.removeRow(i);
        }
        
         for (int i=0;i<superheroes.size(); i++){ //recorro los arrays  
   
            //Inserto en la tabla los valores del objeto
            Object[] row = {superheroes.get(i).getNombre(), superheroes.get(i).getHabilidad(), superheroes.get(i).getGenero(), superheroes.get(i).isCapa()};  

            modelo1.addRow(row);
        
        } 
          //System.out.println("filas: "+ modelo1.getRowCount());
    }
    
     public void ActualizarTablaSuperPoderes(ArrayList<SuperPoder> superpoderes){
         
        for (int i = modelo2.getRowCount() -1; i >= 0; i--){
           
             modelo2.removeRow(i);
        }
         
         
        for (int i=0;i<superpoderes.size(); i++){ //recorro los arrays  
            
            //Creo un objeto para guardar el objeto recorrido por el array
           // SuperPoder getSuperPoder = (SuperPoder) superpoderes.get(i);
            
            //ACTUALIZO MODO FICHEROSS AÑADO LAS NUEVAS FILAS
            Object[] row = {superpoderes.get(i).getNombrePoder(), superpoderes.get(i).getDaño(), superpoderes.get(i).getPotencia(), superpoderes.get(i).getNombreSuperHeroe()};
            modelo2.addRow(row);
            
            //Inserto en la tabla los valores del objeto
            /*
            modelo2.setValueAt(getSuperPoder.getNombrePoder(),i,0);
            modelo2.setValueAt(getSuperPoder.getDaño(),i,1);
            modelo2.setValueAt(getSuperPoder.getPotencia(),i,2);
            modelo2.setValueAt( jComboBoxSuperPoderes.getItemAt(getSuperPoder.getId_SuperHeroe()),i,3);
            */
             
        }  
            
    }
    
     public void ActualizarTablaVillanos(ArrayList<Villano> villanos){
         
         for (int i = modelo3.getRowCount() -1; i >= 0; i--){
           
             modelo3.removeRow(i);
        }
         
        for (int i=0;i<villanos.size(); i++){ //recorro los arrays  
            
            //Creo un objeto para guardar el objeto recorrido por el array
            Villano getVillano = (Villano) villanos.get(i);
            
            //ACTUALIZO MODO FICHEROSS AÑADO LAS NUEVAS FILAS
            Object[] row = {villanos.get(i).getNombreVillano(), villanos.get(i).getHabilidad(), villanos.get(i).getGenero(), villanos.get(i).isMascara(),villanos.get(i).getNombreSuperHeroe()};
            modelo3.addRow(row);
            //Inserto en la tabla los valores del objeto
             /*
            modelo3.setValueAt(getVillano.getNombreVillano(),i,0);
            modelo3.setValueAt(getVillano.getHabilidad(),i,1);
            modelo3.setValueAt(getVillano.getGenero(),i,2);
            modelo3.setValueAt(getVillano.isMascara(),i,3);
            modelo3.setValueAt( jComboBoxVillanos.getItemAt(getVillano.getId_SuperHeroe()),i,4);
             */
            
             
        }  
            
    } 
    
     public void ActualizarTablaMarcas(ArrayList<Marca> marcas){
         
         for (int i = modelo4.getRowCount() -1; i >= 0; i--){
           
             modelo4.removeRow(i);
        }
         
        for (int i=0;i<marcas.size(); i++){ //recorro los arrays  
            
          
            //ACTUALIZO MODO FICHEROSS AÑADO LAS NUEVAS FILAS
            Object[] row = {marcas.get(i).getNombreMarca(), marcas.get(i).getAño(), marcas.get(i).isPelicula(), marcas.get(i).getNombreVillano()};
            modelo4.addRow(row);
            //Inserto en la tabla los valores del objeto
             /*
            modelo3.setValueAt(getVillano.getNombreVillano(),i,0);
            modelo3.setValueAt(getVillano.getHabilidad(),i,1);
            modelo3.setValueAt(getVillano.getGenero(),i,2);
            modelo3.setValueAt(getVillano.isMascara(),i,3);
            modelo3.setValueAt( jComboBoxVillanos.getItemAt(getVillano.getId_SuperHeroe()),i,4);
             */
            
             
        }  
            
            
    }  
    
    //ACTUALIZAR IDS
     
    public void SuperHeroesActualizarIDS(ArrayList<SuperHeroe> superheroes){
        
        for(int i=0; i<superheroes.size(); i++){
            
            superheroes.get(i).setId_SuperHeroe(i);
        }
    } 
     
    public void SuperPoderesActualizarIDS(ArrayList<SuperPoder> superpoderes){
        
        for(int i=0; i<superpoderes.size(); i++){
            
            superpoderes.get(i).setId_SuperPoder(i);
        }
    } 
    
     public void VillosActualizarIDS(ArrayList<Villano> villanos){
        
        for(int i=0; i<villanos.size(); i++){
            
           villanos.get(i).setId_Villano(i);
        }
    } 
     
    //LIMPIAR TEXT FIELD
    public void SuperHeroesLimpiarTextField(){
        
        this.TextFieldName.setText("");
        this.TextFieldHabilidad.setText("");
        this.TextFieldGenero.setText("");
        this.TextFieldCapa.setText("");
    }
    
    public void SuperPoderesLimpiarTextField(){
        
        this.TextFieldName1.setText("");
        this.TextFieldDaño.setText("");
         this.TextFieldPotencia.setText("");
    }
    
     public void VillanosLimpiarTextField(){
        
        this.TextFieldVillanoName.setText("");
        this.TextFieldVillanoHabilidad.setText("");
        this.TextFieldVillanoGenero.setText("");
        this.TextFieldVillanoMascara.setText("");
    }
    
    public void MarcasLimpiarTextField(){
        
        this.TextFieldMarcaName.setText("");
        this.TextFieldMarcaAño.setText("");
        this.TextFieldMarcaPelicula.setText("");
       
    }
    
    //BLOQUEADORES DE ESCRITURA DE TODAS LAS TABLAS
    
    public void PrimeraTablaBloquearoDesbloquearEscrituraTextField(int i){
            //DESBLOQUEO i = 0
            //BLOQUEADO  i!= 0
        
            if(i == 0){
                
                this.TextFieldName.setEditable(true);
                this.TextFieldHabilidad.setEditable(true);
                this.TextFieldGenero.setEditable(true);
                this.TextFieldCapa.setEditable(true);
                
            }else{
                
                this.TextFieldName.setEditable(false);
                this.TextFieldHabilidad.setEditable(false);
                this.TextFieldGenero.setEditable(false);
                this.TextFieldCapa.setEditable(false);
            }
    }
    
     public void SegundaTablaBloquearoDesbloquearEscrituraTextField(int i){
            //DESBLOQUEO i = 0
            //BLOQUEADO  i!= 0
        
            if(i == 0){
                
                this.TextFieldName1.setEditable(true);
                this.TextFieldDaño.setEditable(true);
                this.TextFieldPotencia.setEditable(true);
               
                
            }else{
                
                 this.TextFieldName1.setEditable(false);
                this.TextFieldDaño.setEditable(false);
                this.TextFieldPotencia.setEditable(false);
            }
    }
    
     public void TerceraTablaBloquearoDesbloquearEscrituraTextField(int i){
            //DESBLOQUEO i = 0
            //BLOQUEADO  i!= 0
        
            if(i == 0){
                
                this.TextFieldVillanoName.setEditable(true);
                this.TextFieldVillanoHabilidad.setEditable(true);
                this.TextFieldVillanoGenero.setEditable(true);
                this.TextFieldVillanoMascara.setEditable(true);
              
               
                
            }else{
                
                this.TextFieldVillanoName.setEditable(false);
                this.TextFieldVillanoHabilidad.setEditable(false);
                this.TextFieldVillanoGenero.setEditable(false);
                this.TextFieldVillanoMascara.setEditable(false);
            }
    
     }
    
     
     
     public void CuartaTablaBloquearoDesbloquearEscrituraTextField(int i){
            //DESBLOQUEO i = 0
            //BLOQUEADO  i!= 0
        
            if(i == 0){
                
                this.TextFieldMarcaName.setEditable(true);
                this.TextFieldMarcaAño.setEditable(true);
                this.TextFieldMarcaPelicula.setEditable(true);
                
            }else{
                
                this.TextFieldMarcaName.setEditable(false);
                this.TextFieldMarcaAño.setEditable(false);
                this.TextFieldMarcaPelicula.setEditable(false);
            }
    
     }
     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaSuperHeroes = new javax.swing.JTable();
        jButtonCerrarVentana = new javax.swing.JButton();
        jButtonSuperHeroesInsertar = new javax.swing.JButton();
        jButtonSuperHeroesEliminar = new javax.swing.JButton();
        jButtonSuperHeroesModificar = new javax.swing.JButton();
        jLabelName = new javax.swing.JLabel();
        TextFieldName = new javax.swing.JTextField();
        jLabelGenero = new javax.swing.JLabel();
        TextFieldGenero = new javax.swing.JTextField();
        jLabelSuperPoder = new javax.swing.JLabel();
        TextFieldHabilidad = new javax.swing.JTextField();
        jLabelCapa = new javax.swing.JLabel();
        TextFieldCapa = new javax.swing.JTextField();
        jButtonSuperHeroesGuardar = new javax.swing.JButton();
        jButtonSuperHeroesCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaSuperPoderes = new javax.swing.JTable();
        jButtonSuperPoderesInsertar = new javax.swing.JButton();
        jButtonSuperPoderesEliminar = new javax.swing.JButton();
        jButtonSuperPoderesModificar = new javax.swing.JButton();
        jLabelName1 = new javax.swing.JLabel();
        TextFieldName1 = new javax.swing.JTextField();
        jLabelDaño = new javax.swing.JLabel();
        TextFieldDaño = new javax.swing.JTextField();
        TextFieldPotencia = new javax.swing.JTextField();
        jLabelPotencia = new javax.swing.JLabel();
        jButtonSuperPoderesGuardar = new javax.swing.JButton();
        jButtonSuperPoderesCancelar = new javax.swing.JButton();
        jComboBoxSuperPoderes = new javax.swing.JComboBox<String>();
        jButtonCerrarVentana1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaVillanos = new javax.swing.JTable();
        jButtonVillanoInsertar = new javax.swing.JButton();
        jButtonVillanosEliminar = new javax.swing.JButton();
        jButtonVillanosModificar = new javax.swing.JButton();
        TextFieldVillanoName = new javax.swing.JTextField();
        TextFieldVillanoHabilidad = new javax.swing.JTextField();
        TextFieldVillanoGenero = new javax.swing.JTextField();
        TextFieldVillanoMascara = new javax.swing.JTextField();
        jLabelNameVillano = new javax.swing.JLabel();
        jLabelGenero1 = new javax.swing.JLabel();
        jLabelSuperPoder1 = new javax.swing.JLabel();
        jLabelCapa1 = new javax.swing.JLabel();
        jButtonVillanosGuardar = new javax.swing.JButton();
        jButtonVillanosCancelar = new javax.swing.JButton();
        jComboBoxVillanos = new javax.swing.JComboBox<String>();
        jButtonCerrarVentana2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaMarcas = new javax.swing.JTable();
        jButtonMarcaInsertar = new javax.swing.JButton();
        jButtonMarcaEliminar = new javax.swing.JButton();
        jButtonMarcaModificar = new javax.swing.JButton();
        TextFieldMarcaName = new javax.swing.JTextField();
        jLabelNameMarca = new javax.swing.JLabel();
        TextFieldMarcaAño = new javax.swing.JTextField();
        TextFieldMarcaPelicula = new javax.swing.JTextField();
        jLabelAño = new javax.swing.JLabel();
        jLabelPelicula = new javax.swing.JLabel();
        jButtonMarcaGuardar = new javax.swing.JButton();
        jButtonMarcaCancelar = new javax.swing.JButton();
        jComboBoxMarcas = new javax.swing.JComboBox<String>();
        jButtonCerrarVentana3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TablaSuperHeroes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NAME", "HABILIDAD", "GENERO", "CAPA"
            }
        ));
        TablaSuperHeroes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaSuperHeroesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaSuperHeroes);

        jButtonCerrarVentana.setBackground(new java.awt.Color(0, 0, 153));
        jButtonCerrarVentana.setText("EXIT");
        jButtonCerrarVentana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarVentanaActionPerformed(evt);
            }
        });

        jButtonSuperHeroesInsertar.setText("INSERT");
        jButtonSuperHeroesInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuperHeroesInsertarActionPerformed(evt);
            }
        });

        jButtonSuperHeroesEliminar.setText("DELETE");
        jButtonSuperHeroesEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuperHeroesEliminarActionPerformed(evt);
            }
        });

        jButtonSuperHeroesModificar.setText("UPDATE");
        jButtonSuperHeroesModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuperHeroesModificarActionPerformed(evt);
            }
        });

        jLabelName.setText("NAME");

        jLabelGenero.setText("GENERO");

        TextFieldGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldGeneroActionPerformed(evt);
            }
        });

        jLabelSuperPoder.setText("HABILIDAD");

        jLabelCapa.setText("CAPA");

        jButtonSuperHeroesGuardar.setText("SAVE");
        jButtonSuperHeroesGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuperHeroesGuardarActionPerformed(evt);
            }
        });

        jButtonSuperHeroesCancelar.setText("CANCEL");
        jButtonSuperHeroesCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuperHeroesCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSuperHeroesEliminar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonSuperHeroesInsertar)
                                .addGap(40, 40, 40)
                                .addComponent(jButtonCerrarVentana))
                            .addComponent(jButtonSuperHeroesModificar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelName)
                            .addComponent(jLabelGenero))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSuperHeroesGuardar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextFieldGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabelSuperPoder)
                                            .addComponent(jLabelCapa))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TextFieldHabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TextFieldCapa, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jButtonSuperHeroesCancelar)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButtonSuperHeroesInsertar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSuperHeroesEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSuperHeroesModificar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCerrarVentana)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelName))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TextFieldHabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelSuperPoder)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TextFieldGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelGenero))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TextFieldCapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelCapa)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSuperHeroesGuardar)
                    .addComponent(jButtonSuperHeroesCancelar))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SUPERHEROES", jPanel1);

        TablaSuperPoderes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NAME", "DAÑO", "POTENCIA", "SUPERHEROE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaSuperPoderes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaSuperPoderesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaSuperPoderes);

        jButtonSuperPoderesInsertar.setText("INSERT");
        jButtonSuperPoderesInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuperPoderesInsertarActionPerformed(evt);
            }
        });

        jButtonSuperPoderesEliminar.setText("DELETE");
        jButtonSuperPoderesEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuperPoderesEliminarActionPerformed(evt);
            }
        });

        jButtonSuperPoderesModificar.setText("UPDATE");
        jButtonSuperPoderesModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuperPoderesModificarActionPerformed(evt);
            }
        });

        jLabelName1.setText("NAME");

        jLabelDaño.setText("DAÑO");

        TextFieldPotencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldPotenciaActionPerformed(evt);
            }
        });

        jLabelPotencia.setText("POTENCIA");

        jButtonSuperPoderesGuardar.setText("SAVE");
        jButtonSuperPoderesGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuperPoderesGuardarActionPerformed(evt);
            }
        });

        jButtonSuperPoderesCancelar.setText("CANCEL");
        jButtonSuperPoderesCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuperPoderesCancelarActionPerformed(evt);
            }
        });

        jComboBoxSuperPoderes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxSuperPoderesMouseClicked(evt);
            }
        });
        jComboBoxSuperPoderes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSuperPoderesActionPerformed(evt);
            }
        });

        jButtonCerrarVentana1.setBackground(new java.awt.Color(0, 0, 153));
        jButtonCerrarVentana1.setText("EXIT");
        jButtonCerrarVentana1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarVentana1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelName1)
                    .addComponent(jLabelPotencia))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonSuperPoderesGuardar)
                            .addComponent(TextFieldName1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addComponent(jLabelDaño)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextFieldDaño, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSuperPoderesCancelar)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextFieldPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jComboBoxSuperPoderes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSuperPoderesEliminar)
                            .addComponent(jButtonSuperPoderesModificar))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonSuperPoderesInsertar)
                        .addGap(70, 70, 70)
                        .addComponent(jButtonCerrarVentana1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCerrarVentana1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jButtonSuperPoderesInsertar)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonSuperPoderesEliminar)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonSuperPoderesModificar))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName1)
                    .addComponent(TextFieldName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDaño)
                    .addComponent(TextFieldDaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPotencia)
                    .addComponent(jComboBoxSuperPoderes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSuperPoderesGuardar)
                    .addComponent(jButtonSuperPoderesCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SUPERPODERES", jPanel2);

        jScrollPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane3MouseClicked(evt);
            }
        });

        TablaVillanos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NAME", "HABILIDAD", "GENERO", "MASCARA", "SUPERHEROE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaVillanos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaVillanosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TablaVillanos);

        jButtonVillanoInsertar.setText("INSERT");
        jButtonVillanoInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVillanoInsertarActionPerformed(evt);
            }
        });

        jButtonVillanosEliminar.setText("DELETE");
        jButtonVillanosEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVillanosEliminarActionPerformed(evt);
            }
        });

        jButtonVillanosModificar.setText("UPDATE");
        jButtonVillanosModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVillanosModificarActionPerformed(evt);
            }
        });

        TextFieldVillanoName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldVillanoNameActionPerformed(evt);
            }
        });

        TextFieldVillanoGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldVillanoGeneroActionPerformed(evt);
            }
        });

        jLabelNameVillano.setText("NAME");

        jLabelGenero1.setText("GENERO");

        jLabelSuperPoder1.setText("HABILIDAD");

        jLabelCapa1.setText("MASCARA");

        jButtonVillanosGuardar.setText("SAVE");
        jButtonVillanosGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVillanosGuardarActionPerformed(evt);
            }
        });

        jButtonVillanosCancelar.setText("CANCEL");
        jButtonVillanosCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVillanosCancelarActionPerformed(evt);
            }
        });

        jComboBoxVillanos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxVillanosActionPerformed(evt);
            }
        });

        jButtonCerrarVentana2.setBackground(new java.awt.Color(0, 0, 153));
        jButtonCerrarVentana2.setText("EXIT");
        jButtonCerrarVentana2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarVentana2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonVillanoInsertar, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButtonVillanosEliminar))
                            .addComponent(jButtonVillanosModificar)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabelNameVillano)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextFieldVillanoName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButtonVillanosGuardar)
                                .addGap(64, 64, 64))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabelGenero1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextFieldVillanoGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jButtonVillanosCancelar))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelSuperPoder1)
                                    .addComponent(jLabelCapa1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextFieldVillanoMascara, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextFieldVillanoHabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jComboBoxVillanos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(81, 81, 81)
                .addComponent(jButtonCerrarVentana2)
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonVillanoInsertar)
                            .addComponent(jButtonCerrarVentana2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonVillanosEliminar)
                        .addGap(27, 27, 27)
                        .addComponent(jButtonVillanosModificar))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldVillanoName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldVillanoHabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNameVillano)
                    .addComponent(jLabelSuperPoder1))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldVillanoMascara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCapa1)
                    .addComponent(jComboBoxVillanos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldVillanoGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGenero1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVillanosGuardar)
                    .addComponent(jButtonVillanosCancelar))
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("VILLANOS", jPanel3);

        TablaMarcas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NAME", "AÑO ", "PELICULA", "VILLANOS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaMarcas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMarcasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TablaMarcas);

        jButtonMarcaInsertar.setText("INSERT");
        jButtonMarcaInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMarcaInsertarActionPerformed(evt);
            }
        });

        jButtonMarcaEliminar.setText("DELETE");
        jButtonMarcaEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMarcaEliminarActionPerformed(evt);
            }
        });

        jButtonMarcaModificar.setText("UPDATE");
        jButtonMarcaModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMarcaModificarActionPerformed(evt);
            }
        });

        TextFieldMarcaName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldMarcaNameActionPerformed(evt);
            }
        });

        jLabelNameMarca.setText("NAME");

        TextFieldMarcaPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldMarcaPeliculaActionPerformed(evt);
            }
        });

        jLabelAño.setText("AÑO");

        jLabelPelicula.setText("PELICULA");

        jButtonMarcaGuardar.setText("SAVE");
        jButtonMarcaGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMarcaGuardarActionPerformed(evt);
            }
        });

        jButtonMarcaCancelar.setText("CANCEL");
        jButtonMarcaCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMarcaCancelarActionPerformed(evt);
            }
        });

        jComboBoxMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMarcasActionPerformed(evt);
            }
        });

        jButtonCerrarVentana3.setBackground(new java.awt.Color(0, 0, 153));
        jButtonCerrarVentana3.setText("EXIT");
        jButtonCerrarVentana3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarVentana3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNameMarca)
                    .addComponent(jLabelPelicula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonMarcaGuardar)
                            .addComponent(TextFieldMarcaName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabelAño)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextFieldMarcaAño, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonMarcaCancelar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(TextFieldMarcaPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(212, 212, 212))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonMarcaModificar)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonMarcaEliminar)
                            .addComponent(jButtonMarcaInsertar))))
                .addGap(30, 30, 30)
                .addComponent(jButtonCerrarVentana3)
                .addGap(29, 29, 29))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonMarcaInsertar)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jButtonCerrarVentana3)))
                        .addGap(17, 17, 17)
                        .addComponent(jButtonMarcaEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonMarcaModificar))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldMarcaName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNameMarca)
                    .addComponent(TextFieldMarcaAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAño))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TextFieldMarcaPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelPelicula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMarcaGuardar)
                    .addComponent(jButtonMarcaCancelar))
                .addGap(29, 29, 29))
        );

        jTabbedPane1.addTab("MARCA", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarVentanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarVentanaActionPerformed
        // TODO add your handling code here:
         ActualizarTablaSuperHeroes(superheroes);
         ActualizarTablaSuperPoderes(superpoderes);
         ActualizarTablaVillanos(villanos);
       
        SuperPoderesLeerEscribirFicheros.EscribirFicherosSuperPoderes(superpoderes);
        SuperHeroesLeerEscribirFicheros.EscribirFicherosSuperHeroes(superheroes);
        VillanosLeeryEscribirFicheros.EscribirFicheroVillanos(villanos);
       // System.out.println("array " + superpoderes.size());
        // for(int j=0; j<superheroes.size(); j++)
        //System.out.println("Array superheroes antes de salir" + superheroes.get(j).getNombre() + superheroes.get(j).getId_SuperHeroe());

        System.exit(0);
    }//GEN-LAST:event_jButtonCerrarVentanaActionPerformed

    private void jButtonSuperHeroesInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuperHeroesInsertarActionPerformed
        // TODO add your handling code here:
        //Bloqeo los botones Modificar y Eliminar
    jButtonSuperHeroesModificar.setEnabled(false);
    jButtonSuperHeroesEliminar.setEnabled(false); 
    
    //Pongo los cmapos en vacio 
    this.SuperHeroesLimpiarTextField();
        
    //Desbloqueo los "TextField" para poder editarlos
     this.PrimeraTablaBloquearoDesbloquearEscrituraTextField(0);
    //Traigo los valores de cada uno de los textfield y me creo las variables para poder mandarselas al constructor
                            //e introducirlo en el vector para evitar repetidos
        
    }//GEN-LAST:event_jButtonSuperHeroesInsertarActionPerformed

    private void jButtonSuperHeroesEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuperHeroesEliminarActionPerformed
        // TODO add your handling code here:
        int contador = 0;
        
        //Primero realizamos un filtro por si no se ha realizado
        //ninguna tabla no te deje eliminar ninguna fila
        
        if(TablaSuperHeroes.getSelectedRow() != -1){
            
          
            
           //ELIMINACION DE LAS OTRAS TABLAS   
          
            //SUPERPODERES
            
            for(int i=0; i<superpoderes.size();i++){
                
              
            
                System.out.println("COMPARACION : " );
                System.out.println("SELECCIONADO : " + "Nombre SuperHeroe : " + superheroes.get(TablaSuperHeroes.getSelectedRow()).getNombre() + " " + "Id_SuperHeroe : " + superheroes.get(TablaSuperHeroes.getSelectedRow()).getId_SuperHeroe());
                System.out.println("Nombre SuperPoder : " + superpoderes.get(i).getNombrePoder() + " " + "Id_SuperPoder : " + superpoderes.get(i).getId_SuperHeroe()+ "FK : " + superpoderes.get(i).getId_SuperHeroe());
              
                
                //Comprobar si tiene alguna entidad con el mismo id en esa tabla
                
               if(superheroes.get(TablaSuperHeroes.getSelectedRow()).getId_SuperHeroe() == superpoderes.get(i).getId_SuperHeroe()){
                
                    if(contador < 1)
                        JOptionPane.showMessageDialog(null, "CUIDADO Ha Eliminado todos los datos relacionados con esta ENTIDAD", "alert", JOptionPane.ERROR_MESSAGE);
                         contador++;
                    System.out.println("Eliminado!!");
                //ELIMINACION SEGUNDA TABLA
    
                superpoderes.remove(i);
                //this.ActualizarTablaSuperHeroes(superheroes);
               
                
               }
            }
            
            contador = 0;
            //VILLANOS
            for(int i=0; i<villanos.size();i++){
                
              
            
                System.out.println("COMPARACION : " );
                System.out.println("SELECCIONADO : " + "Nombre SuperHeroe : " + superheroes.get(TablaSuperHeroes.getSelectedRow()).getNombre() + " " + "Id_SuperHeroe : " + superheroes.get(TablaSuperHeroes.getSelectedRow()).getId_SuperHeroe());
                System.out.println("Nombre villanos : " + villanos.get(i).getNombreVillano()+ " " + "Id_Villano : " + villanos.get(i).getId_Villano()+ "FK : " + villanos.get(i).getId_SuperHeroe());
              
                
                //Comprobar si tiene alguna entidad con el mismo id en esa tabla
                
               if(superheroes.get(TablaSuperHeroes.getSelectedRow()).getId_SuperHeroe() == villanos.get(i).getId_SuperHeroe()){
                
                    if(contador < 1)
                        JOptionPane.showMessageDialog(null, "CUIDADO Ha Eliminado todos los datos relacionados con esta ENTIDAD", "alert", JOptionPane.ERROR_MESSAGE);
                         contador++;
                         
                    System.out.println("Eliminado!!");
                //ELIMINACION SEGUNDA TABLA
    
                villanos.remove(i);
                //this.ActualizarTablaSuperHeroes(superheroes);
               
                
               }
            }
            
            this.superheroes.remove(superheroes.get(TablaSuperHeroes.getSelectedRow()));
            
            this.SuperHeroesActualizarIDS(superheroes);
            this.SuperPoderesActualizarIDS(superpoderes);
            this.VillosActualizarIDS(villanos);
          
            this.ActualizarTablaSuperHeroes(superheroes);
            this.ActualizarTablaSuperPoderes(superpoderes);
            this.ActualizarTablaVillanos(villanos);
            //Actualizo el combobox de los objetos relacionados
            LlenarComboBox();
          
            
            //Pongo los huecos en blanco despues de Eliminar en la tabla y en el vector
            this.SuperHeroesLimpiarTextField();
            
        }else{
            
            JOptionPane.showMessageDialog(null, "No has seleccionado ninguna fila", "alert", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButtonSuperHeroesEliminarActionPerformed

    private void jButtonSuperHeroesModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuperHeroesModificarActionPerformed
        // TODO add your handling code here:
         //Filtro con mensaje si no ha seleccionado ninguna fila
        if(TablaSuperHeroes.getSelectedRow() != -1){
            
            //Bloqueo los demas botones para que el usuario no tenga acceso en ese momento hasta que le de a guardar
            jButtonSuperHeroesInsertar.setEnabled(false);
            jButtonSuperHeroesEliminar.setEnabled(false);
            
            //Desbloqueo los textfield para poder modificarlos
            this.PrimeraTablaBloquearoDesbloquearEscrituraTextField(0);

                //this.superheroes.get(Tabla.getSelectedRow()).setNombre(TextFieldName.getText());
                //this.superheroes.get(Tabla.getSelectedRow()).setHabilidad(TextFieldHabilidad.getText());
                //this.superheroes.get(Tabla.getSelectedRow()).setGenero(Character.toString(TextFieldGenero.getText()));
                //this.superheroes.get(Tabla.getSelectedRow()).setCapa(Boolean.toStringTextFieldCapa.getText());
        }else{
            
            JOptionPane.showMessageDialog(null, "No has seleccionado ninguna fila", "alert", JOptionPane.ERROR_MESSAGE);
        }        
            
    }//GEN-LAST:event_jButtonSuperHeroesModificarActionPerformed

    private void jButtonSuperHeroesGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuperHeroesGuardarActionPerformed
     
        //Creo nuevas variables guardando lo introducido por el usuario 
       //para utilizarlas mas comodamente en el modulo
        boolean encontrado = false;
       
        String nombre = this.TextFieldName.getText();
        String Habilidad = this.TextFieldHabilidad.getText();
        boolean capa = Boolean.valueOf(this.TextFieldCapa.getText());
        //Esta sentencia no funciona. ?
        //char genero = this.TextFieldGenero.getText().charAt(0);
        
        //System.out.println(genero);
        
        
        if(jButtonSuperHeroesInsertar.isEnabled() == true){
            
        //Aqui contemplo el caso para si estan las celdas vacias no me deje insertar nada
        
            if (!"".equals(this.TextFieldName.getText().trim()) && !"".equals(this.TextFieldHabilidad.getText().trim())
                 && !"".equals(this.TextFieldGenero.getText().trim()) && !"".equals(this.TextFieldCapa.getText().trim()) ) {
        
            
                 if(this.TextFieldGenero.getText().length() == 1 && this.TextFieldGenero.getText().charAt(0) == 'H' || this.TextFieldGenero.getText().charAt(0) == 'M'){

                    
                              
                               //BUSQUEDA NOMBRE Recorro EL ARRAY SUPERHEROES 
                                   for(int i=0; i<superheroes.size() && encontrado == false; i++){


                                   //Compruebo si el supeheroe existe en el sistema
                                       if(!this.TextFieldName.getText().equals(superheroes.get(i).getNombre())){

                                           //DEBUG COMO RECORRE EL BUCKLE


                                       }else{

                                           //for de debug para saber los superheroes que hay cuando EL NOMBRE YA EXISTE
                                           for(int j=0; j<superheroes.size(); j++)
                                           System.out.println( "superheroes que hay cuando EL NOMBRE YA EXISTE" + superheroes.get(j).getNombre() + superheroes.get(j).getId_SuperHeroe());

                                           JOptionPane.showMessageDialog(null, "Lo sentimos este nombre ya existe", "alert", JOptionPane.ERROR_MESSAGE);
                                           //System.out.println("Lo sentimos este nombreVillano ya existe");
                                            encontrado = true;

                                       }   
                     }

                     if(encontrado == false){

                            //Llamo a la clase object para dar espacio de memoria a la fila que voy a insertar
                            Object[] row = { this.TextFieldName.getText(), this.TextFieldHabilidad.getText(), this.TextFieldGenero.getText(), this.TextFieldCapa.getText()};  

                         
                            // Añado la nueva fila con los datos del NUEVO objeto superheroe a la tabla
                             modelo1.addRow(row);
                             
                           //Construyo un objeto de tipo usuario con los valores del usuario para introducirlo en el array
                             SuperHeroe nuevo = new SuperHeroe(nombre, Habilidad, capa, this.TextFieldGenero.getText().charAt(0)); 

                            //Inserto el objeto en el array
                             this.superheroes.add(nuevo);
                             
                            //Actualizo el combobox de los objetos relacionados
                             LlenarComboBox();
                             
                             //Guardo el tamaño del array de superheroes e inserto el nuevo id del superheroe 
                            int tamaño = this.TamañoSuperheroes();
                            nuevo.setId_SuperHeroe(tamaño-1);

                            //Una vez introducido el nuevo superheroe bloqueo y pongo en blanco de nuevo los TextField
                            this.SuperHeroesLimpiarTextField();

                            this.PrimeraTablaBloquearoDesbloquearEscrituraTextField(1);

                     }
                 }else{
                        JOptionPane.showMessageDialog(null, "Datos en los campos Incorrectos!", "Alert", JOptionPane.ERROR_MESSAGE); 
                 }
                   }else{
                        //BLOQUEO EL BOTON EN GUARDAR PARA PREVENIR ERRORES EN TIEMPO DE EJECUCION
                        jButtonSuperHeroesModificar.setEnabled(false);
                        JOptionPane.showMessageDialog(null, "No puedes insertar campos vacios", "Alert", JOptionPane.ERROR_MESSAGE);  
                 }
            
        }
        
        if(jButtonSuperHeroesModificar.isEnabled() == true){
           
            //Modifico el superheroe seleccionado en el array
            this.superheroes.get(TablaSuperHeroes.getSelectedRow()).setNombre(this.TextFieldName.getText());
            this.superheroes.get(TablaSuperHeroes.getSelectedRow()).setHabilidad(this.TextFieldHabilidad.getText());
            this.superheroes.get(TablaSuperHeroes.getSelectedRow()).setGenero(this.TextFieldGenero.getText().charAt(0));
            this.superheroes.get(TablaSuperHeroes.getSelectedRow()).setCapa(Boolean.valueOf(this.TextFieldName.getText()));
         
            //Refresco el Array en el Layout
            this.ActualizarTablaSuperHeroes(superheroes);
        }
        
        
        //Desbloqueo los botones
            jButtonSuperHeroesInsertar.setEnabled(true);
            jButtonSuperHeroesModificar.setEnabled(true);
            jButtonSuperHeroesEliminar.setEnabled(true);
            
        //Bloqueo la escritura
        //BLOQUEO LA ESCRITURA
       PrimeraTablaBloquearoDesbloquearEscrituraTextField(1);
    }//GEN-LAST:event_jButtonSuperHeroesGuardarActionPerformed

    private void jButtonSuperHeroesCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuperHeroesCancelarActionPerformed
        // TODO add your handling code here:
          
        this.SuperHeroesLimpiarTextField();
        this.PrimeraTablaBloquearoDesbloquearEscrituraTextField(1);
        //Desbloqueo los botones
            jButtonSuperHeroesInsertar.setEnabled(true);
            jButtonSuperHeroesModificar.setEnabled(true);
            jButtonSuperHeroesEliminar.setEnabled(true);
    }//GEN-LAST:event_jButtonSuperHeroesCancelarActionPerformed

    private void TablaSuperHeroesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaSuperHeroesMouseClicked
        // TODO add your handling code here:
        
        this.TextFieldName.setText(superheroes.get(TablaSuperHeroes.getSelectedRow()).getNombre());
        this.TextFieldHabilidad.setText(superheroes.get(TablaSuperHeroes.getSelectedRow()).getHabilidad());
        this.TextFieldCapa.setText(Boolean.toString(superheroes.get(TablaSuperHeroes.getSelectedRow()).isCapa()));
        this.TextFieldGenero.setText(Character.toString(superheroes.get(TablaSuperHeroes.getSelectedRow()).getGenero()));

        //this.ActualizarTablaSuperHeroes(superheroes);
    }//GEN-LAST:event_TablaSuperHeroesMouseClicked

    private void TablaSuperPoderesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaSuperPoderesMouseClicked
        // Inserto el superpoderseleccionado en los text FIELD con los datos respectivos en cada uno
       
      
        
        this.TextFieldName1.setText(superpoderes.get(TablaSuperPoderes.getSelectedRow()).getNombrePoder());
        this.TextFieldDaño.setText(Integer.toString(superpoderes.get(TablaSuperPoderes.getSelectedRow()).getDaño()));
        this.TextFieldPotencia.setText(Integer.toString(superpoderes.get(TablaSuperPoderes.getSelectedRow()).getPotencia()));
        //this.jComboBoxSuperPoderes.setSelectedItem(superpoderes.get(TablaSuperPoderes.getSelectedRow()));
        //this.superheroes.get(TablaSuperHeroes.getSelectedRow()).setNombre(this.TextFieldName.getText());
       
    }//GEN-LAST:event_TablaSuperPoderesMouseClicked

    private void jButtonSuperPoderesInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuperPoderesInsertarActionPerformed
     
        //Bloqeo los botones Modificar y Eliminar
    jButtonSuperPoderesModificar.setEnabled(false);
    jButtonSuperPoderesEliminar.setEnabled(false); 
    
    //DESBLOQUEO EL COMBOBOX AL INSERTAR Y LO RELLENO CON LOS VALORES DEL PRIMERO
    jComboBoxSuperPoderes.setEnabled(true);
    jComboBoxSuperPoderes.removeAllItems();
    this.LlenarComboBox();
    
    //Pongo los cmapos en vacio 
    this.SuperPoderesLimpiarTextField();
        
    //Desbloqueo los "TextField" para poder editarlos
    this.SegundaTablaBloquearoDesbloquearEscrituraTextField(0);
    //Traigo los valores de cada uno de los textfield y me creo las variables para poder mandarselas al constructor
                            //e introducirlo en el vector para evitar repetidos
        
    }//GEN-LAST:event_jButtonSuperPoderesInsertarActionPerformed

    private void jButtonSuperPoderesEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuperPoderesEliminarActionPerformed
        // TODO add your handling code here:
         
        //Primero realizamos un filtro por si no se ha realizado
        //ninguna tabla no te deje eliminar ninguna fila
        
        if(TablaSuperPoderes.getSelectedRow() != -1){
            
           
           //Elimino del vector
           superpoderes.remove(superpoderes.get(TablaSuperPoderes.getSelectedRow()));
         
           //Reordeno los ids de los superpoderes
           SuperPoderesActualizarIDS(superpoderes);
           
           //Actualizo la tabla
           this.ActualizarTablaSuperPoderes(superpoderes);
            
            //BLoqueo el combo box y lo dejo limpio
            jComboBoxSuperPoderes.setEnabled(false);
            jComboBoxSuperPoderes.removeAllItems();
            
            //Pongo los huecos en blanco despues de Eliminar en la tabla y en el vector
            this.SuperPoderesLimpiarTextField();
            
        }else{
            
            JOptionPane.showMessageDialog(null, "No has seleccionado ninguna fila", "alert", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButtonSuperPoderesEliminarActionPerformed

    private void jButtonSuperPoderesModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuperPoderesModificarActionPerformed
        // TODO add your handling code here:
           //Filtro con mensaje si no ha seleccionado ninguna fila
        if(TablaSuperPoderes.getSelectedRow() != -1){
            
            //Bloqueo los demas botones para que el usuario no tenga acceso en ese momento hasta que le de a guardar
            jButtonSuperPoderesInsertar.setEnabled(false);
            jButtonSuperPoderesEliminar.setEnabled(false);
           
            //DESBLOQUEO EL COMBOBOX AL INSERTAR Y LO RELLENO CON LOS VALORES DEL PRIMERO
            jComboBoxSuperPoderes.setEnabled(true);
            jComboBoxSuperPoderes.removeAllItems();
            this.LlenarComboBox();
            
            //Desbloqueo los textfield para poder modificarlos
            this.SegundaTablaBloquearoDesbloquearEscrituraTextField(0);

               
        }else{
            
            JOptionPane.showMessageDialog(null, "No has seleccionado ninguna fila", "alert", JOptionPane.ERROR_MESSAGE);
        }        

    }//GEN-LAST:event_jButtonSuperPoderesModificarActionPerformed

    private void jButtonSuperPoderesGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuperPoderesGuardarActionPerformed
         // TODO add your handling code here:
        
        
      
        boolean encontrado = false;
     
        
        //Esta sentencia no funciona. ?
        //char genero = this.TextFieldGenero.getText().charAt(0);
        
        //System.out.println(genero);
        
        
        if(jButtonSuperPoderesInsertar.isEnabled() == true){
        //Aqui contemplo el caso para si estan las celdas vacias no me deje insertar nada
        
            if (!"".equals(this.TextFieldName1.getText().trim()) && !"".equals(this.TextFieldDaño.getText().trim())
                 && !"".equals(this.TextFieldPotencia.getText().trim())) {

                          
                              

                               //BUSQUEDA NOMBRE Recorro EL ARRAY SUPERHEROES 
                                   for(int i=0; i<superpoderes.size() && encontrado == false; i++){


                                   //Compruebo si el nombreVillano existe en el sistema
                                       if(!this.TextFieldName1.getText().equals(superpoderes.get(i).getNombrePoder())){

                                           //DEBUG COMO RECORRE EL BUCKLE


                                       }else{

                                           //for de debug para saber los superheroes que hay cuando EL NOMBRE YA EXISTE
                                           for(int j=0; j<superpoderes.size(); j++){};
                                          // System.out.println(superpoderes.get(j).getNombrePoder() + superpoderes.get(j).getId_SuperPoder());
                                           //System.out.println("entra");
                                           JOptionPane.showMessageDialog(null, "Lo sentimos este nombre ya existe", "alert", JOptionPane.ERROR_MESSAGE);
                                           //System.out.println("Lo sentimos este nombreVillano ya existe");
                                            encontrado = true;

                                       }   
                     }

                     if(encontrado == false){
                              
                            String NombrePoder = this.TextFieldName1.getText();

                            int Daño = Integer.parseInt(this.TextFieldDaño.getText());

                            int Potencia = Integer.parseInt(this.TextFieldPotencia.getText());
                         
                             //Seleccion del combobox pero no tengo aun el id del objeto padre seleccionado es justo la posicion que se encuentra en el vector
                            int seleccion = jComboBoxSuperPoderes.getSelectedIndex();
                            int id_superHeroe = 0;
                           id_superHeroe = superheroes.get(seleccion).getId_SuperHeroe();
                           
                              //Llamo a la clase object para dar espacio de memoria a la fila que voy a insertar
                            Object[] row = { this.TextFieldName1.getText(), this.TextFieldDaño.getText(), this.TextFieldPotencia.getText(),jComboBoxSuperPoderes.getItemAt(seleccion)};  
                                                                                                                                            //Traigo el string del item seleccionado en el comobox
                            // Añado la nueva fila con los datos del NUEVO objeto superheroe a la tabla
                            modelo2.addRow(row);
                          
                             
                            //Construyo un objeto de tipo superpoder enlazado con la tabla superheroes y los atributos introducidos por el usuario
                             SuperPoder nuevo = new SuperPoder(id_superHeroe, NombrePoder, Daño, Potencia, jComboBoxSuperPoderes.getItemAt(seleccion)); 
                             

                            //Inserto el objeto en el array
                             this.superpoderes.add(nuevo);
                             
                             //Guardo el tamaño del array de superpodere e inserto el nuevo id del superpoder 
                            int tamaño = superpoderes.size();
                            nuevo.setId_SuperPoder(tamaño-1);

                            //Una vez introducido el nuevo superheroe bloqueo y pongo en blanco de nuevo los TextField
                            SuperPoderesLimpiarTextField();

                            SegundaTablaBloquearoDesbloquearEscrituraTextField(1);

                     }
               
                   }else{
                        jButtonSuperPoderesModificar.setEnabled(false);
                        JOptionPane.showMessageDialog(null, "No puedes insertar campos vacios", "Alert", JOptionPane.ERROR_MESSAGE);  
                 }
            
        }
        
        if(jButtonSuperPoderesModificar.isEnabled() == true){
           
            //Seleccion del combobox y guardo la Foreign Key
            int seleccion = jComboBoxSuperPoderes.getSelectedIndex();
            
            
           
            //Modifico el superpoder seleccionado
            
            this.superpoderes.get(TablaSuperPoderes.getSelectedRow()).setNombrePoder(this.TextFieldName1.getText());
            /*
            System.out.println("");
            System.out.println("");
            System.out.println("nombre"+this.TextFieldName.getText() );
            */
            this.superpoderes.get(TablaSuperPoderes.getSelectedRow()).setDaño(Integer.parseInt(this.TextFieldDaño.getText()));
            this.superpoderes.get(TablaSuperPoderes.getSelectedRow()).setPotencia(Integer.parseInt(this.TextFieldPotencia.getText()));
            this.superpoderes.get(TablaSuperPoderes.getSelectedRow()).setId_SuperHeroe(seleccion);
            this.superpoderes.get(TablaSuperPoderes.getSelectedRow()).setNombreSuperHeroe(jComboBoxSuperPoderes.getItemAt(seleccion));
            
            
            //Refresco el Array en el Layout
           this.ActualizarTablaSuperPoderes(superpoderes);
        }
        
        
        //Desbloqueo los botones
            jButtonSuperPoderesInsertar.setEnabled(true);
            jButtonSuperPoderesModificar.setEnabled(true);
            jButtonSuperPoderesEliminar.setEnabled(true);
            
        //Bloqueo ComboBox
            jComboBoxSuperPoderes.setEnabled(false);
            
             //this.ActualizarTablaSuperPoderes(superpoderes);
            
        //BLOQUEO Y LIMPIO LA ESCRITURA
        SegundaTablaBloquearoDesbloquearEscrituraTextField(1);
        this.SuperPoderesLimpiarTextField();
        
    }//GEN-LAST:event_jButtonSuperPoderesGuardarActionPerformed

    private void jButtonSuperPoderesCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuperPoderesCancelarActionPerformed
        // TODO add your handling code here:
          // TODO add your handling code here:
          
        this.SuperPoderesLimpiarTextField();
        this.SegundaTablaBloquearoDesbloquearEscrituraTextField(1);
        //Desbloqueo los botones
            jButtonSuperPoderesInsertar.setEnabled(true);
            jButtonSuperPoderesModificar.setEnabled(true);
            jButtonSuperPoderesEliminar.setEnabled(true);
            jComboBoxSuperPoderes.setEnabled(false);
       
        
    }//GEN-LAST:event_jButtonSuperPoderesCancelarActionPerformed

    private void TextFieldPotenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldPotenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldPotenciaActionPerformed

    private void jComboBoxSuperPoderesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSuperPoderesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSuperPoderesActionPerformed

    private void TablaVillanosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaVillanosMouseClicked
        // TODO add your handling code here:
        this.TextFieldVillanoName.setText((villanos.get(TablaVillanos.getSelectedRow()).getNombreVillano()));
        this.TextFieldVillanoHabilidad.setText((villanos.get(TablaVillanos.getSelectedRow()).getHabilidad()));
        this.TextFieldVillanoGenero.setText(Character.toString(villanos.get(TablaVillanos.getSelectedRow()).getGenero()));
        this.TextFieldVillanoMascara.setText(Boolean.toString(villanos.get(TablaVillanos.getSelectedRow()).isMascara()));

       
      // this.ActualizarTablaVillanos(villanos); 
    }//GEN-LAST:event_TablaVillanosMouseClicked

    private void jButtonVillanoInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVillanoInsertarActionPerformed
    
            //Bloqeo los botones Modificar y Eliminar
    jButtonVillanosModificar.setEnabled(false);
    jButtonVillanosEliminar.setEnabled(false); 
    
    //DESBLOQUEO EL COMBOBOX AL INSERTAR Y LO RELLENO CON LOS VALORES DEL PRIMERO
    jComboBoxVillanos.setEnabled(true);
    jComboBoxVillanos.removeAllItems();
    this.LlenarComboBox();
    
    //Pongo los cmapos en vacio 
    this.VillanosLimpiarTextField();
        
    //Desbloqueo los "TextField" para poder editarlos
    this.TerceraTablaBloquearoDesbloquearEscrituraTextField(0);
    //Traigo los valores de cada uno de los textfield y me creo las variables para poder mandarselas al constructor
                            //e introducirlo en el vector para evitar repetidos
          
    }//GEN-LAST:event_jButtonVillanoInsertarActionPerformed

    private void jButtonVillanosEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVillanosEliminarActionPerformed
          // TODO add your handling code here:
         
        //Primero realizamos un filtro por si no se ha realizado
        //ninguna tabla no te deje eliminar ninguna fila
        
        if(TablaVillanos.getSelectedRow() != -1){
          
            
           
           //Elimino del vector
           villanos.remove(villanos.get(TablaVillanos.getSelectedRow()));
         
           //Reordeno los ids de los superpoderes
           VillosActualizarIDS(villanos);
           
           //Actualizo la tabla
           this.ActualizarTablaVillanos(villanos);
            
            //BLoqueo el combo box y lo dejo limpio
            jComboBoxVillanos.setEnabled(false);
            jComboBoxVillanos.removeAllItems();
            
            //Pongo los huecos en blanco despues de Eliminar en la tabla y en el vector
            this.VillanosLimpiarTextField();
            
        }else{
            
            JOptionPane.showMessageDialog(null, "No has seleccionado ninguna fila", "alert", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButtonVillanosEliminarActionPerformed

    private void jButtonVillanosModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVillanosModificarActionPerformed
            //Filtro con mensaje si no ha seleccionado ninguna fila
        if(TablaVillanos.getSelectedRow() != -1){
               
            //Bloqueo los demas botones para que el usuario no tenga acceso en ese momento hasta que le de a guardar
            jButtonVillanoInsertar.setEnabled(false);
            jButtonVillanosEliminar.setEnabled(false);
           
            //DESBLOQUEO EL COMBOBOX AL INSERTAR Y LO RELLENO CON LOS VALORES DEL PRIMERO
            jComboBoxVillanos.setEnabled(true);
            jComboBoxVillanos.removeAllItems();
            this.LlenarComboBox();
            
            //Desbloqueo los textfield para poder modificarlos
            this.TerceraTablaBloquearoDesbloquearEscrituraTextField(0);


        }else{
            
            JOptionPane.showMessageDialog(null, "No has seleccionado ninguna fila TONTO", "alert", JOptionPane.ERROR_MESSAGE);
        }        

    }//GEN-LAST:event_jButtonVillanosModificarActionPerformed

    private void TextFieldVillanoGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldVillanoGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldVillanoGeneroActionPerformed

    private void jButtonVillanosGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVillanosGuardarActionPerformed
        // TODO add your handling code here:
          
        //Creo nuevas variables guardando lo introducido por el usuario 
       //para utilizarlas mas comodamente en el modulo
        boolean encontrado = false;
       
        String VillanoName = this.TextFieldVillanoName.getText();
        String VillanoHabilidad = this.TextFieldVillanoHabilidad.getText();
        boolean Mascara = Boolean.valueOf(this.TextFieldVillanoMascara.getText());
        //Esta sentencia no funciona. ?
        char genero = this.TextFieldVillanoGenero.getText().charAt(0);
        
        //System.out.println(genero);
        
        
        if(jButtonVillanoInsertar.isEnabled() == true){
        //Aqui contemplo el caso para si estan las celdas vacias no me deje insertar nada
        
            if (!"".equals(this.TextFieldVillanoName.getText().trim()) && !"".equals(this.TextFieldVillanoHabilidad.getText().trim())
                 && !"".equals(this.TextFieldVillanoGenero.getText().trim()) && !"".equals(this.TextFieldVillanoMascara.getText().trim()) ) {

                 if(this.TextFieldVillanoGenero.getText().length() == 1 && this.TextFieldVillanoGenero.getText().charAt(0) == 'H' || this.TextFieldVillanoGenero.getText().charAt(0) == 'M'){

                           
                               //BUSQUEDA NOMBRE Recorro EL ARRAY SUPERHEROES 
                                   for(int i=0; i<villanos.size() && encontrado == false; i++){


                                   //Compruebo si el nombreVillano existe en el sistema
                                       if(!this.TextFieldVillanoName.getText().equals(villanos.get(i).getNombreVillano())){

                                           //DEBUG COMO RECORRE EL BUCKLE


                                       }else{

                                           //for de debug para saber los superheroes que hay cuando EL NOMBRE YA EXISTE
                                           for(int j=0; j<villanos.size(); j++)
                                           System.out.println(villanos.get(j).getNombreVillano() + villanos.get(j).getId_SuperHeroe());

                                           JOptionPane.showMessageDialog(null, "Lo sentimos este nombre ya existe", "alert", JOptionPane.ERROR_MESSAGE);
                                           //System.out.println("Lo sentimos este nombreVillano ya existe");
                                            encontrado = true;

                                       }   
                     }

                     if(encontrado == false){
                         
                       
                              //Seleccion del combobox pero no tengo aun el id del objeto padre seleccionado es justo la posicion que se encuentra en el vector
                            int seleccion = jComboBoxVillanos.getSelectedIndex();
                            int id_SuperHeroe = 0;
                            id_SuperHeroe = superheroes.get(seleccion).getId_SuperHeroe();
                           
                              //Llamo a la clase object para dar espacio de memoria a la fila que voy a insertar
                            Object[] row = { this.TextFieldVillanoName.getText(), this.TextFieldVillanoHabilidad.getText(), this.TextFieldVillanoGenero.getText(),this.TextFieldVillanoMascara.getText(),jComboBoxVillanos.getItemAt(seleccion)};  
                                                                                                                                            //Traigo el string del item seleccionado en el comobox
                            // Añado la nueva fila con los datos del NUEVO objeto superheroe a la tabla
                            modelo3.addRow(row);
                          
                            
                             
                            //Construyo un objeto de tipo superpoder enlazado con la tabla superheroes y los atributos introducidos por el usuario
                             Villano nuevo = new Villano(id_SuperHeroe,  VillanoName, VillanoHabilidad, Mascara, this.TextFieldVillanoGenero.getText().charAt(0), jComboBoxVillanos.getItemAt(seleccion)); 
                             

                            //Inserto el objeto en el array
                             this.villanos.add(nuevo);
                             
                             //Guardo el tamaño del array de superpodere e inserto el nuevo id del superpoder 
                            int tamaño = villanos.size();
                            nuevo.setId_Villano(tamaño-1);

                            //Una vez introducido el nuevo superheroe bloqueo y pongo en blanco de nuevo los TextField
                            VillanosLimpiarTextField();

                            TerceraTablaBloquearoDesbloquearEscrituraTextField(1);

                     }
                 }else{
                        JOptionPane.showMessageDialog(null, "Datos en los campos Incorrectos!", "Alert", JOptionPane.ERROR_MESSAGE); 
                 }
                   }else{
                        JOptionPane.showMessageDialog(null, "No puedes insertar campos vacios", "Alert", JOptionPane.ERROR_MESSAGE);  
                 }
            
        }
       
       
        
        if(jButtonVillanosModificar.isEnabled() == true){
             int seleccion = jComboBoxVillanos.getSelectedIndex();
            
            //Modifico el superheroe seleccionado
            this.villanos.get(TablaVillanos.getSelectedRow()).setNombreVillano(this.TextFieldVillanoName.getText());
            this.villanos.get(TablaVillanos.getSelectedRow()).setHabilidad(this.TextFieldVillanoHabilidad.getText());
            this.villanos.get(TablaVillanos.getSelectedRow()).setGenero(this.TextFieldVillanoGenero.getText().charAt(0));
            this.villanos.get(TablaVillanos.getSelectedRow()).setMascara(Boolean.valueOf(this.TextFieldVillanoMascara.getText()));
            this.villanos.get(TablaVillanos.getSelectedRow()).setId_SuperHeroe((seleccion));
            this.villanos.get(TablaVillanos.getSelectedRow()).setNombreSuperHeroe(jComboBoxVillanos.getItemAt(seleccion));
            
            //Refresco el Array en el Layout
            this.ActualizarTablaVillanos(villanos);
        
           
        } 
       
            
         //Desbloqueo los botones
            jButtonVillanoInsertar.setEnabled(true);
            jButtonVillanosModificar.setEnabled(true);
            jButtonVillanosEliminar.setEnabled(true);
         
          //Bloqueo ComboBox
            jComboBoxVillanos.setEnabled(false);
            
             //this.ActualizarTablaSuperPoderes(superpoderes);
            
        //BLOQUEO Y LIMPIO LA ESCRITURA
       TerceraTablaBloquearoDesbloquearEscrituraTextField(1);
        this.VillanosLimpiarTextField();
            
      
    }//GEN-LAST:event_jButtonVillanosGuardarActionPerformed

    private void jButtonVillanosCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVillanosCancelarActionPerformed
        // TODO add your handling code here:
          this.VillanosLimpiarTextField();
        this.TerceraTablaBloquearoDesbloquearEscrituraTextField(1);
        //Desbloqueo los botones
            jButtonVillanoInsertar.setEnabled(true);
            jButtonVillanosModificar.setEnabled(true);
            jButtonVillanosEliminar.setEnabled(true);
            jComboBoxVillanos.setEnabled(false);
    }//GEN-LAST:event_jButtonVillanosCancelarActionPerformed

    private void jComboBoxVillanosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxVillanosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxVillanosActionPerformed

    private void TextFieldVillanoNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldVillanoNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldVillanoNameActionPerformed

    private void jComboBoxSuperPoderesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxSuperPoderesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSuperPoderesMouseClicked

    private void TablaMarcasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMarcasMouseClicked
        // TODO add your handling code here:
        this.TextFieldMarcaName.setText(marcas.get(TablaMarcas.getSelectedRow()).getNombreMarca());
        this.TextFieldMarcaAño.setText(Integer.toString(marcas.get(TablaMarcas.getSelectedRow()).getAño()));
        this.TextFieldMarcaPelicula.setText(Boolean.toString(marcas.get(TablaMarcas.getSelectedRow()).isPelicula()));
        
    }//GEN-LAST:event_TablaMarcasMouseClicked

    private void jButtonMarcaInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMarcaInsertarActionPerformed
    
        jButtonMarcaModificar.setEnabled(false);
        jButtonMarcaEliminar.setEnabled(false); 
        
         //DESBLOQUEO EL COMBOBOX AL INSERTAR Y LO RELLENO CON LOS VALORES DEL PRIMERO
        jComboBoxMarcas.setEnabled(true);
        jComboBoxMarcas.removeAllItems();
        this.LlenarComboBox();
        
        //Pongo los cmapos en vacio 
        this.MarcasLimpiarTextField();

        //Desbloqueo los "TextField" para poder editarlos
        this.CuartaTablaBloquearoDesbloquearEscrituraTextField(0);
        //Traigo los valores de cada uno de los textfield y me creo las variables para poder mandarselas al constructor
          
    }//GEN-LAST:event_jButtonMarcaInsertarActionPerformed

    private void jButtonMarcaEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMarcaEliminarActionPerformed
        // TODO add your handling code here:
           //Primero realizamos un filtro por si no se ha realizado
        //ninguna tabla no te deje eliminar ninguna fila
        
        if(TablaMarcas.getSelectedRow() != -1){
          
           marcas.remove(marcas.get(TablaMarcas.getSelectedRow()));
           //this.ActualizarTablaSuperHeroes(superheroes);
            modelo4.removeRow(TablaMarcas.getSelectedRow());
            //Pongo los huecos en blanco despues de Eliminar en la tabla y en el vector
            this.MarcasLimpiarTextField();
            
        }else{
            
            JOptionPane.showMessageDialog(null, "No has seleccionado ninguna fila", "alert", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButtonMarcaEliminarActionPerformed

    private void TextFieldMarcaNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldMarcaNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldMarcaNameActionPerformed

    private void TextFieldMarcaPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldMarcaPeliculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldMarcaPeliculaActionPerformed

    private void jButtonMarcaGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMarcaGuardarActionPerformed
        // TODO add your handling code here:
         boolean encontrado = false;
       
        String MarcaName = this.TextFieldMarcaName.getText();
        int Año = Integer.parseInt( this.TextFieldMarcaAño.getText());
        boolean Pelicula = Boolean.valueOf(this.TextFieldMarcaPelicula.getText());
     
        
        if(jButtonMarcaInsertar.isEnabled() == true){
        //Aqui contemplo el caso para si estan las celdas vacias no me deje insertar nada
        
            if (!"".equals(this.TextFieldMarcaName.getText().trim()) && !"".equals(this.TextFieldMarcaAño.getText().trim())
                 && !"".equals(this.TextFieldMarcaPelicula.getText().trim())) {

                
                               //BUSQUEDA NOMBRE Recorro EL ARRAY SUPERHEROES 
                                   for(int i=0; i<marcas.size() && encontrado == false; i++){


                                   //Compruebo si el nombreVillano existe en el sistema
                                       if(!this.TextFieldMarcaName.getText().equals(marcas.get(i).getNombreMarca())){

                                           //DEBUG COMO RECORRE EL BUCKLE


                                       }else{

                                           //for de debug para saber los superheroes que hay cuando EL NOMBRE YA EXISTE
                                           for(int j=0; j<marcas.size(); j++)
                                           System.out.println(marcas.get(j).getNombreMarca() + marcas.get(j).getId_Villano());

                                           JOptionPane.showMessageDialog(null, "Lo sentimos este nombre ya existe", "alert", JOptionPane.ERROR_MESSAGE);
                                           //System.out.println("Lo sentimos este nombreVillano ya existe");
                                            encontrado = true;

                                       }   
                     }

                     if(encontrado == false){
                               //Seleccion del combobox pero no tengo aun el id del objeto padre seleccionado es justo la posicion que se encuentra en el vector
                            int seleccion = jComboBoxMarcas.getSelectedIndex();
                            int id_SuperHeroe = 0;
                            id_SuperHeroe = superheroes.get(seleccion).getId_SuperHeroe();
                           
                              //Llamo a la clase object para dar espacio de memoria a la fila que voy a insertar
                            Object[] row = { this.TextFieldMarcaName.getText(), this.TextFieldMarcaAño.getText(), this.TextFieldMarcaPelicula.getText(),jComboBoxMarcas.getItemAt(seleccion)};  
                                                                                                                                            //Traigo el string del item seleccionado en el comobox
                            // Añado la nueva fila con los datos del NUEVO objeto superheroe a la tabla
                            modelo4.addRow(row);
                          
                            
                             
                            //Construyo un objeto de tipo superpoder enlazado con la tabla superheroes y los atributos introducidos por el usuario
                             Marca nuevo = new Marca(id_SuperHeroe,  MarcaName, Año, Pelicula,  jComboBoxMarcas.getItemAt(seleccion)); 
                             

                            //Inserto el objeto en el array
                             this.marcas.add(nuevo);
                             
                             //Guardo el tamaño del array de superpodere e inserto el nuevo id del superpoder 
                            int tamaño = marcas.size();
                            nuevo.setId_Villano(tamaño-1);

                            //Una vez introducido el nuevo superheroe bloqueo y pongo en blanco de nuevo los TextField
                            MarcasLimpiarTextField();

                            CuartaTablaBloquearoDesbloquearEscrituraTextField(1);

                     }
                
                   }else{
                        JOptionPane.showMessageDialog(null, "No puedes insertar campos vacios", "Alert", JOptionPane.ERROR_MESSAGE);  
                 }
            
        }
     
        if(jButtonVillanosModificar.isEnabled() == true){
           
            int seleccion = jComboBoxMarcas.getSelectedIndex();
            
            //Modifico el superheroe seleccionado
            this.marcas.get(TablaMarcas.getSelectedRow()).setNombreMarca(this.TextFieldMarcaName.getText());
            this.marcas.get(TablaMarcas.getSelectedRow()).setAño(Integer.valueOf(this.TextFieldMarcaAño.getText()));
            this.marcas.get(TablaMarcas.getSelectedRow()).setPelicula(Boolean.valueOf(this.TextFieldMarcaPelicula.getText()));
            this.marcas.get(TablaMarcas.getSelectedRow()).setId_Villano((seleccion));
            this.marcas.get(TablaMarcas.getSelectedRow()).setNombreVillano(jComboBoxMarcas.getItemAt(seleccion));
             //Refresco el Array en el Layout
            this.ActualizarTablaMarcas(marcas);
        } 
           
       
          //Desbloqueo los botones
            jButtonMarcaInsertar.setEnabled(true);
            jButtonMarcaModificar.setEnabled(true);
            jButtonMarcaEliminar.setEnabled(true);
         
          //Bloqueo ComboBox
            jComboBoxMarcas.setEnabled(false);
            
             //this.ActualizarTablaSuperPoderes(superpoderes);
            
        //BLOQUEO Y LIMPIO LA ESCRITURA
       CuartaTablaBloquearoDesbloquearEscrituraTextField(1);
        this.MarcasLimpiarTextField();
    }//GEN-LAST:event_jButtonMarcaGuardarActionPerformed

    private void jButtonMarcaCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMarcaCancelarActionPerformed
        // TODO add your handling code here:
           this.MarcasLimpiarTextField();
        this.TerceraTablaBloquearoDesbloquearEscrituraTextField(1);
        //Desbloqueo los botones
            jButtonMarcaInsertar.setEnabled(true);
            jButtonMarcaModificar.setEnabled(true);
            jButtonMarcaEliminar.setEnabled(true);
            jComboBoxMarcas.setEnabled(false);
    }//GEN-LAST:event_jButtonMarcaCancelarActionPerformed

    private void jComboBoxMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMarcasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMarcasActionPerformed

    private void jButtonMarcaModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMarcaModificarActionPerformed
        // TODO add your handling code here:
         if(TablaMarcas.getSelectedRow() != -1){
            
            //Bloqueo los demas botones para que el usuario no tenga acceso en ese momento hasta que le de a guardar
            jButtonMarcaInsertar.setEnabled(false);
            jButtonMarcaEliminar.setEnabled(false);
            
            //Desbloqueo los textfield para poder modificarlos
            this.CuartaTablaBloquearoDesbloquearEscrituraTextField(0);

        }else{
            
            JOptionPane.showMessageDialog(null, "No has seleccionado ninguna fila TONTO", "alert", JOptionPane.ERROR_MESSAGE);
        }        

    }//GEN-LAST:event_jButtonMarcaModificarActionPerformed

    private void jButtonCerrarVentana1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarVentana1ActionPerformed
        // ESCRIBIMOS LOS CAMBIOS EN LOS NUEVOS FICHEROS:
         ActualizarTablaSuperHeroes(superheroes);
         ActualizarTablaSuperPoderes(superpoderes);
         ActualizarTablaVillanos(villanos);
       
        SuperPoderesLeerEscribirFicheros.EscribirFicherosSuperPoderes(superpoderes);
        SuperHeroesLeerEscribirFicheros.EscribirFicherosSuperHeroes(superheroes);
        VillanosLeeryEscribirFicheros.EscribirFicheroVillanos(villanos);
       // System.out.println("array " + superpoderes.size());
        // for(int j=0; j<superheroes.size(); j++)
        //System.out.println("Array superheroes antes de salir" + superheroes.get(j).getNombre() + superheroes.get(j).getId_SuperHeroe());

        System.exit(0);
    }//GEN-LAST:event_jButtonCerrarVentana1ActionPerformed

    private void jScrollPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane3MouseClicked

    private void TextFieldGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldGeneroActionPerformed

    private void jButtonCerrarVentana2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarVentana2ActionPerformed
        // TODO add your handling code here:
         ActualizarTablaSuperHeroes(superheroes);
         ActualizarTablaSuperPoderes(superpoderes);
         ActualizarTablaVillanos(villanos);
         ActualizarTablaMarcas(marcas);
       
        SuperPoderesLeerEscribirFicheros.EscribirFicherosSuperPoderes(superpoderes);
        SuperHeroesLeerEscribirFicheros.EscribirFicherosSuperHeroes(superheroes);
        VillanosLeeryEscribirFicheros.EscribirFicheroVillanos(villanos);
        MarcasLeerEscribirFicheros.EscribirFicherosMarcas(marcas);
        //System.out.println("array " + superpoderes.size());
         for(int j=0; j<villanos.size(); j++)
        System.out.println("Array superheroes antes de salir" + villanos.get(j).getNombreVillano() + villanos.get(j).getId_Villano());

        System.exit(0);
    }//GEN-LAST:event_jButtonCerrarVentana2ActionPerformed

    private void jButtonCerrarVentana3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarVentana3ActionPerformed
        // TODO add your handling code here:
         ActualizarTablaSuperHeroes(superheroes);
         ActualizarTablaSuperPoderes(superpoderes);
         ActualizarTablaVillanos(villanos);
         ActualizarTablaMarcas(marcas);
       
        SuperPoderesLeerEscribirFicheros.EscribirFicherosSuperPoderes(superpoderes);
        SuperHeroesLeerEscribirFicheros.EscribirFicherosSuperHeroes(superheroes);
        VillanosLeeryEscribirFicheros.EscribirFicheroVillanos(villanos);
        MarcasLeerEscribirFicheros.EscribirFicherosMarcas(marcas);
        //System.out.println("array " + superpoderes.size());
         for(int j=0; j<marcas.size(); j++)
        System.out.println("Array marcas antes de salir" + marcas.get(j).getNombreMarca()+ marcas.get(j).getId_Marca());

        System.exit(0);
    }//GEN-LAST:event_jButtonCerrarVentana3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NUEVAInterfazUtilizable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NUEVAInterfazUtilizable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NUEVAInterfazUtilizable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NUEVAInterfazUtilizable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    new NUEVAInterfazUtilizable().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(NUEVAInterfazUtilizable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaMarcas;
    private javax.swing.JTable TablaSuperHeroes;
    private javax.swing.JTable TablaSuperPoderes;
    private javax.swing.JTable TablaVillanos;
    private javax.swing.JTextField TextFieldCapa;
    private javax.swing.JTextField TextFieldDaño;
    private javax.swing.JTextField TextFieldGenero;
    private javax.swing.JTextField TextFieldHabilidad;
    private javax.swing.JTextField TextFieldMarcaAño;
    private javax.swing.JTextField TextFieldMarcaName;
    private javax.swing.JTextField TextFieldMarcaPelicula;
    private javax.swing.JTextField TextFieldName;
    private javax.swing.JTextField TextFieldName1;
    private javax.swing.JTextField TextFieldPotencia;
    private javax.swing.JTextField TextFieldVillanoGenero;
    private javax.swing.JTextField TextFieldVillanoHabilidad;
    private javax.swing.JTextField TextFieldVillanoMascara;
    private javax.swing.JTextField TextFieldVillanoName;
    private javax.swing.JButton jButtonCerrarVentana;
    private javax.swing.JButton jButtonCerrarVentana1;
    private javax.swing.JButton jButtonCerrarVentana2;
    private javax.swing.JButton jButtonCerrarVentana3;
    private javax.swing.JButton jButtonMarcaCancelar;
    private javax.swing.JButton jButtonMarcaEliminar;
    private javax.swing.JButton jButtonMarcaGuardar;
    private javax.swing.JButton jButtonMarcaInsertar;
    private javax.swing.JButton jButtonMarcaModificar;
    private javax.swing.JButton jButtonSuperHeroesCancelar;
    private javax.swing.JButton jButtonSuperHeroesEliminar;
    private javax.swing.JButton jButtonSuperHeroesGuardar;
    private javax.swing.JButton jButtonSuperHeroesInsertar;
    private javax.swing.JButton jButtonSuperHeroesModificar;
    private javax.swing.JButton jButtonSuperPoderesCancelar;
    private javax.swing.JButton jButtonSuperPoderesEliminar;
    private javax.swing.JButton jButtonSuperPoderesGuardar;
    private javax.swing.JButton jButtonSuperPoderesInsertar;
    private javax.swing.JButton jButtonSuperPoderesModificar;
    private javax.swing.JButton jButtonVillanoInsertar;
    private javax.swing.JButton jButtonVillanosCancelar;
    private javax.swing.JButton jButtonVillanosEliminar;
    private javax.swing.JButton jButtonVillanosGuardar;
    private javax.swing.JButton jButtonVillanosModificar;
    private javax.swing.JComboBox<String> jComboBoxMarcas;
    private javax.swing.JComboBox<String> jComboBoxSuperPoderes;
    private javax.swing.JComboBox<String> jComboBoxVillanos;
    private javax.swing.JLabel jLabelAño;
    private javax.swing.JLabel jLabelCapa;
    private javax.swing.JLabel jLabelCapa1;
    private javax.swing.JLabel jLabelDaño;
    private javax.swing.JLabel jLabelGenero;
    private javax.swing.JLabel jLabelGenero1;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelName1;
    private javax.swing.JLabel jLabelNameMarca;
    private javax.swing.JLabel jLabelNameVillano;
    private javax.swing.JLabel jLabelPelicula;
    private javax.swing.JLabel jLabelPotencia;
    private javax.swing.JLabel jLabelSuperPoder;
    private javax.swing.JLabel jLabelSuperPoder1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
