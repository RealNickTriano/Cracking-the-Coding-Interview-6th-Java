package org.crackingTheCodingInterview.ch01ArraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class PalindromePermutation {
    // Palindrome: string that is the same forwards and backwards
    // A palindrome can have at most one odd count of a character

    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("tact coa"));
        System.out.println(isPalindromePermutationOnePass("tact coa"));
    }
    public static boolean isPalindromePermutation(String str) {
        boolean odd = false;
        int[] counts = new int[26];


        for (int i = 0; i < str.length(); i++) {
            if (!Character.isAlphabetic(str.charAt(i))) continue;
            int c = Character.toLowerCase(str.charAt(i)) - 97; // 'a' = 97 in ascii
            counts[c]++;
        }
        System.out.println(Arrays.toString(counts));

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] % 2 == 1) {
                if (odd) return false;
                odd = true;
            }
        }
        return true;
    }

    public static boolean isPalindromePermutationOnePass(String str) {
        boolean odd = false;
        int[] counts = new int[26];
        int oddCounts = 0;

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isAlphabetic(str.charAt(i))) continue;
            int c = Character.toLowerCase(str.charAt(i)) - 97; // 'a' = 97 in ascii
            counts[c]++;
            if (counts[c] % 2 == 1) oddCounts++;
            else oddCounts--;
        }
        return oddCounts <= 1;
    }

}
// ttaaccppo
//    ctapppatc
