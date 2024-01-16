package backend.Menu_package.Dodawanie_obiektow_package;

import backend.enumy.plec_enum;
import backend.interfejsy.Dodaj_obiekt_interface;
import backend.klasy.Osoba;

import java.util.Scanner;

public class Dodaj_osobe implements Dodaj_obiekt_interface<Object> {
    @Override
    public Object dodaj_obiekt() {
        boolean powtorzenie_petli = true;
        Dodaj_obiekt_interface<Osoba> dodawanie = null;
        Osoba osoba;
        System.out.println("1. dopisz studenta");
        System.out.println("2. dopisz pracownika");


        while (powtorzenie_petli) {
            powtorzenie_petli = false;


            Scanner scanner = new Scanner(System.in);
            int wybor = scanner.nextInt();

            switch (wybor) {
                case 1:
                    dodawanie = new Dodaj_studenta();
                    break;
                case 2:
                    dodawanie = new Dodaj_pracownika_uczelni();
                    break;
                default:
                    System.out.println("wybrales zla opcje!");
                    powtorzenie_petli = true;
                    break;

            }
        }
        osoba =  dodawanie.dodaj_obiekt();
        dodaj_zmienne_osoby(osoba);
        return osoba;
    }
    private void dodaj_zmienne_osoby(Osoba osoba){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wpisz imie: ");
        osoba.setImie(scanner.nextLine());

        System.out.println("Wpisz nazwisko: ");
        osoba.setNazwisko(scanner.nextLine());

        System.out.println("Wpisz pesel: ");
        osoba.setPesel(scanner.nextLine());

        System.out.println("ustaw plec ( M lub K )");
        boolean powtorzenie_petli = true;
        while (powtorzenie_petli){
            powtorzenie_petli = false;

            switch (scanner.nextLine()){
                case "M":
                    osoba.setPlec(plec_enum.MEZCZYZNA);
                    break;
                case "K":
                    osoba.setPlec(plec_enum.KOBIETA);
                    break;
                default:
                    System.out.println("nie rozpoznaje takiej litery, sprobuj ponownie");
                    powtorzenie_petli = true;
            }
        }
        System.out.println("Wpisz wiek: ");
        osoba.setWiek(scanner.nextInt());
        scanner.nextLine();
    }
}
