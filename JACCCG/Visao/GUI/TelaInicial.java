package Visao.GUI;

import javax.swing.JOptionPane;

import BD.DAOController;
import Colecao.Loja;
import Colecao.Usuario;
import JACCCG.JACCCG.Jogo;

public class TelaInicial extends javax.swing.JFrame {
    
    private static TelaInicial instance = null;
    
    private TelaInicial() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public static TelaInicial getInstance() {
        if (instance == null) {
            instance = new TelaInicial();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        novoJogo = new javax.swing.JButton();
        carregarJogo = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        creditos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        novoJogo.setText("Novo Jogo");
        novoJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoJogoActionPerformed(evt);
            }
        });

        carregarJogo.setText("Carregar Jogo");
        carregarJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarJogoActionPerformed(evt);
            }
        });

        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        creditos.setText("Creditos");
        creditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(carregarJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(novoJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(creditos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(novoJogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carregarJogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(creditos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sair)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_sairActionPerformed

    private void novoJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoJogoActionPerformed
        String nome = JOptionPane.showInputDialog(null, "Qual o seu nome, guerreiro?");
        int idUsuario = DAOController.getInstance().novoJogo(nome, 100);
        Usuario usuario = DAOController.getInstance().getUsuario(idUsuario);
        Loja loja = DAOController.getInstance().getLoja(idUsuario);
        Jogo.getInstance().setLoja(loja);
        Jogo.getInstance().setUsuario(usuario);
        MenuInicial.getInstance().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_novoJogoActionPerformed

    private void carregarJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarJogoActionPerformed
    	int idUsuario = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira seu identificador, por favor."));
    	Usuario usuario = DAOController.getInstance().getUsuario(idUsuario);
        JOptionPane.showMessageDialog(null, "Bem vindo de volta, "+usuario.getNome());
        Loja loja = DAOController.getInstance().getLoja(idUsuario);
        Jogo.getInstance().setLoja(loja);
        Jogo.getInstance().setUsuario(usuario);
        MenuInicial.getInstance().setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_carregarJogoActionPerformed

    private void creditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditosActionPerformed
        this.setVisible(false);
        new Creditos();
    }//GEN-LAST:event_creditosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton carregarJogo;
    private javax.swing.JButton creditos;
    private javax.swing.JButton novoJogo;
    private javax.swing.JButton sair;
    // End of variables declaration//GEN-END:variables

}
