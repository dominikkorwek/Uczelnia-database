package frontend.PopUp;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static backend.menager_list.menager_list.wypisz_liste;

public class Wypisywanie_popup extends JFrame{
    public <T> Wypisywanie_popup(List<T> lista){
        this.setTitle("Wyspisanie bazy danych");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setMinimumSize(new Dimension(100,50));

        JLabel label = new JLabel();
        label.setText("tu bedzie lista");

        this.add(label);
        this.pack();
        this.setVisible(true);
    }
}
