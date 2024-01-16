package backend.Menu_package.sortowanie_list_package;

import backend.interfejsy.sortowanie_list_interface;
import backend.klasy.Osoba;

import java.util.*;

import static backend.Bazy_danych_package.Bazy_danych.*;

public class sortowanie_osob implements sortowanie_list_interface {
    @Override
    public void sortuj_liste() {
        boolean powtorzenie_petli = true;
        List<Osoba> lista = null;
        Scanner scanner = new Scanner(System.in);

        while (powtorzenie_petli) {
            powtorzenie_petli = false;

            System.out.println("ktora liste mam posortowac?");
            System.out.println("1. lista studentow");
            System.out.println("2. lista pracownikow");
            System.out.println("\nPodaj indeks");
            String  wybor = scanner.nextLine();

            switch (wybor) {
                case "1":
                    lista = lista_studentow;
                    break;
                case "2":
                    lista = lista_pracownikow;
                    break;
                default:
                    System.out.println("\twybrales zla opcje!");
                    powtorzenie_petli = true;
                    break;
            }
        }

        powtorzenie_petli = true;

        while (powtorzenie_petli) {
            powtorzenie_petli = false;

            System.out.println("jak lista ma byc posortowana?");
            System.out.println("1. Wedlug nazwiska");
            System.out.println("2. Wedlug nazwiska i imienia");
            System.out.println("3. Wedlug nazwiska i wieku");
            System.out.println("\nPodaj indeks");
            String  wybor = scanner.nextLine();

            switch (wybor) {
                case "1":
                    lista.sort(Comparator.comparing(Osoba::getNazwisko));
                    break;
                case "2":
                    lista.sort((o1, o2) -> {
                        if (Objects.equals(o1.getNazwisko(), o2.getNazwisko())) {
                            return o1.getImie().compareTo(o2.getImie());
                        } else {
                            return o1.getNazwisko().compareTo(o2.getNazwisko());
                        }
                    });
                    break;
                case "3":
                    lista.sort((o1, o2) -> {
                        if (Objects.equals(o1.getNazwisko(), o2.getNazwisko())) {
                            return o1.getWiek() - o2.getWiek();
                        } else {
                            return o1.getNazwisko().compareTo(o2.getNazwisko());
                        }
                    });
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
