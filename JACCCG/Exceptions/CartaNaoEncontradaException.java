package Exceptions;

@SuppressWarnings("serial")
public class CartaNaoEncontradaException extends Exception{
	public CartaNaoEncontradaException(String msg){
		super(msg);
	}
}
