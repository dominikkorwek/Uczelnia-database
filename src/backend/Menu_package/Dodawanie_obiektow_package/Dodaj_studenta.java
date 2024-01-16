package backend.Menu_package.Dodawanie_obiektow_package;

import backend.interfejsy.Dodaj_obiekt_interface;
import backend.klasy.Osoba;
import backend.klasy.Student;
import backend.klasy.Uczelnia;

import java.util.Scanner;

import static backend.Bazy_danych_package.Bazy_danych.lista_studentow;
import static backend.menager_list.menager_list.dodaj_na_liste;

public class Dodaj_studenta implements Dodaj_obiekt_interface<Osoba> {
    @Override
    public Osoba dodaj_obiekt() {
        Student student = new Student();
        dodaj_zmienne_studenta(student);
        dodaj_na_liste(lista_studentow,student);
        Uczelnia uczelnia = Uczelnia.getInstance();
        uczelnia.zrejestrujObserwatora(student);
        return student;
    }
    private void dodaj_zmienne_studenta(Student osoba){
        Scanner scanner = new Scanner(System.in);
        boolean powtorzenie_petli;

        System.out.println("Podaj numer indeksu: ");
        osoba.setNr_indeksu(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Podaj rok studiow: ");
        osoba.setRok_studiow(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Czy jest uczestnikiem Erasmus: ");
        powtorzenie_petli = true;
        while (powtorzenie_petli){
            powtorzenie_petli = false;

            switch (scanner.nextLine()){
                case "tak", "TAK", "1":
                    osoba.setUczestnik_ERASMUS(true);
                    break;
                case "nie","NIE","0" :
                    osoba.setUczestnik_ERASMUS(false);
                    break;
                default:
                    System.out.println("sprobuj ponownie");
                    powtorzenie_petli = true;
            }
        }

        powtorzenie_petli = true;
        System.out.println("Jest studentem I czy II stopnia");
        while (powtorzenie_petli){
            powtorzenie_petli = false;

            switch (scanner.nextLine()){
                case "I", "1":
                    osoba.setStudent_I_stopnia(true);
                    osoba.setStudent_II_stopnia(false);
                    break;
                case "II","2" :
                    osoba.setStudent_I_stopnia(false);
                    osoba.setStudent_II_stopnia(true);
                    break;
                default:
                    System.out.println("sprobuj ponownie");
                    powtorzenie_petli = true;
            }
        }

        powtorzenie_petli = true;
        System.out.println("Jest studentem stacjonarnym: ");
        while (powtorzenie_petli){
            powtorzenie_petli = false;

            switch (scanner.nextLine()){
                case "tak","TAK", "1":
                    osoba.setStudia_stacjonarne(true);
                    osoba.setStudia_niestacjonarne(false);
                    break;
                case "nie","NIE","0" :
                    osoba.setStudia_stacjonarne(false);
                    osoba.setStudia_niestacjonarne(true);
                    break;
                default:
                    System.out.println("sprobuj ponownie");
                    powtorzenie_petli = true;
            }
        }

    }
}
