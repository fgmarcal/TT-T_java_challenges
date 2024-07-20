package org.example.modules;

import java.util.ArrayList;
import java.util.List;

public class Mean {

    public static double listMean(List<Double> list){
        if(list.isEmpty()) return 0.0;

        double quantity = list.size();
        double result = 0.0;

        for(double l : list){
            result += l;
        }
        double mean = result / quantity;
        return mean;
    }
}
