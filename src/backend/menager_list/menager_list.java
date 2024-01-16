package backend.menager_list;

import java.util.List;

public class menager_list {
    public static <T> void dodaj_na_liste(List<T> lista, T obiekt){
        lista.add(obiekt);
    }
    public static <T> void wypisz_liste(List<T> lista){
        if (!lista.isEmpty()){
            for (int i=0;i<lista.size();i++)
                System.out.println(i+". "+lista.get(i).toString());
        }
        else
            System.out.println("brak obiektow na liscie");

    }


}
