package test;

import enumy.*;
import klasy.*;
import listy.menager_list;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)  {
        ArrayList<Osoba> osoby = new ArrayList<>();

        osoby.add( new Pracownik_administracyjny("Bob","Koko", "20123",
                50, plec_enum.MEZCZYZNA, stanowisko_administracyjne_enum.REFERENT,
                50, 5000, 20));

        osoby.add( new Pracownik_badawczo_dydaktyczny("Marek", "Adek", "30234",
                40, plec_enum.MEZCZYZNA, stanowisko_badawczo_dydaktyczne_enum.WYKLADOWCA,
                40,8000,10));

        osoby.add( new Student("Dominik", " Korwek", "11111", 19,
                plec_enum.MEZCZYZNA, 280620, 1, false,
                true,false, true,
                false));

        Kursy kurs = new Kursy("logika", 5,
                (Pracownik_badawczo_dydaktyczny) osoby.get(1));

        ArrayList<Kursy> lista_kursow = new ArrayList<>();
        ArrayList<Pracownik_uczelni> lista_pracownikow = new ArrayList<>();
        ArrayList<Student> lista_Studentow = new ArrayList<>();

        menager_list.dodaj_na_liste(lista_kursow,kurs);

        for (Osoba osoba : osoby) {     //dopisanie osob do list i wypisanie stanu kazdego
            if (osoba instanceof Pracownik_uczelni){
                menager_list.dodaj_na_liste(lista_pracownikow,(Pracownik_uczelni) osoba);

            }

            if (osoba instanceof Student) {
                ((Student) osoby.get(2)).zapis_na_kurs(kurs);
                menager_list.dodaj_na_liste(lista_Studentow,(Student) osoba);
            }

            System.out.println(osoba.toString());
        }

        System.out.println("\n\t--------------");
        String szukana_wartosc ="logika";       //tutaj dajemy szukana wartosc
        menager_list.wyszukaj_z_listy_obiekty(lista_kursow,szukana_wartosc);
        menager_list.wyszukaj_z_listy_obiekty(lista_pracownikow,szukana_wartosc);
        menager_list.wyszukaj_z_listy_obiekty(lista_Studentow,szukana_wartosc);

        System.out.println("\n\t------------------");
        menager_list.wypisz_liste(lista_pracownikow);
        menager_list.wypisz_liste(lista_Studentow);
        menager_list.wypisz_liste(lista_kursow);

    }
}

