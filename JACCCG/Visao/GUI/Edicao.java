/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.GUI;

import java.util.LinkedList;
import java.util.List;

import Cartas.CartaDeColecao;
import Cartas.ConstrutorDeBaralho;
import Colecao.RegistroDeBaralho;
import Exceptions.BaralhoCompletoException;
import Exceptions.BaralhoNaoInicializadoException;
import Exceptions.CartaNaoEncontradaException;
import Exceptions.LimiteDeCartasExcedidoException;
import JACCCG.JACCCG.Jogo;

/**
 *
 * @author jake
 */
public class Edicao extends javax.swing.JFrame {

    private static Edicao instance = null;
    private Jogo jogo;
    private ConstrutorDeBaralho construtor;
    
    private Edicao() {
    	jogo = Jogo.getInstance();
    	construtor = new ConstrutorDeBaralho(jogo.getUsuario());
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public static Edicao getInstance() {
        if (instance == null) {
            instance = new Edicao();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Voltar = new javax.swing.JButton();
        escolher = new javax.swing.JButton();
        add = new javax.swing.JButton();
        rem = new javax.swing.JButton();
        cartasDoJogo = new java.awt.List();
        cartasDoBaralho = new java.awt.List();
        Salvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Voltar.setText("Voltar");
        Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarActionPerformed(evt);
            }
        });

        escolher.setText("Escolher");
        escolher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escolherActionPerformed(evt);
            }
        });

        add.setText("adicionar->");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        rem.setText("<-remover");
        rem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remActionPerformed(evt);
            }
        });

        List<CartaDeColecao> cartas = jogo.getUsuario().getColecao().getCartas();
        for(int i = 1; i <= cartas.size(); i++){
            cartasDoJogo.add(i+" - "+cartas.get(i-1).toString());
        }
        cartasDoJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartasDoJogoActionPerformed(evt);
            }
        });

        cartasDoBaralho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartasDoBaralhoActionPerformed(evt);
            }
        });

        Salvar.setText("Salvar");
        Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cartasDoJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(escolher))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cartasDoBaralho, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cartasDoJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cartasDoBaralho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Voltar)
                    .addComponent(escolher)
                    .addComponent(Salvar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setBaralho(List<String> list){
        cartasDoBaralho.removeAll();
        for(String s : list){
            cartasDoBaralho.add(s);
        }
    }
    private void setCartas(List<String> list){
        cartasDoJogo.removeAll();
        for(String s : list){
            cartasDoJogo.add(s);
        }
    }
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
    	int selecionado = cartasDoJogo.getSelectedIndex();
    	if(selecionado == -1) return;
    	CartaDeColecao carta = jogo.getUsuario().getColecao().getCartas().get(selecionado);
    	try {
			construtor.adicionaCarta(carta);
			List<String> strings = new LinkedList<String>();
			for(int i = 1; i <= construtor.getBaralhoAtual().getCartas().size(); i++){
				strings.add(i+" - "+construtor.getBaralhoAtual().getCartas().get(i-1));
			}
			setBaralho(strings);
		} catch (BaralhoNaoInicializadoException e) {
			Util.lancaAviso("Voce deve selecionar um baralho primeiro.");
		} catch (LimiteDeCartasExcedidoException e) {
			Util.lancaAviso("Voce excedeu o limite de cartas do tipo "+carta.getNome());
		} catch (BaralhoCompletoException e) {
			Util.lancaAviso("O baralho ja possui o numero maximo de cartas ("+construtor.getBaralhoAtual().getMaximo()+" cartas)");
		}
    }//GEN-LAST:event_addActionPerformed

    private void remActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remActionPerformed
        int selecionado = cartasDoBaralho.getSelectedIndex();
        if(selecionado == -1) return;
    	CartaDeColecao carta = construtor.getBaralhoAtual().getCartas().get(selecionado);
   		try {
			construtor.removeCarta(carta);
			List<String> strings = new LinkedList<String>();
			for(int i = 1; i <= construtor.getBaralhoAtual().getCartas().size(); i++){
				strings.add(i+" - "+construtor.getBaralhoAtual().getCartas().get(i-1));
			}
			setBaralho(strings);
		} catch (BaralhoNaoInicializadoException e) {
			Util.lancaAviso("Voce deve selecionar um baralho primeiro.");
		} catch (CartaNaoEncontradaException e) {
			Util.lancaAviso("O seu baralho nao continha a carta selecionada.");
		}
    }//GEN-LAST:event_remActionPerformed

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        this.setVisible(false);
        MenuInicial.getInstance().setVisible(true);
    }//GEN-LAST:event_VoltarActionPerformed

    private void escolherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escolherActionPerformed
        //TODO mudar a string para a lista de baralhos
    	String str = "";
    	List<RegistroDeBaralho> baralhos = jogo.getUsuario().getColecao().getBaralhos();
    	for(int i = 1; i <= baralhos.size(); i++){
    		str += i+" - "+baralhos.get(i-1).getNome()+"\n";
    	}
