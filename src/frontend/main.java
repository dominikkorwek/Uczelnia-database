package frontend;

import backend.Bazy_danych_package.Bazy_danych;
import frontend.customView.MainFrame;

public class main {
    public static void main(String[] args) {
        Bazy_danych.wczytaj();
        MainFrame cos =MainFrame.getInstance();

        Bazy_danych.zapisz();
    }
}
