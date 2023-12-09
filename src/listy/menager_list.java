package listy;

import interfejsy.czy_obiekt_zawiera_szukana_interface;

import java.util.ArrayList;

public class menager_list {
    public static <T> void dodaj_na_liste(ArrayList<T> lista, T obiekt){
        if (!lista.contains(obiekt)){
            lista.add(obiekt);
        }
    }
    public static <T> void wypisz_liste(ArrayList<T> lista){
        if (!lista.isEmpty()){
            System.out.println();
            for (T obiekt : lista)
                System.out.println(obiekt.toString());
        }

    }
    public static <T> boolean czy_jest_na_liscie(ArrayList<T> lista,T obiekt){
        return lista.contains(obiekt);
    }

    public static <T extends czy_obiekt_zawiera_szukana_interface> void  wyszukaj_z_listy_obiekty(ArrayList<T> lista, String szukana){

        if (lista.isEmpty()){
            System.out.println("lista jest pusta");
            return;
        }
        System.out.println("wyszukane_obiekty");
        for (T obiekt : lista){
            if(obiekt.toString().contains(szukana)){
                System.out.println(obiekt);
            }
        }

    }


}
