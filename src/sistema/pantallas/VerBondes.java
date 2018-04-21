/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.pantallas;

import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import sistema.BondeD;
import sistema.Sistema;

/**
 *
 * @author ALBER
 */
public class VerBondes extends javax.swing.JFrame {
    public Sistema sistem;
    private int id;
    private int quies;
    /**
     * Creates new form Bondes
     */
    public VerBondes(Sistema sistem, int id, int quies) {
        initComponents();
        this.sistem = sistem;
        this.id = id;
        this.quies = quies;
        Despliega();
    }

    public void Despliega(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object rowData[] = new Object[9];
        Iterator itr = sistem.getBondes().iterator();
        while(itr.hasNext()){
            BondeD bon = (BondeD) itr.next();
            //System.out.println(promo.getNombre() + "    " + promo.getContra() );
            if( quies == 3 ){
                rowData[0] = bon.getId();
                rowData[1] = bon.getIdCliente();
                rowData[2] = bon.getValorNominal();
                rowData[3] = bon.getPlazo();
                rowData[4] = bon.getTasaActual();
                rowData[5] = bon.getDiaInicio();
                rowData[6] = bon.isReinversion();
                rowData[7] = bon.getDiasTranscurridos();
                model.addRow(rowData);
            }
            else if( bon.getIdPromotor() == id && quies == 1 ){
                rowData[0] = bon.getId();
                rowData[1] = bon.getIdCliente();
                rowData[2] = bon.getValorNominal();
                rowData[3] = bon.getPlazo();
                rowData[4] = bon.getTasaActual();
                rowData[5] = bon.getDiaInicio();
                rowData[6] = bon.isReinversion();
                rowData[7] = bon.getDiasTranscurridos();
                model.addRow(rowData);
            }
            else if( bon.getIdCliente() == id && quies == 2 ){
                rowData[0] = bon.getId();
                rowData[1] = bon.getIdCliente();
                rowData[2] = bon.getValorNominal();
                rowData[3] = bon.getPlazo();
                rowData[4] = bon.getTasaActual();
                rowData[5] = bon.getDiaInicio();
                rowData[6] = bon.isReinversion();
                rowData[7] = bon.getDiasTranscurridos();
                model.addRow(rowData);
            }
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdInversion", "IdCliente", "Valor", "Plazo", "Tasa", "Dia Inicio", "Reinversion", "Dias Transcurridos"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Bondes D");

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here
        if( quies == 1 ){
            MainPromotor MP = new MainPromotor(sistem , id );
            MP.setVisible(true);
            dispose();  
        }
        if (quies == 2){
            MainCliente MC = new MainCliente(sistem, id);
            MC.setVisible(true);
            dispose();
        }       
        if (quies == 3){
            MainDirector MD = new MainDirector(sistem);
            MD.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
