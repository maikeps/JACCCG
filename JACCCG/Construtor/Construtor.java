package JACCCG.Construtor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import JACCCG.Cartas.Carta;
import JACCCG.Cartas.Raridade;
import JACCCG.Colecao.Colecao;
import JACCCG.Colecao.Usuario;

public class Construtor {

	private String caminhoCarta = "/home/maike/git/JACCCG/BD/Carta";
	private String caminhoUsuario = "/home/maike/git/JACCCG/BD/Jogador";
	private String caminhoColecao = "/home/maike/git/JACCCG/BD/Colecao";
	
	public Construtor(){
		
	}
	
	public List<Carta> pegaCartas(){
		List<Carta> cartas = new LinkedList<Carta>();
		List<String[]> linhas = ler(caminhoCarta);
		
		for(String[] split : linhas){
			//id,nome,ataque,defesa,custoMana,vida,raridade,preco	
			String nome = split[1];
			int ataque = Integer.parseInt(split[2]);
			int defesa = Integer.parseInt(split[3]);
			int custoMana = Integer.parseInt(split[4]);
			int vida = Integer.parseInt(split[5]);
			Raridade raridade = Raridade.valueOf(split[6]);
			Carta carta = new Carta(nome, ataque, defesa, custoMana, vida, raridade);
			cartas.add(carta);
		}
		
		return cartas;
	}
	
	public List<Usuario> pegaJogador(){
		List<Usuario> jogadores = new LinkedList<Usuario>();
		List<String[]> linhas = ler(caminhoUsuario);
		List<String[]> colecao = ler(caminhoColecao);
		
		for(String[] split : linhas){
			//#id,nome,dinheiros
			String id = split[0];
			String dinheiros = split[2];
			Usuario usuario = new Usuario(colecao, dinheiros);
			jogadores.add(usuario);
		}
		
		return jogadores;
	}
	
	public Colecao pegaColecao(int idJogador){
		Colecao colecao = new Colecao(colecao, baralhos);
		
		return colecao;
	}
	
	public 
	
	public List<String[]> ler(String path){
		List<String[]> linhas = new LinkedList<String[]>();
		
		try {
			FileReader fileReader = new FileReader(path);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = "";
			while ((line = reader.readLine()) != null) {
				if(line.charAt(0) != '#'){
					linhas.add(line.split(","));
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return linhas;
	}
}