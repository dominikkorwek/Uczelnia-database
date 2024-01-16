package backend.Menu_package.Dodawanie_obiektow_package;

import backend.interfejsy.menu_opcje_interface;
import backend.interfejsy.Dodaj_obiekt_interface;

import java.util.Scanner;


public class Dodawanie_obiektow implements menu_opcje_interface {


    @Override
    public void wypisz_menu() throws InterruptedException {
        boolean powtorzenie_petli = true;
        Dodaj_obiekt_interface<Object> obiekt = null;
        Scanner scanner = new Scanner(System.in);


        while (powtorzenie_petli) {
            powtorzenie_petli = false;

            System.out.println("\t menu dodawania obiektow do bazy danych\n");
            System.out.println("1. dopisz osobe");
            System.out.println("2. dopisz kurs");
            System.out.println("3. dopisz studentowi kurs");
            System.out.println("EXIT");
            System.out.println("podaj indeks lub EXIT");

            String wybor = scanner.nextLine();

            switch (wybor) {
                case "1":
                    obiekt = new Dodaj_osobe();
                    break;
                case "2":
                    obiekt = new Dodaj_kurs();
                    break;
                case "3":
                    obiekt = new Dodaj_Studentowi_Kurs();
                    break;
                case "EXIT", "Exit", "exit":
                    System.out.println("wylaczanie menu");
                    break;
                default:
                    System.out.println("wybrales zla opcje!");
                    powtorzenie_petli = true;
                    break;
            }
        }
        if (obiekt != null){
            obiekt.dodaj_obiekt();
        }
        Thread.sleep(1000);

    }
}
