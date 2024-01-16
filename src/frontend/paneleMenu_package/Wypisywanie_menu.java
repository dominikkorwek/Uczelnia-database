package frontend.paneleMenu_package;

import frontend.PopUp.Wypisywanie_popup;
import frontend.customView.CustomButton;
import frontend.customView.CustomPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static backend.Bazy_danych_package.Bazy_danych.*;

public class Wypisywanie_menu extends CustomPanel implements ActionListener {
    private CustomButton wyswietl_studentow;
    private CustomButton wyswietl_pracownikow;
    private CustomButton wyswietl_kursy;
    public Wypisywanie_menu() {


        wyswietl_studentow = new CustomButton("wyswietl studentow");
        wyswietl_studentow.addActionListener(this);
        wyswietl_pracownikow = new CustomButton("wyswietl pracownikow");
        wyswietl_pracownikow.addActionListener(this);
        wyswietl_kursy = new CustomButton("wyswietl kursy");
        wyswietl_kursy.addActionListener(this);

        this.add(wyswietl_studentow);
        this.add(wyswietl_pracownikow);
        this.add(wyswietl_kursy);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame popUp;
        if (e.getSource() == wyswietl_studentow)
            popUp = new Wypisywanie_popup(lista_studentow);
        if (e.getSource() == wyswietl_pracownikow)
            popUp = new Wypisywanie_popup(lista_pracownikow);
        if (e.getSource() == wyswietl_kursy)
            popUp = new Wypisywanie_popup(lista_kursow);
    }
}
