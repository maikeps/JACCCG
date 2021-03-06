package Controle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Leitor {

	private Scanner scanner;
	
	public Leitor(){
		scanner = new Scanner(System.in);
	}
	public String leString(){
		String aux = scanner.next();
		return aux;
	}
	public int leInt(int min, int max){
		int inteiro = 0;
		try{
			inteiro = scanner.nextInt();
			if(inteiro < min || inteiro > max){
				System.out.println("Digite um valor entre "+min+" e "+max);
				return leInt(min, max);
			}
		}catch(InputMismatchException e){
			System.out.println("Digite um inteiro");
			leInt(min, max);
		}
		return inteiro;
	}

	public int leInt() {
		int inteiro = 0;
		try{
			inteiro = scanner.nextInt();
		}catch(InputMismatchException e){
			System.out.println("Digite um inteiro");
			leInt();
		}
		return inteiro;
	}

	public boolean leBoolean() {
		String string = scanner.nextLine().toLowerCase();
		if(string.equals("nao") || string.equals("sim")){
			return (string.equals("sim")) ? true : false;
		}else{
			return leBoolean();
		}
	}
}
