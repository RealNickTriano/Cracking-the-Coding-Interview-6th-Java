package org.crackingTheCodingInterview.ch01ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {
    public static void main(String[] args) {
        System.out.println(checkPermutation("pasta", "pstab"));
    }

    // Use a map to hold char : count
    // compare both maps
    // runtime O(n), space O(n), n is length of strings
    public static boolean checkPermutation(String str1, String str2) {

        if (str1.length() != str2.length()) return false;

        Map<Character, Integer> charOccurences1 = new HashMap<>();
        Map<Character, Integer> charOccurences2 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if (charOccurences1.get(str1.charAt(i)) == null) {
                charOccurences1.put(str1.charAt(i), 1);
            } else {
                charOccurences1.put(str1.charAt(i), charOccurences1.get(str1.charAt(i)) + 1);
            }

            if (charOccurences2.get(str2.charAt(i)) == null) {
                charOccurences2.put(str2.charAt(i), 1);
            } else {
                charOccurences2.put(str2.charAt(i), charOccurences2.get(str2.charAt(i)) + 1);
            }

        }
        return charOccurences1.equals(charOccurences2);
    }

    // Create a list where indices = char ascii value
    // increment for 1 string, decrement for other
    // all should be 0 if permutations, otherwise not
    // same runtime as using maps, but less space complexity
    // runtime O(n), space O(1)
    public static boolean permutation(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        int[] counts = new int[128];

        for (int i = 0; i < str1.length(); i++) {
            counts[str1.charAt(i)]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            counts[str2.charAt(i)]--;
            if (counts[str2.charAt(i)] < 0) return false;
        }

        return true;
    }

}
