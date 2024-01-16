package backend.Menu_package.Szukanie_obiektow_package;


import backend.interfejsy.menu_opcje_interface;
import backend.interfejsy.czy_obiekt_zawiera_szukana_interface;

import java.util.List;
import java.util.Scanner;

import static backend.Bazy_danych_package.Bazy_danych.*;

public class Szukanie_obiektow implements menu_opcje_interface {
    @Override
    public void wypisz_menu() throws InterruptedException {
        boolean powtorzenie_petli = true;
        Scanner scanner = new Scanner(System.in);
        while (powtorzenie_petli) {
            powtorzenie_petli = false;

            System.out.println("co chcesz wyszukac?");
            System.out.println("1. kurs");
            System.out.println("2. studenta");
            System.out.println("3. pracownika");
            System.out.println("4. wszystko");
            System.out.println("EXIT");
            System.out.println("podaj indeks lub EXIT");


            String wybor = scanner.nextLine();
            System.out.println("podaj szukana wartosc");
            String szukana = scanner.nextLine();
            Thread.sleep(1000);

            switch (wybor) {
                case "1":
                    System.out.println("\twyszukiwanie z listy kursow");
                    wyszukaj_z_listy_obiekty(lista_kursow,szukana);
                    break;
                case "2":
                    System.out.println("\twyszukiwanie z listy studentow");
                    wyszukaj_z_listy_obiekty(lista_studentow,szukana);
                    break;
                case "3":
                    System.out.println("\twyszukiwanie z listy pracownikow");
                    wyszukaj_z_listy_obiekty(lista_pracownikow,szukana);
                    break;
                case "4":
                    System.out.println("\twyszukiwanie z listy kursow");
                    wyszukaj_z_listy_obiekty(lista_kursow,szukana);

                    System.out.println("\twyszukiwanie z listy studentow");
                    wyszukaj_z_listy_obiekty(lista_studentow,szukana);

                    System.out.println("\twyszukiwanie z listy pracownikow");
                    wyszukaj_z_listy_obiekty(lista_pracownikow,szukana);
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
    }

    public <T extends czy_obiekt_zawiera_szukana_interface> void  wyszukaj_z_listy_obiekty(List<T> lista, String szukana){
        if (lista.isEmpty()){
            System.out.println("lista jest pusta");
            return;
        }

        System.out.println("wyszukane obiekty (indeksu sa wypisywane wedlug calej listy)");
        for (int i=0;i<lista.size();i++){
            if(lista.get(i).czy_zawiera_szukana(szukana)){
                System.out.println(i+". "+lista.get(i).toString());
            }
        }

    }

}
