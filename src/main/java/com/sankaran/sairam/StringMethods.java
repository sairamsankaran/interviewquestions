package com.sankaran.sairam;

public class StringMethods {
    public static boolean isStringWithUniqueCharacters(String string) {
        int[] ascii = new int[256];
        int characterIndex = 0;
        for (int i=0; i < string.length(); i++) {
            characterIndex = string.charAt(i);
            if (ascii[characterIndex] == 1) {
                // repeating character
                return false;
            } else {
                ascii[characterIndex] = 1;
            }
        }
        return true;
    }

    public static void removeDuplicates(char[] string) {
        if (string == null || string.length < 2) {
            return;
        }
        boolean[] ascii = new boolean[256]; // 256 ascii characters
        int tail = 1;
        int characterIndex = string[0];
        ascii[characterIndex] = true;
        for (int i = 1; i < string.length; i++) {
            characterIndex = string[i];
            if (!ascii[characterIndex]) {
                string[tail] = string[i];
                tail = tail + 1;
                ascii[characterIndex] = true;
            }
        }
        string[tail] = 0;
    }

    public static char[] encode(char[] string) {
        // encode space with %20
        int spaceCount = 0;
        int length = string.length;

        for (int i = 0; i < length; i++) {
            if (string[i] == ' ') {
                spaceCount++;
            }
        }

        int newLength = length + spaceCount*2;
        char[] newString = new char[newLength];
        for (int i = length-1; i >= 0; i--) {
           if (string[i] == ' ') {
               newString[newLength-1] = '0';
               newString[newLength-2] = '2';
               newString[newLength-3] = '%';
               newLength = newLength - 3;
           } else {
               newString[newLength-1] = string[i];
               newLength = newLength - 1;
           }
        }
        return newString;
    }
}
