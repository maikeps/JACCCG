package Controle;

import java.util.Observable;
import java.util.Observer;

public class Logger implements Observer {

	static private Logger instance = null;
	
	private Logger(){
		
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}
	public static Logger getInstance(){
		if(instance == null){
			instance = new Logger();
		}
		return instance;
	}	

}
