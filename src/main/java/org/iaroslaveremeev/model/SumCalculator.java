package org.iaroslaveremeev.model;

public class SumCalculator extends NumberCalculator {

    /**
     * 7.	Создать класс SumCalculator
     * с реализацией операции сложения
     */
    public SumCalculator(int n) {
        super(n);
    }

    @Override
    int twoIntsOperation(int a, int b) {
        return a + b;
    }
}
