package backend.Menu_package.Dodawanie_obiektow_package;

import backend.enumy.stanowisko_badawczo_dydaktyczne_enum;
import backend.interfejsy.Dodaj_obiekt_interface;
import backend.klasy.Pracownik_badawczo_dydaktyczny;
import backend.klasy.Pracownik_uczelni;

import java.util.Scanner;

import static backend.Bazy_danych_package.Bazy_danych.lista_pracownikow;
import static backend.Bazy_danych_package.Bazy_danych.lista_wykladowcow;
import static backend.menager_list.menager_list.dodaj_na_liste;

public class Dodaj_pracownika_bad_dydak implements Dodaj_obiekt_interface<Pracownik_uczelni> {
    @Override
    public Pracownik_uczelni dodaj_obiekt() {
        Pracownik_badawczo_dydaktyczny osoba = new Pracownik_badawczo_dydaktyczny();
        dodaj_zmienne_pracownika_badawczo_dydaktycznego(osoba);
        dodaj_na_liste(lista_pracownikow, osoba);

        if (osoba.getStanowisko().equals(stanowisko_badawczo_dydaktyczne_enum.WYKLADOWCA.toString())) {
            dodaj_na_liste(lista_wykladowcow, osoba);
        }
        return osoba;

    }

    private  void dodaj_zmienne_pracownika_badawczo_dydaktycznego(Pracownik_badawczo_dydaktyczny osoba) {
        Scanner scanner = new Scanner(System.in);
        boolean powtorzenie_petli = true;
        System.out.println("Podaj liczbe publikacji: ");
        osoba.setLiczba_publikacji(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Podaj stanowisko: ");
        while (powtorzenie_petli) {
            powtorzenie_petli = false;

            switch (scanner.nextLine()) {
                case "Asystent", "ASYSTENT", "asystent":
                    osoba.setStanowisko(stanowisko_badawczo_dydaktyczne_enum.ASYSTENT.toString());
                    break;
                case "Adiunkt", "ADIUNKT", "adiunkt":
                    osoba.setStanowisko(stanowisko_badawczo_dydaktyczne_enum.ADIUNKT.toString());
                    break;
                case "PROFESOR NADZWYCZAJNY", "profesor nadzwyczajny", "Profesor nadzwyczajny":
                    osoba.setStanowisko(stanowisko_badawczo_dydaktyczne_enum.PROFESOR_NADZWYCZAJNY.toString());
                    break;
                case "PROFESOR ZWYCZAJNY", "profesor zwyczajny", "Profesor zwyczajny":
                    osoba.setStanowisko(stanowisko_badawczo_dydaktyczne_enum.PROFESOR_ZWYCZAJNY.toString());
                    break;
                case "WYKLADOWCA", "wykladowca", "Wykladowca":
                    osoba.setStanowisko(stanowisko_badawczo_dydaktyczne_enum.WYKLADOWCA.toString());
                    break;
                default:
                    System.out.println("sprobuj ponownie");
                    powtorzenie_petli = true;
            }
        }
    }
}
