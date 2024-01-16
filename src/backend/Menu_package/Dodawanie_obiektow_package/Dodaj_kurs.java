package backend.Menu_package.Dodawanie_obiektow_package;

import backend.interfejsy.Dodaj_obiekt_interface;
import backend.klasy.Kursy;

import java.util.Scanner;

import static backend.Bazy_danych_package.Bazy_danych.*;
import static backend.menager_list.menager_list.*;

public class Dodaj_kurs implements Dodaj_obiekt_interface<Object> {
    @Override
    public Object dodaj_obiekt() {
        Kursy kurs = new Kursy();
        dodaj_zmienne_kursu(kurs);
        dodaj_na_liste(lista_kursow,kurs);
        return kurs;
    }
    private void dodaj_zmienne_kursu(Kursy kurs){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj nazwe kursu: ");
        kurs.setNazwa_kursu(scanner.nextLine());

        System.out.println("Podaj punkty ECTS: ");
        kurs.setECTS(scanner.nextInt());
        scanner.nextLine();

        boolean powtorz_petle = true;
        while(powtorz_petle){
            powtorz_petle = false;

            System.out.println("Podaj wykladowce, ktory wyklada zajecia:\n mozliwi wykladowcy: ");
            wypisz_liste(lista_wykladowcow);
            if(lista_wykladowcow.isEmpty()){
                System.out.println("brak wykladowcow w bazie danych,zamykanie dodawania");
                kurs = null;
                continue;
            }
            System.out.println("\n podaj indeks z listy");

            try{
                kurs.setWykladowca( lista_wykladowcow.get(scanner.nextInt()));
                scanner.nextLine();
            }catch (IndexOutOfBoundsException e){
                System.out.println("podales zly indeks, sprobuj ponownie");
                powtorz_petle = true;
            }

        }

    }
}
