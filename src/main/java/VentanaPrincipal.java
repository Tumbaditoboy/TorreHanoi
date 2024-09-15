/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;





/**
 *
 * @author dzlan
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    int ContNumMov = 0; 
    Pila PilaTorreA;
    Pila PilaTorreB;
    Pila PilaTorreC;
    
    
    DefaultTableModel ModeloTablaTorreA, ModeloTablaTorreB, ModeloTablaTorreC;
    
    int Objetivo  = 0; 
    
    double NumMinMov = 0; 
    
    
    
    

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
    

    ModeloTablaTorreA = (DefaultTableModel) TorreA.getModel();
    ModeloTablaTorreA.setRowCount(10);
    
    ModeloTablaTorreB = (DefaultTableModel) TorreB.getModel();
    ModeloTablaTorreB.setRowCount(10);
    
    ModeloTablaTorreC = (DefaultTableModel) TorreC.getModel();
    ModeloTablaTorreC.setRowCount(10);
    
    DefaultTableCellRenderer renderA = new DefaultTableCellRenderer();
    renderA.setHorizontalAlignment(SwingConstants.CENTER);
    TorreA.getColumnModel().getColumn(0).setCellRenderer(renderA);
    
    DefaultTableCellRenderer renderB = new DefaultTableCellRenderer();
    renderB.setHorizontalAlignment(SwingConstants.CENTER);
    TorreB.getColumnModel().getColumn(0).setCellRenderer(renderB);
    
    DefaultTableCellRenderer renderC = new DefaultTableCellRenderer();
    renderC.setHorizontalAlignment(SwingConstants.CENTER);
    TorreC.getColumnModel().getColumn(0).setCellRenderer(renderC);
    
   
}
    private void Limpiar(){
        
        ContNumMov = 0; 
        NumMinMov = 0; 
        
         CbNumDiscos.setSelectedItem(String.valueOf(Objetivo));
         
    }
    
    private void PresentarCantMov(){
        
        ContNumMov ++;
        LblNumMov.setText(String.valueOf(ContNumMov));
        
        
    }
    
    private void Reiniciar (){
        
        try{
            
            if(!LblMinMov.getText().equals("")){
               
                Limpiar();
                Iniciar();
            }
            
        }catch(Exception E){
            System.out.println("Error: " +E.getMessage());
        }
        
    }
    
    private void Iniciar (){
    
        try{
            
        PilaTorreA = new Pila();
        PilaTorreB = new Pila();
        PilaTorreC = new Pila();

        Objetivo = Integer.parseInt(CbNumDiscos.getSelectedItem().toString());
        
        NumMinMov = Math.pow(2, Objetivo) -1;
        
        LblNumMov.setText(String.valueOf(ContNumMov));
        LblMinMov.setText(String.valueOf(String.format("%.0f", NumMinMov)));
        
        
        for (int x = Objetivo; x >= 1; x--){
            
            Nodo Plataforma = new Nodo();
            
            String Disco = ""; 
            
            for(int y = x; y > 0 ; y--){
                
                Disco+= "#";  
            }
            
            Plataforma.setDato(Disco);
            
            PilaTorreA.Push(Plataforma);
             
        }
        
        PresentarTorreA();
        PresentarTorreB();
       PresentarTorreC();
        
            
        }catch(Exception E){
            System.out.println("Error: "+E.getMessage());
        }
         
    }
    
    private void PresentarTorreA(){
        
        ((DefaultTableModel)TorreA.getModel()).setRowCount(0); 
        
        ModeloTablaTorreA.setRowCount(10);
        
        Nodo K;
        
        int RowDisco = (10 - PilaTorreA.getContNodo());
        
        if(PilaTorreA.getContNodo() > 0){
            
            for(K = PilaTorreA.getCabeza(); K.getAbajo() != null; K = K.getAbajo()){
                
                String [] VectorNormal = {K.getDato()};
                
                ModeloTablaTorreA.insertRow(RowDisco, VectorNormal);
                RowDisco ++;
            }
            
            if(K.getAbajo() == null){
                 String [] VectorNormal = {K.getDato()};
                 ModeloTablaTorreA.insertRow(RowDisco, VectorNormal);
            }
            
        }
        
        TorreA.setModel(ModeloTablaTorreA);
        ModeloTablaTorreA.setRowCount(10);
        
        
    }
    
    private void PresentarTorreB(){
        
        ((DefaultTableModel)TorreB.getModel()).setRowCount(0); 
        
        ModeloTablaTorreB.setRowCount(10);
        
        Nodo K;
        
        int RowDisco = (10 - PilaTorreB.getContNodo());
        
        if(PilaTorreB.getContNodo() > 0){
            
            for(K = PilaTorreB.getCabeza(); K.getAbajo() != null; K = K.getAbajo()){
                
                String [] VectorNormal = {K.getDato()};
                
                ModeloTablaTorreB.insertRow(RowDisco, VectorNormal);
                RowDisco ++;
            }
            
            if(K.getAbajo() == null){
                 String [] VectorNormal = {K.getDato()};
                 ModeloTablaTorreB.insertRow(RowDisco, VectorNormal);
            }
            
        }
        
        TorreB.setModel(ModeloTablaTorreB);
        ModeloTablaTorreB.setRowCount(10);
        
        
    }
    
    private void PresentarTorreC(){
        
        ((DefaultTableModel)TorreC.getModel()).setRowCount(0); 
        
        ModeloTablaTorreC.setRowCount(10);
        
        Nodo K;
        
        int RowDisco = (10 - PilaTorreC.getContNodo());
        
        if(PilaTorreC.getContNodo() > 0){
            
            for(K = PilaTorreC.getCabeza(); K.getAbajo() != null; K = K.getAbajo()){
                
                String [] VectorNormal = {K.getDato()};
                
                ModeloTablaTorreC.insertRow(RowDisco, VectorNormal);
                RowDisco ++;
            }
            
            if(K.getAbajo() == null){
                 String [] VectorNormal = {K.getDato()};
                 ModeloTablaTorreC.insertRow(RowDisco, VectorNormal);
            }
            
        }
        
        TorreC.setModel(ModeloTablaTorreC);
        ModeloTablaTorreC.setRowCount(10);
        
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TorreB = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TorreC = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TorreA = new javax.swing.JTable();
        BtnA_B = new javax.swing.JButton();
        BtnA_C = new javax.swing.JButton();
        BtnB_A = new javax.swing.JButton();
        BtnB_C = new javax.swing.JButton();
        BtnC_A = new javax.swing.JButton();
        BtnC_B = new javax.swing.JButton();
        CbNumDiscos = new javax.swing.JComboBox<>();
        LblNumMov = new javax.swing.JLabel();
        LblMinMov = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BtnIniciar = new javax.swing.JButton();
        BtnReiniciar = new javax.swing.JButton();
        BtnResolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setFocusable(false);

        TorreB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TorreB"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TorreB.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(TorreB);
        if (TorreB.getColumnModel().getColumnCount() > 0) {
            TorreB.getColumnModel().getColumn(0).setResizable(false);
        }

        jScrollPane2.setFocusable(false);

        TorreC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TorreC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TorreC.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(TorreC);
        if (TorreC.getColumnModel().getColumnCount() > 0) {
            TorreC.getColumnModel().getColumn(0).setResizable(false);
        }

        jScrollPane3.setFocusable(false);

        TorreA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TorreA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TorreA.setRowSelectionAllowed(false);
        jScrollPane3.setViewportView(TorreA);
        if (TorreA.getColumnModel().getColumnCount() > 0) {
            TorreA.getColumnModel().getColumn(0).setResizable(false);
        }

        BtnA_B.setText("B");
        BtnA_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnA_BActionPerformed(evt);
            }
        });

        BtnA_C.setText("C");
        BtnA_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnA_CActionPerformed(evt);
            }
        });

        BtnB_A.setText("A");
        BtnB_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnB_AActionPerformed(evt);
            }
        });

        BtnB_C.setText("C");
        BtnB_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnB_CActionPerformed(evt);
            }
        });

        BtnC_A.setText("A");
        BtnC_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnC_AActionPerformed(evt);
            }
        });

        BtnC_B.setText("B");
        BtnC_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnC_BActionPerformed(evt);
            }
        });

        CbNumDiscos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "4", "5", "6", "7", "8", "9", "10" }));

        LblNumMov.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LblNumMov.setForeground(new java.awt.Color(204, 0, 0));
        LblNumMov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblNumMov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        LblMinMov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblMinMov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Número de discos");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Número de movimientos minimo ");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Número de movimientos");

        BtnIniciar.setText("Iniciar");
        BtnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIniciarActionPerformed(evt);
            }
        });

        BtnReiniciar.setText("Reiniciar");
        BtnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReiniciarActionPerformed(evt);
            }
        });

        BtnResolver.setText("Resolver");
        BtnResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(BtnA_B, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnA_C, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(BtnB_A, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnB_C, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnC_A, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(BtnC_B, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(63, 63, 63))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CbNumDiscos, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(336, 358, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnIniciar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnReiniciar)
                        .addGap(103, 103, 103)
                        .addComponent(BtnResolver)
                        .addGap(81, 81, 81))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LblMinMov, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(LblNumMov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(131, 131, 131))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnA_B)
                    .addComponent(BtnA_C)
                    .addComponent(BtnB_A)
                    .addComponent(BtnB_C)
                    .addComponent(BtnC_B)
                    .addComponent(BtnC_A))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbNumDiscos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnIniciar)
                            .addComponent(BtnReiniciar)
                            .addComponent(BtnResolver))
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(LblMinMov, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LblNumMov, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MoverDeA_B(){
        
        try{
            
            if(PilaTorreA.getContNodo() > 0){
                
                Nodo Plataforma = new Nodo();
                
                Plataforma.setDato(PilaTorreA.Peek()); 
                
                if(PilaTorreB.getContNodo() > 0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreB.Peek()) > 0){
                        
                        return;
                    }
                }
                
               PilaTorreA.Pop();
               PilaTorreB.Push(Plataforma);
               
                PresentarTorreA();
                PresentarTorreB();
                PresentarCantMov();
            }
            
            
        }catch(Exception E){
            System.out.println("Error: "+E.getMessage());
        }
         
    }
    
    
    private void BtnA_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnA_BActionPerformed
        MoverDeA_B();
    }//GEN-LAST:event_BtnA_BActionPerformed

    private void MoverDeA_C(){
        
            try{
            
            if(PilaTorreA.getContNodo() > 0){
                
                Nodo Plataforma = new Nodo();
                
                Plataforma.setDato(PilaTorreA.Peek()); 
                
                if(PilaTorreC.getContNodo() > 0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreC.Peek()) > 0){
                        
                        return;
                    }
                }
                
               PilaTorreA.Pop();
               PilaTorreC.Push(Plataforma);
               
                PresentarTorreA();
                PresentarTorreC();
                PresentarCantMov();

                if(PilaTorreC.getContNodo() == Objetivo && ContNumMov == NumMinMov){
                    JOptionPane.showMessageDialog(null,"Felicidades has alcanzado el ojetivo de mínimo de movimientos\n\nIntenta con otro nivel de dificultad :)","Felicitaciones", JOptionPane.WARNING_MESSAGE);
                    
            }else if(PilaTorreC.getContNodo() == Objetivo && ContNumMov != NumMinMov){
                JOptionPane.showMessageDialog(null,"Felicidades, lo has resuelto :) \n\nIntenta superar el objetivo minimo de movimientos","Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
            }
        }
            
        }catch(Exception E){
            System.out.println("Error: "+E.getMessage());
        }
         
    }
        
    
    
    
    private void BtnA_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnA_CActionPerformed
        MoverDeA_C();
    }//GEN-LAST:event_BtnA_CActionPerformed

    private void MoverDeB_A(){
        
         try{
            
            if(PilaTorreB.getContNodo() > 0){
                
                Nodo Plataforma = new Nodo();
                
                Plataforma.setDato(PilaTorreB.Peek()); 
                
                if(PilaTorreA.getContNodo() > 0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreA.Peek()) > 0){
                        
                        return;
                    }
                }
                
               PilaTorreB.Pop();
               PilaTorreA.Push(Plataforma);
               
                PresentarTorreA();
                PresentarTorreB();
                PresentarCantMov();
            }
            
            
        }catch(Exception E){
            System.out.println("Error: "+E.getMessage());
        }   
        
    }
    
    
    private void BtnB_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnB_AActionPerformed
       MoverDeB_A();
    }//GEN-LAST:event_BtnB_AActionPerformed
  
    private void MoverDeB_C(){
        
                 try{
            
            if(PilaTorreB.getContNodo() > 0){
                
                Nodo Plataforma = new Nodo();
                
                Plataforma.setDato(PilaTorreB.Peek()); 
                
                if(PilaTorreC.getContNodo() > 0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreC.Peek()) > 0){
                        
                        return;
                    }
                }
                
               PilaTorreB.Pop();
               PilaTorreC.Push(Plataforma);
               
               
                PresentarTorreB();
                PresentarTorreC();
                PresentarCantMov();

                if(PilaTorreC.getContNodo() == Objetivo && ContNumMov == NumMinMov){
                    JOptionPane.showMessageDialog(null,"Felicidades has alcanzado el ojetivo de mínimo de movimientos\n\nIntenta con otro nivel de dificultad :)","Felicitaciones", JOptionPane.WARNING_MESSAGE);
                    
            }else if(PilaTorreC.getContNodo() == Objetivo && ContNumMov != NumMinMov){
                JOptionPane.showMessageDialog(null,"Felicidades, lo has resuelto :) \n\nIntenta superar el objetivo minimo de movimientos","Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
            }
        }
            
        }catch(Exception E){
            System.out.println("Error: "+E.getMessage());
        }
        
        
    }
    
    private void BtnB_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnB_CActionPerformed
        MoverDeB_C();
    }//GEN-LAST:event_BtnB_CActionPerformed

    private void MoverDeC_A(){
        
         try{
            
            if(PilaTorreC.getContNodo() > 0){
                
                Nodo Plataforma = new Nodo();
                
                Plataforma.setDato(PilaTorreC.Peek()); 
                
                if(PilaTorreA.getContNodo() > 0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreA.Peek()) > 0){
                        
                        return;
                    }
                }
                
               PilaTorreC.Pop();
               PilaTorreA.Push(Plataforma);
               
                PresentarTorreA();
                PresentarTorreC();
                PresentarCantMov();
            }
            
            
        }catch(Exception E){
            System.out.println("Error: "+E.getMessage());
        }   
    }
    
    private void BtnC_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnC_AActionPerformed
        MoverDeC_A();
    }//GEN-LAST:event_BtnC_AActionPerformed

    private void MoverDeC_B(){
    
               try{
            
            if(PilaTorreC.getContNodo() > 0){
                
                Nodo Plataforma = new Nodo();
                
                Plataforma.setDato(PilaTorreC.Peek()); 
                
                if(PilaTorreB.getContNodo() > 0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreB.Peek()) > 0){
                        
                        return;
                    }
                }
                
               PilaTorreC.Pop();
               PilaTorreB.Push(Plataforma);
               
                PresentarTorreB();
                PresentarTorreC();
                PresentarCantMov();
            }
            
            
        }catch(Exception E){
            System.out.println("Error: "+E.getMessage());
        } 
        
    }
    
    private void BtnC_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnC_BActionPerformed
      MoverDeC_B();
    }//GEN-LAST:event_BtnC_BActionPerformed

    private void BtnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIniciarActionPerformed
       
    ContNumMov = 0;    
    Iniciar();
        
    }//GEN-LAST:event_BtnIniciarActionPerformed

    private void BtnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReiniciarActionPerformed
        Reiniciar();
    }//GEN-LAST:event_BtnReiniciarActionPerformed

    boolean Stop = false;
    
    private void MoverPlataforma (Pila Origen, Pila Destino){
        
        if(Stop== false){
          
        Nodo Plataforma = new Nodo();    
         
        Plataforma.setDato(Origen.Peek());
        
        Origen.Pop();
        
        
        Destino.Push(Plataforma);
        
        PresentarTorreA();
        PresentarTorreB();
        PresentarTorreC();
        PresentarCantMov();
        
        JOptionPane pane = new JOptionPane("Paso # "+LblNumMov.getText()+"\n\n¿Continuar?",JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
        
        JDialog dialog = pane.createDialog("Número de pasos");
        
        
         dialog.setLocation(600, 400);
        
         dialog.setVisible(true);
         
         int opt = (int) pane.getValue();
         
        if(opt == JOptionPane.NO_OPTION){
            Stop = true;
        }
        
        
        }  
        
    }
    
    
    private void ResolverHanoiRecursivo(int n, Pila Origen, Pila Auxiliar, Pila Destino ){
        
        if(n ==1){
            
            MoverPlataforma(Origen, Destino);
           
        }else{
            
            ResolverHanoiRecursivo(n -1, Origen, Destino, Auxiliar);
            
            MoverPlataforma(Origen, Destino);
            
            ResolverHanoiRecursivo(n -1, Auxiliar, Origen, Destino);
            
        }
        
        
    }
    
    
    
    
    
    
    private void BtnResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResolverActionPerformed
       
        if(!LblMinMov.getText().equals("") && PilaTorreC.getContNodo() != Objetivo){
           
            Reiniciar();
            Stop=false;
            
            ResolverHanoiRecursivo(Objetivo, PilaTorreA, PilaTorreB, PilaTorreC);
            
        }
        
    }//GEN-LAST:event_BtnResolverActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnA_B;
    private javax.swing.JButton BtnA_C;
    private javax.swing.JButton BtnB_A;
    private javax.swing.JButton BtnB_C;
    private javax.swing.JButton BtnC_A;
    private javax.swing.JButton BtnC_B;
    private javax.swing.JButton BtnIniciar;
    private javax.swing.JButton BtnReiniciar;
    private javax.swing.JButton BtnResolver;
    private javax.swing.JComboBox<String> CbNumDiscos;
    private javax.swing.JLabel LblMinMov;
    private javax.swing.JLabel LblNumMov;
    private javax.swing.JTable TorreA;
    private javax.swing.JTable TorreB;
    private javax.swing.JTable TorreC;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