//        String escolha = Util.pedeString(str);
    	int escolha = Util.pedeInt(1, baralhos.size(), str);
    	construtor.editaBaralho(baralhos.get(escolha-1));
        RegistroDeBaralho baralho = construtor.getBaralhoAtual();
        List<String> strings = new LinkedList<String>();
        for(CartaDeColecao c : baralho.getCartas()){
            strings.add(c.toString());
        }
        setBaralho(strings);
    	
    	
//        if (escolha != null) {
//            try {
//                int rest = Integer.parseInt(escolha);
//                if (rest >= 1) {
//                    //TODO escolher baralho pelo rest
//                    this.setVisible(false);
//                } else {
//                    throw new NumberFormatException();
//                }
//            } catch (NumberFormatException e) {
//                Util.lancaAviso("Escolha um baralho ou volte!");
//            }
//        }
    }//GEN-LAST:event_escolherActionPerformed

    private void cartasDoJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartasDoJogoActionPerformed
    	int selecionado = cartasDoJogo.getSelectedIndex();
    	if(selecionado == -1) return;
    	CartaDeColecao carta = jogo.getUsuario().getColecao().getCartas().get(selecionado);
    	try {
			construtor.adicionaCarta(carta);
			List<String> strings = new LinkedList<String>();
			for(int i = 1; i <= construtor.getBaralhoAtual().getCartas().size(); i++){
				strings.add(i+" - "+construtor.getBaralhoAtual().getCartas().get(i-1));
			}
			setBaralho(strings);
		} catch (BaralhoNaoInicializadoException e) {
			Util.lancaAviso("Voce deve selecionar um baralho primeiro.");
		} catch (LimiteDeCartasExcedidoException e) {
			Util.lancaAviso("Voce excedeu o limite de cartas do tipo "+carta.getNome());
		} catch (BaralhoCompletoException e) {
			Util.lancaAviso("O baralho ja possui o numero maximo de cartas ("+construtor.getBaralhoAtual().getMaximo()+" cartas)");
		}
        // TODO add your handling code here:
    }//GEN-LAST:event_cartasDoJogoActionPerformed

    private void cartasDoBaralhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartasDoBaralhoActionPerformed
    	int selecionado = cartasDoBaralho.getSelectedIndex();
        if(selecionado == -1) return;
    	CartaDeColecao carta = construtor.getBaralhoAtual().getCartas().get(selecionado);
   		try {
			construtor.removeCarta(carta);
			List<String> strings = new LinkedList<String>();
			for(int i = 1; i <= construtor.getBaralhoAtual().getCartas().size(); i++){
				strings.add(i+" - "+construtor.getBaralhoAtual().getCartas().get(i-1));
			}
			setBaralho(strings);
		} catch (BaralhoNaoInicializadoException e) {
			Util.lancaAviso("Voce deve selecionar um baralho primeiro.");
		} catch (CartaNaoEncontradaException e) {
			Util.lancaAviso("O seu baralho nao continha a carta selecionada.");
		}
    }//GEN-LAST:event_cartasDoBaralhoActionPerformed

    private void SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarActionPerformed
    	construtor.salvarBaralho();
    	this.setVisible(false);
        Colecao.getInstance().setVisible(true);
    }//GEN-LAST:event_SalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Salvar;
    private javax.swing.JButton Voltar;
    private javax.swing.JButton add;
    private java.awt.List cartasDoBaralho;
    private java.awt.List cartasDoJogo;
    private javax.swing.JButton escolher;
    private javax.swing.JButton rem;
    // End of variables declaration//GEN-END:variables
}
