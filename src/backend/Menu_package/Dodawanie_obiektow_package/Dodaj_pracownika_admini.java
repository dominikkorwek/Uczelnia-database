package backend.Menu_package.Dodawanie_obiektow_package;

import backend.enumy.stanowisko_administracyjne_enum;
import backend.interfejsy.Dodaj_obiekt_interface;
import backend.klasy.Pracownik_administracyjny;
import backend.klasy.Pracownik_uczelni;

import java.util.Scanner;

import static backend.Bazy_danych_package.Bazy_danych.lista_pracownikow;
import static backend.menager_list.menager_list.dodaj_na_liste;

public class Dodaj_pracownika_admini  implements Dodaj_obiekt_interface<Pracownik_uczelni> {
    @Override
    public Pracownik_uczelni dodaj_obiekt() {
        Pracownik_administracyjny osoba = new Pracownik_administracyjny();
        dodaj_zmienne_pracownika_administracyjnego(osoba);
        dodaj_na_liste(lista_pracownikow,osoba);

        return osoba;
    }
    private  void dodaj_zmienne_pracownika_administracyjnego(Pracownik_administracyjny osoba){
        Scanner scanner = new Scanner(System.in);
        boolean powtorzenie_petli = true;

        System.out.println("Podaj liczbe nadgodzin: ");
        osoba.setLiczba_nadgodzin(scanner.nextFloat());
        scanner.nextLine();

        System.out.println("Podaj Stanowisko: ");
        while (powtorzenie_petli){
            powtorzenie_petli = false;

            switch (scanner.nextLine()){
                case "REFERENT","referent", "Referent":
                    osoba.setStanowisko(stanowisko_administracyjne_enum.REFERENT.toString());
                    break;
                case "SPECJALISTA", "specjalista", "Specjalista" :
                    osoba.setStanowisko(stanowisko_administracyjne_enum.SPECJALISTA.toString());
                    break;
                case "Starszy specjalista","STARSZY SPECJALISTA", "starszy specjalista":
                    osoba.setStanowisko(stanowisko_administracyjne_enum.STARSZY_SPECJALISTA.toString());
                    break;
                case "KIEROWNIK DZIALU","kierownik dzialu", "Kierownik dziali":
                    osoba.setStanowisko(stanowisko_administracyjne_enum.KIEROWNIK_DZIALU.toString());
                    break;
                case "DYREKTOR","dyrektor", "Dyrektor":
                    osoba.setStanowisko(stanowisko_administracyjne_enum.DYREKTOR.toString());
                    break;
                default:
                    System.out.println("sprobuj ponownie");
                    powtorzenie_petli = true;
            }
        }
    }
}
