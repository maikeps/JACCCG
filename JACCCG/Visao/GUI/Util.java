/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Visao.GUI;

import java.awt.PopupMenu;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

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
    
    public static String prepareString(String s) {

        String[] d = s.split("\n");
        String retorno = "<html>";
        for (String d1 : d) {
            retorno += d1 + "<br />";
        }
        return retorno + "</html>";
    }

    public static void addNaLabel(String s, JLabel log) {
        String d = log.getText();
        String[] split = d.split("</html>");
        String[] split2 = split[0].split("<html>");
        d = "<html>" + s + "<br />" + split2[1] + "</html>";
        log.setText(d);
    }
}
