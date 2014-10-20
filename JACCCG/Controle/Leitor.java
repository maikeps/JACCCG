package JACCCG.Controle;

import java.util.Scanner;

public class Leitor {

	private Scanner scanner;
	
	public Leitor(){
		scanner = new Scanner(System.in);
	}
	
	public int leInput(){
		return scanner.nextInt();
	}
}
