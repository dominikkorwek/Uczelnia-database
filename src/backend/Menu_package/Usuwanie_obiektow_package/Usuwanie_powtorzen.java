package backend.Menu_package.Usuwanie_obiektow_package;

import backend.interfejsy.menu_opcje_interface;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import static backend.Bazy_danych_package.Bazy_danych.lista_pracownikow;
import static backend.Bazy_danych_package.Bazy_danych.lista_studentow;

public class Usuwanie_powtorzen implements  menu_opcje_interface {
    @Override
    public void wypisz_menu() throws InterruptedException {
        boolean powtorzenie_petli = true;
        Scanner scanner = new Scanner(System.in);
        while (powtorzenie_petli) {
            powtorzenie_petli = false;

            System.out.println("ktora lista ma byc bez powtorzen ?");
            System.out.println("1. Studentow");
            System.out.println("2. Pracownikow");
            System.out.println("EXIT");
            System.out.println("podaj indeks lub EXIT");

            String wybor = scanner.nextLine();
            Thread.sleep(3000);

            switch (wybor) {
                case "1":
                    usun_powtorzenia_z_listy(lista_studentow);
                    break;
                case "2":
                    usun_powtorzenia_z_listy(lista_pracownikow);
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

    public <T> void usun_powtorzenia_z_listy(List<T> lista) {
        HashSet<T> podlista = new HashSet<>(lista);
        lista.clear();
        lista.addAll(podlista);
    }

}
