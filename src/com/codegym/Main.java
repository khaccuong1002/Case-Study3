package com.codegym;

import com.codegym.menu.ShoeServiceMenu;

public class Main {
    public static void main(String[] args) {
        ShoeServiceMenu shoeServiceMenu = new ShoeServiceMenu();
//        shoeServiceMenu.getMenu();
        int option = 0;
        do {
            shoeServiceMenu.getMenu();
        } while (option != 0);
    }
}