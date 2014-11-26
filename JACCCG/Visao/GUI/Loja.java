package Visao.GUI;


import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Cartas.CartaDeColecao;
import Cartas.Raridade;
import JACCCG.JACCCG.Jogo;


public class Loja extends javax.swing.JFrame {


    private static Loja instance = null;
    private Jogo jogo;
    
    private Loja() {
        initComponents();
        this.setLocationRelativeTo(null);
        jogo = Jogo.getInstance();
    }
    
    public static Loja getInstance(){
        if(instance == null){
            instance = new Loja();
        }
        return instance;
    }

   
    @SuppressWarnings("unchecked")
    private void initComponents() {

        mostrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pNome = new javax.swing.JButton();
        pValor = new javax.swing.JButton();
        pCusto = new javax.swing.JButton();
        pRaridade = new javax.swing.JButton();
        comprar = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        Cartas = new java.awt.ScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mostrar.setText("Mostrar!");
        mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarActionPerformed(evt);
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

        comprar.setText("Comprar!");
        comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarActionPerformed(evt);
            }
        });

        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comprar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Cartas, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mostrar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(voltar)
                    .addComponent(comprar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarActionPerformed(java.awt.event.ActionEvent evt) {
    	Jogo jogo = Jogo.getInstance();
    	List<CartaDeColecao> cartas = jogo.getLoja().getCartas();
    	List<String> strings = new LinkedList<String>();
    	for(int i = 0; i < cartas.size(); i++){
    		strings.add((i+1) + " - " + cartas.get(i).toString());
    	}
    	String str = Util.prepareString(strings);
    	Cartas.add(new JLabel(str));
    }
    
    private void pNomeActionPerformed(java.awt.event.ActionEvent evt) {
    	Cartas.removeAll();
    	Jogo.getInstance();
    	String j = Util.pedeString("Insira o nome da carta:");
    	List<CartaDeColecao> cartas = Jogo.getInstance().getLoja().getPesquisador().pesquisaCarta(j);
    	List<String> strings = new LinkedList<String>();
    	JLabel label = new JLabel();
    	for(int i = 0; i < cartas.size(); i++){
    		strings.add((i+1) + " - " + cartas.get(i).toString());
    	}
    	String str = Util.prepareString(strings);

    	Cartas.add(new JLabel(str));
    }

    private void comprarActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        MenuInicial.getInstance().setVisible(true);
    }

    private void pRaridadeActionPerformed(java.awt.event.ActionEvent evt) {
    	Cartas.removeAll();
    	Jogo.getInstance();
    	int raridade = Util.pedeInt(1,3,"Insira o custo da carta a ser pesquisada\n1 - COMUM\n2 - INCOMUM\n3 - RARA");
    	List<CartaDeColecao> cartas = Jogo.getInstance().getLoja().getPesquisador().pesquisaCarta(Raridade.values()[3-raridade]);
    	List<String> strings = new LinkedList<String>();
    	JLabel label = new JLabel();
    	for(int i = 0; i < cartas.size(); i++){
    		strings.add((i+1) + " - " + cartas.get(i).toString());
    	}
    	String str = Util.prepareString(strings);

    	Cartas.add(new JLabel(str)); 
    }  

    private void pCustoActionPerformed(java.awt.event.ActionEvent evt) {
    	Cartas.removeAll();
    	Jogo.getInstance();
    	int raridade = Util.pedeInt(1,3,"Insira o custo da carta a ser pesquisada\n1 - COMUM\n2 - INCOMUM\n3 - RARA");
    	List<CartaDeColecao> cartas = Jogo.getInstance().getLoja().getPesquisador().pesquisaCarta(Raridade.values()[3-raridade]);
    	List<String> strings = new LinkedList<String>();
    	JLabel label = new JLabel();
    	for(int i = 0; i < cartas.size(); i++){
    		strings.add((i+1) + " - " + cartas.get(i).toString());
    	}
    	String str = Util.prepareString(strings);

    	Cartas.add(new JLabel(str)); 
    }
  

    private void pValorActionPerformed(java.awt.event.ActionEvent evt) {
    }


    private java.awt.ScrollPane Cartas;
    private javax.swing.JButton comprar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton mostrar;
    private javax.swing.JButton pCusto;
    private javax.swing.JButton pNome;
    private javax.swing.JButton pRaridade;
    private javax.swing.JButton pValor;
    private javax.swing.JButton voltar;
}
