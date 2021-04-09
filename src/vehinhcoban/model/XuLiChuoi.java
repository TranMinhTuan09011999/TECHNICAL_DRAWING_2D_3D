/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehinhcoban.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author 09096
 */
public class XuLiChuoi {

    public static boolean kiemTraToaDo(JTextField txt) {
        String toado = txt.getText();
        String regex = "^-\\d+||\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(toado);
        if (matcher.matches() && toado.length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean kiemTraSoDo(JTextField txt) {
        String toado = txt.getText();
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(toado);
        if (matcher.matches() && toado.length() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
