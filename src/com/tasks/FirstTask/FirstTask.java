package com.tasks.FirstTask;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/* из задания я понял, что нужно в первую очередь сортировать по кол-ву
 * вхождений, а вторичным условием по числу */
public class FirstTask {

    static class DataClass {

        int number;
        int counter;

        DataClass(int number, int counter) {
            this.number = number;
            this.counter = counter;
        }

        int getNumber() {
            return number;
        }

        int getCounter() {
            return counter;
        }

        @Override
        public String toString() {
            return "{число = " + number +
                    "; количество = " + counter +
                    '}';
        }
    }

    private static void getResult(int[] array) {

        List<DataClass> list = new ArrayList();
        for (int el : array) {
            if (list.size() == 0) {
                list.add(new DataClass(el, 0));
            }
            for (int i = 0; i != list.size(); i++) {
                if (list.get(i).number == el) {
                    list.get(i).counter++;
                    break;
                } else {
                    if (i == list.size() - 1)
                        list.add(new DataClass(el, 0));
                }
            }
        }

        List result = list.stream().sorted(Comparator
                .comparing(DataClass::getCounter)
                .thenComparing(DataClass::getNumber))
                .collect(Collectors.toList());


        System.out.println(result.toString());
    }


    public static void main(String[] args) {

        int[] array = new int[]{2, 5, 4, 1, 4, 9, 2};
        getResult(array);

    }

}




