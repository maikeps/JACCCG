package Visao.GUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Batalha.Jogador;
import Batalha.Juiz;
import Batalha.Oponente;

public class MenuBatalha extends javax.swing.JFrame {

    JLabel labelMesaOp = new javax.swing.JLabel("");
    JLabel labelMesaJog = new javax.swing.JLabel("");
    JLabel labelMaoJog = new javax.swing.JLabel("");
    static MenuBatalha instance = null;
    
    Juiz juiz;
    Oponente oponente;
    Jogador jogador;

    private MenuBatalha() {
        initComponents();
        this.setTitle("Batalha!!!");
        log.setText("Batalha iniciada!");
        mesaJog.add(labelMesaJog);
        mesaOponente.add(labelMesaOp);
        maoJog.add(labelMaoJog);
        this.setLocationRelativeTo(null);
    }

    public static MenuBatalha getInstance(Juiz juiz, Oponente oponente, Jogador jogador) {
    	if (instance == null) {
            instance = new MenuBatalha();
        }
    	instance.juiz = juiz;
    	instance.oponente = oponente;
    	instance.jogador = jogador;
    	
    	instance.setOps();
    	
        return instance;
    }

    private void setOps() {
    	this.atualizaHpJogador(jogador.getVida());
    	this.atualizaHpOponente(oponente.getVida());
	}
    

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        hpOponente = new javax.swing.JLabel();
        nomeJogador = new javax.swing.JLabel();
        nomeOponente = new javax.swing.JLabel();
        hpJogador = new javax.swing.JLabel();
        maoJog = new java.awt.ScrollPane();
        mesaJog = new java.awt.ScrollPane();
        mesaOponente = new java.awt.ScrollPane();
        tamDeckOp = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tamDeck = new javax.swing.JLabel();
        manaJog = new javax.swing.JLabel();
        manaOP = new javax.swing.JLabel();
        jogarCarta = new javax.swing.JButton();
        atacar = new javax.swing.JButton();
        Desistir = new javax.swing.JButton();
        passarVez = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Batalha!!!");
        setBackground(new java.awt.Color(134, 185, 133));
        setForeground(new java.awt.Color(134, 185, 133));

        jPanel1.setBackground(new java.awt.Color(134, 185, 133));

        hpOponente.setBackground(new java.awt.Color(134, 185, 133));
        hpOponente.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        hpOponente.setForeground(new java.awt.Color(208, 22, 22));
        hpOponente.setText("HP:");

        nomeJogador.setBackground(new java.awt.Color(134, 185, 133));
        nomeJogador.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        nomeJogador.setText("nomeJogador");

        nomeOponente.setBackground(new java.awt.Color(134, 185, 133));
        nomeOponente.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        nomeOponente.setForeground(new java.awt.Color(208, 22, 22));
        nomeOponente.setText("nomeOponente");

        hpJogador.setBackground(new java.awt.Color(134, 185, 133));
        hpJogador.setText("HP:");

        tamDeckOp.setForeground(new java.awt.Color(208, 22, 22));
        tamDeckOp.setText("n/m");

        jLabel1.setText("Deck oponente:");

        jLabel2.setText("Deck :");

        tamDeck.setForeground(new java.awt.Color(208, 22, 22));
        tamDeck.setText("n/m");

        manaJog.setText("Mana:");

