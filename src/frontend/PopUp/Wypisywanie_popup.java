package frontend.PopUp;

import frontend.customView.CustomPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static backend.menager_list.menager_list.wypisz_liste;

public class Wypisywanie_popup extends JFrame{
    public <T> Wypisywanie_popup(ArrayList<T> lista){
        this.setTitle("Wyspisanie bazy danych");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setMinimumSize(new Dimension(200,50));
        CustomPanel panel = new CustomPanel();

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        ArrayList<JLabel> label = wypisz_liste(lista);
        for (JLabel jLabel : label) {
            panel.add(jLabel);
        }
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }
}
