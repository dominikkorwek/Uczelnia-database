package backend.Menu_package.Wypisywanie_list_package;

import backend.interfejsy.menu_opcje_interface;

import java.util.Scanner;

import static backend.Bazy_danych_package.Bazy_danych.*;
import static backend.menager_list.menager_list.wypisz_liste;

public class Wypisywanie_list implements menu_opcje_interface {
    @Override
    public void wypisz_menu() {
        boolean powtorzenie_petli = true;
        Scanner scanner = new Scanner(System.in);
        while (powtorzenie_petli) {
            powtorzenie_petli = false;

            System.out.println("ktora liste chcesz wypisac?");
            System.out.println("1. lista kursow");
            System.out.println("2. lista studentow");
            System.out.println("3. lista pracownikow");
            System.out.println("EXIT");
            System.out.println("podaj indeks lub EXIT");

            String wybor = scanner.nextLine();

            switch (wybor) {
                case "1":
                    System.out.println("\twypisywanie listy kursow\n");
                    wypisz_liste(lista_kursow);
                    break;
                case "2":
                    System.out.println("\twypisywanie listy studentow\n");
                    wypisz_liste(lista_studentow);
                    break;
                case "3":
                    System.out.println("\twypisywanie listy pracownikow\n");
                    wypisz_liste(lista_pracownikow);
                    break;
                case "EXIT", "Exit", "exit":
                    System.out.println("wylaczanie menu");
                    break;
                default:
                    System.out.println("\twybrales zla opcje!\n");
                    powtorzenie_petli = true;
                    break;
            }
        }
    }
}
