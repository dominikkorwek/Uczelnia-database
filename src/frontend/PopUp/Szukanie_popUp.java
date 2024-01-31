package frontend.PopUp;

import backend.interfejsy.czy_obiekt_zawiera_szukana_interface;
import frontend.customView.CustomPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static backend.menager_list.menager_list.wypisz_liste;
import static backend.menager_list.menager_list.wyszukaj_z_listy_obiekty;

public class Szukanie_popUp extends JFrame{
    public <T extends czy_obiekt_zawiera_szukana_interface> Szukanie_popUp(ArrayList<T> lista, String szukana){
        this.setTitle("Szukanie w bazach danych");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setMinimumSize(new Dimension(100,50));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        ArrayList<JLabel> label = wyszukaj_z_listy_obiekty(lista,szukana);

        for (JLabel jLabel : label) {
            panel.add(jLabel);
        }

        this.add(panel);
        this.pack();
        this.setVisible(true);
    }
}
