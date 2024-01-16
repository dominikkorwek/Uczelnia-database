package backend.Menu_package.Usuwanie_obiektow_package;

import backend.interfejsy.czy_obiekt_zawiera_szukana_interface;
import backend.interfejsy.menu_opcje_interface;

import java.util.List;
import java.util.Scanner;

import static backend.Bazy_danych_package.Bazy_danych.*;

public class Usuwanie_po_szukanej implements menu_opcje_interface {
    @Override
    public void wypisz_menu() throws InterruptedException {
        boolean powtorzenie_petli = true;
        Scanner scanner = new Scanner(System.in);
        while (powtorzenie_petli) {
            powtorzenie_petli = false;

            System.out.println("co chcesz usunac?");
            System.out.println("1. kurs");
            System.out.println("2. studenta");
            System.out.println("3. pracownika");
            System.out.println("EXIT");
            System.out.println("podaj indeks lub EXIT");

            String wybor = scanner.nextLine();
            System.out.println("podaj wartosc, dla ktorej usuniete zostana obiekty");
            String szukana = scanner.nextLine();
            Thread.sleep(3000);

            switch (wybor) {
                case "1":
                    System.out.println("\twyszukiwanie z listy kursow\n");
                    usun_obiekt_z_listy(lista_kursow,szukana);
                    break;
                case "2":
                    System.out.println("\twyszukiwanie z listy studentow\n");
                    usun_obiekt_z_listy(lista_studentow,szukana);
                    break;
                case "3":
                    System.out.println("\twyszukiwanie z listy pracownikow\n");
                    usun_obiekt_z_listy(lista_pracownikow,szukana);
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

    public <T extends czy_obiekt_zawiera_szukana_interface> void  usun_obiekt_z_listy(List<T> lista, String szukana){
        if (lista.isEmpty()){
            System.out.println("lista jest pusta");
            return;
        }

        usuwanie(lista,szukana);
        if (lista == lista_pracownikow){
            usuwanie(lista_wykladowcow,szukana);
        }


    }
    private <T extends czy_obiekt_zawiera_szukana_interface> void usuwanie(List<T> lista, String szukana){
        for(T obiekt : lista){
            if(obiekt.czy_zawiera_usuwanie(szukana)){
                System.out.println("znaleziono obiekt: "+ obiekt);
                System.out.println("usuwanie obiektu");
                lista.remove(obiekt);
            }
        }
    }


}
