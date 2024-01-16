package backend.Menu_package.sortowanie_list_package;

import backend.interfejsy.sortowanie_list_interface;
import backend.klasy.Kursy;


import java.util.Comparator;
import java.util.Scanner;

import static backend.Bazy_danych_package.Bazy_danych.lista_kursow;

public class sortowanie_kursow implements sortowanie_list_interface {
    @Override
    public  void sortuj_liste() {
        boolean powtorzenie_petli = true;
        Scanner scanner = new Scanner(System.in);
        while (powtorzenie_petli) {
            powtorzenie_petli = false;

            System.out.println("wedlug czego mam posortowac?");
            System.out.println("1. ECTS");
            System.out.println("2. Nazwa prowadzacego");
            System.out.println("EXIT");
            System.out.println("podaj indeks lub EXIT");
            String  wybor = scanner.nextLine();

            switch (wybor) {
                case "1":
                    lista_kursow.sort(Comparator.comparingInt(Kursy::getECTS));
                    break;
                case "2":
                    lista_kursow.sort(Comparator.comparing((Kursy k) -> k.getWykladowca().getNazwisko()));
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


}