        manaOP.setForeground(new java.awt.Color(208, 22, 22));
        manaOP.setText("Mana:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(nomeOponente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(59, 59, 59))
                                    .addComponent(hpOponente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(409, 409, 409)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tamDeckOp)
                                .addGap(46, 46, 46))
                            .addComponent(mesaJog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mesaOponente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hpJogador)
                            .addComponent(manaJog))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tamDeck)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(maoJog, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeJogador)
                            .addComponent(manaOP))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeOponente)
                    .addComponent(tamDeckOp)
                    .addComponent(jLabel1))
                .addGap(11, 11, 11)
                .addComponent(hpOponente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(manaOP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mesaOponente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(mesaJog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maoJog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tamDeck)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(nomeJogador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hpJogador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(manaJog)))
                .addContainerGap())
        );

        jogarCarta.setBackground(new java.awt.Color(50, 50, 147));
        jogarCarta.setForeground(new java.awt.Color(255, 255, 255));
        jogarCarta.setText("Jogar carta");
        jogarCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jogarCartaActionPerformed(evt);
            }
        });

        atacar.setBackground(new java.awt.Color(50, 50, 147));
        atacar.setForeground(new java.awt.Color(255, 255, 255));
        atacar.setText("Atacar!!!");
        atacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atacarActionPerformed(evt);
            }
        });

        Desistir.setBackground(new java.awt.Color(215, 215, 215));
        Desistir.setForeground(new java.awt.Color(195, 68, 68));
        Desistir.setText("Desistir");
        Desistir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesistirActionPerformed(evt);
            }
        });

        passarVez.setBackground(new java.awt.Color(148, 63, 63));
        passarVez.setForeground(new java.awt.Color(255, 255, 255));
        passarVez.setText("Passar vez");
        passarVez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passarVezActionPerformed(evt);
            }
        });

        log.setEditable(false);
        jScrollPane1.setViewportView(log);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(atacar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jogarCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passarVez, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Desistir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passarVez)
                    .addComponent(atacar)
                    .addComponent(jogarCarta)
                    .addComponent(Desistir)))
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jogarCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jogarCartaActionPerformed
        String result = Util.pedeString("Escolha qual carta jogar");
        try {
            if (result != null) {
                int carta = Integer.parseInt(result);
                if(carta <= 0) throw new NumberFormatException();
                	
            }
        } catch (java.lang.NumberFormatException e) {
            Util.lancaAviso("ENTRADA INVALIDA!!!");
        }
    }//GEN-LAST:event_jogarCartaActionPerformed

    public void atualizaMesaOponente(String s) {
        labelMesaOp.setText(Util.prepareString(s));
    }

    public void atualizaMesaJogador(String s) {
        labelMesaJog.setText(Util.prepareString(s));
    }

    public void atualizaMaoJogador(String s) {
        labelMaoJog.setText(Util.prepareString(s));
    }

    public void atualizaNomeJogador(String s) {
        nomeJogador.setText(s);
    }

    public void atualizaNomeOponente(String s) {
        nomeOponente.setText(s);
    }

    public void atualizaHpOponente(int hp) {
        hpOponente.setText("HP: " + hp);
    }

    public void atualizaHpJogador(int hp) {
        hpJogador.setText("HP: " + hp);
    }

    public void atualizaManaOponente(int hp) {
        manaOP.setText("Mana: " + hp);
    }

    public void atualizaManaJogador(int hp) {
        manaJog.setText("Mana: " + hp);
    }

    public void atualizaDeckOponente(int n, int m) {
        tamDeckOp.setText(n + "/" + m);
    }

    public void atualizaDeckJogador(int n, int m) {
        tamDeck.setText(n + "/" + m);
    }


    private void atacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atacarActionPerformed
        try {
            String resultado = Util.pedeString("Escolha com que carta vai atacar?");
            if (resultado != null) {
                int atacante = Integer.parseInt(resultado);
                if(atacante <= 0) throw new NumberFormatException();
                //TODO Seleção da carta atacante...
                resultado = Util.pedeString("Escolha que carta vai atacar?");
                if (resultado != null) {
                    int atacada = Integer.parseInt(resultado);
                    if(atacada <= 0) throw new NumberFormatException();
                    //TODO Seleção da carta atacada...
                }
            }
        } catch (java.lang.NumberFormatException e) {
            Util.lancaAviso("ENTRADA INVALIDA!!!");
        }
    }//GEN-LAST:event_atacarActionPerformed

    private void DesistirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesistirActionPerformed
        int resp;
        resp = JOptionPane.showConfirmDialog(null, "Deseja realmente desistir?", "Confirmação:", JOptionPane.YES_NO_OPTION);

        if (resp == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            MenuInicial.getInstance().setVisible(true);
            //TODO fazer jogador perder
        }
    }//GEN-LAST:event_DesistirActionPerformed

    public void atualizaLog(String msg){
        msg = log.getText()+"\n"+msg;
        log.setText(msg);
    }
    private void passarVezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passarVezActionPerformed
        int resp;
        resp = JOptionPane.showConfirmDialog(null, "Deseja realmente passar a vez?", "Confirmação:", JOptionPane.YES_NO_OPTION);

        if (resp == JOptionPane.YES_OPTION) {
            //passa a vez
        } else {

        }
    }//GEN-LAST:event_passarVezActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Desistir;
    private javax.swing.JButton atacar;
    private javax.swing.JLabel hpJogador;
    private javax.swing.JLabel hpOponente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jogarCarta;
    private javax.swing.JTextPane log;
    private javax.swing.JLabel manaJog;
    private javax.swing.JLabel manaOP;
    private java.awt.ScrollPane maoJog;
    private java.awt.ScrollPane mesaJog;
    private java.awt.ScrollPane mesaOponente;
    private javax.swing.JLabel nomeJogador;
    private javax.swing.JLabel nomeOponente;
    private javax.swing.JButton passarVez;
    private javax.swing.JLabel tamDeck;
    private javax.swing.JLabel tamDeckOp;
    // End of variables declaration//GEN-END:variables
}
