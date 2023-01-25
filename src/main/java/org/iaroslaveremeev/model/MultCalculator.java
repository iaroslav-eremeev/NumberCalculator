package org.iaroslaveremeev.model;

public class MultCalculator extends NumberCalculator {

    /**
     * 7.	Создать класс MultCalculator
     * с реализацией операции умножения
     */
    public MultCalculator(int n) {
        super(n);
    }

    @Override
    int twoIntsOperation(int a, int b) {
        return a * b;
    }
}
