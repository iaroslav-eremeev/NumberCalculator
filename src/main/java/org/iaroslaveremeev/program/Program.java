package org.iaroslaveremeev.program;


import org.iaroslaveremeev.model.MultCalculator;
import org.iaroslaveremeev.model.NumberCalculator;
import org.iaroslaveremeev.model.SumCalculator;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        try {
            SumCalculator sumCalculator = new SumCalculator(5);
            MultCalculator multCalculator = new MultCalculator(5);

            System.out.println("Sum calculator:");
            System.out.println(Arrays.toString(sumCalculator.getMassNegative()));
            System.out.println(Arrays.toString(sumCalculator.getMassPositive()));
            System.out.println("Getters for Sum calculator");
            System.out.println(sumCalculator.launchGetters());
            System.out.println("Filling Sum calculator...");
            sumCalculator.fill(10, 10, 10, 10, 0);
            System.out.println("Result for Sum calculator");
            System.out.println(sumCalculator.result());

            System.out.println("Mult calculator:");
            System.out.println(Arrays.toString(multCalculator.getMassNegative()));
            System.out.println(Arrays.toString(multCalculator.getMassPositive()));
            System.out.println("Getters for Mult calculator");
            System.out.println(multCalculator.launchGetters());
            System.out.println("Filling Mult calculator...");
            multCalculator.fill(10, 10, 10, 10, 2);
            System.out.println("Result for Mult calculator");
            System.out.println(multCalculator.result());

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
