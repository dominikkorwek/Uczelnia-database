package backend.menager_list;

import backend.interfejsy.czy_obiekt_zawiera_szukana_interface;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongArray;

import static backend.Bazy_danych_package.Bazy_danych.*;

public class menager_list {
    public static <T> void dodaj_na_liste(ArrayList<T> lista, T obiekt){
        lista.add(obiekt);
        zapisz();
    }
    public static <T> ArrayList<JLabel> wypisz_liste(ArrayList<T> lista){
        ArrayList<JLabel> label = new ArrayList<>();
        StringBuilder string = new StringBuilder();
        if (!lista.isEmpty()){
            for (int i=0;i<lista.size();i++){
                string.append((i + 1)).append(". ").append(lista.get(i).toString());
                label.add(new JLabel(string.toString()));
                string = new StringBuilder();
            }
        }
        else{
            string = new StringBuilder(("brak obiektow na liscie"));
            label.add(new JLabel(string.toString()));
        }
        return label;
    }
    public static <T extends czy_obiekt_zawiera_szukana_interface> ArrayList<JLabel>  wyszukaj_z_listy_obiekty(ArrayList<T> lista, String szukana){
        StringBuilder message = new StringBuilder();
        ArrayList<JLabel> labels = new ArrayList<>();

        if (lista.isEmpty()){
            message = new StringBuilder("lista jest pusta");
            labels.add(new JLabel(message.toString()));
        }

        for (int i=0;i<lista.size();i++){
            if(lista.get(i).czy_zawiera_szukana(szukana)){
                message.append((i + 1)).append(". ").append(lista.get(i).toString()).append("\n");
                labels.add(new JLabel(message.toString()));
            }
        }
        return labels;
    }

    public static <T extends czy_obiekt_zawiera_szukana_interface> void  usun_obiekt_z_listy(ArrayList<T> lista, String szukana){
        if (lista.isEmpty()){
            return;
        }
        usuwanie(lista,szukana);
        if (lista == lista_pracownikow){
            usuwanie(lista_wykladowcow,szukana);
        }
        zapisz();
    }
    private static <T extends czy_obiekt_zawiera_szukana_interface> void usuwanie(ArrayList<T> lista, String szukana){
        lista.removeIf(obiekt -> obiekt.czy_zawiera_usuwanie(szukana));
        zapisz();
    }
    public static <T> void usun_powtorzenia_z_listy(ArrayList<T> lista) {
        HashSet<T> podlista = new HashSet<>(lista);
        lista.clear();
        lista.addAll(podlista);
        zapisz();
    }


}
