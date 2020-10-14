package com.tasks.SecondTask;

import java.util.Stack;

public class SecondTask {


    private static boolean isValidRegex(String str) {

        Stack stack = new Stack();

        String open = "([";
        String close = ")]";

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < open.length(); j++) {
                if (str.charAt(i) == open.charAt(j)) {
                    stack.push(open.charAt(j));
                }
            }
            for (int j = 0; j < close.length(); j++) {
                if (str.charAt(i) == close.charAt(j)) {
                    if (!stack.isEmpty()) {
                        if (((char) stack.peek() != '(') && ((char) stack.peek() == (char) (close.charAt(j) - 2))) {
                            stack.pop();
                        } else if ((char) stack.peek() == '(' && close.charAt(j) == ')') {
                            stack.pop();
                        } else {
                            System.out.println(false);
                            return false;
                        }
                    } else {
                        System.out.println(false);
                        return false;
                    }
                }
            }
        }
        System.out.println(stack.isEmpty());
        return stack.isEmpty();
    }



    public static void main(String[] args) {

        String inputt = "()()[[]()]"; // valid
        String input = "()()[]()[(])"; // invalid

        isValidRegex(inputt);
    }
}