package backend.Menu_package.Usuwanie_obiektow_package;

import backend.interfejsy.menu_opcje_interface;

import java.util.Scanner;



public class Usuwanie_obiektow implements menu_opcje_interface {


    @Override
    public void wypisz_menu() throws InterruptedException {
        boolean powtorzenie_petli = true;
        Scanner scanner = new Scanner(System.in);
        menu_opcje_interface usuwanie = null;
        
        while (powtorzenie_petli) {
            powtorzenie_petli = false;

            System.out.println("jak chcesz usunac?");
            System.out.println("1. po nazwie");
            System.out.println("2. duplikaty");
            System.out.println("EXIT");
            System.out.println("podaj indeks lub EXIT");

            String wybor = scanner.nextLine();
            Thread.sleep(3000);

            switch (wybor) {
                case "1":
                    usuwanie = new Usuwanie_po_szukanej();
                    break;
                case "2":
                    usuwanie = new Usuwanie_powtorzen();
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
        assert usuwanie != null;
        usuwanie.wypisz_menu();
    }
}
