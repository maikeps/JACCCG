package JACCCG.Controle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Leitor {

	private Scanner scanner;
	
	public Leitor(){
		scanner = new Scanner(System.in);
	}
	
	public int leInt(int min, int max){
		int inteiro = 0;
		try{
			inteiro = scanner.nextInt();
			if(inteiro < min || inteiro > max){
				System.out.println("Digite um valor entre "+min+" e "+max);
				leInt(min, max);
			}
		}catch(InputMismatchException e){
			System.out.println("Digite um inteiro");
			leInt(min, max);
		}
		return inteiro;
	}

	public boolean leBoolean() {
		String string = scanner.nextLine().toLowerCase();
		System.out.println(string);
		if(!string.equals("nao") && !string.equals("sim")){
			System.out.println("Digite sim ou nao");
			leBoolean();
		}
		return (string.equals("sim")) ? true : false;
	}
}
