package JACCCG.Tests;

import JACCCG.Cartas.CartaDeColecao;
import JACCCG.Cartas.Fabrica;
import JACCCG.Colecao.Loja;
import JACCCG.Colecao.Usuario;
import JACCCG.Exceptions.CartaNaoEncontradaException;

public class Tests {

	public static void main(String[] args){
	
		Usuario u = Fabrica.cria();
		Loja j = new Loja(Fabrica.criaCartas());
		
		
		System.out.println("O Usuário tinha: " + u.getDinheiros());
		try {
			System.out.println("O Usuário vendeu: " + u.getColecao().getCartas().get(0));
			j.compra(u.getColecao().getCartas().get(0), u);
			System.out.println("O Usuário ficouc com: " + u.getDinheiros());
		} catch (CartaNaoEncontradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Depois");
		for(CartaDeColecao c : u.getColecao().getCartas()){
			System.out.println(c);
		}
		
	}
	
}