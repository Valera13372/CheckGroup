package sample;


import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Controller {
    public Button Search;
    public TextField URLVVOD;
    public Label ResultChislo;

    public void Otvet(ActionEvent otveto) {
        try {


            URLConnection connect = (URLConnection) new URL(URLVVOD.getText()).openConnection();
            Scanner scan = new Scanner(connect.getInputStream());
            String result = "";
            while (scan.hasNextLine()) {
                result = result + scan.nextLine();

            }
            Pattern patt = Pattern.compile("[А-Я]{1}[а-я]+\\s[А-Я]{1}[а-я]+");
            Matcher match = patt.matcher(result);
            String x = "";
            int a =0;
            while (match.find()) {
                x = x + match.group() + "\n";
                a++;
            }
            System.out.println(x);
            System.out.println(a);
            ResultChislo.setText(Integer.toString(a));

            scan.close();
        } catch (Exception ex) {
            System.out.println("Неа");
        }
    }
}



