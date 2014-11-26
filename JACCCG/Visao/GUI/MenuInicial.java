package Visao.GUI;

import java.util.ArrayList;
import java.util.List;

import BD.DAOController;
import BD.OponenteDAO;
import Batalha.Oponente;
import Colecao.RegistroDeBaralho;
import JACCCG.JACCCG.Jogo;

/**
 *
 * @author jake
 */
public class MenuInicial extends javax.swing.JFrame {
    private static MenuInicial instance = null;
    
    private MenuInicial() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public static MenuInicial getInstance(){
        if(instance == null){
            instance = new MenuInicial();
        }
        return instance;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoJogar = new javax.swing.JButton();
        botaoLoja = new javax.swing.JButton();
        botaoColecao = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botaoJogar.setText("Jogar!!!");
        botaoJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoJogarActionPerformed(evt);
            }
        });

        botaoLoja.setText("Loja");
        botaoLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLojaActionPerformed(evt);
            }
        });

        botaoColecao.setText("Coleção");
        botaoColecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoColecaoActionPerformed(evt);
            }
        });

        botaoSair.setText("Sair");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoJogar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoLoja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoColecao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoJogar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoLoja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoColecao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoJogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoJogarActionPerformed
        this.setVisible(false);
        
        Escolha ops = Escolha.getInstance();
        ArrayList<String> listNOp = new ArrayList<String>();
        ArrayList<String> listNBara = new ArrayList<String>();
        List<RegistroDeBaralho> listBara = Jogo.getInstance().getUsuario().getColecao().getBaralhos();
        List<Oponente> listOp = DAOController.getInstance().getOponentesLiberados(Jogo.getInstance().getUsuario().getId());
        
        for(RegistroDeBaralho r : listBara){
            listNBara.add(r.getNome());
        }
        for(Oponente o : listOp){
            listNOp.add(o.toString());
            System.out.println(o.toString());
        }
        ops.addListas(listNOp, listNBara);
        ops.setVisible(true);

    }//GEN-LAST:event_botaoJogarActionPerformed

    private void botaoLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLojaActionPerformed
        this.setVisible(false);
        Loja.getInstance().setVisible(true);
    }//GEN-LAST:event_botaoLojaActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botaoSairActionPerformed

    private void botaoColecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoColecaoActionPerformed
        this.setVisible(false);
        Colecao.getInstance().setVisible(true);
    }//GEN-LAST:event_botaoColecaoActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoColecao;
    private javax.swing.JButton botaoJogar;
    private javax.swing.JButton botaoLoja;
    private javax.swing.JButton botaoSair;
    // End of variables declaration//GEN-END:variables
}
