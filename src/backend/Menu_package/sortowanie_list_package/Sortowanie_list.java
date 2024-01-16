package backend.Menu_package.sortowanie_list_package;

import backend.interfejsy.menu_opcje_interface;
import backend.interfejsy.sortowanie_list_interface;

import java.util.Scanner;


public class Sortowanie_list implements menu_opcje_interface {
    @Override
    public void wypisz_menu() throws InterruptedException {
        boolean powtorzenie_petli = true;
        sortowanie_list_interface sortowanie = null;
        Scanner scanner = new Scanner(System.in);
        while (powtorzenie_petli) {
            powtorzenie_petli = false;

            System.out.println("ktora liste chcesz posortowac?");
            System.out.println("1. lista kursow");
            System.out.println("2. listy osob");
            System.out.println("EXIT");
            System.out.println("podaj indeks lub EXIT");


            String  wybor = scanner.nextLine();

            switch (wybor) {
                case "1":
                    sortowanie =new sortowanie_kursow();
                    break;
                case "2":
                    sortowanie = new sortowanie_osob();
                    break;
                case "EXIT", "Exit", "exit":
                    System.out.println("wylaczanie menu");
                    break;
                default:
                    System.out.println("\twybrales zla opcje!");
                    powtorzenie_petli = true;
                    break;
            }
        }
        Thread.sleep(1000);
        if (sortowanie != null){
            sortowanie.sortuj_liste();
            Thread.sleep(1000);
        }
    }
}
