package frontend.PopUp.dodawanie_package;

import backend.klasy.Kursy;
import backend.klasy.Pracownik_badawczo_dydaktyczny;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static backend.Bazy_danych_package.Bazy_danych.lista_kursow;
import static backend.Bazy_danych_package.Bazy_danych.lista_studentow;
import static backend.menager_list.menager_list.dodaj_na_liste;

public class Dodawanie_kursu_popup extends Dodawanie_abstract {
    public Dodawanie_kursu_popup() {
        dodaj_kurs();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = "";
        message += wiadomosc_bledu_kurs(message);

        if (message.isEmpty()) {
            Kursy kurs = new Kursy();
            dodaj_kurs(kurs);
            wylacz();
            dodaj_na_liste(lista_kursow,kurs);

        }
        else{
            JOptionPane.showMessageDialog(null,message);
        }
    }
}
