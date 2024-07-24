package org.example.modules;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MeanTest {

    @org.junit.jupiter.api.Test
    @Description("Should return the mean of a list o doubles")
    void listMeanCase1() {
        //Arrange
        List<Double> list = List.of(1.0, 2.0, 3.0);
        double fakeMean = (1.0 + 2.0 + 3.0)/3.0;
        //Act
        var result = new Mean().listMean(list);
        //Assert
        Assertions.assertEquals(fakeMean, result, 0.0);
    }
}