package frontend.PopUp.dodawanie_package;

import backend.klasy.Pracownik_administracyjny;
import backend.klasy.Pracownik_badawczo_dydaktyczny;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static backend.Bazy_danych_package.Bazy_danych.lista_pracownikow;
import static backend.Bazy_danych_package.Bazy_danych.lista_studentow;
import static backend.menager_list.menager_list.dodaj_na_liste;

public class Dodawanie_pracownika_admini_popup extends Dodawanie_abstract{
    public Dodawanie_pracownika_admini_popup(){
        dodaj_wybory_pracownika_admini();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String message = "";
        message += wiadomosc_bledu_osoba(message);
        message += wiadomosc_bledu_pracownik(message);
        message += wiadomosc_bledu_pracownik_admini(message);

        if (message.isEmpty()) {
            Pracownik_administracyjny pracownik = new Pracownik_administracyjny();
            dodaj_osobe(pracownik);
            dodaj_pracownika(pracownik);
            dodaj_pracownika_admini(pracownik);
            wylacz();
            dodaj_na_liste(lista_pracownikow,pracownik);

        }
        else{
            JOptionPane.showMessageDialog(null,message);
        }
    }
}
