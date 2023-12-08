package org.crackingTheCodingInterview.ch01ArraysAndStrings;

public class URLify {
    public static void main(String[] args) {
        System.out.println(URLify(new char[]{'h', 'e', ' ', 'l', ' ', 'l', 'o', ' ', ' ', ' ', ' '}));
    }

    public static String URLify(char[] input) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == (' ')) {
                input = shiftRight(input, i);
                input[i] = '%';
                input[i+1] = '2';
                input[i+2] = '0';
            }
        }

        return new String(input);
    }

    public static char[] shiftRight(char[] input, int fromIndex) {
        boolean move = false;
        for (int j = input.length - 1; j > fromIndex; j--) {
            if (input[j] != ' ') {
                move = true;
            }
            if (move) {
                input[j + 1] = input[j-1];
                input[j + 2] = input[j];
            }
        }
        return input;
    }
}
