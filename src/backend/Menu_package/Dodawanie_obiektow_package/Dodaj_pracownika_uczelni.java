package backend.Menu_package.Dodawanie_obiektow_package;

import backend.interfejsy.Dodaj_obiekt_interface;
import backend.klasy.Osoba;
import backend.klasy.Pracownik_uczelni;

import java.util.Scanner;

public class Dodaj_pracownika_uczelni  implements Dodaj_obiekt_interface<Osoba> {
    @Override
    public Osoba dodaj_obiekt() {
        Scanner scanner = new Scanner(System.in);
        Dodaj_obiekt_interface<Pracownik_uczelni> pracownik = null;
        Pracownik_uczelni osoba;
        System.out.println("1. Pracownik badawczo-dydaktyczny");
        System.out.println("2. Pracownik administracyjny");

        boolean powtorzenie_petli = true;
        while (powtorzenie_petli){
            powtorzenie_petli = false;

            switch (scanner.nextLine()){
                case "Pracownik badawczo-dydaktyczny","1":
                    pracownik = new Dodaj_pracownika_bad_dydak();

                    break;

                case "Pracownik administracyjny","2":
                    pracownik = new Dodaj_pracownika_admini();
                    break;

                default:
                    System.out.println("sprobuj ponownie");
                    powtorzenie_petli = true;
            }
        }
        osoba =  pracownik.dodaj_obiekt();
        dodaj_zmienne_pracownika_uczelni(osoba);
        return osoba;
    }
    private void dodaj_zmienne_pracownika_uczelni(Pracownik_uczelni osoba){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj staz pracy: ");
        osoba.setStraz_pracy(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Podaj pensje: ");
        osoba.setPensja(scanner.nextFloat());
        scanner.nextLine();
    }
}
