package org.crackingTheCodingInterview.ch01ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

/**
 * Is Unique: Implement an algorithm to determine if a string
 * has all unique characters. What if you cannot use additional data structures?
 */
public class IsUnique {

    // Using a HashSet data structure O(n)
    public static boolean isUnique(String str) {
        Set<Character> uniqueChars = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (uniqueChars.contains(str.charAt(i))) {
                return false;
            } else {
                uniqueChars.add(str.charAt(i));
            }
        }
        return true;
    }

    // Using 32-bit vector (assume lowercase only characters) O(n)
    public static boolean isUniqueBitVector(String str) {
        // Initialize 32-bit vector to 0
        int checker = 0;
        // Iterate through string
        for (int i = 0; i < str.length(); ++i) {
            // Get the int value of current char
            int val = str.charAt(i) - 'a';
            // Perform AND operation on checker and current char value
            // Will return 1 if the same place in checker and value have a 1 in the bit representation
            if ((checker & (1 << val)) > 0) return false;
            // Perform OR operation on checker and char value
            // This updates the checker value flipping a 0 to 1 in the place where the char is represented
            checker |= (1 << val);
        }
        return true;
    }

    // Not using additional data structures O(n^2)
    public static boolean isUniqueNoDataStructure(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
