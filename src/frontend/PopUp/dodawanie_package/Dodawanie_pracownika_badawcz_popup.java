package frontend.PopUp.dodawanie_package;

import backend.enumy.stanowisko_badawczo_dydaktyczne_enum;
import backend.klasy.Pracownik_badawczo_dydaktyczny;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

import static backend.Bazy_danych_package.Bazy_danych.*;
import static backend.menager_list.menager_list.dodaj_na_liste;

public class Dodawanie_pracownika_badawcz_popup extends Dodawanie_abstract{
    public Dodawanie_pracownika_badawcz_popup(){
        dodaj_wybory_pracownika_badawcz();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = "";
        message += wiadomosc_bledu_osoba(message);
        message += wiadomosc_bledu_pracownik(message);
        message += wiadomosc_bledu_pracownik_bada(message);

        if (message.isEmpty()) {
            Pracownik_badawczo_dydaktyczny pracownik = new Pracownik_badawczo_dydaktyczny();
            dodaj_osobe(pracownik);
            dodaj_pracownika(pracownik);
            dodaj_pracownika_bada(pracownik);
            dodaj_na_liste(lista_pracownikow,pracownik);
            if (Objects.equals(pracownik.getStanowisko(), stanowisko_badawczo_dydaktyczne_enum.WYKLADOWCA.toString()))
                dodaj_na_liste(lista_wykladowcow,pracownik);
            wylacz();
        }
        else{
            JOptionPane.showMessageDialog(null,message);
        }
    }
}
