package com.tasks.ThirdTask;

public class ThirdTask {


    private static int method(int number) {
        String str = String.valueOf(number);

        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();

        int index = stringBuilder.indexOf("0");
        stringBuilder.setCharAt(index, '1');

        stringBuilder.reverse();
        int result = Integer.parseInt(stringBuilder.toString());

        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        method(4012023); // input: 4012023
                        // output: 4012123
    }
}
