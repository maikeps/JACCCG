/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Visao.GUI;

import java.util.IllegalFormatException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author jake
 */
public class Util {
    public static void lancaAviso(String mess){
        JOptionPane.showMessageDialog(null, mess); 
    }
    
    public static String pedeString(String mess) {
        return JOptionPane.showInputDialog(null, mess);
    }
    
    public static int pedeInt(int min, int max, String msg){
    	int num = min-1;
    	while(num < min || num > max){
    		try{
    			num = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
    		}catch(NumberFormatException e){
    			return pedeInt(min, max, msg);
    		}
    	}
    	return num;
    }
    
    public static int pedeInt(String msg){
		try{
			int num = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
	    	return num;
		}catch(NumberFormatException e){
			return pedeInt(msg);
		}
    }
    
    public static String prepareString(String s) {

        String[] d = s.split("\n");
        String retorno = "<html>";
        for (String d1 : d) {
            retorno += d1 + "<br />";
        }
        return retorno + "</html>";
    }
    
    public static String prepareString(List<String> strings){
    	String string = "<html>";
    	for(String s : strings){
    		string += s+"<br/>";
    	}
    	string += "</html>";
    	
    	return string;
    }

    public static void addNaLabel(String s, JLabel log) {
        String d = log.getText();
        System.out.println(d);
        String[] split = d.split("</html>");
        String[] split2 = split[0].split("<html>");
        d = "<html>" + s + "<br/>" + split2[0] + "</html>";
        log.setText(d);
    }
}
