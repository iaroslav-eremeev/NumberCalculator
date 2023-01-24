package org.iaroslaveremeev.program;


import org.iaroslaveremeev.model.NumberCalculator;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        try {
            NumberCalculator numberCalculator = new NumberCalculator(10);
            System.out.println(Arrays.toString(numberCalculator.getMassNegative()));
            System.out.println(Arrays.toString(numberCalculator.getMassPositive()));
            System.out.println();
            System.out.println(Arrays.toString(numberCalculator.getMassData(numberCalculator).get(0)) +
                    "\n" + Arrays.toString(numberCalculator.getMassData(numberCalculator).get(1)));
            numberCalculator.fill(10, 9, 8, 7);
            System.out.println(Arrays.toString(numberCalculator.getDataA()));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
