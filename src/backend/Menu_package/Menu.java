package backend.Menu_package;

import backend.Bazy_danych_package.Bazy_danych;
import backend.Menu_package.Dodawanie_obiektow_package.Dodawanie_obiektow;
import backend.Menu_package.Szukanie_obiektow_package.Szukanie_obiektow;
import backend.Menu_package.Usuwanie_obiektow_package.Usuwanie_obiektow;
import backend.Menu_package.Wypisywanie_list_package.Wypisywanie_list;
import backend.Menu_package.sortowanie_list_package.Sortowanie_list;
import backend.interfejsy.menu_opcje_interface;

import java.util.Scanner;

public class Menu {
    public static void wypisz_menu()  {
        try {

            Scanner scanner = new Scanner(System.in);
            boolean powtorz_petle = true;
            menu_opcje_interface opcja;

            while (powtorz_petle) {
                opcja = null;
                System.out.println("\nwitaj w menu zarzadzania bazami danych. Podaj co chcesz zrobic");
                System.out.println("1. Dodaj obiekt");
                System.out.println("2. Wyszukaj obiekt");
                System.out.println("3. Usun obiekt");
                System.out.println("4. Wypisz liste");
                System.out.println("5. Sortowanie list");
                System.out.println("6. Menu uczelni");
                System.out.println("EXIT");
                System.out.println("podaj indeks lub EXIT");

                switch (scanner.nextLine()) {
                    case "1":
                        opcja = new Dodawanie_obiektow();
                        break;
                    case "2":
                        opcja = new Szukanie_obiektow();
                        break;
                    case "3":
                        opcja = new Usuwanie_obiektow();
                        break;
                    case "4":
                        opcja = new Wypisywanie_list();
                        break;
                    case "5":
                        opcja = new Sortowanie_list();
                        break;
                    case "5\6":
                        opcja = new Menu_uczelnia();
                        break;


                    case "EXIT", "Exit", "exit":
                        powtorz_petle = false;
                        System.out.println("wylaczanie menu");
                        break;
                    default:
                        System.out.println("wypisz ponownie");
                }
                Thread.sleep(1000);
                if (opcja != null){
                    opcja.wypisz_menu();
                    System.out.println("\nnacisnij enter,aby przejsc do menu");
                    scanner.nextLine();
                    Thread.sleep(1000);
                }
                Bazy_danych.zapisz();

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
