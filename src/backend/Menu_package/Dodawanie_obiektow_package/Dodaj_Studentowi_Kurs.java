package backend.Menu_package.Dodawanie_obiektow_package;

import backend.interfejsy.Dodaj_obiekt_interface;
import backend.klasy.Kursy;
import backend.klasy.Student;

import java.util.Objects;
import java.util.Scanner;

import static backend.Bazy_danych_package.Bazy_danych.*;
import static backend.menager_list.menager_list.*;

public class Dodaj_Studentowi_Kurs implements Dodaj_obiekt_interface<Object> {

    @Override
    public Object dodaj_obiekt() {
        dodaj_studentowi_kurs();
        return null;
    }

    private void dodaj_studentowi_kurs(){
        Scanner scanner = new Scanner(System.in);

        Student student = null;
        Kursy kurs ;

        boolean powtorz_petle = true;
        while(powtorz_petle){
            powtorz_petle = false;
            System.out.println("Podaj studentwa, ktoremu chcesz dopisac kurs");
            wypisz_liste(lista_studentow);
            if (lista_studentow.isEmpty()){
                System.out.println("W bazie danych nie ma zadnych kursow. Zamykanie dodawania");
                continue;
            }
            System.out.println("\n podaj indeks z listy");
            try{
                student = (Student) lista_studentow.get(scanner.nextInt());
                scanner.nextLine();
                if (student == null)
                    throw new NullPointerException();
            }catch (IndexOutOfBoundsException|NullPointerException e){
                System.out.println("podales zly indeks, sprobuj ponownie");
                powtorz_petle = true;
            }
        }

        powtorz_petle = true;
        while(powtorz_petle){
            System.out.println("Podaj kursy, ktore chcesz dopisac studentowi");
            wypisz_liste(lista_kursow);
            if(lista_kursow.isEmpty()){
                System.out.println("w bazie danych nie ma zadnych kursow. Zamykanie dodawania");
                continue;
            }
            System.out.println("\n podaj indeks z listy, lub wpisz ,,escape,, aby zakonczyc dodawac kursy");
            try{
                while (scanner.hasNextInt()){
                    kurs = lista_kursow.get( scanner.nextInt());
                    scanner.nextLine();
                    assert student != null;
                    dodaj_na_liste(student.getKursy_studenta(),kurs);
                }
                if (Objects.equals(scanner.next(), "escape")){
                    System.out.println("zakonczono dodawanie kursow");
                    powtorz_petle = false;
                }

            }catch (IndexOutOfBoundsException e){
                System.out.println("podales zly indeks, sprobuj ponownie");
            }

        }

    }
}
