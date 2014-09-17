package com.sankaran.sairam;

/**
 * Created by sairamsankaran on 9/1/14.
 */
public class PhoneNumber {
    private String phoneNumber = null;
    private static final int PHONE_NUMBER_LENGTH = 7;

    public PhoneNumber(String number) {
        this.phoneNumber = number;
    }

    public void printPhoneWords() {
        char[] number = null;
        if (this.phoneNumber != null) {
            number = this.phoneNumber.toCharArray();
        }
        char[] result = new char[PHONE_NUMBER_LENGTH];
        doprintPhoneWords(number, 0, result);
    }

    private void doprintPhoneWords(char[] phoneNumber, int currentDigit, char[] result) {
        if (currentDigit == PHONE_NUMBER_LENGTH) {
            System.out.println(new String(result));
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (phoneNumber[currentDigit] == 0 || phoneNumber[currentDigit] == 1) {
                return;
            }
            result[currentDigit] = getCharKey(phoneNumber[currentDigit], i);
            doprintPhoneWords(phoneNumber, currentDigit+1, result);
        }
    }

    private char getCharKey(int key, int position) {
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (key == 0 | key == 1) {
            return '-';
        } else {
           return alphabets.charAt((key-2)*3 + (position-1));
        }

    }


    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber("6303094");
        phoneNumber.printPhoneWords();
    }

}
