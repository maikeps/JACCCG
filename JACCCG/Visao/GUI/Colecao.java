package Visao.GUI;

import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Cartas.CartaDeColecao;
import Cartas.Raridade;
import JACCCG.JACCCG.Jogo;

public class Colecao extends javax.swing.JFrame {

    private static Colecao instance = null;
    private Jogo jogo;

    private Colecao() {
    	jogo = Jogo.getInstance();
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public static Colecao getInstance() {
        if (instance == null) {
            instance = new Colecao();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        mostrar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        Cartas = new java.awt.ScrollPane();
        voltar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pNome = new javax.swing.JButton();
        pValor = new javax.swing.JButton();
        pCusto = new javax.swing.JButton();
        pRaridade = new javax.swing.JButton();

        jButton2.setText("Pesquisa cartas");

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mostrar.setText("Mostrar!");
        mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarActionPerformed(evt);
            }
        });

        editar.setText("Editar Baralhos");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(230, 230, 230));

        jLabel1.setText("Pesquisa por:");

        pNome.setText("Nome");
        pNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pNomeActionPerformed(evt);
            }
        });

        pValor.setText("Valor");
        pValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pValorActionPerformed(evt);
            }
        });

        pCusto.setText("Custo");
        pCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	pCustoActionPerformed(evt);
            }
        });

        pRaridade.setText("Raridade");
        pRaridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	pRaridadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pCusto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pRaridade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pCusto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pRaridade))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(voltar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cartas, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cartas, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mostrar)
                        .addGap(33, 33, 33)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(voltar)
                    .addComponent(editar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    protected void pRaridadeActionPerformed(ActionEvent evt) {
    	Cartas.removeAll();
    	int raridade = Util.pedeInt(1, 3, "Insira o custo da carta a ser pesquisada\n1 - COMUM\n2 - INCOMUM\n3 - RARA");
    	List<CartaDeColecao> cartas = jogo.getUsuario().getColecao().getPesquisador().pesquisaCarta(Raridade.values()[3-raridade]);
    	List<String> strings = new LinkedList<String>();
    	for(CartaDeColecao c : cartas){
    		strings.add(c.toString());
    	}
    	String str = Util.prepareString(strings);
    	Cartas.add(new JLabel(str));
	}

	protected void pCustoActionPerformed(ActionEvent evt) {
    	Cartas.removeAll();
    	int custo = Util.pedeInt("Insira o custo da carta a ser pesquisada");
    	List<CartaDeColecao> cartas = jogo.getUsuario().getColecao().getPesquisador().pesquisaCarta(custo);
    	List<String> strings = new LinkedList<String>();
    	for(CartaDeColecao c : cartas){
    		strings.add(c.toString());
    	}
    	String str = Util.prepareString(strings);
    	Cartas.add(new JLabel(str));
	}

	protected void pValorActionPerformed(ActionEvent evt) {
    	Cartas.removeAll();
    	int preco = Util.pedeInt("Insira o valor da carta a ser pesquisada");
    	int menorQue = JOptionPane.showConfirmDialog(null, "Deseja valores menores ou iguais a "+preco+"?");
    	List<CartaDeColecao> cartas = jogo.getUsuario().getColecao().getPesquisador().pesquisaCarta(preco, (menorQue == 0));
    	List<String> strings = new LinkedList<String>();
    	for(CartaDeColecao c : cartas){
    		strings.add(c.toString());
    	}
    	String str = Util.prepareString(strings);
    	Cartas.add(new JLabel(str));
	}

	private void pNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pNomeActionPerformed
    	Cartas.removeAll();
    	String nome = Util.pedeString("Insira o nome da carta a ser pesquisada");
    	List<CartaDeColecao> cartas = jogo.getUsuario().getColecao().getPesquisador().pesquisaCarta(nome);
    	List<String> strings = new LinkedList<String>();
    	for(CartaDeColecao c : cartas){
    		strings.add(c.toString());
    	}
    	String str = Util.prepareString(strings);
    	Cartas.add(new JLabel(str));
    }//GEN-LAST:event_pNomeActionPerformed

    private void mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarActionPerformed
    	Cartas.removeAll();
    	List<CartaDeColecao> cartas = jogo.getUsuario().getColecao().getCartas();
    	List<String> strings = new LinkedList<String>();
    	for(CartaDeColecao c : cartas){
    		strings.add(c.toString());
    	}
    	String str = Util.prepareString(strings);
    	Cartas.add(new JLabel(str));
    }//GEN-LAST:event_mostrarActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        this.setVisible(false);
        MenuInicial.getInstance().setVisible(true);
    }//GEN-LAST:event_voltarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        this.setVisible(false);
        Edicao.getInstance().setVisible(true);
    }//GEN-LAST:event_editarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.ScrollPane Cartas;
    private javax.swing.JButton editar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton mostrar;
    private javax.swing.JButton pCusto;
    private javax.swing.JButton pNome;
    private javax.swing.JButton pRaridade;
    private javax.swing.JButton pValor;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
