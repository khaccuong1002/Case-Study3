package com.codegym.comparator;

import com.codegym.entity.Shoe;

import java.util.Comparator;

public class ShoePriceComparator implements Comparator<Shoe> {

    @Override
    public int compare(Shoe o1, Shoe o2) {
        return Integer.compare(o1.getPrice(), o2.getPrice());
    }
}
