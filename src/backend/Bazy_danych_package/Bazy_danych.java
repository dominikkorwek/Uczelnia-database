package backend.Bazy_danych_package;

import backend.klasy.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Bazy_danych {

    public static ArrayList<Osoba> lista_studentow = new ArrayList<>();
    public static ArrayList<Osoba> lista_pracownikow = new ArrayList<>();
    public static ArrayList<Kursy> lista_kursow = new ArrayList<>();
    public static ArrayList<Pracownik_badawczo_dydaktyczny> lista_wykladowcow = new ArrayList<>();


    public static void zapisz()  {
        serializacja_listy(lista_studentow,"listastudentow.srv");
        serializacja_listy(lista_pracownikow,"listapracownikow.srv");
        serializacja_listy(lista_wykladowcow,"listawykladowcow.srv");
        serializacja_listy(lista_kursow,"listakursow.srv");
    }
    public static void wczytaj() {
        deserializacja_listy(lista_studentow,"listastudentow.srv");
        deserializacja_listy(lista_pracownikow,"listapracownikow.srv");
        deserializacja_listy(lista_wykladowcow,"listawykladowcow.srv");
        deserializacja_listy(lista_kursow,"listakursow.srv");
    }

    private static <T> void serializacja_listy( List<T> lista, String nazwa)  {
        try (FileOutputStream plik_wyjsciowy = new FileOutputStream(nazwa)){
            ObjectOutputStream out = new ObjectOutputStream(plik_wyjsciowy);
            out.writeObject(lista);
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static <T> void deserializacja_listy(List<T> lista, String nazwa) {
        try(FileInputStream plik_wejsciowy = new FileInputStream(nazwa)){
            ObjectInputStream in = new ObjectInputStream(plik_wejsciowy);
            List<T> nowaLista = (ArrayList<T>) in.readObject();
            lista.clear();
            lista.addAll(nowaLista);
            in.close();
        } catch (IOException ignored){

        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
