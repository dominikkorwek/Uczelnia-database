package backend.Menu_package;


import backend.interfejsy.menu_opcje_interface;
import backend.klasy.Uczelnia;

import java.util.Scanner;

public class Menu_uczelnia implements menu_opcje_interface {
    @Override
    public void wypisz_menu() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean powtorz_petle = true;
        Uczelnia uczelnia = Uczelnia.getInstance();

        while (powtorz_petle) {
            System.out.println("\nMenu uczelni");
            System.out.println("1.Rozpocznij nowy rok");
            System.out.println("EXIT");
            System.out.println("podaj indeks lub EXIT aby wyjsc");

            switch (scanner.nextLine()) {
                case "1":
                    uczelnia.aktualizuj_rok_studiow();
                    System.out.println("\nnacisnij enter,aby przejsc do menu");
                    scanner.nextLine();
                    break;

                case "EXIT", "Exit", "exit":
                    powtorz_petle = false;
                    System.out.println("wylaczanie menu");
                    break;
                default:
                    System.out.println("wypisz ponownie");
            }
            Thread.sleep(1000);

        }
    }
}
