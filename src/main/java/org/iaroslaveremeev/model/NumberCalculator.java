package org.iaroslaveremeev.model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class NumberCalculator {

    private int[] dataA;
    private int[] massPositive;
    private int[] massNegative;

    public int[] getDataA() {
        return dataA;
    }

    public void setDataA(int[] dataA) {
        this.dataA = dataA;
    }

    public int[] getMassPositive() {
        return massPositive;
    }

    public void setMassPositive(int[] massPositive) {
        this.massPositive = massPositive;
    }

    public int[] getMassNegative() {
        return massNegative;
    }

    public void setMassNegative(int[] massNegative) {
        this.massNegative = massNegative;
    }

    /**
     * 1.	Создать базовый класс NumberCalculator, который имеет поля:
     * массивы целых чисел с названиями соответственно dataA, massPositive и massNegative,
     * конструктор принимает на вход число n – размер массивов.
     * Конструктор должен заполнить случайными числами в диапазоне от -100 до 100 только второй и третий массивы.
     * Второй массив заполняется только положительными числами, третий – отрицательными
     */
    public NumberCalculator(int n) {
        this.dataA = new int[n];
        Random random = new Random();
        this.massPositive = new int[n];
        massPositive = random.ints(n,-100, -1).toArray();
        this.massNegative = new int[n];
        massNegative = random.ints(n, 1, 100).toArray();
    }
    /**
     * 2.	Реализовать метод fill, который принимает на вход переменное количество аргументов
     * типа int и производит заполнение первого массива.
     * Корректно обработать ситуацию, когда размер переданного
     * массива окажется меньше размера исходного
     */
    public void fill(int ... numbers){
        for (int i = 0, j = this.dataA.length; i < numbers.length; i++, j--) {
            if (j == 0) {
                System.out.println("The dataA array is full. Only the first " + this.dataA.length +
                        " numbers you entered will be saved in the array.");
                break;
            }
            this.dataA[i] = numbers[i];
        }
        if (this.dataA.length > numbers.length){
            System.out.println("The dataA array is bigger than entry. " +
                    "The rest of it will be filled with zeros.");
            for (int i = numbers.length; i < this.dataA.length; i++) {
                this.dataA[i] = 0;
            }
        }
    }

    /**
     * 5.	Написать метод, который возвращает объект такого же типа, как и объект,
     * для которого будет вызван метод, используя динамическую идентификацию типа через getClass() и getConstructor(),
     * подавая в качестве аргумента конструктора длину массива, увеличенную вдвое
     */
    public NumberCalculator getObjectWithDoubleArrayLength(NumberCalculator numberCalculator)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return numberCalculator.getClass()
                .getConstructor(int.class).newInstance(numberCalculator.getDataA().length * 2);
    }

    /**
     * 6.	Написать метод, который будет динамически определять и
     * получать массивы и данные из них, которые сохранены в полях, начинающихся с названия mass
     */
    public ArrayList<int[]> getMassData(NumberCalculator numberCalculator) throws IllegalAccessException {
        Field[] fields = numberCalculator.getClass().getDeclaredFields(); // все имеющиеся поля!
        ArrayList<int[]> arrays = new ArrayList<>();
        for (Field field : fields) {
            String fieldName = field.getName();
            if (fieldName.startsWith("mass")) {
                arrays.add((int[]) field.get(this)); // получение содержимого поля из объекта
            }
        }
        return arrays;
    }

    /**
     * 9.	Используя динамическую идентификацию типов,
     * написать метод, который вызывает только геттеры, начинающиеся с названия getMass
     */
    public boolean launchGetters(NumberCalculator numberCalculator)
            throws InvocationTargetException, IllegalAccessException {
        Method[] methods = numberCalculator.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("getMass") && method.getParameterCount() == 0) {
                int[] array = (int[]) method.invoke(numberCalculator); // динамический вызов метода
                System.out.println(Arrays.toString(array));
            }
        }
        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberCalculator that = (NumberCalculator) o;
        return Arrays.equals(dataA, that.dataA) && Arrays.equals(massPositive, that.massPositive) && Arrays.equals(massNegative, that.massNegative);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(dataA);
        result = 31 * result + Arrays.hashCode(massPositive);
        result = 31 * result + Arrays.hashCode(massNegative);
        return result;
    }

    @Override
    public String toString() {
        return "NumberCalculator{" +
                "dataA=" + Arrays.toString(dataA) +
                ", massPositive=" + Arrays.toString(massPositive) +
                ", massNegative=" + Arrays.toString(massNegative) +
                '}';
    }
}
