package backend.test;

import backend.Bazy_danych_package.Bazy_danych;

import static backend.Menu_package.Menu.wypisz_menu;


public class Main {

    public static void main(String[] args)  {
        Bazy_danych.wczytaj();

        wypisz_menu();

        Bazy_danych.zapisz();
    }

}

