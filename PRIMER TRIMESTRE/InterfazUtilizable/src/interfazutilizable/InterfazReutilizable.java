/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazutilizable;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RASPUTIN
 */
public class InterfazReutilizable extends javax.swing.JFrame {
//creo el array 
    DefaultTableModel modelo; //Para enlazar la tabla con el Layout
    private ArrayList<SuperHeroe> superheroes;
    
  
    /**
     * Creates new form InterfazReutilizable
     */
    public InterfazReutilizable() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        //Pongo los comandos a false para que no pueda escribir a noser que sea insertar o modificar
        
         this.TextFieldName.setEditable(false);
         this.TextFieldSuperpoder.setEditable(false);
         this.TextFieldGenero.setEditable(false);
         this.TextFieldCapa.setEditable(false);
        
         
        modelo = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column==4){
                    
                    return true;
                }else{
                    
                    return false;
                }
            }
        
            
        };
        modelo.addColumn("Name");
        modelo.addColumn("Super Poder");
        modelo.addColumn("Genero");
        modelo.addColumn("Capa");
        this.Tabla.setModel(modelo);
        
        this.superheroes = new ArrayList();
        this.UsuariosPredefinidos();
       
    }
    
    public void UsuariosPredefinidos(){
        
         //Creo los vectores con los valores de cada superheroe que voy a crear y guardar en mi vector de objetos
       
        int[]id_SuperHeroe = {1,2,3,4,5,6,7,8,9};
         
        String nombre[] = {"Spiderman","Batman","Joker","DoctorStrange","DoctorOctopus","Venom",
                        "DeadPool","Punisher","Lovezno"};

        String superpoder[] = {"HombreAraña","Murcielago","PayasoLoco","ControlDimensional","TentaculosMecanicos","Simbioide","Indestructible","Castigador","Garras"};

        boolean capa[] = {false,true,false,false,false,false,false,false,false};

        char genero[] = {'H','H','H','H','H','H','H','H','H'};
    
        for (int i=0;i<superpoder.length; i++){ //recorro los arrays  

            SuperHeroe NuevoVengador = new SuperHeroe(nombre[i],superpoder[i], capa[i], genero[i]); //creo al superheroe
            NuevoVengador.setId_SuperHeroe(i);
            superheroes.add(NuevoVengador);
            //System.out.println(superheroes.get(i).getNombre());
            
             Object[] row = {superheroes.get(i).getNombre(), superheroes.get(i).getSuperpoder(), superheroes.get(i).getGenero(), superheroes.get(i).isCapa()};
             modelo.addRow(row);

        }  
   
      
    }
    
    public int TamañoSuperheroes(){
        int tamaño = 0;
        
        for(int i=0; i<superheroes.size();i++){
        
                tamaño = i;
        }
        
        return tamaño;
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
    
    public void ActualizarTabla(ArrayList<SuperHeroe> superheroes){
        
         for (int i=0;i<superheroes.size(); i++){ //recorro los arrays  
            
            //Creo un objeto para guardar el objeto recorrido por el array
            SuperHeroe getSuperheroe = (SuperHeroe) superheroes.get(i);
            
            //Inserto en la tabla los valores del objeto
            modelo.setValueAt(getSuperheroe.getNombre(),i,0);
            modelo.setValueAt(getSuperheroe.getSuperpoder(),i,1);
            modelo.setValueAt(getSuperheroe.getGenero(),i,2);
            modelo.setValueAt(getSuperheroe.isCapa(),i,3);
            
            
        }  
    }
    
    public void LimpiarTextField(){
        
        this.TextFieldName.setText("");
        this.TextFieldSuperpoder.setText("");
        this.TextFieldGenero.setText("");
        this.TextFieldCapa.setText("");
    }
    
    public void BloquearoDesbloquearEscrituraTextField(int i){
            //DESBLOQUEO i = 0
            //BLOQUEADO  i!= 0
        
            if(i == 0){
                
                this.TextFieldName.setEditable(true);
                this.TextFieldSuperpoder.setEditable(true);
                this.TextFieldGenero.setEditable(true);
                this.TextFieldCapa.setEditable(true);
                
            }else{
                
                this.TextFieldName.setEditable(false);
                this.TextFieldSuperpoder.setEditable(false);
                this.TextFieldGenero.setEditable(false);
                this.TextFieldCapa.setEditable(false);
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

        jButton1 = new javax.swing.JButton();
        TextFieldName = new javax.swing.JTextField();
        TextFieldSuperpoder = new javax.swing.JTextField();
        TextFieldGenero = new javax.swing.JTextField();
        TextFieldCapa = new javax.swing.JTextField();
        jLabelName = new javax.swing.JLabel();
        jLabelSuperPoder = new javax.swing.JLabel();
        jLabelGenero = new javax.swing.JLabel();
        jLabelCapa = new javax.swing.JLabel();
        jButtonCerrarVentana = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonInsertar = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        Panel1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        Panel2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TextFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldNameActionPerformed(evt);
            }
        });
        getContentPane().add(TextFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 120, -1));
        getContentPane().add(TextFieldSuperpoder, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 120, -1));

        TextFieldGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldGeneroActionPerformed(evt);
            }
        });
        getContentPane().add(TextFieldGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 120, -1));
        getContentPane().add(TextFieldCapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 120, -1));

        jLabelName.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabelName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelName.setText("NAME");
        getContentPane().add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabelSuperPoder.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabelSuperPoder.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSuperPoder.setText("S.PODER");
        jLabelSuperPoder.setToolTipText("");
        getContentPane().add(jLabelSuperPoder, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, -1, -1));

        jLabelGenero.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabelGenero.setForeground(new java.awt.Color(255, 255, 255));
        jLabelGenero.setText("GENERO");
        getContentPane().add(jLabelGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jLabelCapa.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabelCapa.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCapa.setText("CAPA");
        getContentPane().add(jLabelCapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, -1, -1));

        jButtonCerrarVentana.setBackground(new java.awt.Color(0, 0, 102));
        jButtonCerrarVentana.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCerrarVentana.setText("EXIT");
        jButtonCerrarVentana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarVentanaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCerrarVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        jButtonEliminar.setBackground(new java.awt.Color(0, 0, 102));
        jButtonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminar.setText("ELIMINAR");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, -1, -1));

        jButtonCancelar.setBackground(new java.awt.Color(0, 0, 102));
        jButtonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancelar.setText("CANCELAR");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, -1, -1));

        jButtonModificar.setBackground(new java.awt.Color(0, 0, 102));
        jButtonModificar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModificar.setText("MODIFICAR");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, -1));

        jButtonGuardar.setBackground(new java.awt.Color(0, 0, 102));
        jButtonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGuardar.setText("GUARDAR");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, -1));

        jButtonInsertar.setBackground(new java.awt.Color(0, 0, 102));
        jButtonInsertar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonInsertar.setText("INSERTAR");
        jButtonInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, -1, -1));

        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        Panel1.setMaximumSize(new java.awt.Dimension(555, 555));
        Panel1.setPreferredSize(new java.awt.Dimension(250, 203));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Superpoder", "Genero", "Capa"
            }
        ));
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        Panel1.setViewportView(Tabla);

        jTabbedPane2.addTab("tab1", Panel1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Panel2.setViewportView(jTable1);

        jTabbedPane2.addTab("tab2", Panel2);

        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 220));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 0, 580, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertarActionPerformed

    //Bloqeo los botones Modificar y Eliminar
    jButtonModificar.setEnabled(false);
    jButtonEliminar.setEnabled(false); 
    
    //Pongo los cmapos en vacio 
    this.LimpiarTextField();
        
    //Desbloqueo los "TextField" para poder editarlos
     this.BloquearoDesbloquearEscrituraTextField(0);
    //Traigo los valores de cada uno de los textfield y me creo las variables para poder mandarselas al constructor
                            //e introducirlo en el vector para evitar repetidos
        
    }//GEN-LAST:event_jButtonInsertarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // TODO add your handling code here:
         
        
        //Primero realizamos un filtro por si no se ha realizado
        //ninguna tabla no te deje eliminar ninguna fila
        
        if(Tabla.getSelectedRow() != -1){
            
            
            
           // modelo.removeRow(Tabla.getSelectedRow());
            //PosicionEliminado = ;
            modelo = (DefaultTableModel) this.Tabla.getModel();
            this.superheroes.remove(superheroes.get(Tabla.getSelectedRow()));
            //this.ActualizarTabla(superheroes);
            modelo.removeRow(Tabla.getSelectedRow());
            
            //Pongo los huecos en blanco despues de Eliminar en la tabla y en el vector
            this.LimpiarTextField();
            
        }else{
            
            JOptionPane.showMessageDialog(null, "No has seleccionado ninguna fila", "alert", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        
        //Filtro con mensaje si no ha seleccionado ninguna fila
        if(Tabla.getSelectedRow() != -1){
            
            //Bloqueo los demas botones para que el usuario no tenga acceso en ese momento hasta que le de a guardar
            jButtonInsertar.setEnabled(false);
            jButtonEliminar.setEnabled(false);
            
            //Desbloqueo los textfield para poder modificarlos
            this.BloquearoDesbloquearEscrituraTextField(0);

                //this.superheroes.get(Tabla.getSelectedRow()).setNombre(TextFieldName.getText());
                //this.superheroes.get(Tabla.getSelectedRow()).setSuperpoder(TextFieldSuperpoder.getText());
                //this.superheroes.get(Tabla.getSelectedRow()).setGenero(Character.toString(TextFieldGenero.getText()));
                //this.superheroes.get(Tabla.getSelectedRow()).setCapa(Boolean.toStringTextFieldCapa.getText());
        }else{
            
            JOptionPane.showMessageDialog(null, "No has seleccionado ninguna fila", "alert", JOptionPane.ERROR_MESSAGE);
        }        
            
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
      
        //Creo nuevas variables guardando lo introducido por el usuario 
       //para utilizarlas mas comodamente en el modulo
        boolean encontrado = false;
       
        String nombre = this.TextFieldName.getText();
        String superpoder = this.TextFieldSuperpoder.getText();
        boolean capa = Boolean.valueOf(this.TextFieldCapa.getText());
        //Esta sentencia no funciona. ?
        //char genero = this.TextFieldGenero.getText().charAt(0);
        
        //System.out.println(genero);
        
        
        if(jButtonInsertar.isEnabled() == true){
        //Aqui contemplo el caso para si estan las celdas vacias no me deje insertar nada
        
            if (!"".equals(this.TextFieldName.getText().trim()) && !"".equals(this.TextFieldSuperpoder.getText().trim())
                 && !"".equals(this.TextFieldGenero.getText().trim()) && !"".equals(this.TextFieldCapa.getText().trim()) ) {

                 if(this.TextFieldGenero.getText().length() == 1 && this.TextFieldGenero.getText().charAt(0) == 'H' || this.TextFieldGenero.getText().charAt(0) == 'M'){

                    
                                //Llamo a la clase object para dar espacio de memoria a la fila que voy a insertar
                               Object[] row = { this.TextFieldName.getText(), this.TextFieldSuperpoder.getText(), this.TextFieldGenero.getText(), this.TextFieldCapa.getText()};  

                               //BUSQUEDA NOMBRE Recorro EL ARRAY SUPERHEROES 
                                   for(int i=0; i<superheroes.size() && encontrado == false; i++){


                                   //Compruebo si el nombre existe en el sistema
                                       if(!this.TextFieldName.getText().equals(superheroes.get(i).getNombre())){

                                           //DEBUG COMO RECORRE EL BUCKLE


                                       }else{

                                           //for de debug para saber los superheroes que hay cuando EL NOMBRE YA EXISTE
                                           for(int j=0; j<superheroes.size(); j++)
                                           System.out.println(superheroes.get(j).getNombre() + superheroes.get(j).getId_SuperHeroe());

                                           JOptionPane.showMessageDialog(null, "Lo sentimos este nombre ya existe", "alert", JOptionPane.ERROR_MESSAGE);
                                           //System.out.println("Lo sentimos este nombre ya existe");
                                            encontrado = true;

                                       }   
                     }

                     if(encontrado == false){

                            // Añado la nueva fila con los datos del NUEVO objeto superheroe a la tabla
                             modelo.addRow(row);
                            
                            //Construyo un objeto de tipo usuario con los valores del usuario para introducirlo en el array
                             SuperHeroe nuevo = new SuperHeroe(nombre, superpoder, capa, this.TextFieldGenero.getText().charAt(0)); 

                            //Inserto el objeto en el array
                             this.superheroes.add(nuevo);
                             
                             //Guardo el tamaño del array de superheroes e inserto el nuevo id del superheroe 
                            int tamaño = this.TamañoSuperheroes();
                            nuevo.setId_SuperHeroe(tamaño);

                            //Una vez introducido el nuevo superheroe bloqueo y pongo en blanco de nuevo los TextField
                            this.LimpiarTextField();

                            this.BloquearoDesbloquearEscrituraTextField(1);

                     }
                 }else{
                        JOptionPane.showMessageDialog(null, "Datos en los campos Incorrectos!", "Alert", JOptionPane.ERROR_MESSAGE); 
                 }
                   }else{
                        JOptionPane.showMessageDialog(null, "No puedes insertar campos vacios", "Alert", JOptionPane.ERROR_MESSAGE);  
                 }
            
        }
        
        if(jButtonModificar.isEnabled() == true){
           
            //Modifico el superheroe seleccionado
            this.superheroes.get(Tabla.getSelectedRow()).setNombre(this.TextFieldName.getText());
            this.superheroes.get(Tabla.getSelectedRow()).setSuperpoder(this.TextFieldSuperpoder.getText());
            this.superheroes.get(Tabla.getSelectedRow()).setGenero(this.TextFieldGenero.getText().charAt(0));
            this.superheroes.get(Tabla.getSelectedRow()).setCapa(Boolean.valueOf(this.TextFieldName.getText()));
         
            //Refresco el Array en el Layout
            this.ActualizarTabla(superheroes);
        }
        
        
        //Desbloqueo los botones
            jButtonInsertar.setEnabled(true);
            jButtonModificar.setEnabled(true);
            jButtonEliminar.setEnabled(true);
        
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        
        this.LimpiarTextField();
        this.BloquearoDesbloquearEscrituraTextField(1);
        //Desbloqueo los botones
            jButtonInsertar.setEnabled(true);
            jButtonModificar.setEnabled(true);
            jButtonEliminar.setEnabled(true);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonCerrarVentanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarVentanaActionPerformed
        // TODO add your handling code here:
          System.exit(0);
    }//GEN-LAST:event_jButtonCerrarVentanaActionPerformed

    private void TextFieldGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldGeneroActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_TextFieldGeneroActionPerformed

    private void TextFieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldNameActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        //Para que me muestre el nombre en los TextField al pulsar sobre ellos

        this.TextFieldName.setText(superheroes.get(Tabla.getSelectedRow()).getNombre());
        this.TextFieldSuperpoder.setText(superheroes.get(Tabla.getSelectedRow()).getSuperpoder());
        this.TextFieldCapa.setText(Boolean.toString(superheroes.get(Tabla.getSelectedRow()).isCapa()));
        this.TextFieldGenero.setText(Character.toString(superheroes.get(Tabla.getSelectedRow()).getGenero()));

        this.ActualizarTabla(superheroes);
    }//GEN-LAST:event_TablaMouseClicked

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane2MouseClicked

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
            java.util.logging.Logger.getLogger(InterfazReutilizable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazReutilizable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazReutilizable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazReutilizable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazReutilizable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Panel1;
    private javax.swing.JScrollPane Panel2;
    private javax.swing.JTable Tabla;
    private javax.swing.JTextField TextFieldCapa;
    private javax.swing.JTextField TextFieldGenero;
    private javax.swing.JTextField TextFieldName;
    private javax.swing.JTextField TextFieldSuperpoder;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCerrarVentana;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonInsertar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCapa;
    private javax.swing.JLabel jLabelGenero;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelSuperPoder;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
