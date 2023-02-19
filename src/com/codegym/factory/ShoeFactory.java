package com.codegym.factory;

import com.codegym.entity.Adidas;
import com.codegym.entity.Nike;
import com.codegym.entity.Puma;
import com.codegym.entity.Shoe;
import com.codegym.service.ShoeService;

import java.util.Scanner;

public class ShoeFactory {
    Scanner sc = new Scanner(System.in);
    ShoeService shoeService = ShoeService.getManagement();
    public Shoe getShoe(BrandType brandType) {
        Shoe shoeCreated = null;
        switch (brandType) {
            case nike:
            case NIKE:
                shoeCreated = new Nike();
                shoeCreated = shoeService.inputShoeInfo(shoeCreated);
                break;
            case adidas:
            case ADIDAS:
                shoeCreated = new Adidas();
                shoeCreated = shoeService.inputShoeInfo(shoeCreated);
                break;
            case puma:
            case PUMA:
                shoeCreated = new Puma();
                shoeCreated = shoeService.inputShoeInfo(shoeCreated);
                break;
        }
        return shoeCreated;
    }


}
