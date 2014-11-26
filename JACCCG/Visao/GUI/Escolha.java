/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Visao.GUI;

import java.util.List;

/**
 *
 * @author jake
 */
public class Escolha extends javax.swing.JFrame {
    
    private static Escolha instance = null;
    
    
    private Escolha() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public static Escolha getInstance(){
        if(instance == null){
            instance = new Escolha();
        }
        
        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escolhido = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        oponentes = new java.awt.List();
        baralhos = new java.awt.List();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Escolhido.setText("Escolher ");
        Escolhido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EscolhidoActionPerformed(evt);
            }
        });

        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        oponentes.setBackground(new java.awt.Color(242, 241, 240));
        oponentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oponentesActionPerformed(evt);
            }
        });

        baralhos.setBackground(new java.awt.Color(242, 241, 240));

        jLabel1.setText("Oponentes:");

        jLabel2.setText("Baralhos:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Escolhido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 402, Short.MAX_VALUE)
                        .addComponent(voltar))
                    .addComponent(baralhos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(oponentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(oponentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(baralhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Escolhido)
                    .addComponent(voltar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        this.setVisible(false);
        MenuInicial.getInstance().setVisible(true);
    }//GEN-LAST:event_voltarActionPerformed
    
    public void addListas(List<String> oponentes,List<String> baralhos){
        this.setOponetes(oponentes);
        this.setBaralhos(baralhos);
    }
    
    private void setOponetes(List<String> list){
        oponentes.removeAll();
        for(String s : list){
            oponentes.add(s);
        }
    }
    
    private void setBaralhos(List<String> list){
        baralhos.removeAll();
        for(String s : list){
            baralhos.add(s);
        }
    }
    
    private void EscolhidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EscolhidoActionPerformed
        int escolhaOP  = oponentes.getSelectedIndex();
        int escolhaBa  = baralhos.getSelectedIndex();
        
        if(escolhaOP != -1 && escolhaBa != -1){
            //TODO usar index baralho e oponente
            this.setVisible(false);
            MenuBatalha.getInstance().setVisible(true);
        }else{
            Util.lancaAviso("Escolha um baralho e um oponente antes de avançar ou volte!");
        }
    }//GEN-LAST:event_EscolhidoActionPerformed

    private void oponentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oponentesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oponentesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Escolhido;
    private java.awt.List baralhos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private java.awt.List oponentes;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
