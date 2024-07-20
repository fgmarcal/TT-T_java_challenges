package org.example;

import org.example.modules.Mean;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Double> list = new ArrayList<>();
        list.add(3.0);
        list.add(4.0);
        list.add(5.0);
        list.add(6.0);

        var result = Mean.listMean(list);
        System.out.println(result);
    }
}