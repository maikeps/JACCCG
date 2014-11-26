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
public class Baralhos extends javax.swing.JFrame {
    
    public static Baralhos instance = null;
    
    private Baralhos() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public static Baralhos getInstance(){
        if(instance == null){
            instance = new Baralhos();
        }
        return instance;
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listaDeBaralhos = new java.awt.List();
        seleciona = new javax.swing.JButton();
        cancela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listaDeBaralhos.setBackground(new java.awt.Color(242, 241, 240));

        seleciona.setText("Selecionar");
        seleciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionaActionPerformed(evt);
            }
        });

        cancela.setText("Cancelar");
        cancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listaDeBaralhos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(seleciona)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                        .addComponent(cancela)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listaDeBaralhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seleciona)
                    .addComponent(cancela))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelaActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelaActionPerformed

    private void selecionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionaActionPerformed
        int escolhaBa  = listaDeBaralhos.getSelectedIndex();
        
        if(escolhaBa != -1){
            //TODO usar index baralho
            this.setVisible(false);
        }else{
            Util.lancaAviso("Escolha um baralho ou volte!");
        }
    }//GEN-LAST:event_selecionaActionPerformed
    
    private void setBaralhos(List<String> list){
        listaDeBaralhos.removeAll();
        for(String s : list){
            listaDeBaralhos.add(s);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancela;
    private java.awt.List listaDeBaralhos;
    private javax.swing.JButton seleciona;
    // End of variables declaration//GEN-END:variables
}
